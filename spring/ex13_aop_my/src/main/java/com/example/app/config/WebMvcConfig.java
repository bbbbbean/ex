package com.example.app.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.app.handler.CustomHandler;
import com.example.app.interceptor.MemoInterceptor;

// 해당 페이지가 servlet-context를 대체함


@Configuration	// 설정 파일
@EnableWebMvc	// MVC 패턴 관련 필요한 것들을 관리 (bean ,,,) - servlet-context의 일을 옮길 수 있게 됨
// servlet-context <context:component-scan base-package="com.example.app.controller" /> 역할
@ComponentScans({
	@ComponentScan("com.example.app.controller"),
	@ComponentScan("com.example.app.restController")
})

// 이제 자바로 설정할거냐 xml로 할거냐 택1 가능
// WebMvcConfigurer : mvc관련 일을 도와주는 함수들 상속 가능 
public class WebMvcConfig implements WebMvcConfigurer {

	// 파일 업로드 관련 설정
	@Bean
	public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20971520); 			// 1024*1024*20 : 20MB	// 전체 업로드 허용 사이즈
        multipartResolver.setMaxUploadSizePerFile(20971520); 	// 20MB	// 파일 1개당 허용가능한 업로드 사이즈
        multipartResolver.setMaxInMemorySize(20971520); 		// 20MB // 캐시 공간
        return multipartResolver;
	}
	
	// servlet-context에서 아래 파트들 주석처리!
	//ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// 정적 자원 경로
	// servlet-context의 <resources mapping="/resources/**" location="/resources/" /> 역할
	// 페이지 기본 이미지 설정 시 중요, 까딱하면 백엔드에서 접근이 안됨
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// Insterceptor Add
	@Override
	// registry : 연결되어있는 부분
	public void addInterceptors(InterceptorRegistry registry) {
		// 어떤 경로에 동작하는 지 endpoint도 추가
		registry.addInterceptor(new MemoInterceptor()).addPathPatterns("/memo/*");
	}
	
	// Handler Mapping
	// 1) BEAN Mapping (Bean Name Url Handler Mapping) : 요정 URL을 동일한 이름을 가진 Bean에 매핑
	@Bean
	BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
		return new BeanNameUrlHandlerMapping();
	}
	// custom Handler 연결
	@Bean("/custom01")
	public CustomHandler customHandler() {
		return new CustomHandler();
	}

	// 2) Simple Url Handler Mapping : 개발자가 직접 매핑 정보를 설정하는 방식 중 하나, 기본값 : 정적 자원 매핑
	@Bean
	SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
		
		Map<String, Object> urlMap = new HashMap();
		urlMap.put("/custom02", new CustomHandler());
		handlerMapping.setUrlMap(urlMap);
		return handlerMapping;
	}
	
	// 3) Requeset Mapping Handler Mapping : Controller와 매핑되는 URL을 찾아내고 해당 URL에 대한 요청 처리
	// 적절한 컨트롤러 및 메서드를 찾아 매핑(@RequestMapping, @GetMapping, @PostMapping)
	// 처음 동작할 때 활성화되는 부분
	@Bean
	RequestMappingHandlerMapping requestMappingHandlerMapping() throws NoSuchMethodException, SecurityException {
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		// URL 요청 매핑 정보 구성 - 빌드 패턴
		RequestMappingInfo mappingInfo = RequestMappingInfo.paths("/custom03")
														   .methods(RequestMethod.GET)
														   .build();
		// URL 매핑될 매서드를 찾기
		// 내가 원하는 함수를 여기와 연결시켜줄 수 있음 - customHandler 안의 함수 중 택해서 연결 가능
		// reflect 사용
		Method method = CustomHandler.class.getMethod("hello",null);
		
		// 요청 매핑 정보, 핸들러, 메서드 등록
		handlerMapping.registerMapping(mappingInfo, new CustomHandler(), method);
		
		return handlerMapping;
	}
	
}

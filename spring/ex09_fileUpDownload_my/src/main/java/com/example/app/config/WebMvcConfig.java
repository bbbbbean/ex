package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
	
}

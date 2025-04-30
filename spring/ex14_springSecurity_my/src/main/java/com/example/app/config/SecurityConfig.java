package com.example.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.example.app.config.auth.PrincipalDetailsService;
import com.example.app.config.auth.exceptionHandler.CustomAccessDeniedHandler;
import com.example.app.config.auth.exceptionHandler.CustomAuthenticationEntryPoint;
import com.example.app.config.auth.loginHandler.CustomLoginFailureHandler;
import com.example.app.config.auth.loginHandler.CustomLoginSuccessHandler;
import com.example.app.config.auth.logoutHandler.CustomLogoutHandler;
import com.example.app.config.auth.logoutHandler.CustomLogoutSuccessHandler;

@Configuration
// security로 대신 사용하겠다 선언
@EnableWebSecurity
// 세션 기반
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// PW 입력할 때 사용해야 하니까 걸어둠?
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PrincipalDetailsService principalDetailsService;
	
	@Autowired
	private DataSource dataSource3;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF 비활성화
		http.csrf().disable();	// +CSRF 토큰값 확인 X, GET방식으로 /logout 처리 가능
								// 비활성화 X시, POST방식으로만 로그아웃 가능
		
		// CSRF토큰 쿠키 형태로 전달
		// 취약해질 가능성 있음
//		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		// permitAll : 권한 없이 접근 가능
		
		// 권한 체크
		// 들어오는 모든 요청마다 권한 요구
		http.authorizeRequests()
			// 특정 URL에 대하여 필요한 권한 설정
			// 페이지.롤 << 이런식으로 체인하면서 다 설정
			// roles 설정 시 ROLE_USER 이런식으로 저장됨
			.antMatchers("/","/join","/login").permitAll()
			.antMatchers("/user").hasRole("USER")
			.antMatchers("/manager").hasRole("MANAGER")
			.antMatchers("/admin").hasRole("ADMIN")
			.anyRequest()
			//.permitAll()
			.authenticated();
		
		// 로그인
		http.formLogin()
			// 로그인 폼 커스텀
			.loginPage("/login")
			.permitAll()
			// 로그인 성공 시 핸들러 (토큰 인증, 소셜 로그인에 사용)
			.successHandler(new CustomLoginSuccessHandler())
			// 로그인 실패 시 핸들러
			.failureHandler(new CustomLoginFailureHandler());
		
		// 로그아웃
		http.logout()
			.permitAll()
			// 로그아웃을 직접 처리하는 핸들러
			.addLogoutHandler(new CustomLogoutHandler())
			.logoutSuccessHandler(new CustomLogoutSuccessHandler());
		
		// 예외처리
		http.exceptionHandling()
			.authenticationEntryPoint(new CustomAuthenticationEntryPoint()) 	// 인증이 안된 계정이 인증이 필요한 페이지에 접근 시 사용
																				// 미인증 계정 예외 처리
			.accessDeniedHandler(new CustomAccessDeniedHandler()); // 인증된 상태라도 권한이 부족한 경우 예외 처리, 권한 부족시 예외처리
		
		// remamber-me
		http.rememberMe()
			// 서비스 등록을 할 예정이라면 해당 키값으로 연결
			.key("rememberMeKey")
			// 파라미터 설정을 하지 않으면 기본적으로 remember-me로 받아옴
			.rememberMeParameter("remember-me")
			// 무조건 로그인 상태를 유지할거냐 - 체크를 하지 않아도 유지 true, 체크 할 때만 유지 false
			.alwaysRemember(false)
			// 로그인 유지 기간 - 초단위
			.tokenValiditySeconds(60*60)
			// 로그인이 만료된 이후 계정의 상태 정보를 DB에 넣어주기 위한 레파지토리
			// 아래에서 생성한 bean 넣기
			.tokenRepository(tokenRepository());
	}
	
	// 계정하나만 만들어서 로그인 처리
	// 임시 로그인
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// {noop} : 암호화 알고리즘을 쓰지 않는 옵션 -> 원본 형태로 저장
		// 상기 옵션 없애고 암호화를 시켜둘 때 -> 로그인이 안됨
		// PW에 암호화 인코딩을 걸어야 암호화 된 해당 비밀번호라고 인식
		
//		auth.inMemoryAuthentication()
//			.withUser("user")
//			.password(passwordEncoder.encode("1234"))
//			.roles("USER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("manager")
//			.password(passwordEncoder.encode("1234"))
//			.roles("MANAGER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password(passwordEncoder.encode("1234"))
//			.roles("ADMIN");
		
		auth.userDetailsService(principalDetailsService).passwordEncoder(passwordEncoder);
	}
	
	// 기본 제공
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 로그인 계정 상태 정보를 DB에 담기 위한 repo
	// DB에 넣어야함 -> 데이터소스 필요
	@Bean
	public PersistentTokenRepository tokenRepository(){
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource3);
		
		return repo;
	}
}

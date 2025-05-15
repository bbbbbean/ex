package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// 상속 받는게 아닌 자체적으로 bean 생성 가능 -> 스스로 체인을 만들어 리턴 가능
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		// 전부 람다식으로 바뀜
		//CSRF비활성화
		http.csrf((CsrfConfigurer<HttpSecurity> config)->{config.disable();}); //+CSRF토큰값확인 x , GET /logout 처리 가능
		
		//CSRF토큰 쿠키형태로 전달
//		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		//권한체크
		http.authorizeHttpRequests((auth)->{
			auth.requestMatchers("/","/join","/login").permitAll();
			auth.requestMatchers("/user").hasRole("USER");
			auth.requestMatchers("/manager").hasRole("MANAGER");
			auth.requestMatchers("/admin").hasRole("ADMIN");
			auth.anyRequest().authenticated();
		});
		
		//로그인
		http.formLogin((login)->{
			login.permitAll();
			//login.successHandler(new CustomLoginSuccessHandler());
			//login.failureHandler(new CustomLoginFailureHandler());
		});
		
		//로그아웃
		http.logout((logout)->{
			logout.permitAll();
			//logout.addLogoutHandler(new CustomLogoutHandler());
			//logout.logoutSuccessHandler(new CustomLogoutSuccessHandler());
		});
		
		//예외처리
		http.exceptionHandling((exception)->{
			//exception.authenticationEntryPoint(new CustomAuthenticationEntryPoint()); //미인증 계정 예외처리
			//exception.accessDeniedHandler(new CustomAccessDeniedHandler());			//권한 부족시 예외처리
		});
		
		//REMEMBER-ME : 토큰 방식을 쓰면 비효율적이라 삭제
		
		// bean으로 filter가 저장됨
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

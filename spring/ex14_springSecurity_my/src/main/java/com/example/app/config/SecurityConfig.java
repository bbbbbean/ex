package com.example.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// security로 대신 사용하겠다 선언
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 권한 체크
		// 들어오는 모든 요청마다 권한 요구
		http.authorizeRequests()
			.anyRequest().authenticated();
		
		// 로그인
		http.formLogin()
			.permitAll();
		
		// 로그아웃
		http.logout()
			.permitAll();
		
		// 예외처리
		
	}
	
	// 계정하나만 만들어서 로그인 처리
	// 임시 로그인
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// {noop} : 암호화 알고리즘을 쓰지 않는 옵션
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("{noop}1234")
			.roles("USER");
	}
	
}

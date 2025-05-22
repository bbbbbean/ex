package com.example.demo.config.auth.loginHandler;

import com.example.demo.config.auth.jwt.JwtProperties;
import com.example.demo.config.auth.jwt.JwtTokenProvider;
import com.example.demo.config.auth.jwt.TokenInfo;
import com.example.demo.config.auth.redis.RedisUtil;
import com.example.demo.domain.entity.JwtToken;
import com.example.demo.domain.repository.JwtTokenRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	// provider == component -> 연결 가능
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private JwtTokenRepository jwtTokenRepository;

	@Autowired
	private RedisUtil redisUtil;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

		log.info("CustomLoginSuccessHandler's onAuthenticationSuccess invoke..");


		// TOKEN 쿠키로 전달
		// 로그인 성공 시 토큰을 만들어 쿠키 형태로 정보 던짐
		// 로그인 했으면 정보가 있겠지.. 거기서 꺼내오기
		//String username = authentication.getName();
		TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
		// 토큰 쿠키화
		Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,tokenInfo.getAccessToken()); // (key, value)
		// 유효기간
		cookie.setMaxAge(JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME);
		// 쿠키 적용 위치 - 모든 경로
		cookie.setPath("/");
		response.addCookie(cookie);

//		JwtToken jwtToken = jwtTokenRepository.findByUsername(authentication.getName());
//		if(jwtToken==null){
//
//		}
		// JWT 토큰 DB 저장
		JwtToken jwtToken = new JwtToken();
		jwtToken.setAccessToken(tokenInfo.getAccessToken());
		jwtToken.setRefreshToken(tokenInfo.getRefreshToken());
		jwtToken.setUsername(authentication.getName());
		jwtToken.setCreateAt(LocalDateTime.now());
		jwtTokenRepository.save(jwtToken);

		// Resis에 refresh 저장
		// 쿠키로 username 던짐 -> 토큰 만료 후에 확인을 위해
		Cookie usernameCookie = new Cookie("username",authentication.getName());
		usernameCookie.setMaxAge(JwtProperties.REFRESH_TOKEN_EXPIRATION_TIME);
		usernameCookie.setPath("/");
		response.addCookie(usernameCookie);
		// RT: : rt라는 폴더 안에 만들어짐
		// 이름, 리프레시 토크, 만료일
		redisUtil.setDataExpire("RT:"+authentication.getName(),tokenInfo.getRefreshToken(),JwtProperties.REFRESH_TOKEN_EXPIRATION_TIME);
		


		//	** 로그인 처리
		//---------------------------------
		//	최초로그인(Client's AT x , DB x)
		//---------------------------------
		//	- Client에게 AT 전송
		//	- DB 저장
		//	- DB 저장 여부로 최초인지 판단
		//	- authorization filter로 넘기기
		//---------------------------------
		//	기존로그인(Client's AT o , DB o)
		//---------------------------------
		//	- AT 만료 x -> 로그인 완료처리
		//	- AT 만료 o -> ** RT x -> AT 갱신
		//	- AT 만료 o -> ** RT o -> AT, RT 새로 발급 + 기존 DB 갱신
		//	provider : 토큰 유효성 체크 부분
		//---------------------------------
		//	기존로그인(Client's AT o , DB x)
		//---------------------------------
		//	-
		//---------------------------------
		//	기존로그인(Client's AT x , DB o) -예외상황
		//---------------------------------
		//-


		response.sendRedirect(request.getContextPath()+"/");
	}
}

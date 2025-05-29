package com.example.demo.config.auth.logoutHandler;


import com.example.demo.config.auth.PrincipalDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomLogoutHandler implements LogoutHandler {

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

		log.info("CustomLogoutHandler's logout invoke");

		PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
		// principalDetails 여기에 userDto가 있음 -> provider꺼낼 수 있음
		String provider = principalDetails.getUserDto().getProvider();
		if(provider!=null&&provider.startsWith("kakao")){

		}else if(provider!=null&&provider.startsWith("naver")){

		}else if(provider!=null&&provider.startsWith("google")){

		}

		HttpSession session =  request.getSession();
		if(session!=null)
			session.invalidate();

	}

}

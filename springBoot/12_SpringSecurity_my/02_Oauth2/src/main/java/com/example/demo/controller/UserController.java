package com.example.demo.controller;

import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.repository.UserRepositor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private UserRepositor userRepositor;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public void login() {
		log.info("GET /login...");
	}

	
//	@GetMapping("/user")
//	public void user(Authentication authentication) {
//		log.info("GET /user..." + authentication);
//		log.info("name..." + authentication.getName());
//		log.info("principal..." + authentication.getPrincipal());
//		log.info("authorities..." + authentication.getAuthorities());
//		log.info("details..." + authentication.getDetails());
//		log.info("credential..." + authentication.getCredentials());
//	}
	
//	@GetMapping("/user")
//	public void user(@AuthenticationPrincipal Principal principal) {
//		log.info("GET /user..." + principal);
//	}
	
	@GetMapping("/user")
	public void user(Model model) {
		log.info("GET /user...");
		Authentication authenticaton = 
		SecurityContextHolder.getContext().getAuthentication();
		log.info("authentication : " + authenticaton);
		
		model.addAttribute("auth",authenticaton);
		
	}
	
	@GetMapping("/manager")
	public void manager() {
		log.info("GET /manager...");	
	}
	@GetMapping("/admin")
	public void admin() {
		log.info("GET /admin...");	
	}
	
	
	
	@GetMapping("/join")
	public void join() {
		log.info("GET /join..");
	}
	@PostMapping("/join")
	public String join_post(UserDto dto, Model model, RedirectAttributes redirectAttributes ) {
		log.info("POST /join.." + dto);

		// DTO -> Entity (DB저장), Entity -> DTO (뷰로 전달)
		// 변경 작업이 필요 -> 매번 바꾸기 귀찮으니까 바꾸는 함수 처리를 하긴 함
		// 아래 작업을 DTO에 넣거나 converter를 만듦

		// DTO -> Entity 작업 후 repo에 저장
//		User user = User.builder()
//				.username(dto.getUsername())
//				.password(dto.getPassword())
//				.role("ROLE_USER")
//				.build();
//		userRepositor.save(user);
		// 해당 작업 DTO에 넣어 반복적으로 사용 가능하게 만듦
		// 작업 후 줄인 코드
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		userRepositor.save(dto.toEntity());

		boolean isJoin  = false;
		if(isJoin) {
			redirectAttributes.addFlashAttribute("message","회원가입 완료!");
			return "redirect:/login";
		}
		else
			return "join";
	}
}




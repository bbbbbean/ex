package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	// join 연결
	@Autowired
	private UserServiceImpl userService;
	
	
	// 특정 컨트롤러에 대한 WebDataBinder 초기화를 지정
	// binder 시에 동작
	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("memoController's dataBinder "+webDataBinder);
		// (바꿀 예정 클래스, 넣을 데이터, 변환 폼)
		webDataBinder.registerCustomEditor(String.class, "phone", new PhoneEditor());
		webDataBinder.registerCustomEditor(LocalDate.class, "birthday", new BirthEditor());
	}
	
	// 로그인용 page 생성
	@GetMapping("/login")
	public void login() {
		log.info("GET /login");
	}
	
	// 권한별 page 생성
//	@GetMapping("/user")
//	public void user(Authentication authentication) {
//		log.info("GET /user : "+authentication);
//		log.info("name : "+authentication.getName()); // username
//		log.info("principal : "+authentication.getPrincipal()); //Dto
//		log.info("authorities : "+authentication.getAuthorities());	// role, 인증 여부
//		log.info("details : "+authentication.getDetails()); // 사용자 상세 정보
//		log.info("credential : "+authentication.getCredentials());
//	}

//	@GetMapping("/user")
//	public void user(@AuthenticationPrincipal Principal principal ) {
//		log.info("GET /user : "+principal); // 유저 관련 정보 전체 출력	
//	}
	
	// context에 직접 접근하는 방식
	// model에 담아 던지는 방식
	@GetMapping("/user")
	public void user(Model model) {
		log.info("GET /user");
		Authentication authentication =	SecurityContextHolder.getContext().getAuthentication();
		log.info("authentication : "+authentication);
		
		model.addAttribute("auth",authentication);	// 이렇게 잘 안쓰는데 이런 방법도 있다
	}
	
	@GetMapping("/manager")
	public void manager() {
		log.info("GET /manager");
	}
	@GetMapping("/admin")
	public void admin() {
		log.info("GET /admin");
	}
	

	@GetMapping("/join")
	public void join() {
		log.info("GET /join");
	}
	
//	@PostMapping("/join")
//	public void join_post(@Valid UserDto dto, BindingResult result, Model model) {
//		log.info("POST /join" +dto);
//		if(result.hasErrors()) {
//			// 에러 모음 : result.getFieldErrors();
//			for(FieldError error : result.getFieldErrors()) {
//				log.info("error : "+error+" msg : "+error.getDefaultMessage());
//				// 에러를 담아 보내야함
//				// 필드 이름과 해당 메세지를 담음
//				model.addAttribute(error.getField(), error.getDefaultMessage());
//			}
//		}
//	}
	@PostMapping("/join")
	public String join_post(@Valid UserDto dto, BindingResult result, Model model,RedirectAttributes redirectAttributes) {
		log.info("POST /join" +dto);
			
		for(FieldError error : result.getFieldErrors()) {
			log.info("error : "+error+" msg : "+error.getDefaultMessage());
			model.addAttribute(error.getField(), error.getDefaultMessage());
			return "/join";
		}
		
		boolean isJoin = userService.userJoin(dto);
		if(isJoin) { 
			// 세션에 저장
			redirectAttributes.addFlashAttribute("message","회원가입 완료");
			return "redirect:/login";}
		else
			return "/join";
	}
	
	// 포멧팅
	private static class PhoneEditor extends PropertyEditorSupport{
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
				// 폰번호
				text = text.replace("-","");
				setValue(text);
		}
	}
	private static class BirthEditor extends PropertyEditorSupport{
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			// 생일
			LocalDate date = null;
			if(text.isEmpty()) {
				date = LocalDate.now();
			}else {
				// yyyy~MM~dd -> yyyy-MM-dd (localDate format
				text = text.replace("~", "-");
				date = LocalDate.parse(text,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			setValue(date);
		}
	}
	@GetMapping("/ex")
	public void ex() throws FileNotFoundException{
		log.info("GET ex");
		throw new FileNotFoundException("파일을 찾을 수 없습니다.");
	}
}

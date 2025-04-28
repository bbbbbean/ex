package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	// 특정 컨트롤러에 대한 WebDataBinder 초기화를 지정
	// binder 시에 동작
	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("memoController's dataBinder "+webDataBinder);
		// (바꿀 예정 클래스, 넣을 데이터, 변환 폼)
		webDataBinder.registerCustomEditor(String.class, "phone", new PhoneEditor());
		webDataBinder.registerCustomEditor(LocalDate.class, "birthday", new BirthEditor());
	}

	@GetMapping("/join")
	public void join() {
		log.info("GET /join");
	}
	
	@PostMapping("/join")
	public void join_post(@Valid UserDto dto, BindingResult result, Model model) {
		log.info("POST /join" +dto);
		if(result.hasErrors()) {
			// 에러 모음 : result.getFieldErrors();
			for(FieldError error : result.getFieldErrors()) {
				log.info("error : "+error+" msg : "+error.getDefaultMessage());
				// 에러를 담아 보내야함
				// 필드 이름과 해당 메세지를 담음
				model.addAttribute(error.getField(), error.getDefaultMessage());
			}
		}
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

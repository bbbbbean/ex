package com.example.app.controller;

import java.beans.PropertyEditorSupport;
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.dto.MemoDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
	// 특정 컨트롤러에 대한 WebDataBinder 초기화를 지정
	// binder 시에 동작
	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("memoController's dataBinder "+webDataBinder);
		// (바꿀 예정 클래스, 넣을 데이터, 변환 폼)
		webDataBinder.registerCustomEditor(LocalDate.class, "dateTest", new DateTestEditor());
	}
	
	@GetMapping("/add")
	public void add_get() {
		log.info("GET /memo/add");
	}
	
	@PostMapping("/add")
	public void add_post(@Valid MemoDto dto,BindingResult bindingResult,Model model) {
		log.info("POST /memo/add..."+dto);
		// 유효성 검사를 원하면 해당 요소가 있는 DTO에 유효성 검사를 원한다라는 애노테이션을 명시해야함
		// @Valid MemoDto dto
		// 우리는 메모안의 id에 유효성 검사를 할 예정이니까 메모Dto에 @Valid라는 애노테이션을 달아 유효성 검사를 실시할 것
		// 할 때 버전 잘 맞춰주기
		if(bindingResult.hasErrors()) {	// 에러가 있다면!
			// 에러 하나 확인 : ID
			//log.info("유효성 에러 발생 : "+bindingResult.getFieldError("id").getDefaultMessage());
			for(FieldError error : bindingResult.getFieldErrors()) {
				log.info("Error Field : "+error.getField()+" Error Msg : "+error.getDefaultMessage());
				// 상기 에러 메세지들을 뷰어에 표시해야함 -> 메세지를 담아 전달 필요 : model로 묶어 보내기
				// 에러가 발생한 부분과 메세지 인자에 담기
				model.addAttribute(error.getField(),error.getDefaultMessage());
			}
		}
	}
	
	// static private
	private static class DateTestEditor extends PropertyEditorSupport {
		
		// 매핑되어 들어오는 값 확인 예정
		@Override
		public void setAsText(String dateTest) throws IllegalArgumentException {
			log.info("DateTestEditor's setAsText invoke "+dateTest);
			LocalDate date = null;
			if(dateTest.isEmpty()) {
				date = LocalDate.now();
			}else {
				// yyyy#MM#dd -> yyyy-MM-dd (localDate format
				dateTest = dateTest.replace("#", "-");
				date = LocalDate.parse(dateTest,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			setValue(date);
		}

		
	}
}

package com.example.demo.controller;

import com.example.demo.domain.dto.MemoDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	public void add_post(@Valid MemoDto dto, BindingResult bindingResult, Model model) {
		log.info("POST /memo/add..."+dto);

		if(bindingResult.hasErrors()) {	// 에러가 있다면!
			for(FieldError error : bindingResult.getFieldErrors()) {
				log.info("Error Field : "+error.getField()+" Error Msg : "+error.getDefaultMessage());
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

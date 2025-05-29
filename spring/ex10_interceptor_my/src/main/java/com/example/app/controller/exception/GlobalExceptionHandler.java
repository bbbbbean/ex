package com.example.app.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
//모든 컨트롤러의 오류와 예외를 잡아내기 위한 class
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String AllExceptionHandler(Exception e, Model model) {
		log.info("GlobalExceptionHandler's error : "+e);
		model.addAttribute("ex",e);
		return "global_error";
	}
	
}

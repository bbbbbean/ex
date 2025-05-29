package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
@Slf4j
@RequestMapping("/except")
public class ExceptionTestController {
	
	// 예외 테스트 컨트롤러에만 국한된 예외 처리
	// 모든 컨트롤러에서 발생한 예외를 관리는 global exception
	
	// 괄호 안에 해당 예외만 잡겠다 선언 가능
	// .class붙여주기
	@ExceptionHandler(FileNotFoundException.class)
	public String fileNotFoundExceptionHandler(Exception e, Model model) {
		log.error("error : "+e);
		// except 안의 에러 페이지로 보낼 예정
		return "/except/error";
	}
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticExceptionHandler(Exception e, Model model) {
		log.error("error : "+e);
		// except 안의 에러 페이지로 보낼 예정
		return "/except/error";
	}
	
//	@ExceptionHandler(Exception.class)
//	public String exceptionHandler(Exception e, Model model) {
//		log.error("error : "+e);
//		// except 안의 에러 페이지로 보낼 예정
//		return "/except/error";
//	}
	
	@GetMapping("/ex")
	public void ex() throws FileNotFoundException{
		log.info("GET ex");
		throw new FileNotFoundException("파일을 찾을 수 없습니다.");
	}
	
	@GetMapping("/page01")
	public void ex1() throws FileNotFoundException{
		log.info("GET /except/page01");
		throw new FileNotFoundException("파일을 찾을 수 없습니다.");
	}

	// 
	@GetMapping("/page02/{num}/{div}")
	public String ex2(
			@PathVariable("num") int num,
			@PathVariable("div") int div,
			Model model) throws ArithmeticException {
		log.info("GET /except/page02"+(num/div));
		model.addAttribute("result",(num/div));
		// 0으로 나누면 오류 뜸 : 그 어떤 수도 0으로 나눌 수 없음
		// Request processing failed; nested exception is java.lang.ArithmeticException: / by zero
		// 산술 오류 : ArithmeticException 
		
		return "/except/page02";
	}
	
}

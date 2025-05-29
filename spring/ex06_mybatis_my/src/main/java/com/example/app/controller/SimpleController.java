package com.example.app.controller;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

// 서블릿 context가 관리함
@Controller
// 
@Slf4j
// 기본 url 설정 - front에서 경로 잡던 걸 바로 할 수 있음
@RequestMapping("/test")
public class SimpleController {
	
	// 세부적인 연결 작업 가능 - 세부 카테고리 가능
	// method 지정 가능 - 여기는 GET 지정
	@RequestMapping( value = "test1" , method=RequestMethod.GET)
	public void test1() {
		log.info("Get /test/test1");
		// 파라미터
		// 유효성
		// 서비스
		// 뷰 - Resolver가 관련, prefix/suffix를 붙여 주소 완성시켜 보내줌
		// 이제 뷰 이동 따로 안해도 됨 우와~
	
	}

	@RequestMapping( value = "test2" , method=RequestMethod.GET)
	// void : 기본적으로 함수 명에 해당되는 파일이 있는지 확인
	// 함수 이름이 아닌 다른 페이지 연결을 원한다면? return지정
	// views 안에서 페이지 찾는게 기본
	// 타 폴더 안을 원하면 해당 상위 폴더도 기입
	public String test2() {
		log.info("Get /test/test2");

		return "test/abcd";
	}
	
	// 요청하는 작업 : POST도 동시에 받아낼 수 있음
	@RequestMapping( value = "test3" , method= {RequestMethod.GET,RequestMethod.POST})
	public void test3() {
		log.info("Get/POST /test/test3");
	}
	@GetMapping("/ex")
	public void ex() throws FileNotFoundException{
		log.info("GET ex");
		throw new FileNotFoundException("파일을 찾을 수 없습니다.");
	}
}

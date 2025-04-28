package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.service.MemoServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
	
	
	
	@Autowired
	private MemoServiceImpl memoServiceImpl;
	
	// 특정 컨트롤러에 대한 WebDataBinder 초기화를 지정
	// binder 시에 동작
//	@InitBinder
//	public void dataBinder(WebDataBinder webDataBinder) {
//		log.info("memoController's dataBinder "+webDataBinder);
//		// (바꿀 예정 클래스, 넣을 데이터, 변환 폼)
//		webDataBinder.registerCustomEditor(LocalDate.class, "dateTest", new DateTestEditor());
//	}
	
	// 파라미터 받기
	@GetMapping("/add")
	public void add_get(MemoDto dto) throws SQLException {
		log.info("GET /memo/add");
		memoServiceImpl.registrationMemo(dto);	
	}
	
	
	@PostMapping("/add")
	public void add_post(@Valid MemoDto dto,BindingResult bindingResult,Model model) throws SQLException {
		log.info("POST /memo/add..."+dto);
		// 유효성 검사
		if(bindingResult.hasErrors()) {	// 에러가 있다면!
			for(FieldError error : bindingResult.getFieldErrors()) {
				log.info("Error Field : "+error.getField()+" Error Msg : "+error.getDefaultMessage());
				// 상기 에러 메세지들을 뷰어에 표시해야함 -> 메세지를 담아 전달 필요 : model로 묶어 보내기
				// 에러가 발생한 부분과 메세지 인자에 담기
				model.addAttribute(error.getField(),error.getDefaultMessage());
			}
		}
		// 서비스
		boolean isAdded = memoServiceImpl.registrationMemo(dto);
		// tx 처리 서비스
		// return void라 자료형 설정없이 바로 사용
		// 테스트지에서 사용.. 어차피 에러 발생할 코드라 옮김.. 
		//memoServiceImpl.addMemoTx(dto);
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
	
	@GetMapping("/ex")
	public void ex() throws FileNotFoundException{
		log.info("GET ex");
		throw new FileNotFoundException("파일을 찾을 수 없습니다.");
	}
	
	@GetMapping("/rest")
	public void rest() {
		log.info("GET /rest...");
	}
}

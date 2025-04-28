package com.example.app.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.domain.dto.FileDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/file")
public class FileUpDownloadController {
	
	// 정적 경로 설정 : 파일 저장 위치
	private String ROOT_PATH = "c:\\";
	private String UPLOAD_PATH = "upload";	
	
	@GetMapping("/upload")
	public void upload_form() {
		log.info("GET /file/upload");
	}
	
	// 파일을 받는 클래스 : 스프링은 정해져 있음 : multipartFile
	// 여러개의 파일 : 배열 형태로 전달됨 -> 배열로 받기
	// 다른 이름의 파일이 들어올 수 있음 -> 전달되는 파라미터로 한정시키기
	@PostMapping("/upload")
	public void upload(@RequestParam MultipartFile[] files) {
		log.info("POST /file/upload"+files.length);
		
		LocalDateTime now = LocalDateTime.now();
		//yyyyMMdd_HHmmss 폴더명
		String folderName =now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		//업로드 경로 설정
		String UploadPath = ROOT_PATH
							+File.separator // '/'
							+UPLOAD_PATH
							+File.separator
							+folderName 
							+File.separator;
		//디렉토리 생성( c:\\upload\\20250421_102933\\ )
		File dir = new File(UploadPath);
		if(!dir.exists()) 
			dir.mkdirs();
		
		// 파일 하나씩 열어보기
		for(MultipartFile file : files) {
			System.out.println("--------------------");
			System.out.println("FILE NAME : " + file.getOriginalFilename());
			System.out.println("FILE SIZE : " + file.getSize() + " Byte");
			System.out.println("--------------------");
			
			String filename = file.getOriginalFilename();
			File fileObject = new File(dir,filename);	// 업로드 처리
		}
		
	}
	
	@PostMapping("/upload_dto")
	public void upload_dto(FileDto dto) throws IllegalStateException, IOException {
		MultipartFile [] files = dto.getFiles();
		
		log.info("POST /file/upload"+files.length);
		
		LocalDateTime now = LocalDateTime.now();
		//yyyyMMdd_HHmmss 폴더명
		String folderName =now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		//업로드 경로 설정
		String UploadPath = ROOT_PATH
							+File.separator // '/'
							+UPLOAD_PATH
							+File.separator
							+folderName 
							+File.separator;
		//디렉토리 생성( c:\\upload\\20250421_102933\\ )
		File dir = new File(UploadPath);
		if(!dir.exists()) 
			dir.mkdirs();
		
		// 파일 하나씩 열어보기
		for(MultipartFile file : files) {
			System.out.println("--------------------");
			System.out.println("FILE NAME : " + file.getOriginalFilename());
			System.out.println("FILE SIZE : " + file.getSize() + " Byte");
			System.out.println("--------------------");
			
			String filename = file.getOriginalFilename();
			File fileObject = new File(dir,filename);
			file.transferTo(fileObject);	// 업로드 처리
		}
		
	}
	
}


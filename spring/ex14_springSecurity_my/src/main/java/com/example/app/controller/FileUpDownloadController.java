package com.example.app.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public void upload(@RequestParam MultipartFile[] files) throws IllegalStateException, IOException {
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
	
	// LIST
	@GetMapping("/list")
	public void list(Model model) {
		log.info("GET /file/list");
		// 업로드 된 상위 폴더 경로
		String UploadPath = ROOT_PATH
						+File.separator // '/'
						+UPLOAD_PATH
						+File.separator;
		File uploadDir = new File(UploadPath);
		// 업로드 상위 경로(C:\\upload)의 하위 폴더들(날짜별로 생성된 폴더) 받기
		File [] dirs = uploadDir.listFiles();
		for(File dir : dirs) {
			System.out.println("DIR : "+dir);
			// 이름과 같은 파일 연결
			File subDir = new File(dir.getPath());
			// 하위 폴더 안의 파일들 꺼내기(개별 파일들)
			for(File file:subDir.listFiles()) {
				System.out.println("file : "+file);
			}
		}
		// 모델에 uploadPath만 전달하면 아래 출력값 전부 사용 가능
		// 위에서는 제대로 출력이 되는가 확인한 것
		model.addAttribute("uploadPath",new File(UploadPath));
	}
	
	// MediaType.APPLICATION_OCTET_STREAM_VALUE : 페이지 전환이 되지 않고 다운로드 처리가 됨
	@GetMapping(value="/download" ,produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody	// 내용 전달 용으로 변환 == @RestController : 해당 컨트롤러는 어노테이션 명시 없이 리턴값이 @ResponseBody로 설정됨
	public ResponseEntity<Resource> download(@RequestParam("path") String path) throws UnsupportedEncodingException {
		log.info("GET /file/download "+path);
		
		//FileSystemResource : 파일시스템의 특정 파일로부터 정보를 가져오는데 사용
		Resource resource = new FileSystemResource(path);
		//파일명 추출
		String filename = resource.getFilename();
		//헤더 정보 추가
		HttpHeaders headers = new HttpHeaders();
		//ISO-8859-1 : 라틴어(특수문자등 깨짐 방지)
		headers.add("Content-Disposition","attachment; filename="+new String(filename.getBytes("UTF-8"),"ISO-8859-1"));
		//리소스,파일정보가 포함된 헤더,상태정보를 전달
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
	
}


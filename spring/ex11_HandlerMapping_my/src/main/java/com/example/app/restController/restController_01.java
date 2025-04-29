package com.example.app.restController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.dto.MemoDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rest")
public class restController_01 {
	// text
	@GetMapping(value="/getText", produces=MediaType.TEXT_PLAIN_VALUE)
	public String f1() {
		log.info("GET /rest/getText");
		return "Hello World";
	}
	
	// Json
	@GetMapping(value="/getJson", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MemoDto f2() {
		log.info("GET /rest/getJson");
		return new MemoDto(11,"abcd","ffff",LocalDateTime.now(), null);
	}
	
	// xml
	@GetMapping(value="/getXml", produces=MediaType.APPLICATION_XML_VALUE)
	public MemoDto f3() {
		log.info("GET /rest/getXml");
		return new MemoDto(22,"aaaa","sssss",LocalDateTime.now(),null);
	}
	
	// list
	@GetMapping(value="/getList", produces=MediaType.APPLICATION_XML_VALUE)
	public List<MemoDto> f4(){
		log.info("GET /rest/getList");
		List<MemoDto> list = new ArrayList();
		
		for(int i=5000;i<5010;i++){
			list.add(new MemoDto(i,"A"+i,"aa",LocalDateTime.now(),null));
		}
		return list;
	}
	
	// XmlList
	@GetMapping(value="/getXmlList/{show}", produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<MemoDto>> f5(@PathVariable("show") boolean show){
		log.info("GET /rest/getXmlList");
		if(show) {
			List<MemoDto> list = new ArrayList();
			for(int i=6000;i<6010;i++) {
				list.add(new MemoDto(i,"A"+i,"aa",LocalDateTime.now(),null));
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
	}
}

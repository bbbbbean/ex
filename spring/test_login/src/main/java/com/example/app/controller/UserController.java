package com.example.app.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Dao.UserDaoImpl;
import com.example.app.domain.Dto.UserDto;
import com.example.app.domain.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@GetMapping("/login")
	public void loginpage() {
		log.info("GET /login");
	}
	
	@PostMapping("/login")
	public String login(String userid, RedirectAttributes redirectAttributes) throws SQLException {
		log.info("POST /login");
		UserDto user = userDaoImpl.selectOne(userid);
		
		if(user==null) {
			return "redirect:/join";
		}else
			return "/home";
		
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/join")
	public void joinpage() {
		log.info("GET /join");
	}
	
	@PostMapping("/join")
	public String join(@Valid UserDto dto, RedirectAttributes redirectAttributes) throws SQLException {
		log.info("POST /join");
		// 서비스
		boolean isAdded = userService.join(dto);
		if(isAdded) { 	// 세션에 저장
			redirectAttributes.addFlashAttribute("message","회원가입 완료");
			return "redirect:/login";}
		else
			return "/join";
	}
	
	@GetMapping("/list")
	public void listpage() {
		log.info("GET /list");
	}
	
	@PostMapping("/update")
	public String update(UserDto dto, RedirectAttributes redirectAttributes) throws SQLException {
		log.info("POST /update");
		boolean isUpdated = userService.update(dto);
		if(isUpdated) 
			return "/list";
		else
			return "/listAt";
	}
	@PostMapping("/delete")
	public String delete(String userid, RedirectAttributes redirectAttributes) throws SQLException {
		log.info("POST /delete");
		boolean isDeleted = userService.delete(userid);
		
		return "/list";
	}
	
}

package com.example.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl {
	
	// 패스워드 암호화
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMapper userMapper;
	
	// TX는 기본값으로 넣는다 생각하기
	@Transactional(rollbackFor = Exception.class)
	public boolean userJoin(UserDto userDto) {
		
		// 패스워드 암호화
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		// role 셋팅 - 시큐리티 연결때만 ROLE_붙이기
		userDto.setRole("ROLE_USER");
		// 서비스 연결
		int result = userMapper.insert(userDto);
		
		return result>0;
	}
}

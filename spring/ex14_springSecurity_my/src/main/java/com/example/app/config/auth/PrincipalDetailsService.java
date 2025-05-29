package com.example.app.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
// userDatail(정보 단위)을 사용하기 위한 service
public class PrincipalDetailsService implements UserDetailsService{

	// myBatis 사용중
	// 유저 조회하는 코드가 필요
	@Autowired
	private UserMapper userMapper;
	
	// DB로 부터 내용을 꺼내서 검증할 수 있는 단위(userDatail)로 변환 후 던지는 거
	// 조회 기능은 딱히 없음 -> userMapper에서 조회 메서드 생성
	// 조회된 정보를 검증할 수 있는 단위로 변환만 가능
	
	// 로그인 폼에서 id, pw 입력 -> 로그인 요청 -> 인증 처리하기 전 id를 받아옴 -> 해당 id와 같은 유저 있나 판별 후 반환
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// DB내용 가져오기
		UserDto userDto = userMapper.selectAt(username);
		
		// 계정이 없을 경우 userDto==null
		if(userDto==null)
			throw new UsernameNotFoundException(username+" 존재하지 않는 계정입니다.");

		return new PrincipalDetails(userDto);
	}

}

package com.example.demo.config.auth;

import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.UserRepositor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	private UserRepositor userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("loadUserByUsername .. " + username);
		Optional<User> userOption = userRepository.findById(username);	// username이 id, username으로 찾겟다
		if(userOption.isEmpty())
			throw new UsernameNotFoundException(username + " 존재하지 않는 계정입니다.");
		// entoty -> DTO
		UserDto userDto = UserDto.toDto(userOption.get());
		// 하나만 반환 불가 -> 해당하는 생성자 만들기
		return new PrincipalDetails(userDto);
	}

}



package com.example.app.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.app.domain.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 유저 정보를 받는 단위 (UserDetails)
// 계정 정보를 꺼내주는 역할까지
public class PrincipalDetails implements UserDetails{
	// 기본 포함
	private UserDto userDto;


// 권한 체크할 때 꺼내는 내용
// Dto의 role
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// 받는 단위 collection으로 여러 role을 받을 예정
	// GrantedAuthority와 상속 관계에 있는 컬렉션으로 만들어야함
	Collection <GrantedAuthority> authorities = new ArrayList();
	// SimpleGrantedAuthority : GrantedAuthority에서 일반적으로 많이 쓰이는 거
	authorities.add(new SimpleGrantedAuthority(userDto.getRole()));
	
	// 권한을 꺼내 return 타입에 맞게 변환 후 반환
	return authorities;
}

@Override
public String getPassword() {
	return userDto.getPassword();
}

@Override
public String getUsername() {
	return userDto.getUsername();
}

// 계정 만료 여부
@Override
public boolean isAccountNonExpired() {
	return true;
}

// 잠긴 계정 여부
@Override
public boolean isAccountNonLocked() {
	return true;
}

// 비밀번호 만료 여부
@Override
public boolean isCredentialsNonExpired() {
	return true;
}

// 계정 사용 가능 여부
@Override
public boolean isEnabled() {
	return true;
}
	
	
}

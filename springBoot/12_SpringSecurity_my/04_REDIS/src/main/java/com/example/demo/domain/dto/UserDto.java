package com.example.demo.domain.dto;

import com.example.demo.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	
	private String username;		//유저ID
	private String password;	//패스워드
	private String role;

	// OAuth2 Client Info
	private String provider;
	private String providerId;

	// entity user를 반환
	public User toEntity(){
		return User.builder()
				.username(this.getUsername())
				.password(this.getPassword())
				.role("ROLE_USER")
				.build();
	}

	// entoty -> DTO
	public static UserDto toDto(User user){
		return UserDto.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.role(user.getRole())
				.build();
	}

}

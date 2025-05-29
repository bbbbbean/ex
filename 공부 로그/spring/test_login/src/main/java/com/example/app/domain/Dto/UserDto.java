package com.example.app.domain.Dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class UserDto {
	@NotNull(message = "ID는 필수항목입니다.")
	private String userid;
	@NotNull(message = "PW는 필수항목입니다.")
	private String password;
	@NotNull(message = "이름은 필수항목입니다.")
	private String name;
	private String nickname;
}

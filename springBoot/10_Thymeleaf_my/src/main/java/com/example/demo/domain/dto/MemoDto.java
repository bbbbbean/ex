package com.example.demo.domain.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto {
	// 최소 숫자 제한 가능
	// WebDataBinder 기능
	@Min(value = 10,message = "ID는 10이상 숫자로만 설정 가능합니다.")
	@Max(value = 65535,message = "ID는 65535이하의 숫자로만 설정 가능합니다.")
	@NotNull(message = "ID는 필수항목입니다.")
	private Integer id;
	@NotBlank(message = "메모를 입력하세요")
	private String text;
	@NotBlank(message = "작성자를 입력하세요")
	@Email(message = "example@example.com에 맞게 입력해주세요")
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	@NotNull(message = "날짜 정보를 선택해주세요")
	private LocalDateTime createAt;
	
	// webDataBinder가 일정부분 변환해주지만 모든 것을 변환해주지는 않음
	// 들어오는 문자열을 날짜로 변환시키는 작업 필요 : in-format 작업
	// 괄호 안 형태의 문자열 형태가 들어오면 날짜로 변환
	// 이런 형식으로 들어올 예정이니까 바꿔달라 요청
	private LocalDate dateTest;

	public MemoDto(int id, String text) {
		this.id = id;
		this.text = text;
	}
}

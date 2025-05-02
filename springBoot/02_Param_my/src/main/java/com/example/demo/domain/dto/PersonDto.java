package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//애노테이션으로 전부 생성 가능
//@Getter
//@Setter
//@ToString

// 위 세개 한번에 만드는 것
@Data

// 모든 인자를 받는 생성자
@AllArgsConstructor
// default 생성자
@NoArgsConstructor

// 위 모든 것을 context 영역 안으로 넣어보기 -> root, servlet 택 1


// lombok 기능 추가
// 모든 생성자의 경우를 만들어주는 객체 생성 패턴 중의 하나
@Builder
public class PersonDto {
	private String username;
	private int age;
	private String addr;
}

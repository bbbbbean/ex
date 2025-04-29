package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app.domain.dto.PersonDto;

// 설정파일이라고 명시
// 해당으로 작업하면 보통 bean이 됨
@Configuration
public class PersonDtoBeanConfig {
	// root에서 해당 파일을 bean으로 저장
	
	@Bean
	public PersonDto person03() {
		return new PersonDto("김범수",44,"서울");
	}
	@Bean(name = "personBean")
	public PersonDto person04() {
		return new PersonDto("박범수",22,"울산");
	}
	@Bean
	public PersonDto person05() {
		return PersonDto.builder()
				.age(55)
				.username("철수")
				.addr("울산")
				.build();

	}
}

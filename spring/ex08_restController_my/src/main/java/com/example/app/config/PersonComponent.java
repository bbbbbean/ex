package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Data;

// 상위어?
@Component
@Data
public class PersonComponent {
	private String username;
	private int age;
	private String addr;
	
	PersonComponent(){
		this.username="티티";
		this.age=33;
		this.addr="인천";
	}
	
}

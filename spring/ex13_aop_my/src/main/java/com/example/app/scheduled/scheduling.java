package com.example.app.scheduled;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
// 스케줄링에 사용할 것이다 명시
// 반복처리 해야 할 때
@EnableScheduling
public class scheduling {
	// 반복 주기, 반복 단위를 넣어줘야함
	// fixedRate : 1000=1s 마다 반복실행
	
//	@Scheduled(fixedRate = 1000)
//	public void t1() {
//		System.out.println("scheduling's t1 invoke");
//	}
	
	// cron : (초 분 시 일 월 요일)마다 실행 지정 가능
	// 요일 : 0-6, 일~토
	// */3 : 3초, 3분, 3시간... 마다 실행 
//	@Scheduled(cron = "*/3 * * * * *")
//	public void t2() {
//		System.out.println("scheduling's t2 invoke");
//	}
}

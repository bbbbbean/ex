package com.example.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {
	// 어떠한 서비스 로직에 aop를 설정할지 명시
	// 어디에 적용할 것인지 명시
	// 어떤 함수가 실행될 때 동작시킬 것인지 execution(자료형 함수경로이름)
	// (..) : 어떤 파라미터든 상관하지 않겠다
	// 상태줄에 빨간 좌회전 화살표 있으면 잘 걸린 것
	@Before("execution(boolean com.example.app.domain.service.MemoServiceImpl.registrationMemo(..))")
	public void loggingBefore(JoinPoint joinPoint) {
		log.info("[AOP] Before "+joinPoint);
	}
	
	@After("execution(* com.example.app.domain.service.MemoServiceImpl.getAllMemo())")
	public void loggingAfter(JoinPoint joinPoint) {
		log.info("[AOP] After "+joinPoint);
		log.info("[AOP] After "+joinPoint.getTarget());
		log.info("[AOP] After "+joinPoint.getSignature());
		log.info("[AOP] After "+joinPoint.getSignature().getName());
	}
	
	@Around("execution(* com.example.app.domain.service.*.*(..))")
	public Object loggingAround(ProceedingJoinPoint pjp) throws Throwable {
		// 이전 시점
		log.info("[AOP] Around Before");
		long startTime = System.currentTimeMillis();
		
		// MVC 흐름대로 진행
		// before 작업을 한 이후 서비스로 내용을 넘기는 작업을 함
		Object isUpdated = (Object)pjp.proceed();
		
		// 이후 시점
		log.info("[AOP] Around After");
		long endTime = System.currentTimeMillis();
		log.info("[AOP] Time : "+(endTime-startTime)+" ms");
		
		return isUpdated;
	}
}


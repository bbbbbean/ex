package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 맵핑 필요없음
//@WebListener
public class C01ServletContextListener implements ServletContextListener{
	// context가 시작 종료될 때(웹 어플리케이션이 시작, 종료) 추가적으로 할 일이 있다면 처리 
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// context가 구동될 때
		// 기본 옵션으로 넣고 싶은 설정값들을 넣을 때 사용
		System.out.println("[Listener] C01ServletContextListener start");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// context가 종료될 때
		System.out.println("[Listener] C01ServletContextListener end");
	}
	
}

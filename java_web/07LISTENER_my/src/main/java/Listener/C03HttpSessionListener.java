package Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class C03HttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// 세션 생성
		System.out.println("[Listener] HttpSessionListener create");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// 세션 제거
		System.out.println("[Listener] HttpSessionListener destroy");
	}
	
}

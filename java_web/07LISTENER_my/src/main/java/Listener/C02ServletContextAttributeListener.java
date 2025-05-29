package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class C02ServletContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		// 속성이 추가되었을 때
		System.out.println("[Listener] ServletContextAttributeListener add");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// 속성이 제거되었을 때 
		System.out.println("[Listener] ServletContextAttributeListener remove");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// 속성이 변경되었을 때
		System.out.println("[Listener] ServletContextAttributeListener replace");
	}
	
}

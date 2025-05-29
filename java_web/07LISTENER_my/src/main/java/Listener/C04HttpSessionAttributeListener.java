package Listener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class C04HttpSessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// 세션 속성 추가
		System.out.println("[Listener] HttpSessionAttributeListener add");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// 세션 속성 제거
		System.out.println("[Listener] HttpSessionAttributeListener remove");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// 세션 속성 변경
		System.out.println("[Listener] HttpSessionAttributeListener replace");
	}
	
}

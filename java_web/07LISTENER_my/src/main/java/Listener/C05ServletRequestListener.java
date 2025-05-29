package Listener;

import javax.servlet.ServletRequestEvent;

import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class C05ServletRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("[Listener] C05ServletRequestListener destroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("[Listener] C05ServletRequestListener init");
	}
	
}

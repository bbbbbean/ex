package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/TEST_01")
public class C01Servlet_Test extends HttpServlet {
	// 처음 실행할 때 동작
	@Override
	public void init() throws ServletException {
		System.out.println("INIT() Invoke...");
	}
	
	// 요청을 추가할 때
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// -
		System.out.println("Service() Invoke...");
	}

	// 파일이 수정될 때 마다 호출
	@Override
	public void destroy() {
		// -
		System.out.println("Destroy() Invoke...");
	}


	
}

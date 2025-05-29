package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/app/add","/app/replace","/app/remove"})
public class C02ListenerTest extends HttpServlet {
	// ServletContextAttributeListener Test용
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Servlet] C02ListenerTest Service");
		String uri = req.getRequestURI();
		if(uri.contains("/app/add")) {
			// add 속성 추가
			req.getServletContext().setAttribute("CTX_KET", "CTX_VALUE");
		}else if(uri.contains("/app/replace")) {
			// add 기존 속성 수정
			req.getServletContext().setAttribute("CTX_KET", "CTX_VALUE_2");
		}else {
			// add 기존 속성 삭제
			req.getServletContext().removeAttribute("CTX_KET");
		}
	}
}

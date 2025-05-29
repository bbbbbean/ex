package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/session/remove","/session/attr/add","/session/attr/replace","/session/attr/remove"})
public class C03ListenerTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Servlet] C03ListenerTest Service");
		String uri = req.getRequestURI();
		// 보통 세션이 만료되면 새 페이지 이동 시 자동으로 세션이 새로 만들어짐
		// getSession false 설정 시 자동 생성 끔
		HttpSession session = req.getSession();
		if(uri.contains("/session/remove")) {
			// session 제거
			session.invalidate();
		}else if(uri.contains("/session/attr/add")) {
			// session 속성 추가
			session.setAttribute("S_KEY", "S_VALUE");
		}else if(uri.contains("/session/attr/replace")){
			// session 기존 속성 수정
			session.setAttribute("S_KEY", "S_VALUE2");
		}else {
			// session 기존 속성 삭제
			session.removeAttribute("S_KEY");
		}
	}
}

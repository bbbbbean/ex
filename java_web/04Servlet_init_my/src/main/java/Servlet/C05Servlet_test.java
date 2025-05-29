package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class C05Servlet_test extends HttpServlet {

	// 페이지로의 이동, 파라미터 전달
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}
	
	// 처리를 위한 함수
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/POST /login.do");
		// 파라미터 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 입력값 검증(생략)
		// 작업 처리(login : DB랑 정보 일치 판별, 세션에 정보 저장해놨음 세션과 일치비교 )
		HttpSession session = req.getSession(); // 세션 꺼내기
		String dbUsername = (String) session.getAttribute("username");
		String dbpassword = (String) session.getAttribute("password");
		
		if(!username.equals(dbUsername)) {
			req.setAttribute("username_mag","ID가 일치하지 않습니다.");
		}
		if(!password.equals(dbpassword)) {
			req.setAttribute("password_mag","PW가 일치하지 않습니다.");
		}
		if(!username.equals(dbUsername) || !password.equals(dbpassword)) {
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			return;
		}
		// 뷰로 이동(로그인 창으로 리다이렉트, /main.do redirect)
		resp.sendRedirect(req.getContextPath()+"/main.do");		
		
		
	}
	
}

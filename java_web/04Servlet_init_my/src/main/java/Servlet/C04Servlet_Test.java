package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebServlet랑 상속 잊지말기
@WebServlet("/join.do")
public class C04Servlet_Test extends HttpServlet {
	
	// get 요청 : doGet
	// 연결시키는 위치는 web-inf에 걸어주기 : 서블릿에 쓰이는 폴더, 보안폴더(직접 열 수 없음->직접 실행시 404에러뜸 :: 기본설정)->forward를 사용해 위치 잡아주기
	@Override
	// HttpServletRequest req : 리퀘스트 내장 객체
	// 페이지의 직접 경로를 가릴 수 있음
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/GET /join.do");
		req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp);
	}


	// post 처리를 위한 함수
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 컨트롤러 부분이라 생각
		// 파라미터 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 입력값 검증(생략)
		// 작업 처리(DB삽입 생략, 세션에 담기로 처리)
		// request 객체에서 session 받아올 수 있음 -> 앞으로 유용하게 사용하세욤
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		// 뷰로 이동(로그인 창으로 리다이렉트, /login.do redirect)
		resp.sendRedirect(req.getContextPath()+"/login.do");	
	}
	
}

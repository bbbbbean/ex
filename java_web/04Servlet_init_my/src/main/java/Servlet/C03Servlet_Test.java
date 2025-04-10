package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebServlet랑 상속 잊지말기
@WebServlet("/main.do")
public class C03Servlet_Test extends HttpServlet {
	
	// get 요청 : doGet
	// 연결시키는 위치는 web-inf에 걸어주기 : 서블릿에 쓰이는 폴더, 보안폴더(직접 열 수 없음->직접 실행시 404에러뜸 :: 기본설정)->forward를 사용해 위치 잡아주기
	@Override
	// HttpServletRequest req : 리퀘스트 내장 객체
	// 페이지의 직접 경로를 가릴 수 있음
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/GET /main.do");
		req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
	}
}

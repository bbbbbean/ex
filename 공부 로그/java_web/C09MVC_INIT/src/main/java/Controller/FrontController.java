package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.user.UserCreateController;

// 모든 경로 : /
@WebServlet("/")
public class FrontController extends HttpServlet {
	//서브컨트롤러 저장 자료구조("/endPoint":서브컨트롤러객체 저장용)
	private Map<String,SubController> map = new HashMap();

	// 서블릿은 작업을 수정하지 않는 한 계속 쓸 수 있음 -> 싱글톤 필요없음
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		try {
		// 기본 home 경로 잡기
		map.put("/", new HomeController());
		map.put("/index.do", new HomeController());
			
		// 인증 작업 : /user/*
		// 유저 컨트롤러를 만들어 회원 CRUD, 로그인, 로그아웃
		map.put("/user/create", new UserCreateController());	// Join
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException("서브컨트롤러 등록 오류");
		}
		
		// 도서 : /book/*
		// 도서 CRUD
	}
	
	// 모든 요청을 받아냄 -> 어떤 주소를 넣어도 받아내짐
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			// 요청할 때마다 실행
			System.out.println("[FC] Service");
			String endPoint = req.getServletPath();
			System.out.println("[FC] endPoint "+endPoint);
			SubController controller = map.get(endPoint);	//요청사항을 처리할 SubController get
			controller.execute(req,resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			exceptionHandler(e,req);
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
		}
	}

	// 예외처리함수
	public void exceptionHandler(Exception e, HttpServletRequest req) {
		// 문제가 생기면 포워딩
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
	
	
}

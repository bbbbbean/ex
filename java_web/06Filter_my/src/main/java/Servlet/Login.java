package Servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.OracleDBUtils;
import Utils.UserDto;

//@WebServlet("/login.do")
public class Login extends HttpServlet{
	//GET - 	/login.do - /WEB-INF/user/login.jsp 연결
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
	}
	
	//POST - 	/login.do - 회원가입처리(username,password 받아 DBUtils를 이용한 DB INSERT)
	//테이블 : tbl_user
	//성공시 : /main.do 로 리다이렉트
	//실패시 : /login.do로 포워딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 받기
		String userid = req.getParameter("username");
		String password = req.getParameter("password");
		// 유효성 검사
		// 작업(DB 서치 -> 확인)
		boolean isAuth = false;
		try {
			UserDto user = OracleDBUtils.getInstance().selectOne(userid);
			if(user!=null && user.getPassword().equals(password)) {
				// 세션 작업
				HttpSession session = req.getSession();
				session.setAttribute("userid", userid);
				session.setAttribute("role", user.getRole());
				session.setAttribute("addr", user.getAddr());
				isAuth = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 뷰
		if(isAuth==true) {
			// resp.sendRedirect(req.getContextPath()+"/main.do");
			return;
		}else {
			req.setAttribute("msg", "로그인 실패");
			req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
			return;
		}
	}
	
}

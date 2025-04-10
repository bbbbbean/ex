package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.OracleDBUtils;
import Utils.UserDto;

@WebServlet("/join.do")
public class Join extends HttpServlet{
	//GET - 	/join.do - /WEB-INF/user/join.jsp 연결
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
		return;
	}

	//POST - /join.do - 회원가입처리(username,password 받아 DBUtils를 이용한 DB INSERT)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 0;
		try {
			
			//테이블 : tbl_user(요청 파라미터에 맞게 적절히 생성)
			String userid = req.getParameter("username");
			String password = req.getParameter("password");
			String role_user = "R_user";
			String addr = req.getParameter("addr");
			UserDto user = new UserDto(userid,password,role_user,addr);
			
			result = OracleDBUtils.getInstance().userJoin(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 실패시 -> 오류 발생으로 인한 실패들 -> try문에 있으면 자동으로 오류 캐치 절로 넘어가서 포워딩이 안된것
		// :: result를 전역으로 빼주고 위 아래 전부 받을 수 있게 설정 한 뒤 if로 성공 실패 여부 나누기
		if(result>0) {
			//성공시 - /login.do 로 리다이렉트
			resp.sendRedirect(req.getContextPath()+"/login.do");
			return;
		}else {
			//실패시 - /join.do 로 포워딩
			req.setAttribute("msg", "회원가입 실패");
			req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
			return;
		}
	}
	
}

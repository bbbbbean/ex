package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Type.Role;

public class LoginRedirectFilter implements Filter{
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		chain.doFilter(req, resp);
		// 로그인 후 보내기
		// ROLE_ADMIN -> /admin_main
		// ROLE_MANAGER -> /manager_main
		// ROLE_USER -> /user_main
		
		// 세션에 저장된 권한 빼와야함
		// 세션 : HttpServlet에서 빼올 수 있음 -> req, resp 다운캐스팅
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		String myRole = (String) request.getSession().getAttribute("role");
		
		// role 가져오기
		Role my= null;
		switch(myRole) {
			case "ROLE_USER":
				my = Role.ROLE_USER;
				break;
			case "ROLE_MANAGER":	
				my = Role.ROLE_MANAGER;
				break;
			case "ROLE_ADMIN":
				my = Role.ROLE_ADMIN;
				break;
			default :
				break;
		}
		
		// 권한 판별
		switch(my.ordinal()) {
		case 1:
			response.sendRedirect(request.getContextPath()+"/user_main");
			break;
		case 2:
			response.sendRedirect(request.getContextPath()+"/manager_main");
			break;
		case 3:
			response.sendRedirect(request.getContextPath()+"/admin_main");
			break;
		}
		
	}

}

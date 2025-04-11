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
		String method = request.getMethod(); 
		
		// 방식이 POST인지 먼저 판별
		if(method.contains("POST") && (myRole!=null)) {
			System.out.println("로그인 상태 확인 role : "+myRole);
			switch(myRole) {
				case "ROLE_USER":
					response.sendRedirect(request.getContextPath()+"/user_main");
					return;
					//break;
				case "ROLE_MANAGER":
					response.sendRedirect(request.getContextPath()+"/manager_main");
					return;
					//break;
				case "ROLE_ADMIN":
					response.sendRedirect(request.getContextPath()+"/admin_main");
					return;
					//break;
				default :
					break;
			}
		}
		
		/*
		 * // role 가져오기 Role my= null; switch(myRole) { case "ROLE_USER": my =
		 * Role.ROLE_USER; break; case "ROLE_MANAGER": my = Role.ROLE_MANAGER; break;
		 * case "ROLE_ADMIN": my = Role.ROLE_ADMIN; break; default : break; }
		 * 
		 * // 권한 판별 switch(my.ordinal()) { case 1:
		 * response.sendRedirect(request.getContextPath()+"/user_main"); break; case 2:
		 * response.sendRedirect(request.getContextPath()+"/manager_main"); break; case
		 * 3: response.sendRedirect(request.getContextPath()+"/admin_main"); break; }
		 */
		
	}

}

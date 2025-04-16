package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.Role;


public class PermissionFilter implements Filter{

	// 특정 페이지별로 어떤 권한이 필요한지 선저장 필요
	// ex ) admin_main 접근때 필요한 권한 값 : 3 - ROLE_ADMIN
	// ex ) manager_main 접근때 필요한 권한 값 : 2 - ROLE_MANAGER
	// ex ) user_main 접근때 필요한 권한 값 : 1 - ROLE_USER
	// ex ) 권한 없음 : 0 - ROLE_ANONYMOUS (익명계정, 비회원)
	// 숫자 : 비교 연산이 가능
	// 문자로도 저장
	
	// URL : Permission Value
	// 권한 값 저장을 위한 맵
	private Map<String,Role> pageGradeMap = new HashMap();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		String projectPath = filterConfig.getServletContext().getContextPath();
		
		// admin_main	: 3 - ROLE_ADMIN
		// manager_main	: 2 - ROLE_MANAGER
		// user_main	: 1 - ROLE_USER

		// 정적 자원도 생각해줘야함 - 정적자원 경로가 맵핑되지 않아 css등이 깨지는 것
		
		
		// 기본 페이지 맵핑
		pageGradeMap.put(projectPath+"/", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/index.do", Role.ROLE_ANONYMOUS);
		
		// user
		pageGradeMap.put(projectPath+"/user/create", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/user/login", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/user/logout", Role.ROLE_ANONYMOUS);

		// role
		pageGradeMap.put(projectPath+"/user/admin", Role.ROLE_ADMIN);
		pageGradeMap.put(projectPath+"/user/manager", Role.ROLE_MANAGER);
		pageGradeMap.put(projectPath+"/user/user", Role.ROLE_USER);
		
		// book
		pageGradeMap.put(projectPath+"/book/list", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/book/create", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/book/read", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/book/update", Role.ROLE_ANONYMOUS);
		pageGradeMap.put(projectPath+"/book/delete", Role.ROLE_ANONYMOUS);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("[Filter] perm filter start");

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		HttpSession session = request.getSession();
		String myRole = (String) session.getAttribute("role");
		
		// 정적 자원 경로 잡기
		String uri = request.getRequestURI();
		if(uri.contains("/resources")) {
			// 포함하고 있으면 바로 넘김
			// 정적 자원들은 필터링에서 걸리지 않게 잘 빼내주기
			// 여기서는 정적 자원을 그냥 넘기도록 함
			
		}else {
			// 1. 로그인을 안하면 role이 없음 - 비회원 거르기
			if(myRole==null) {
				session.setAttribute("role", "ROLE_ANONYMOUS");
				response.sendRedirect(request.getContextPath()+"/user/login?msg=not authenticated");
				return;
			}
			
			// 2. role 값이 있는 경우
			// 2-1 ) 꺼낸 role 값 판별 후 저장 -- 보통 로그인 때 애초에 저장
			Role my = null;
			switch(myRole) {
			case "ROLE_USER":
				my = Role.ROLE_USER;		// 1
				break;
			case "ROLE_MANAGER":
				my = Role.ROLE_MANAGER;		// 2
				break;
			case "ROLE_ADMIN":
				my = Role.ROLE_ADMIN;		// 3
				break;
			default:
				my = Role.ROLE_ANONYMOUS;	// 0
				break;
			}
					
			// 2-2 ) Page Role Value 꺼내기
			String requestUri = request.getRequestURI();	// /project/admin_main 등등
			Role pageRole = pageGradeMap.get(requestUri);	// uri로 꺼낼 수 있는 값 = role 값 => enum role 자료형으로 잡아주기
			
			// 2-3 ) 회원 권한 수준과 페이지 권한 수준 비교
			if(my.ordinal()<pageRole.ordinal()) { // 비허용
				throw new ServletException("해당 권한으로는 접근이 불가능한 페이지입니다.");
			}
			
			System.out.printf("URL : %s, MyRole : %d, PageRole : %d\n",requestUri,my.ordinal(),pageRole.ordinal());
			
		}
		
		
		
		chain.doFilter(req, resp); 	// 언제나 기준 먼저 잡아주기!

		System.out.println("[Filter] perm filter end");
	}

	
	
}

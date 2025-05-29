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
		// 처음 실행 함수, 최초 1회 동작
		// 권한 값 저장을 위한 함수 담을 것
		// project 경로도 함께 넣어야함 - filterConfig 안에서 꺼낼 수 있음
		String projectPath = filterConfig.getServletContext().getContextPath();
		
		// admin_main	: 3 - ROLE_ADMIN
		// manager_main	: 2 - ROLE_MANAGER
		// user_main	: 1 - ROLE_USER
		// 해당 경로는 3, 해당경로는 2, 해당 경로는 1 저장 - 상수일 경우 <String, Integer>
		// 열거형 클래스 사용할 경우 map의 자료형도 잘 바꿔주기 - 열거형 클래스일 경우 클래스 이름 <String, Role>
		
		// 열거형 클래스 : 특정한 문자열에 해당되는 값을 미리 저장하여 사용할 수 있는 클래스?? 
		// -> 따로 관리하기도 함, 우리는 type에서 따로 관리 예정
		// enum 클래스 : 문자를 상수로 치환 가능
		// 숫자로만 저장해두면 이게 어떤거였는지 기억을 못함 그럴때를 대비해 문자와 함께 저장해두는것 - 상수와 의미를 함께 저장
		
		// 페이지에다 권한 지정해 둬야해서 Role 사용
		pageGradeMap.put(projectPath+"/admin_main", Role.ROLE_ADMIN);
		pageGradeMap.put(projectPath+"/manager_main", Role.ROLE_MANAGER);
		pageGradeMap.put(projectPath+"/user_main", Role.ROLE_USER);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("[Filter] perm filter start");
		// 요청이 들어올 때 권한 확인 후 페이지 보내면 됨
		// 로그인 상태를 봐야함 - 아이디, 패스워드 일치 시 세션에 role을 저장함 == 로그인 된 상태라면 role이 저장되어있다.
		// 세션에 저장된 role 꺼내기
		
		// ServletRequest : HttpServletRequest(외부 프로토콜도 포함)의 상위 클래스, 상속 관계
		// 다운 캐스팅이 필요
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		HttpSession session = request.getSession();
		String myRole = (String) session.getAttribute("role");
		// 로그인할때 role을 바로 상수 치환할 수도 있음
		// 하지만? 우리는 여기서 해보기
		
		// 1. 로그인을 안하면 role이 없음 - 비회원 거르기
		if(myRole==null) {
			response.sendRedirect(request.getContextPath()+"/login.do?msg=not authenticated");
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
		// 요청하는 url 확인 후 값을 꺼내 확인 가능 -> url확인이 선행
		String requestUri = request.getRequestURI();	// /project/admin_main 등등
		Role pageRole = pageGradeMap.get(requestUri);	// uri로 꺼낼 수 있는 값 = role 값 => enum role 자료형으로 잡아주기
		
		// 2-3 ) 회원 권한 수준과 페이지 권한 수준 비교
		if(my.ordinal()<pageRole.ordinal()) { // 비허용
			throw new ServletException("해당 권한으로는 접근이 불가능한 페이지입니다.");
		}
		
		System.out.printf("URL : %s, MyRole : %d, PageRole : %d\n",requestUri,my.ordinal(),pageRole.ordinal());
		
		chain.doFilter(req, resp); 	// 언제나 기준 먼저 잡아주기!

		System.out.println("[Filter] perm filter end");
	}

	
	
}

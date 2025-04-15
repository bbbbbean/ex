package Controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Dto.UserDto;
import Domain.Service.UserServiceImpl;

public class UserLogoutController implements SubController {
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private UserServiceImpl userService; // 여기서 로그아웃 처리
	
	public UserLogoutController() throws Exception{
		userService = UserServiceImpl.getInstance();	
	}
	
	// FrontController -> UserLogoutController 등록 (URI : /user/logout)
	private boolean isAuth;
	private String role;
	private String username;
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// UserLogoutController
		//  - 1 파라미터받기 생략 
		//	- 2 session 안 속성 정보(isAuth , role , username) 꺼내오고 유효성 체크
		//  - isAuth == false 라면 포워딩 /WEB-INF/login.jsp   session에 message 속성 추가 "로그인상태가 아닙니다"
		
		// UserService
		//  - logout함수 내 처리
		//		- session invalid 처리 하기
		//		- Map<String,Object> 로 return "isLogout",true , "message","로그아웃성공"
		
		// UserLogoutController
		//	- isLogout 정보를 확인하여 로그아웃 성공/실패 둘다  /login.do
		//  - message는 session 에 저장
		
		// session 안 속성 정보(isAuth , role , username) 꺼내오고 유효성 체크
		// HttpSession session = req.getSession()으로 만들고 작업하기
		HttpSession session = req.getSession();
		// null 오류 뜬 이유.. .. . 
		// isAuth -> 참거짓 판별 -> null이 아니라 참거짓으로 넣어야 아래에서 제대로 판별가능
		isAuth = session.getAttribute("isAuth")!=null?(boolean) req.getSession().getAttribute("isAuth"):false;
		role = (String) session.getAttribute("role");
		username = (String) session.getAttribute("username");
		
		try {
			if(!isAuth) {
				req.getSession().setAttribute("message", "로그인 상태가 아닙니다");
				req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
				// 포워드 뒤 return 빼먹지 말기
				return ;
			}
			
			// 유효성 검사 함수 -> 유효성 체크는 함수로 빼기
			boolean isOk = isValid(isAuth, role, username);
			
			// 서비스
			Map<String,Object> serviceResponse = userService.logout(req.getSession());
			// 서비스 파라미터 받아오기
			Boolean isLogout = (boolean) serviceResponse.get("isLogout");
			String message = (String) serviceResponse.get("message");
			
			if(isLogout!=null && isLogout==true) {
				// 성공 메세지 전달
				req.getSession().setAttribute("message", message);
			}else {
				// 실패 메세지 전달
				session.setAttribute("message", "로그아웃 실패");
			}

			// 페이지 이동
			// 여기까지 왔다는건 모든 false를 이겨내고 true만 왔다는 소리..
			resp.sendRedirect(req.getContextPath()+"/user/login");

			
		}catch(Exception e) {
			e.setStackTrace(null);
		}
	}
	
	private boolean isValid(Boolean isAuth, String role, String username) {
		
		if(isAuth==false || isAuth==null) {
			
			return false;
		}
		
		return true;
	}

	
}

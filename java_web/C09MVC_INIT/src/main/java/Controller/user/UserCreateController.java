package Controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.UserDto;
import Domain.Service.UserServiceImpl;

// 서브와 상속관계여야 프론트에 등록 가능
public class UserCreateController implements SubController {

	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private UserServiceImpl userService;
	public UserCreateController() throws Exception {
		// 프론트 컨트롤러로 예외 던지기
		userService = UserServiceImpl.getInstance();
		// throw new Exception("test");
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] UserCreateController execute");
		
		try {
			// get방식 접근 시 페이지 출력용
			String uri = req.getMethod();
			if(uri.equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/user/create.jsp").forward(req, resp);
				return;
			}
			
			
			// post 처리용 로직
			// 파라미터 확인 (username, password)
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String role = "ROLE_USER";
			// 입력값 검증
			UserDto userDto = new UserDto(username,password,role);
			// null 유효성 검사
			boolean isOk = isValid(userDto);
			if(!isOk) {
				req.getRequestDispatcher("/WEB-INF/view/user/create.jsp").forward(req, resp);
				return;
			}
			// 서비스
			boolean isJoin = userService.userJoin(userDto);
			// 뷰 
			if(isJoin) {
				// 스프링 : home 컨트롤러가 자동으로 만들어짐 -> 우리도 만들어보자~
				resp.sendRedirect(req.getContextPath()+"/index.do");
			}else {
				req.getRequestDispatcher("/WEB-INF/view/user/create.jsp").forward(req, resp);
			}
			
			
			
			// 에러 테스트
			//throw new Exception("Exception test");
					
		}catch(Exception e) {
			// 예외는 예외핸들러로 보내기
			// 예외가 발생하면 보내 줄 페이지 지정
			exceptionHandler(e);
			try {req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);}
			catch(Exception e2){}
		}
	}

	private boolean isValid(UserDto userDto) {
		// null 체크
		if (userDto.getUsername() == null || userDto.getUsername().length() <= 4) {
			req.setAttribute("username_err", "userid의 길이는 최소 5자이상이어야합니다");
			System.out.println("[INVALID] userid의 길이는 최소 5자이상이어야합니다");
			return false;
		}
		if (userDto.getUsername().matches("^[0-9].*")) {
			System.out.println("[INVALID] userid의 첫문자로 숫자가 들어올수 없습니다");
			req.setAttribute("username_err", "userid의 userid의 첫문자로 숫자가 들어올수 없습니다");
			return false;
		}
		return true;
	}
	
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		// 문제가 생기면 포워딩
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
	
}

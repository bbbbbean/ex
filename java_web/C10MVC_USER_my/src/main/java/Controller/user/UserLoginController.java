package Controller.user;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.UserDto;
import Domain.Service.UserServiceImpl;

public class UserLoginController implements SubController {

	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private UserServiceImpl userService; // 여기서 로그인 처리
	
	public UserLoginController() throws Exception{
		userService = UserServiceImpl.getInstance();	
//		throw new Exception("TEST");
	}
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] UserLoginController execute..");

		try {
			String uri = req.getMethod();
			if(uri.equals("GET")) {		// GET방식이면 페이지가 보여지도록
				req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
				return ;
			}
			
			//파라미터(username,password)
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String role = "ROLE_USER";
			
			//입력값검증
			UserDto userDto = new UserDto(username,password,null);
			boolean isOk = isValid(userDto);
			if(!isOk) {
				req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
				return ;
			}
			
			//서비스
			boolean isLogin =  false;
			//boolean isJoin =  userService.userJoin(userDto);
			// 로그인 - 입력값과 DB의 값 비교
			Map<String,Object> serviceResponse = userService.login(userDto,req.getSession());
			isLogin =(boolean)serviceResponse.get("isLogin");
			String message = (String)serviceResponse.get("message");
			
			//뷰
			PrintWriter out = resp.getWriter();
			
			if(isLogin) {
				req.getSession().setAttribute("message", message);
				// 주소에 한글 쓰면 오류 터짐 원래는 메세지를 담으려 했으나 세션으로 뺌
				resp.sendRedirect(req.getContextPath()+"/index.do");
				// 메세지를 던지기 위해 PrintWriter 사용해보기
				//out.println("<sctipt>alert("+message+");location.href=/index.do;</sctipt>");
			}else {
				// 로그인 실패 시
				req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
			}
			
			
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}

	private boolean isValid(UserDto userDto) {
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
		// NULL 체크 / 데이터(자료)수준에서의 의미있는데이터가 포함되어져있는지 여부
		// userid 은 첫문자가 숫자인지 여부 - /or 길이가 1글자인지 등등..
		// username 은 첫문자가 숫자인지 여부 -
		// password 복잡도체크는 Business Layer 체크(Policy 에 의한 처리)

		return true;
	}
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}

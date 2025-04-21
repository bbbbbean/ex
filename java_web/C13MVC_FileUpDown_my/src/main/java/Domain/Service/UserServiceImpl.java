package Domain.Service;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import Domain.Dao.UserDao;
import Domain.Dao.UserDaoImpl;
import Domain.Dao.ConnectionPool.ConnectionPool;
import Domain.Dto.UserDto;


public class UserServiceImpl {
	
	//
	private UserDao userDao ;
	private ConnectionPool connectionPool ;	//TX
	
	//싱글톤 패턴
	private static UserServiceImpl instance;
	private UserServiceImpl() throws Exception {
		userDao = UserDaoImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init...");
	};
	public static UserServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance = new UserServiceImpl();
		return instance ;
	}
	
	//회원가입(+TX처리필요)
	public boolean userJoin(UserDto userDto) throws Exception{
		boolean isJoin = false;
		try {
		
			connectionPool.beginTransaction();
			
			isJoin  = userDao.insert(userDto)>0; //sql 질의 다수
//			userDao.insert(new UserDto("aaaaa","","",""));
//			userDao.insert(new UserDto("aaaab","","",""));
//			userDao.insert(new UserDto("aaaaa","","",""));	//PK 중복 오류!
			
			connectionPool.commitTransaction();
			
		}catch(SQLException e) {
			connectionPool.rollbackTransaction();
		}
	
		return  isJoin;
		
	};
	
	//회원조회
	
	//회원정보수정
	
	//회원탈퇴
	
	//로그인
	public Map<String,Object> login(UserDto userDto, HttpSession session) throws Exception{
		// 상태 정보 메세지를 같이 담아 보내기 위해 Map 형식으로 전달
		Map<String,Object> response = new LinkedHashMap();	// linked : 메모리 효율적으로 관리 가능
		boolean isLogin = false;
		try {
			//connectionPool.beginTransaction();
			UserDto userDb  = userDao.select(userDto.getUsername()); //sql 질의 다수
			
			if(userDb==null) {
				response.put("isLogin", false);
				response.put("message", "동일한 계정이 존재하지 않습니다.");
			}else {
				// 롤도 넣어주는게 좋음, 왜?
				// 롤을 기준으로 탑메뉴에 로그인하러가기 페이지 링크 혹은 로그아웃 링크를 걸어주면 됨
				
				// 패스워드 일치 여부 확인 (암호화 전)
				if(!userDto.getPassword().equals(userDb.getPassword())) {
					response.put("isLogin", false);
					response.put("message", "패스워드가 일치하지 않습니다.");
				}else {
					// Id, 패스워드 일치 -> 로그인
					// 세션 혹은 토큰(암호화된 쿠키) 이용
					// 비즈니스 로직은 여기서 처리하는게 맞음
					// 사용자에 대한 기본적인 인증 정보 담기
					session.setAttribute("isAuth", true);
					session.setAttribute("username", userDb.getUsername());
					session.setAttribute("role", userDb.getRole());
					session.setMaxInactiveInterval(60*10);	// 세션 만료 시간
					
					response.put("isLogin", true);
					response.put("message", "로그인 성공");
				}
			}
			// 셀렉트문에서 커넥션을 풀어버려서 커밋할 거리가 없어서 오류 나던 것
			//connectionPool.commitTransaction();
			
		}catch(SQLException e) {
			//connectionPool.rollbackTransaction();
		}
		return  response;
	};
	
	//로그아웃
	// UserService
	//  - logout함수 내 처리
	//		- session invalid 처리 하기
	//		- Map<String,Object> 로 return "isLogout",true , "message","로그아웃성공"
	
	public Map<String,Object> logout (HttpSession session){
		Map<String,Object> response = new LinkedHashMap();
		
		if((boolean) session.getAttribute("isAuth")) {
			session.invalidate();
			response.put("isLogout", true);
			response.put("message", "로그아웃 성공");
		}

		return response;
	}

}

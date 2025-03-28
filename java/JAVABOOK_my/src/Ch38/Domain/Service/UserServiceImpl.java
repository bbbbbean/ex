package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.Dao.UserDao;
import Ch38.Domain.Dao.UserDaoImpl;
import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38.Domain.Dto.UserDto;

// 회원 가입 등을 위한 유저 서비스
// 중간에서 묶어줌
// 유지보수 가능성 고려할 것
// 시퀀스 다이어그램 : 요청과 응답 도식화, 함수 적는게 좋음
//			     : 비즈니스 로직을 처리하기 위해 사용자-서비스별 이용관계를 정의하는 부분 
//				 : 시퀀스 == 순서

public class UserServiceImpl {
	
	// DB와 연결 - userDao가 가지고 있음 - 연결
	private UserDao userDao;
	private ConnectionPool connectionPool;
	
	// 싱글톤 패턴 처리 : 컨트롤러에서 바로 연결하기 위함
	private static UserServiceImpl instance;
	private UserServiceImpl() throws Exception {
		// DB와 연결 - userDao가 가지고 있음 - 연결
		userDao = UserDaoImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init");
	};
	public static UserServiceImpl getInstance() throws Exception {
		if(instance == null)
			instance = new UserServiceImpl();
		return instance;
	}

	// 서비스 함수 생성
	// 비즈니스 - 함수의 용도에 맞게 함수 이름 잘 지어주기
	// 서비스 계층 : 유동적 - 맞는 반환 형태와 인자 잘 넣어주기
	// 회원 가입(+TX(트랜젝션) 처리 필요)
	public boolean UserJoin(UserDto userDto) throws Exception{
		// ** 예외 처리는 다 떠넘김, 가끔 여기서 해결할 수도 있지만 그럴 경우에도 결과값은 예외 핸들러로 넘김
		boolean isJoin = false;
		try {
			// TX처리는 매번 모든 함수에 넣어줘야함 - 공통 관심사, 횡단 처리 로직(AOP)
			connectionPool.beginTransaction();	// TX 시작, 블럭 묶기 시작
			
			isJoin = userDao.insert(userDto)>0;	// sql 질의 다수
//			userDao.insert(new UserDto("aaaaa","","",""));	// 인위적으로 만든 문제 상황
//			userDao.insert(new UserDto("aaabb","","",""));	// 인위적으로 만든 문제 상황
//			userDao.insert(new UserDto("aaaaa","","",""));	// 인위적으로 만든 문제 상황, Pk 중복오류
			
			
			connectionPool.commitTransaction();	// TX 종료
			
		}catch(SQLException e) {
			// rollback
			connectionPool.rollbackTransaction(); // rollback
		}
		return isJoin;
	}
	
	// 회원 조회
	
	// 회원 정보 수정
	
	// 회원 탈퇴
	
	// 로그인
	
	// 로그아웃
	
	
	
}

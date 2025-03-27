package Ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.UserDto;

// 유저 테이블과의 연결 위함

public class UserDaoImpl {
	// DB연결에 필요한 클래스 먼저 정리
	// DB Attr
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String id = "root";
	private String pw = "1234";
	private String url = "jdbc:mysql://localhost:3306/bookDB";
	
	// 싱글톤 패턴 처리
	// 객체 하나만 만드는 것, 접속할 유저별로 하나만 생성해 관리
	private static UserDaoImpl instance;
	private UserDaoImpl() throws ClassNotFoundException, SQLException   {
		// DB연결작업
		// 예외 단위 중앙화를 위해 예외는 controller로 던짐
		System.out.println("[DAO] UserDaoImpl init");
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("BookDaoImpl DB Connection Success");
	}
	public static UserDaoImpl getInstance() throws ClassNotFoundException, SQLException  {
		if(instance==null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	// CRUD 함수 - 유저 테이블과 연결된 처리함수
	// 추가하면 추가된 행의 갯수 리턴
	public int insert(UserDto userDto) throws SQLException {
		// 원래 여기서 예외처리 안함, 커넥션풀이 없어서 임시 작업
		try {
			// Dto에서 받은 쿼리문 실행
			// user insert == 회원가입
			// Dto에 맞게 컬럼 생성
			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
			pstmt.setString(1, userDto.getUserid());
			pstmt.setString(2, userDto.getUsername());
			pstmt.setString(3, userDto.getPassword());
			pstmt.setString(4, "ROLE_USER");
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("UserDao's Insert SQL Exception");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	// 수정하면 수정된 행의 갯수 리턴
	public int update(UserDto userDto) throws SQLException {
		// 원래 여기서 예외처리 안함, 커넥션풀이 없어서 임시 작업
		try {
			// Dto에서 받은 쿼리문 실행
			pstmt = conn.prepareStatement("");
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("UserDao's Update SQL Exception");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	// 삭제하면 삭제된 행의 갯수 리턴
	public int delete(UserDto userDto) throws SQLException {
		// 원래 여기서 예외처리 안함, 커넥션풀이 없어서 임시 작업
		try {
			// Dto에서 받은 쿼리문 실행
			pstmt = conn.prepareStatement("");
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("UserDao's Delete SQL Exception");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	// 단건조회
	public UserDto select(UserDto userDto) {
		return null;
	}
	// 다건조회(전체 조회)
	public List<UserDto> selectAll(){
		return null;
	}


}

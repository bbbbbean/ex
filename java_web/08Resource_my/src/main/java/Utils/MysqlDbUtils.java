package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MysqlDbUtils {
	
	private String url = "jdbc:mysql://localhost/testDB";
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	// 데이터 소스를 받아와서 사용
	// DataSource Resource 연결
	private DataSource dataSource;
	
	//싱글톤 : 여기서 작업
	private static MysqlDbUtils instance;
	private MysqlDbUtils() throws Exception {
		// Class.forName("com.mysql.cj.jdbc.Driver");
		// conn = DriverManager.getConnection(url, id, pw);
		
		// 직접 연결하지 않아도 됨
		// 아래 코드로 연결
		// 미리 만들어 놓은 자원들을 연결, 검색하기 위한 객체
		Context initContext = new InitialContext();
		// lookup : 이름으로 검색, 이름 제대로 적어주는게 중요
		// Context의 환경 값 들고옴
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		dataSource = (DataSource)envContext.lookup("jdbc/MysqlDB");
		conn = dataSource.getConnection();
		System.out.println("Connection : "+conn);
	}
	public static MysqlDbUtils getInstance() throws Exception {
		if(instance==null)
			instance = new MysqlDbUtils();
		return instance;
	}
	
	public int insert(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_test values(?,?,?)");
		pstmt.setString(1,userDto.getUsername());
		pstmt.setString(2,userDto.getPassword());
		pstmt.setString(3,userDto.getRole());
		
		int result =  pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	public UserDto selectOne(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_test where username=?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		UserDto userDto = null;
		if(rs!=null) {
			rs.next();
			userDto = new UserDto(rs.getString(1),rs.getString(2),rs.getString(3));
		}
		return userDto;
	}

}








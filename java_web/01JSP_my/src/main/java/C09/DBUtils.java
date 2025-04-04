package C09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import C04.UserDto;

public class DBUtils {
	// DB 관련 코드 다 넣을 예정
	
	
	// 아래 경로는 시험 문제에 제공
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;	// 시험장에서 정리.. 안해도 뭐..
	private PreparedStatement pstmt;	// 정리 잘하기
	private ResultSet rs;	// 정리 잘하기
	
	
	// 싱글톤 패턴 처리 - 가능하다면
	private static DBUtils instance;
	private DBUtils() throws Exception {
		// 생성자에서 처리
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}
	public static DBUtils getInstance() throws Exception {
		if(instance == null)
			instance = new DBUtils();
		return instance;
	}
	
	// 3~4개 있을 예정,.. 이름 다양하게 해서 잘 빼쓰기
	public int insertUser(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	public UserDto selectOneUser(String userid) throws Exception{
		pstmt = conn.prepareStatement("select * from tbl_user where userid=?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		UserDto userDto = null;
		if(rs != null) {
			while(rs.next()) {
				userDto = new UserDto();
				userDto.setUserid(rs.getString("userid"));
				userDto.setPassword(rs.getString("password"));
				userDto.setRole(rs.getString("role"));
			}
		}
		rs.close();
		pstmt.close();
		return userDto;
	}
	public List<UserDto> selectAllUser() throws Exception{
		pstmt = conn.prepareStatement("select * from tbl_user");
		rs = pstmt.executeQuery();
		List<UserDto> list = new ArrayList();
		UserDto userDto = null;

		if(rs != null) {
			while(rs.next()) {
				userDto = new UserDto();
				userDto.setUserid(rs.getString("userid"));
				userDto.setPassword(rs.getString("password"));
				userDto.setRole(rs.getString("role"));
				list.add(userDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	public int updateUser(UserDto userDto) throws Exception{
		pstmt = conn.prepareStatement("update tbl_user set userid=?, password=?, role=? where userid=?");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		pstmt.setString(4, userDto.getUserid());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	public int deleteUser(String userid) throws Exception {
		pstmt = conn.prepareStatement("delete from tbl_user where userid=?");
		pstmt.setString(1, userid);
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	
}

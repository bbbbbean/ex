package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OracleDBUtils {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	private DataSource dataSource;
	
	//싱글톤 
	private static OracleDBUtils instance;
	private OracleDBUtils() throws Exception {
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//conn = DriverManager.getConnection(url, id, pw);
		
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		dataSource = (DataSource)envContext.lookup("jdbc/Oracle");
		conn = dataSource.getConnection();
		System.out.println("Connection : "+conn);
	}
	public static OracleDBUtils getInstance() throws Exception {
		if(instance==null)
			instance = new OracleDBUtils();
		return instance;
	}
	
	public int userJoin(UserDto user) throws Exception{
		// insert 문
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
		pstmt.setString(1, user.getUserid());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getRole());
		pstmt.setString(4, user.getAddr());
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	public UserDto selectOne(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_user where userid='"+username+"'");
		rs = pstmt.executeQuery();
		UserDto userDto = null;
		
		if(rs!=null) {
			rs.next();
			userDto = new UserDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
		}
		rs.close();
		pstmt.close();
		return userDto;
	}
}








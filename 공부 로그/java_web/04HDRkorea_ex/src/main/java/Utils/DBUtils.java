package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
	// DB 연결
	// 전부 private
	private String url = "jdbc:oracle:thin@//localhost:1521/xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 싱글톤
	private static DBUtils instance;	// static
	private DBUtils() throws Exception{
		Class.forName("oracla.jdbc.OracleDriver");
		conn = DriverManager.getConnection(url,id,pw);
	}
	// instance 따와야 하는거만 public
	public static DBUtils getInstance() throws Exception {
		if(instance==null) 
			instance = new DBUtils();
		return instance;
	}
	
	
	// 쿼리문
	public List<StudentDto> selectAllStudent() throws Exception{
		String sql="";
		pstmt = conn.prepareStatement(sql);
		List<StudentDto> list = new ArrayList();
		StudentDto dto = null;
		
		rs = pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				dto = new StudentDto();
				
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	
}

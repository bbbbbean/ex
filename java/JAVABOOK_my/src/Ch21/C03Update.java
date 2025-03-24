package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C03Update {

	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// DRIVER 메모리 적재
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			// CONNECTION
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");
			
			
//			pstmt = conn.prepareStatement("Update tbl_std set age=20 where name='홍길동'");
			
//			String name = "적길동";
//			int age = 20;
//			String addr = "대전";
//			pstmt = conn.prepareStatement("Update tbl_std set age=?,addr=? where name=?");
//			pstmt.setInt(1, age);
//			pstmt.setString(2, addr);
//			pstmt.setString(3, name);
			
//			String name = "청길동";
//			int age = 3;
//			String addr = "청산";
//			pstmt = conn.prepareStatement("Update tbl_std set age="+age+",addr='"+addr+"'where name='"+name+"'");

			String name = args[0];
			int age = Integer.parseInt(args[1]);
			String addr = args[2];
			pstmt = conn.prepareStatement("Update tbl_std set age="+age+",addr='"+addr+"'where name='"+name+"'");
			
			
			// SQL 실행
			int result = pstmt.executeUpdate();	// return 1. 추가, 수정, 삭제 된 행 갯수, 2. 0
						
			if(result>0) {
				System.out.println("Update 성공");
			}else {
				System.out.println("Update 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	
			try { conn.close();} catch (SQLException e) {e.printStackTrace(); }
		}
	}

}

package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C04Delete {

	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//tbl_std 에 삭제 코드 넣어보세요(단일삭제하기)

		try {
			// DRIVER 메모리 적재
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			// CONNECTION
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");
			
			
			
			// 고정값
//			pstmt = conn.prepareStatement("delete from tbl_std where name='홍길동'");
			// 변수
//			String name = "백길동";
//			pstmt = conn.prepareStatement("delete from tbl_std where name=?");
//			pstmt.setString(1, name);
			// 변수2
//			String name = "적길동";
//			pstmt = conn.prepareStatement("delete from tbl_std where name='"+name+"'");
			// main args -> 한번은 실행해야 메인의 위치가 잡힘
			String name = args[0];
//			pstmt = conn.prepareStatement("delete from tbl_std where name='"+name+"'");
			pstmt = conn.prepareStatement("delete from tbl_std where name=?");
			pstmt.setString(1, name);
			
			// SQL 실행
			int result = pstmt.executeUpdate();	// return 1. 추가, 수정, 삭제 된 행 갯수, 2. 0
						
			if(result>0) {
				System.out.println("Delete 성공");
			}else {
				System.out.println("Delete 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	
			try { conn.close();} catch (SQLException e) {e.printStackTrace(); }
		}
	}

}

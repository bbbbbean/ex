package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class C05Select {
	public static void main(String[] args) {
		
		// DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		// JDBC 참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// DRIVER 메모리 적재
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success");
			
			// DB연결
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB Connected");
			
			// SQL 준비
			pstmt = conn.prepareStatement("select * from tbl_std");	// select 구문
			
			// SQL 실행
			rs = pstmt.executeQuery();	// 반환 자료형 : result set, null 불가, select 된 결과가 없더라도 result set은 만들어짐
			// rs의 디폴트 위치 : 목록 행 (name, age, addr)
			if(rs!=null) {	// null체크는 언제나 해주기
				while(rs.next()) {	// 다음행이 있는지 확인 후 다음행 출력
					// 테이블 정보 출력
					System.out.print(rs.getString("name")+" ");
					System.out.print(rs.getInt("age")+" ");
					System.out.print(rs.getString("addr")+" \n");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 자원정리 필수! 역순으로 실행
			try {rs.close();	}catch(SQLException e) {e.printStackTrace();}
			try {pstmt.close();	}catch(SQLException e) {e.printStackTrace();}
			try {conn.close();	}catch(SQLException e) {e.printStackTrace();}
		}
		
		
		
	}
}

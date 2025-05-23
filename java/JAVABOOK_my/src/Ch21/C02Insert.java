package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 

public class C02Insert {
	public static void main(String[] args) {
		
		// DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";		
		
		// JDBC 참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet re = null;
		
		try {
			// DRIVER 메모리 적재
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success");
			
			
			// CONNECTION
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB Connected");
			
			
			// SQL 쿼리 준비** 
//			pstmt=conn.prepareStatement("sql 문장");
			
			// 고정값 쿼리문
			pstmt=conn.prepareStatement("insert into tbl_std values('홍길동',10,'대구')");	// 고정값 -> 보통 가변값을 고려함
			
			// 변수 쿼리문 방법1. ?
//			String name = "청길동";
//			int age = 10;
//			String addr = "대구";
//			pstmt=conn.prepareStatement("insert into tbl_std values(?,?,?)");	// 변수 표시 = ?
//			pstmt.setString(1, name); 	// 변수 순서, 변수
//			pstmt.setInt(2, age);		// 변수 순서, 변수
//			pstmt.setString(3, addr); 	// 변수 순서, 변수
			
			// 변수 쿼리문 방법2. 변수 직접 집어넣기 (상단 방법 지원 안될 수도 있음)
//			pstmt=conn.prepareStatement("insert into tbl_std values('"+name+"',"+age+",'"+addr+"')");	// 문자열은 앞뒤로 홑따옴표
			
			// 외부인자 받아 실행 (main args)
			String name = args[0];
			int age = Integer.parseInt(args[1]);
			String addr = args[1];
			pstmt=conn.prepareStatement("insert into tbl_std values('"+name+"',"+age+",'"+addr+"')");
			
			// SQL 실행
			int result = pstmt.executeUpdate();	// return 1. 추가, 수정, 삭제 된 행 갯수, 2. 0
			
			if(result>0) {
				System.out.println("Insert 성공");
			}else {
				System.out.println("Insert 실패");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();	}catch(SQLException e) {e.printStackTrace();}	// 자원 반납 시 예외가 뜰 수 있음	
		}
		
		
		
	}
}

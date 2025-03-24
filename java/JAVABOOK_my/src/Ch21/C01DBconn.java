package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// JDBC

// 어느 외부 시스템과 연결, 어떤 프로그램을 쓰는지 java에 적재 -> DB연결(connection) -> 쿼리문 제작(statement, preparedStatement - DB공격 차단을 위해선 후자 사용)
// -> 자바에서 DB로 쿼리문 전송 (select/insert,update,delete)

// 드라이브들과 아카이브로 연결할 예정

// mysql-java 커넥터
// https://dev.mysql.com/downloads/connector/j/
// 14장 mysql ppt에 설치법 나와있음

public class C01DBconn {
	public static void main(String[] args) {
		
		// DB CONN DATA
		// 접속을 위한 자료
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		//			  고정 : 프로그램 // 접속 위치(Network)/DB명
		
		
		// JDBC 참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet re = null;	// 내용을 받아오기 위한 클래스
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// jar 해당 위치에 있음
			System.out.println("Driver Loading Success");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB Connected");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();	}catch(SQLException e) {e.printStackTrace();}	// 자원 반납 시 예외가 뜰 수 있음	
		}
		
		
		
	}
}

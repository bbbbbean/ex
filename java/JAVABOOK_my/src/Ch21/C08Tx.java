package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//transaction : 더이상 분할이 불가능한 업무 처리의 단위
// 			  : 하나의 작업을 위해 더이상 분할 될 수 없는 명령들의 모음
//			  : 한꺼번에 수행되어야 할 일련의 연산모음

// 기능을 구현한다는데 하나의 쿼리만 들어간다는 보장 X (ex, 회원가입 : 회원정보 확인(select), 해당 회원이 없다면? 회원 정보 삽입(insert) -> 2개 사용)
// 예시		  : A은행과 B은행 -> 계좌이체 -> A에 update(돈차감), B에 update(돈추가) : 하나의 기능
//			  : 트랜젝션 x시, 두 update가 따로 기능함 -> 오류시, A에서 돈은 나갔는데 B에 돈이 안들어가는 상황 발생
//			  : 기능단위로 묶이면 중간에 오류가 나도 원래대로 원복이 쉬움

// 결론		  : 같이 동작되어야 하는 기능 묶음, 페어 처리, 같이 성공 혹은 같이 실패


public class C08Tx {	
	// DB setup
	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";		
					
	// JDBC 참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet re = null;
	
	public static void main(String[] args) {
		try {
			// DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB Connected");
			
			// insert 여러개 삽입 - 여러개의 쿼리문 사용
			// 하나의 기능으로 묶지 않음 -> 중간에 에러 발생 시 이전 작업은 완료
			// 하나의 기능으로 묶어 모두 실행 취소로 만들어보기
			System.out.println("insert 시작");
			conn.setAutoCommit(false); 	// mysql은 작업시 자동으로 커밋됨 -> 이 기능 꺼주는거
										// 임시 테이블에 저장 후 커밋 코드 발견시 그 때 커밋됨
			pstmt = conn.prepareStatement("insert into tbl_std values('a',1,'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('b',1,'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('a',1,'a')");	// PK 중복 오류
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbl_std values('d',1,'a')");
			pstmt.executeUpdate();
			conn.commit(); // 해당 시점에서 커밋
			System.out.println("insert 종료");
			
		}catch(Exception e) {	// 오류 발생 시
			e.printStackTrace();
			try {conn.rollback();}catch(Exception e2) {}	// rollback : 커밋 전 시점으로 되돌려줌
		}finally {
			try {pstmt.close();}catch(Exception e1) {}
			try {conn.close();}catch(Exception e1) {}
		}
		
		
	}
}

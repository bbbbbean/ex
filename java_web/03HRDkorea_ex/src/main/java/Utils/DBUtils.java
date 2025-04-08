package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


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
	
	// 강사테이블 조회
	public List<TeacherDto> selectAllTeacher() throws Exception{
		String sql="select * from TBL_TEACHER_202201";
		pstmt = conn.prepareStatement(sql);
		List<TeacherDto> list = new ArrayList();
		TeacherDto dto = null;
		
		rs = pstmt.executeQuery();
		if(rs != null) {
			while(rs.next()) {
				dto = new TeacherDto();
				dto.setTeacher_code(rs.getString(1));
				dto.setTeacher_name(rs.getString(2));
				dto.setClass_name(rs.getString(3));
				dto.setClass_price(rs.getInt(4));
				dto.setTeacher_regist_date(rs.getString(5));
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	
}

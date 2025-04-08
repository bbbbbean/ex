package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
	
	
	public List<MemberDto> selectAllMember() throws Exception{
		
		// 조회 쿼리문
		// select m_no, m_name, p_name,p_school,m_jumin,M_city,p_tel1,p_tel2,p_tel3
		// from tbl_member_202005
		// join tbl_party_202005
		// on tbl_member_202005.p_code=tbl_party_202005.p_code;
		
		String sql = "select m_no, m_name, p_name,p_school,m_jumin,M_city,p_tel1,p_tel2,p_tel3"
				+ " from tbl_member_202005"
				+ " join tbl_party_202005"
				+ " on tbl_member_202005.p_code=tbl_party_202005.p_code";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<MemberDto> list = new ArrayList();
		MemberDto dto = null;

		if(rs!=null) {
			while(rs.next()) {
				dto = new MemberDto();
				dto.setM_no(rs.getString(1));
				dto.setM_name(rs.getString(2));
				dto.setP_name(rs.getString(3));
				dto.setP_school(rs.getString(4));
				dto.setM_jumin(rs.getString(5));
				dto.setM_city(rs.getString(6));
				dto.setP_tel1(rs.getString(7));
				dto.setP_tel2(rs.getString(8));
				dto.setP_tel3(rs.getString(9));
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	
	public int insertVote(VoteDto dto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_vote_202005 values (?,?,?,?,?,?)");
		pstmt.setString(1, dto.getV_jumin());
		pstmt.setString(2, dto.getV_name());
		pstmt.setString(3, dto.getM_no());
		pstmt.setString(4, dto.getV_time());
		pstmt.setString(5, dto.getV_area());
		pstmt.setString(6, dto.getV_confirm());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
}

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
	
	// 회원 테이블 조회
	public List<MemberDto> selectAllMember() throws Exception{
		String sql="select * from TBL_member_202201";
		pstmt = conn.prepareStatement(sql);
		List<MemberDto> list = new ArrayList();
		MemberDto dto = null;
		
		rs = pstmt.executeQuery();
		if(rs != null) {
			while(rs.next()) {
				dto = new MemberDto();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setGrade(rs.getString(5));
				
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	// 강의 테이블 조회
	public List<ClassDto> selectAllClass() throws Exception{
		String sql="select * from TBL_class_202201";
		pstmt = conn.prepareStatement(sql);
		List<ClassDto> list = new ArrayList();
		ClassDto dto = null;
		
		rs = pstmt.executeQuery();
		if(rs != null) {
			while(rs.next()) {
				dto = new ClassDto();
				dto.setRegist_month(rs.getString(1));
				dto.setC_no(rs.getString(2));
				dto.setClass_area(rs.getString(3));
				dto.setTuition(rs.getInt(4));
				dto.setTeacher_code(rs.getString(5));
				
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	// class 테이블 insert
	public int insertClass(ClassDto classDto) throws Exception {
		String sql="insert into tbl_class_202201 values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, classDto.getRegist_month());
		pstmt.setString(2, classDto.getC_no());
		pstmt.setString(3, classDto.getClass_area());
		pstmt.setInt(4, classDto.getTuition());
		pstmt.setString(5, classDto.getTeacher_code());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	// member + class
	public List<MemberInfoDto> selectAllMemberInfo() throws Exception{
		// select regist_month, TBL_MEMBER_202201.c_no, c_name, teacher_code, class_area, tuition
		// from TBL_MEMBER_202201
		// join TBL_CLASS_202201
		// on TBL_MEMBER_202201.c_no=TBL_CLASS_202201.c_no;
		String sql="select regist_month, TBL_MEMBER_202201.c_no, c_name, teacher_code, class_area, tuition, grade"
				+ " from TBL_MEMBER_202201"
				+ " join TBL_CLASS_202201"
				+ " on TBL_MEMBER_202201.c_no=TBL_CLASS_202201.c_no";
		pstmt = conn.prepareStatement(sql);
		List<MemberInfoDto> list = new ArrayList();
		MemberInfoDto dto= null;
		rs = pstmt.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				dto = new MemberInfoDto();
				dto.setRegist_month(rs.getString(1));
				dto.setC_no(rs.getString(2));
				dto.setC_name(rs.getString(3));
				dto.setTeacher_code(rs.getString(4));
				dto.setClass_area(rs.getString(5));
				dto.setTuition(rs.getInt(6));
				dto.setGrade(rs.getString(7));
				
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	// teacher + class
	public List<TeacherClassDto> SelectTeacherInfo() throws Exception{
		String sql="select TBL_CLASS_202201.teacher_code, class_name, teacher_name, sum(tuition)"
				+ " from TBL_CLASS_202201"
				+ " join TBL_teacher_202201"
				+ " on TBL_CLASS_202201.teacher_code = tbl_teacher_202201.teacher_code"
				+ " group by TBL_CLASS_202201.teacher_code, class_name, teacher_name"
				+ " order by TBL_CLASS_202201.teacher_code";
		pstmt = conn.prepareStatement(sql);
		List <TeacherClassDto> list = new ArrayList();
		TeacherClassDto dto = null;
		rs = pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				dto = new TeacherClassDto();
				dto.setTeacher_code(rs.getString(1));
				dto.setClass_name(rs.getString(2));
				dto.setTeacher_name(rs.getString(3));
				dto.setSumTuition(rs.getInt(4));
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	
	
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%!
	//DB연결
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";

	private Connection conn;	// 시험장에서 정리.. 안해도 뭐..
	private PreparedStatement pstmt;	// 정리 잘하기
	private ResultSet rs;		// 정리 잘하기
	
	private void getConnection() throws Exception{
		if(conn==null)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
	}
	
	// 아이디 비교 -> 아이디 넣어서 조회 했을때 null이면 됨
	
	private int select(String userid) throws Exception{
		pstmt = conn.prepareStatement("select * from join_tbl where='"+userid+"'");
		rs = pstmt.executeQuery();
		
		
		rs.close();
		pstmt.close();
		return ;
	}
	
%>
    
<%
	// 파라미터 받아오기
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");

	// 유효성 체크
	if(userId.isEmpty()){
		request.setAttribute("userid_msg","ID를 입력하세요");
	}
	if(password.isEmpty()){
		request.setAttribute("password_msg","PW를 입력하세요");
	}
	if(userId.isEmpty()||password.isEmpty()){
		request.getRequestDispatcher("./join_form.jsp").forward(request, response);
		return;
	}
	
	// user info와 대조
	// 
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./errors.jsp"%>
<%@page import="java.sql.*, C04.*" %>
<!--
	1. db 연결 사전 작업
	   C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar
	   해당 파일 WEB-INF - lib에 넣기
	2. 속성/기능 추가 : db연결, 쿼리문
	3. service 란에서 사용
-->
    
    
<!-- 속성/기능 추가 -->
<%!
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void getConnection() throws Exception{
		if(conn==null)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
	}
	private int insert(UserDto userDto) throws Exception{
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
		pstmt.setString(1,userDto.getUserid());
		pstmt.setString(2,userDto.getPassword());
		pstmt.setString(3,userDto.getRole());
		
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return result;
	}
%>

<!-- service함수 -->
<%
	/* 요청 정보 확인 */
	String url = (String)request.getAttribute("url");	// 기본적으로 객체 단위로 줌 -> downcasting 필요
	Integer serviceNo = (Integer)request.getAttribute("serviceNo");
	System.out.println("URL : "+url);
	System.out.println("serviceNo : "+serviceNo);

	getConnection(); 	// db연결
	
	if(url.contains("/join")){
		UserDto userDto = (UserDto)request.getAttribute("userDto");
		insert(userDto);
	}
%>
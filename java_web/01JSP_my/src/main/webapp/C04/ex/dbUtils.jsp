<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./errors.jsp"%>
<%@page import="java.sql.*, C04.*" %>
<!--
	1. db 연결 사전 작업
	   C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar
	   해당 파일 WEB-INF - lib에 넣기
	2. 속성/기능 추가 : db연결, 쿼리문
	3. service 란에서 사용
	4. 문제가 없다면 login 페이지로 redirecting
-->
    
    
<!-- 속성/기능 추가 -->
<%!
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
	private UserDto selectOne(String userid) throws Exception{
		pstmt = conn.prepareStatement("select * from tbl_user where userid='"+userid+"'");	// 홑따옴표로 문자열 표현 명시, 이게 더 정확함..
		rs = pstmt.executeQuery();
		UserDto userDto=null;
		
		if(rs != null){
			if(rs.next()){
				userDto = new UserDto();
				userDto.setUserid(userid);
				userDto.setPassword(rs.getString("password"));
				userDto.setRole(rs.getString("role"));
			}
		}
		rs.close();
		pstmt.close();
		return userDto;
	}
%>

<!-- service함수 -->
<%
	/* 요청 정보 확인 */
	String url = (String)request.getAttribute("url");	// 기본적으로 객체 단위로 줌 -> downcasting 필요
	Integer serviceNo = (Integer)request.getAttribute("serviceNo");
	System.out.println("URL : "+url);
	System.out.println("serviceNo : "+serviceNo);
	
	if(url.contains("/join")){
		getConnection(); 	// db연결
		UserDto userDto = (UserDto)request.getAttribute("userDto");
		if(insert(userDto)>0){
			response.sendRedirect("login_form.jsp");	// redirect 다수 사용시 return 예약어 사용
			return;
		}
	}
	if(url.contains("/myinfo")){
		request.setAttribute("isConfirm", true);	// 루핑 방지, 무조건 true
		
		getConnection(); 	// db연결
		String userid = request.getParameter("userid");
		UserDto userDto = selectOne(userid);
		
		request.setAttribute("myinfo-result", userDto);
		request.getRequestDispatcher("./myinfo.jsp").forward(request, response);	// forwarding 처리
		return;
		
	}

%>
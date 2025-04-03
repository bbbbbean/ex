<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.io.*" %>

<%
	// InputStream
	// 특정 파일을 읽어 읽은 파일을 다운로드 처리
	// 경로부터 읽어야함, 프로젝트 경로부터 읽기
	// 윈도우는 역슬러스(\) 두번
	String dirPath = pageContext.getServletContext().getRealPath("/")+"C05\\files\\";
	System.out.println("dirPath : "+dirPath);
	
	try{
		// InputStream
		FileInputStream in = new FileInputStream(dirPath+"TEST.txt");
		
		// OutputStream
		out.clear();					// response outStream을 닫고 버퍼를 비움
		out = pageContext.pushBody();	// 현재 페이지의 body에 연결
		ServletOutputStream bout = response.getOutputStream();
		
		// 넣은 파일을 문서가 아닌 파일로 인식하게 해야 함
		// Response Header 지정 ***
		response.setHeader("Content-type","application/octet-stream;charset-utf-8");
		response.setHeader("Content-Disposition","attachment; filename=TEST.txt");
		
		byte[] buff = new byte[4096];
		while(true){	// 버퍼를 사용해 용량이 큰 파일도 빠르게 받아올 수 있게 설정
			int data = in.read(buff);
			if(data==-1)	// 파일이 끝나면
				break;
			/* bout.write((byte)data); 버퍼 설정 전*/
			/* 버퍼, 시작 인덱스(위치), 길이(전체 넣고싶으면 data 전체) */
			bout.write(buff,0,data);
			bout.flush();
		}
		bout.close();
		in.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	
	




%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 다운로드 처리 -->
	<!-- outputStream을 꺼낼 수 있다는건 어떤 처리를 할 수 있다는 뜻 -->




</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 

	<h1>MEMO ADD(/memo/add)</h1>
	
	<form action="${pageContext.request.contextPath}/memo/add" method="post">
		<div>
			<!-- 에러 메시지 : 필드 이름으로 들어옴, 해당 이름으로 설정하면 메세지 꺼내서 출력 -->
			<label>id : </label> <span>${id}</span><br>
			<input name="id" />
		</div>
		<div>
			<label>text : </label>  <span>${text}</span><br>
			<textarea name="text" /></textarea>
		</div> 
		<div>
			<label>writer : </label>  <span>${writer}</span><br>
			<input name="writer" />
		</div>
		
		<div>
			<label>createAt : </label>  <span>${createAt}</span><br>
			<!-- in-format 작업 -->
			<!-- 데이터가 어떻게 들어오는지 확인 필요 -->
			<!-- 2025-04-24 오전 09:29 형식으로 들어옴-->
			<!-- yyyy-MM-dd'T'HH:mm -->
			<input type="datetime-local" name="createAt" />
		</div>
		
		
		<div>
			<label>dateTest(customFormat) : </label>  <span></span><br>
			<input type="text" name="dateTest" placeHolder="yyyy#MM#dd" />
		</div>
		
		<div>
			<input type="submit" value="메모쓰기" />
		</div>
	</form>
</body>
</html>
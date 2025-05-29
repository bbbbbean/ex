<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 반복처리 하면서 아래 내용들 꺼낼 때 사용, 기본 제공 --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 최상위 경로는 보이지 않게 처리하기 : 보이지 않는 편이 좋음 -->
	<h1>File List</h1>
	<div>FilePath : ${uploadPath }</div>
	<!-- 파일 객체로 만들어 던지기 -->
	<c:forEach items='${uploadPath.listFiles()}' var='subdir'>
		FOLDER : ${subdir.getPath()} </br>
		<c:forEach items='${subdir.listFiles() }' var='file'>
			- file :
			<!-- 누르면 다운로드 되게 처리 --> 
			<a href="javascript:void(0)" class="item" data-dir="${subdir.getPath()}" data-filename="${file.getName()}">
				${file.getPath() } </br>
			</a>
		</c:forEach>
		<hr>
	</c:forEach>
	
	<script>
	const projectPath = '${pageContext.request.contextPath}';
	
	const item_els = document.querySelectorAll('.item');
	item_els.forEach((item)=>{
		
		item.addEventListener('click',function(){
			
			const filepath= encodeURIComponent(item.getAttribute('data-dir')+"\\"+item.getAttribute('data-filename'))
			alert(filepath);
			location.href=projectPath+"/file/download?path="+filepath;
		})
		
	})
	</script>
	
</body>
</html>
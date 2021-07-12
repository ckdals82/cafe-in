<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#box{
		width: 600px;
		height: auto;
		border: 2px solid blue;
		margin: 10px;
		
	}
	
	#box > img{
	margin: 20px;
	width: 150px;
	height: 150px;
	border: 2px solid #8888ff;
	}
	
	#box > img:hover{
	
	border: 2px solid pink;
	}
</style>

</head>
<body>
<hr>
	${ vo.title }
<hr>
	<div id="box">
	<!--  for string fileanme : vo file_list -->
	 <c:forEach var="filename" items="${ vo.file_list }">
		<img src="resources/upload/${ filename }" width="150"> 
	 </c:forEach> 
	</div>
	
	<br>
	<p>${ vo.content }</p>
	
	<br>
	<a href="insert_form3.do">다시하기</a>
	
</body>
</html>
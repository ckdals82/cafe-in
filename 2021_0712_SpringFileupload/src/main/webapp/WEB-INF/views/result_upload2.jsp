<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	${ vo.title }
<hr>
	<img src="resources/upload/${ vo.filename }" width="150"> <br>
	<p>${ vo.content }</p>
	
	<br>
	<a href="insert_form.do">다시하기</a>
	
</body>
</html>
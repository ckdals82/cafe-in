<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제목 : ${ title }
	<hr>
	<!-- for(string filename : file_list) -->
	<c:forEach var="filename" items="${ file_list }">
	<img  src="upload/${ filename }" width="100" height="100"> <br>
	</c:forEach>
	
	<br>
	<a href="input_upload3.jsp">다시하기</a>
</body>
</html>
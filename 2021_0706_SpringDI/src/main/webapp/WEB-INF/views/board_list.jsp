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
	<hr>
		각나라 인사말
	<hr>
	<ul>
		<!-- for(String fruit: fruit list) -->
		<c:forEach var="msg" items="${ list }">
			<li>${ msg } </li>
		</c:forEach>
	</ul>
	
</body>
</html>
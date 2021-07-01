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
	도서목록
<hr>
	<ul>
		<!-- for(string book : book_list) -->
		<c:forEach var="book" items="${ requestScope.book_list }">
			<li> <a href="view.do?book=${ book }">${ pageScope.book }</a> </li>
		</c:forEach>
		
		
	</ul>
</body>
</html>
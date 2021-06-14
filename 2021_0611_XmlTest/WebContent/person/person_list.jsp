<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



<style type="text/css">

#box{
width: 800px;
margin: auto;
margin-top: 50px;
}
</style>

</head>
<body>
<div id="box">
	<table class="table">
		<tr class="success">
		<th>번호</th>
		<th> 이름</th>
		<th> 닉네임</th>
		<th> 나이</th>
		<th> 휴대전화</th>
		<th> 집전화</th>
		
		</tr>
		<c:forEach var="vo" items="${list }">
		<tr>
			<td>1 </td>
			<td>${vo.name }</td>
			<td>${vo.nickname } </td>
			<td> ${vo.age }</td>
			<td> ${vo.tel }</td>
			<td> ${vo.hometel }</td>
		</tr>
		</c:forEach>
	</table>
	
	
</div>
</body>
</html>
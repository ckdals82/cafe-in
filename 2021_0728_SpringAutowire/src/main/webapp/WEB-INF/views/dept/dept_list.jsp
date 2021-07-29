<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- JSTL설정 -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		#box{
			width: 400px;
			margin: auto;
			margin-top:  30px;
			
		}
	</style>
		<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		
</head>
<body>
	<div id="box">
	<table class="table">
		<!-- title -->
		<tr>
			<th>일련번호</th>
			<th>부서번호</th>
			<th>부서명</th>
			<th>위치</th>
		</tr>
		
		<!-- data -->
		<!-- for DeptVo vo : list -->
		<c:forEach var="vo" items="${ requestScope.list }" varStatus="i">
            <tr>
               <td>${ i.count }(${ i.index })</td>
               <td>${ pageScope.vo.deptno }</td>
               <td>${ vo.dname }</td>
               <td>${ vo.loc }</td>
            </tr>
         </c:forEach>
	</table>
	
	</div>
</body>
</html>




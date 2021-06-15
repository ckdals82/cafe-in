<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#main_box{
		width: 1000px;
		margin: auto;
		margin-top: 10px;
	}
	#main_box >h1{
		text-align: center;
		font-size: 22pt;
		color: #cccccc;
		tex-shadow: 1px 1px 3px black;
	}
	
	.btn_type{
	text-align: right;
	margin-top: 10px;
	margin-bottom: 10px;
	}

</style>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<body>
<div id="main_box">
	<h1>::::회원 목록::::</h1>
	<div class="btn_type">
		
		<!-- 로그인이 안된상태 -->
		<c:if test="${ empty sessionScope.user }">
		<input class="btn btn-success" type="button" value="로그인"
										onclick="location.href='login_form.do'">
		</c:if>
		<!-- 로그인 된 상태 -->
		<c:if test="${ not empty sessionScope.user }">
			${ user.m_name }님 로그인하셨습니다
			<input class="btn btn-success" type="button" value="로그아웃"
										onclick="location.href='logout.do'">
		</c:if>
		
	</div>
	
	<table class="table">
	<!-- title -->
		<tr class="success">
			<th>회원번호 </th>
			<th>회원명 </th>
			<th> 아이디</th>
			<th>비밀번호 </th>
			<th> 우편번호</th>
			<th> 주소</th>
			<th>가입일자 </th>
			<th> 수정일자</th>
			<th> 회원구분</th>
			<th> 편집</th>
		</tr>
		<!-- data -->
		<c:forEach var="vo" items="${ list }">
		<tr>
			<td>${vo.m_idx } </td>
			<td>${vo.m_name } </td>
			<td>${vo.m_id } </td>
			<td>${vo.m_pwd } </td>
			<td>${vo.m_zipcode } </td>
			<td>${vo.m_addr } </td>
			<td>${vo.m_regdate } </td>
			<td>${ fn:substring(vo.m_regdate,0,10) } </td>
			<td>${ fn:substring(vo.m_modifydate,0,10) } </td>
			<td>${vo.m_grade } </td>
			
			<td>
				<c:if test="${ (user.m_grade eq '관리자') or (user.m_id eq vo.m_id) }">
					<input class="btn btn-info" type="button" value="수정" onclick="modify_form('${vo.m_idx }');">
					<input class="btn btn-danger" type="button" value="삭제" onclick="del('${vo.m_idx}');">
				</c:if>
			 </td>
			</tr>
		</c:forEach>
	</table>
	
</div>

</body>
</html>
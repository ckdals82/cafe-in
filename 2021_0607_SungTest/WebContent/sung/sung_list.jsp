<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- JSTL설정 -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	
	<style type="text/css">
	
	
	
	#box{
	width: 800px;
	margin: auto;
	margin-top: 30px;
	}
	h1{
	text-align: center;
	font-size: 25pt;
	font-weight: bold;
	color: white;
	text-shadow: 1px 1px 5px black;
	}
	</style>
	
	<script type="text/javascript">
		function del(no){
			/* alert('삭제할 번호:' +no); */
			
			//예(true) 아니오(false)
			if(confirm('정말 삭제 하시겠습니까?')==false) return;
			
			//삭제정보전송
			location.href="delete.do?no=" + no; //SungDeleteAction 
		}
		//수정폼 띄우기
		function modify_form(no){
			
			location.href="modify_form.do?no=" + no;//SungModifyFormAction
		}
		
	</script>
	
</head>
<body>
	<div id="box">
		<h1>::성적관리::</h1>
		
		<!-- 등록버튼 -->
		<div style="text-align: right; margin-bottom: 10px">
			<input class="btn btn-primary" type="button" value="등록하기"
											onclick="location.href='insert_form.do'">
		</div>
		
		<table class="table table-striped">
		
		<tr class="success">
			<th>번호 </th>
			<th>이름 </th>
			<th> 국어</th>
			<th> 영어</th>
			<th> 수학</th>
			<th> 총점</th>
			<th>평균</th>
			<th> 등수</th>
			<th> 비고</th>
			
		</tr>
		
		<!-- data -->
		
		<!-- data가 비어있으면 -->
		<%-- <c:if test="${ empty list }">
			<tr>
				<td colspan="9">데이터가 없습니다. </td>
			</tr>
		</c:if> --%>
		
		<!-- vo = SungVo vo -->
		<c:forEach var="vo" items="${ requestScope.list }">
			<tr>
				<td> ${ vo.no }</td>
				<td> ${ vo.name }</td>
				<td> ${ vo.kor }</td>
				<td> ${ vo.eng }</td>
				<td> ${ vo.mat }</td>
				<td> ${ vo.tot }</td>
				<td> ${ vo.avg }</td>
				<td> ${ vo.rank }</td>
				<td width="150">
					<input class="btn btn-info" type="button" value="수정" 
					                                           onclick="modify_form('${vo.no }');" >
					<input class="btn btn-danger" type="button" value="삭제"                  
					                                             onclick="del('${ vo.no}');">
				</td>
				
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>
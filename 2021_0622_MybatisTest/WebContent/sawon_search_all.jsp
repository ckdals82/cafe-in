<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
	#box{
		width: 1000px;
		margin: auto;
		margin-top: 10px;
		
	
	}
	
	
	</style>
<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	//jquery초기화
	$(document).ready(function(){
		
		//조회버튼이 클릭되면
		$("#btn_find").click(function(){
			
			var deptno = $("#deptno").val();
			var sajob = $("#sajob").val();
			var sasex = $("#sasex").val();
			//ajax요청
			$.ajax({
											  //SawonAllListAction (call)
				url  	: 'sawon/all_list.do',	  //sawon/list.do?deptno=10&sajob=사원&sasex=남자
				data 	: {'deptno': deptno,'sajob':sajob,'sasex':sasex}, //parameter
				success : function(result_data){
					$("#disp").html(result_data);
				},
				error   : function(err){
					alert(err.reponseText);
				}
				
			});
			
		});
		
	});
</script>

</head>
<body>
<div id="box">
부서: <select id="deptno">
		<option value="0">전체보기 </option>
		<option value="10">10번부서 </option>
		<option value="20">20번부서 </option>
		<option value="30">30번부서 </option>
		<option value="40">40번부서 </option>
	</select>
	&nbsp;&nbsp;&nbsp;
	직급: <select id="sajob">
		<option value="all">전체보기 </option>
		<option value="부장">부장 </option>
		<option value="과장">과장 </option>
		<option value="대리">대리 </option>
		<option value="사원">사원 </option>
		<option value="사원">알바 </option>
	</select>
	&nbsp;&nbsp;&nbsp;
	성별: <select id="sasex">
			<option value="all">전체보기 </option>
			<option value="남자">남자 </option>
			<option value="여자">여자 </option>
		</select>
	&nbsp;&nbsp;&nbsp;
	<input type="button" value="조회" id="btn_find">
<hr>
<div id="disp"></div>
</div>	
</body>
</html>
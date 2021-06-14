<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
function search(){
	var p_name = $("#p_name").val().trim();
	if(p_name==''){
		alert('검색할 상품명을 입력하세요!!');
		$("#p_name").val('');
		$("#p_name").focus('');
		
		return;
	}
	
	var page	= $("#select_page").val();
	var display = $("#select_display").val();
	
	//start계산
	var start = (page-1) * display +1;
	
	//ajax로 요청
	$.ajax({
		url : 'product/list.do',
		data: {'p_name':p_name,'start':start,'display':display},
		success: function(result_data){
			$("#disp").html(result_data);
		},
		error : function(err){
			alert(err.responseText);
		}
	});
	
}


//jquery 초기화

$(document).ready(function(){
	
	//r검색버튼이 눌리면
	$("#btn_search").click(function(){
		
		search();
		
		
	});
	$("#select_page").change(function(){
		
		search();
		
		
	});
	$("#select_display").change(function(){
		
		search();
		
		
	});
	
	
} );
	


</script>

<style type="text/css">

#box{
width: 1000px;
margin: auto;
margin-top: 10px;
}
</style>

</head>
<body>

<div id="box"> 
	상품명: <input id="p_name">
			<input type="button" value="검색" id="btn_search">
			
	페이지: <select id="select_page">
				<option value="1"> 1페이지</option>
				<option value="2"> 2페이지</option>
				<option value="3"> 3페이지</option>
				<option value="4"> 4페이지</option>
				<option value="5"> 5페이지</option>
				<option value="6"> 6페이지</option>
				<option value="7"> 7페이지</option>
				<option value="8"> 8페이지</option>
				<option value="9"> 9페이지</option>
				<option value="10"> 10페이지</option>
			</select>
			
	검색갯수: <select id="select_display">
				<option value="10"> 10개씩 보기</option>
				<option value="20"> 20개씩 보기</option>
				<option value="30"> 30개씩 보기</option>
				<option value="40"> 40개씩 보기</option>
				<option value="50"> 50개씩 보기</option>
				<option value="60"> 60개씩 보기</option>
				<option value="70"> 70개씩 보기</option>
				<option value="80"> 80개씩 보기</option>
				<option value="90"> 90개씩 보기</option>
				<option value="100"> 100개씩 보기</option>
			</select>	
			<hr>
<div id="disp">  </div>	
</div>


</body>
</html>
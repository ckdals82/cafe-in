<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		width: 600px;
		margin: auto;
		margin-top: 100px;
	}
</style>
<script type="text/javascript">
	var regular_number = /^[0-9]{1,3}$/;
	
	function send(f){
		
		var name = f.name.value.trim();
		var kor  = f.kor.value.trim();
		var eng  = f.eng.value.trim();
		var mat  = f.mat.value.trim();
		
		if(name==''){
			alert('이름을 입력하세요!!');
			f.name.value='';
			f.name.focus();
			return;
		}
		//국어/영어/수학/체크 : 0 ~100사이의 숫자만 입력
		if(regular_number.test(kor)==false || kor<0 || kor>100){
			alert('0~100사이의 숫자만 입력하세요!!');
			f.kor.value='';
			f.kor.focus();
			return;
		}
		if(regular_number.test(eng)==false || eng<0 || eng>100){
			alert('0~100사이의 숫자만 입력하세요!!');
			f.kor.value='';
			f.kor.focus();
			return;
		}
		if(regular_number.test(mat)==false || mat<0 || mat>100){
			alert('0~100사이의 숫자만 입력하세요!!');
			f.kor.value='';
			f.kor.focus();
			return;
		}
		
		//정말수정하시겠습니까?
		
		f.action="modify.do";//sungModifyAction
		f.submit();//전송
		
	}
	
	
</script>
</head>
<body >
<div id="box">
 <div class="panel panel-primary">
      <div class="panel-heading"> <h3>성적수정폼</h3> </div>
      <div class="panel-body">
      	<form>
      		<input type="hidden" name="no" value="${ vo.no }">
      	<table class="table table-striped">
      		<tr>
      			<th> 이름</th>
      			<td> <input name="name" value="${ vo.name }"> </td>
      		</tr>
      		<tr>
      			<th> 국어</th>
      			<td> <input name="kor" value="${ vo.kor }"> </td>
      		</tr>
      		<tr>
      			<th> 영어</th>
      			<td> <input name="eng" value="${ vo.eng }"> </td>
      		</tr>
      		<tr>
      			<th> 수학</th>
      			<td> <input name="mat" value="${vo.mat }"> </td>
      		</tr>
      		<tr>
      			<td colspan="2" align="center">
      				<input class="btn btn-primary" type="button" value="수정하기"
      				                               onclick="send(this.form);"> <!-- 폼에대한정보를 넘긴다  -->
      				
      				<!-- 2021_0607_SungTest/sung/insert_form.do -->
      				<input class="btn btn-success" type="button" value="목록보기" 
      				                               onclick="location.href='list.do'">
      			</td> 
      		</tr>
      		</table>
      </form>
      </div>
    </div>
    </div>
</body>
</html>
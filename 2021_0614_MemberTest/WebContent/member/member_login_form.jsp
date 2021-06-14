<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#box{
	width: 400px;
	margin: auto;
	margin-top: 100px;
	
	
	
	}
	input[type="button"]{
		width= 100px;
	}
</style>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	
	
	<div id='box'>
		<form>
				<div class="panel panel-primary">
		      <div class="panel-heading">로그인</div>
		      <div class="panel-body">
		      <table class="table">
				<tr> 
					<th>아이디</th>
					<td> <input name="id"> </td>
				</tr>
				<tr> 
					<th>비밀번호</th>
					<td> <input type="password" name="pwd"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input class="btn btn-primary" type="button" value="로그인">
						<input class="btn btn-success" type="button" value="메인화면"
								onclick="location.href='list.do'">
						<input class="btn btn-info" type="button" value="회원가입"
								onclick="location.href='insert_form.do'">
					 </td>
				</tr>			
			</table>
		      </div>
		    </div>
			
			
		</form>
	</div>
	
	
</body>
</html>
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



	<style type="text/css">
	
	#photo_popup{
		width: 400px;
		min-height: 500px;
		
		border: 2px solid blue;
		
		position: absolute;
		left: 400px;
		top: 100px;
		background: black;
		display: none; /* hide속성임 */
		padding: 20px;
	}
	/* 이 아이디를 가진 애에 아래에 있는 이미지 */
	#photo_popup > img {
	width: 356px;
	height: 356px;
	border: 1px solid white;
	}
	
	#pop_title{
		
		border: 1px solid #cccccc;
		margin-top: 10px;
		color: white;
	}
	#pop_content{
		min-height: 50px;
		height: auto;
		border: 1px solid #cccccc;
		margin-top: 10px;
		margin-bottom: 10px;
		color: white;
	}
	#pop_regdate{
	color: white;
	}
		
	</style>
	
	<script type="text/javascript">
		function close_me(){
			$("#photo_popup").hide();
		}
	</script>

</head>
<body>

	<div id="photo_popup">
		<div style="text-align: right;"> 
			<span id="pop_regdate">올린날짜</span>
			<input type="button" value="x" onclick="close_me();" > 
		</div>
		<img  id="pop_image" src="">
		<div id="pop_title">제목부분</div>
		<div id="pop_content">내용</div>
		<div style="text-align: center; ">
			
			<input class="btn-primary" type="button" value="다운로드">
			<input class="btn-danger" type="button" value="삭제하기">
			<input class="btn-info" type="button" value="수정하기">
			
		</div>
	</div>

</body>
</html>
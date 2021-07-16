<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jquery -->
<script src="../resource/js/jquery-3.6.0.min.js"></script>

<!-- bootstrap -->
<link href="../resource/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="../resource/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>

<!-- semantic ui -->
<link rel="stylesheet" href="../resource/Semantic-UI-CSS-master/semantic.css">
<script src="../resource/Semantic-UI-CSS-master/semantic.js"></script>

<!-- google fonts -->    
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1&display=swap" rel="stylesheet">

<!-- common -->
<link rel="stylesheet" href="../_css/common.css">
<script src='../_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="../_css/member_login_form.css">
<script src='../_js/member_login_form.js'></script>

</head>
<body>

	<div class="tp_layer">
		<div class="tp_button_layout">
			<%@ include file="../etc/top_button.jsp" %>
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_logo_layout">
			<%@ include file="../etc/logo.jsp" %>
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_main_layout">
			
			<table class="login_title_box">
				<tr>
					<td>
						<div class="login_title">Cafe, in 로그인</div>
					</td>
				</tr>			
			</table>
			
			<div class="tp_space"></div>
			<div class="tp_space"></div>
			<div class="tp_space"></div>
			<div class="tp_space"></div>
			<div class="tp_space"></div>
			
			<form>
				<table class="login_box" >
					<tr>
						<td class="label_title">아이디</td>
						<td>
							<input type="text" id="in_id" class="input_lgn" name="i_id" placeholder="LoginID">
							<button class='clear_icon' type='reset'>x</button>
						</td>
					</tr>
					
					<tr>
						<td class="label_title">비밀번호</td>
						<td>
							<input type="password" id="in_pwd" class="input_lgn" name="i_pwd" placeholder="Password">
							<button class="clear_icon" type="reset">x</button>
						</td>
					</tr>
					
					<tr>
						<td>
							<div class="tp_space"></div>
						</td>
					</tr>
					
					<tr>
						<td class="button_tot" colspan="2">
							<button type="button" class="btn btn-warning" onclick="location.href='index.jsp'">로그인</button>
							<!-- <input type="button" id="bt_login" class="login_button" value="로그인" onclick="location.href='index.jsp'"/> -->
							<button type="button" class="btn btn-warning" onclick="location.href='join_page.jsp'">회원가입</button>
							<!-- <input type="button" id="bt_new" class="login_button" value="회원가입" onclick="location.href='join_page.jsp'"/> -->
						</td>
					</tr>
				</table>
			</form>
			
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_bottom_layout">
			<%@ include file="../etc/bottom.jsp" %>
		</div>
	</div>

</body>
</html>
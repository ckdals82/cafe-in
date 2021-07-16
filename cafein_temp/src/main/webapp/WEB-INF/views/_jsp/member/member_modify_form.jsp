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
<link rel="stylesheet" href="../_css/my_modify.css">
<script src='../_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="../_css/member_modify_form.css">
<script src='../_js/member_modify_form.js'></script>

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
      
	         <div class="join_page_form">        
	               <div class="new_title">Cafe, in 정보수정</div>
	                 <div class="join_page_div">
	                    <div id="image_container"></div>
	                   <table class="join_table">
	                      <tr>
	                         <td class="join_title">이름</td>
	                         <td><input id="in_name" class="input_new" placeholder="Name" readonly="readonly"></td>
	                      </tr>
	                      <tr>
	                         <!-- <td rowspan="6"><img width=150 id="td_star" src="../img/img_photo.png"></td> -->
	                         <td class="join_title">아이디</td>
	                         <td><input id="in_id" class="input_new" placeholder="ID" readonly="readonly"></td>
	                      </tr>
	                      <tr>
	                         <td class="join_title">비밀번호</td>
	                         <td><input type="password" id="in_pwd" class="input_new" placeholder="Password"></td>
	                      </tr>
	                      <tr>
	                         <td class="join_title">비밀번호 확인</td>
	                         <td><input type="password" id="in_name" class="input_new" placeholder="Password-check"></td>
	                      </tr>
	                      <tr>
	                         <td class="join_title">이메일</td>
	                         <td><input id="in_email" class="input_new" placeholder="E-mail"></td>
	                      </tr>
	                      <tr>
	                         <td class="join_title">우편번호</td>
	                         <td>
	                         	<input id="in_zipcode" class="input_new" placeholder="zipcode" readonly="readonly">
	                         	<input id="addr_button" type="button" class="btn btn-warning" value="주소찾기">
	                         </td>
	                      </tr>
	                      <tr>
	                         <td class="join_title">주소</td>
	                         <td><input id="in_addr" class="input_new" placeholder="Adress" readonly="readonly"></td>
	                      </tr>
	                      <tr>
	                         <td class="join_title">상세주소</td>
	                         <td><input id="in_addr_detail" class="input_new" placeholder="Adress-detail"></td>
	                      </tr>
	                      <tr>
	                         <!--<td><input type="button" value="사진등록"></td> -->
	                         <td class="join_title">생년월일</td>
	                         <td><input id="in_birth" class="input_new" placeholder="YYYY-MM-DD"></td>
	                      </tr>
	                      <tr>
	                         <td class="join_title">휴대전화</td>
	                         <td><input id="in_tel" class="input_new" placeholder="Phone-number"></td>
	                      </tr>
	                      <tr>
	                         <td colspan="2" align="center">
	                         <input id="join_button" type="button" class="btn btn-warning btn-ok" value="수정하기"></td>
	                      </tr>
	                   </table>
	                </div>
	           </div>
			
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_bottom_layout">
			<%@ include file="../etc/bottom.jsp" %>
		</div>
	</div>

</body>
</html>
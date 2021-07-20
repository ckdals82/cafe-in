<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jquery -->
<script src="${ pageContext.request.contextPath }/resources/JQuery/jquery-3.6.0.min.js"></script>

<!-- bootstrap -->
<link href="${ pageContext.request.contextPath }/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${ pageContext.request.contextPath }/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>

<!-- semantic ui -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/Semantic-UI-CSS-master/semantic.css">
<script src="${ pageContext.request.contextPath }/resources/Semantic-UI-CSS-master/semantic.js"></script>

<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/_css/common.css">
<script src='${ pageContext.request.contextPath }/resources/_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/_css/detail_insert_form.css">
<script src='${ pageContext.request.contextPath }/resources/_js/detail_insert_form.js'></script>

</head>
<body>

	<div class="tp_layer">
	   <div class="tp_button_layout">
	      <%@ include file="../etc/top_button.jsp" %>
	   </div>
	</div>
	
	<div class="tp_layer">
	   <div class="tp_menu_layout">
	      <%@ include file="../etc/top_menu.jsp" %>
	   </div>
	</div>
	
	<div class="tp_layer">
	   <div class="tp_main_layout">
	      
	      <div class="cafe_name"><img src="../_img/img_star.png" class="star_size"> <span> 카페명</span>  <img src="../_img/img_hot.png" class="hot_size"></div>
	         
	         <div class="img_cafe_info">
	         
	            <div class="cafe_img"></div>
	
	            	<table class="cafe_info">
		                 <tr class="tb_h">
		                   <td class="title_align">카페위치</td>
		                   <td class="review_content"> 
		                       <form>
		                           <input  type="text" id="in_id" class="input_lgn">
		                       </form>  
		                   </td>
		                   <td class="link_button"></td>
		                 </tr>
		                 
		                 <tr class="tb_h">
		                   <td class="title_align">전화번호</td>
		                   <td class="review_content"> 
		                       <form >
		                   	  	  <input type="text" id="in_id" class="input_lgn">
		                       </form>
		                   </td>
		                   <td class="link_button"></td>
		                 </tr>
		                 
		                 <tr class="tb_h">
		                   <td class="title_align">키워드</td>
		                   <td class="review_content">
		                       <form>
		                   	  	  <input  type="text" id="in_id" class="input_lgn">
		                       </form>
		                   <td class="link_button"></td>
		                 </tr>
		                 
		                 <tr class="tb_h">
		                   <td class="title_align">메뉴</td>
		                   <td class="review_content">
		                       <form>
		                   	  	  <input  type="text" id="in_id" class="input_lgn">
		                       </form>
		                   </td>
		                   <td class="link_button"></td>
		                 </tr>
		                 
		                 <tr class="tb_h">
		                   <td class="title_align">리뷰</td>
		                   <td class="review_content">
		                       <form >
		                           <input  type="text" id="in_id" class="input_lgn">
		                       </form>
		                   </td>
		                   <td class="link_button">
		                   </td>
		                 </tr>
		                 
		                 <tr class="tb_h">
		                   <td class="title_align"></td>
		                   <td class="review_content"></td>
		                   <td class="link_button">
		                      <form action="">
		                      	<input type="button" class="btn btn-warning"  id="bt_write_review" value="수정하기" onclick=""/>
		                      </form>
		                   </td>
		                 </tr>
	            	</table>
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
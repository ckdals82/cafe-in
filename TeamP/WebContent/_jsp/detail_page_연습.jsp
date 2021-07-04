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

<!-- common -->
<link rel="stylesheet" href="../_css/common.css">
<script src='../_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="../_css/detail_page.css">
<script src='../_js/detail_page.js'></script>

 <script
src="https://kit.fontawesome.com/6478f529f2.js"
      crossorigin="anonymous">
      >
    </script>

</head>
<body>

	<div class="tp_layer">
		<div class="tp_button_layout">
			<%@ include file="top_button.jsp" %>
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_menu_layout">
			<%@ include file="top_menu.jsp" %>
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_main_layout">
			
			<div class="cafe_name"><i class="fas fa-star"></i> 카페명 <i  class="fab fa-hotjar"></i></div>
				<div class="img_cafe_info">
				<div class="cafe_img"></div>

					<table class="cafe_info">
					<thead>
					  <tr class="tg-0lax">
					    <th class="tg-m_img" colspan="2"></th>
					    <th class="tg-0lax"></th>
					  </tr>
					</thead>
					<tbody>
					  <tr class="tb_h">
					    <td class="tg-0lax">카페위치</td>
					    <td class="tg-0lax"></td>
					    <td class="tg-0lax"> 
					    <div class="review_w"> <a class="icon_C_change" href="review_write_page.jsp"> <i  class="fas fa-search fa-2x" class="cafe_icon"></i></a>
					    			<span>길찾기</span> </div>
					    	</td>
					  </tr>
					  <tr class="tb_h">
					    <td class="tg-0lax">전화번호</td>
					    <td class="tg-0lax"></td>
					    <td class="tg-0lax"></td>
					  </tr>
					  <tr class="tb_h">
					    <td class="tg-0lax">키워드</td>
					    <td class="tg-0lax, cafe_hashT">#조용한분위기 #공부</td>
					    <td class="tg-0lax"></td>
					  </tr>
					  <tr class="tb_h">
					    <td class="tg-0lax">메뉴</td>
					    <td class="tg-0lax"></td>
					    <td class="tg-0lax"></td>
					  </tr>
					  <tr class="tb_h" >
					    <td class="tg-0lax">리뷰</td>
					    <td class="tg-0lax"></td>
					    <td class="tg-0lax"> 
					    		<div class="review_w"> <a class="icon_C_change" href="review_write_page.jsp"> <i  class="fas fa-pen fa-2x" class="cafe_icon" ></i></a>
					    			<span>길찾기</span> </div>
					    	</td>
					  </tr>
					</tbody>
					</table>
			</div>
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_bottom_layout">
			<%@ include file="bottom.jsp" %>
		</div>
	</div>

</body>
</html>
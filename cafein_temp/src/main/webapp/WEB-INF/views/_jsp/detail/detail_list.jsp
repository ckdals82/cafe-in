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

<!-- daum 주소찾기 라이브러리  -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 

<!-- common -->
<link rel="stylesheet" href="../_css/common.css">
<script src='../_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="../_css/detail_list.css">
<script src='../_js/detail_list.js'></script>

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
			
			<div class="cafe_name">
				<img src="../_img/img_star.png" class="star_size"> <span>카페명</span>  <img src="../_img/img_hot.png" class="hot_size">
			</div>
            
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
	                     <td class="link_button">
	                       <form> 
	                       	<button class="btn btn-warning"  onclick="window.open('https://map.kakao.com/link/to/18577297')">길찾기</button> 
	                       </form>         
	                     </td>
	                   </tr>
	                   
	                   <tr class="tb_h">
	                     <td class="title_align">전화번호</td>
	                     <td class="review_content">
	                          <form>
	                     	  	  <input  type="text" id="in_id" class="input_lgn">
	                         </form>
	                     </td>
	                     <td class="link_button"></td>
	                   </tr>
	                   
	                   <tr class="tb_h">
	                     <td class="title_align">키워드</td>
	                     <td class="review_content">
	                          <form >
	                     	  	  <input  type="text" id="in_id" class="input_lgn">
	                         </form>
	                     </td>
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
	                          <form>
	                     	  	  <input  type="text" id="in_id" class="input_lgn">
	                         </form>
	                     </td>
	                     <td class="link_button">
	                        <form action="">
	                        	<input  type="button"  class="btn btn-warning" id="bt_write_review" value="리뷰작성" onclick="location.href='review_write_page.jsp'"/>
	                        </form>
	                     </td>
	                   </tr>
	                   
	                   <tr class="tb_h">
	                     <td class="title_align"></td>
	                     <td class="review_content"></td>
	                     <td class="link_button"></td>
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
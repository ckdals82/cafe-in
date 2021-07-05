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
         
         <div class="cafe_name"><img src="../_img/img_star.png" class="star_size"> 카페명 <img src="../_img/img_hot.png" class="hot_size"></div>
            
            <div class="img_cafe_info">
            
               <div class="cafe_img"></div>

               <table class="cafe_info">
                  
                    <tr class="tb_h">
                      <td class="title_align">카페위치</td>
                      <td class="review_content"></td>
                      <td class="link_button">
                        <form> <input type="button" id="bt_navi" value="길찾기" onclick=""/> </form>         
                      </td>
                    </tr>
                    
                    <tr class="tb_h">
                      <td class="title_align">전화번호</td>
                      <td class="review_content"></td>
                      <td class="link_button"></td>
                    </tr>
                    
                    <tr class="tb_h">
                      <td class="title_align">키워드</td>
                      <td class="review_content">#조용한분위기 #공부</td>
                      <td class="link_button"></td>
                    </tr>
                    
                    <tr class="tb_h">
                      <td class="title_align">메뉴</td>
                      <td class="review_content"></td>
                      <td class="link_button"></td>
                    </tr>
                    
                    <tr class="tb_h">
                      <td class="title_align">리뷰</td>
                      <td class="review_content"></td>
                      <td class="link_button">
                         <form action="">
                         	<input  type="button" id="bt_write_review" value="리뷰작성" onclick="location.href='review_write_page.jsp'"/>
                         </form>
                      </td>
                    </tr>
                    
                     <tr class="tb_h">
                      <td class="title_align"></td>
                      <td class="review_content"></td>
                      <td class="link_button">
                         <form action="">
                         	<input  type="button" id="bt_write_review" value="작성완료" onclick=""/>
                         </form>
                      </td>
                    </tr>
                    
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jquery -->
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>

<!-- bootstrap -->
<link href="${ pageContext.request.contextPath }/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${ pageContext.request.contextPath }/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>

<!-- semantic ui -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/Semantic-UI-CSS-master/semantic.css">
<script src="${ pageContext.request.contextPath }/resources/Semantic-UI-CSS-master/semantic.js"></script>

<!-- google fonts -->    
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1&display=swap" rel="stylesheet">

<!-- common -->
<link rel="stylesheet" href="../_css/common.css">
<script src='../_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="../_css/top_menu.css">
<script src='../_js/top_menu.js'></script>

</head>
<body>
	
	<div class="top_menu">
      <div>
         <table>
               <tr>
                  <td><img class="img_logo_menu" src="${pageContext.request.contextPath}/_img/img_logo.png"></td>
               <td></td>
               <td class="td_font">
                  <div class="menu_cafe_location">현재 카페 지역</div>
               </td>
               <td>
                  <div>
                     <select name="location" class="select_location">
                        <option value="">서울시 관악구 신림동</option>
                     </select>
                  </div>
               </td>

               </tr>
         </table>
      </div>
      
      <div class="top_menu2">
         <div class="ui inverted menu">
            <a class="active item">필터</a> 
            <a class="item">     추천카페 </a> 
            <a class="item" href="#" onclick="location.href='review_page.jsp'"> 리뷰 </a>
         </div>
      </div>   
   </div>
	
	
</body>
</html>
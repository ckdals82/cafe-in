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
<link rel="stylesheet" href="../_css/top_main.css">
<script src='../_js/top_main.js'></script>

</head>
<body>
	
	<div class="top_main">
      <table>
         <tr>
            <td><img class="img_logo" src="${pageContext.request.contextPath}/_img/img_logo.png"></td>
            <td></td>
            <td></td>
            <td><div class="top_search_cafe"><input type="button" class="btn btn-warning" value="카페찾기" onclick="location.href='recommend_page.jsp'"></div></td>
            <td></td>
         </tr>
      </table>
   </div>
   
   <div class="top_search_bar">
         <div class="ui icon input">
              <input class="search" type="text" placeholder="검색창...">
               <i class="inverted circular search link icon"></i>
         </div>
   </div>
   
   <div class="top_location">
      <div><input id ="location_text" type="text" value="내 위치 기준"><img class="img_location" src="${pageContext.request.contextPath}/_img/img_location.png" onclick=""></div>
   </div>
	
</body>
</html>
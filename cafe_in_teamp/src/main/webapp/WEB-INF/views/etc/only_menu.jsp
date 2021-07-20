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

<!-- sweetalert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/_css/common.css">
<script src='${ pageContext.request.contextPath }/resources/_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/_css/only_menu.css">
<script src='${ pageContext.request.contextPath }/resources/_js/only_menu.js'></script>

</head>
<body>
   <%@ include file="filter_pop.jsp"  %>
   <div class="only_menu">
       <div>
          <table>
                <tr>
                   <td><img class="img_logo_only_menu" src="${pageContext.request.contextPath}/_img/img_logo.png"></td>
                <td></td>
   
                </tr>
          </table>
       </div>
       
       <div class="only_menu2">
          <div class="ui inverted menu">
             <a class="active item" href="#" onclick="filter_view()">필터</a> 
             <a class="item">     추천카페 </a> 
             <a class="item" href="#" onclick="location.href='review_page.jsp'"> 리뷰 </a>
          </div>
       </div>   
   </div>
   
   
</body>
</html>
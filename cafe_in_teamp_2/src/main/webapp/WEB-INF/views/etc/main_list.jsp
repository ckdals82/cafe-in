<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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

<!-- google fonts -->    
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1&display=swap" rel="stylesheet">

<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/_css/common.css">
<script src='${ pageContext.request.contextPath }/resources/_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/_css/index.css">
<script src='${ pageContext.request.contextPath }/resources/_js/index.js'></script>

</head>
<body>

	<div class="tp_layer">
		<div class="tp_button_layout">
			<%@ include file="top_button.jsp" %>
		</div>
	</div>

	<div class="tp_layer">
		<div class="tp_search_layout">
			<%@ include file="top_main.jsp" %>
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_index_layout">
					
			<c:forEach var="i" begin="1" end="16"> 
	            <div class="index_photo">
	               <img class="index_image" src="${ pageContext.request.contextPath }/resources/_img/cafe1.jpg" alt="image">
	            </div>
	        </c:forEach>

		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_bottom_layout">
			<%@ include file="bottom.jsp" %>
		</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/2_2_top.css">
<link rel="stylesheet" href="../css/main_bottom_fix.css">
<link rel="stylesheet" href="../css/main_menu.css">
<link rel="stylesheet" href="../css/index.css">

</head>
<body>

    <!-- division tag : block요소 -->
	<div id="main_box">
		<div id="header">
			<!-- 외부화일을 포함 -->
			<%@include file="2_2_top.jsp"%>
		</div>
		
		
		<!-- 내용 -->
		<div id="content">
			<%@include file="main_bottom_fix.jsp" %>
		</div>
		
	</div>
	


</body>
</html>
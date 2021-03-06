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
<link rel="stylesheet" href="../_css/index.css">
<script src='../_js/index.js'></script>

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
			index_screen
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_bottom_layout">
			<%@ include file="bottom.jsp" %>
		</div>
	</div>

</body>
</html>
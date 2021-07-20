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
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/_css/common.css">
<script src='${ pageContext.request.contextPath }/resources/_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/_css/top_button.css">
<script src='${ pageContext.request.contextPath }/resources/_js/top_button.js'></script>

</head>
<body>
	
	<div class="main_top_button">
		<table class="button_box">
			<tr>
				<td></td>
				<td align="right">
					<table>
						<tr align="right">
							<td>
								<div class="quick_item _modify" onclick="location.href='my_modify.jsp'">
									<img class="img_modify" src="${ pageContext.request.contextPath }/resources/_img/img_modify.png">
								</div>
							</td>
							<td>
								<div class="quick_item _login" onclick="location.href='login_page.jsp'">
									<img class="img_login" src="${ pageContext.request.contextPath }/resources/_img/img_login.png">
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
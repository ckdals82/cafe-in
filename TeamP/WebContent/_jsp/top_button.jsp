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
<link rel="stylesheet" href="../_css/top_button.css">
<script src='../_js/top_button.js'></script>

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
								<div class="quick_item _modify" onclick="location.href='my_modify.jsp'"><img class="img_modify" src="../_img/img_modify.png">
								</div>
							</td>
							<td>
								<div class="quick_item _login" onclick="location.href='login_page.jsp'"><img class="img_login" src="../_img/img_login.png">
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
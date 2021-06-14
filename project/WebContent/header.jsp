<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
@charset "UTF-8";
#div_Location{
	margin-left: 30%;
	margin-bottom: 100px;
	font-size: 20pt;
	display: inline;
	margin-right: 70px;
}


.input_button_three{
	padding-left: 30px;
	padding-right: 30px;
	background: #808080;
	
}
  <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- css -->
    <link rel="stylesheet" href="../css/main_bottom.css" />

    <!-- js -->
    <link rel="stylesheet" href="../javascript/main_bottom.js" />
  </head>

</style>






<meta charset="UTF-8">
<title>Insert title here</title>

<!--bootstrap  -->
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>



<link rel="stylesheet" href="../css/2_2_top.css">
<link rel="stylesheet" href="../javascript/2_2_top.js">

</head>

<body>
<header>
	<div>
		<h5>
			<div style="text-align: right;">
				<img src="../img/img_login.png"> 
				<img src="../img/img_logout.png">
			</div>
		</h5>
	</div>
	
	<div >
		<img src="../img/img_logo.png" style="float: left;">
		<div id="div_Location">현재 카페 지역</div><select><option>서울시관악구신림동</option></select> 
			<h1 class="input_button_three">
				<input type="button" value="필터" style="margin-left: 400px;" >
				<input type="button" value="추천카페" style="margin-left:200px;">
				<input type="button" value="리뷰" style="margin-left:200px;">
			</h1>
	</div>
	</header>
	
<footer>

  
  
    <div id="bx_main_bottom">
      <div id="rcm_cafe">추천카페</div>
      <input id="more_view" type="button" style="float: right" value="더보기" />
      <br />
      <br />
      <br />
      <div id="photo1"></div>
      <div id="photo2"></div>
      <div id="photo3"></div>
      <div id="photo4"></div>
      <div id="photo5"></div>
      <div id="photo6"></div>
      <div id="photo7"></div>
      <div id="photo8"></div>
    </div>

	</footer>

</body>
</html>
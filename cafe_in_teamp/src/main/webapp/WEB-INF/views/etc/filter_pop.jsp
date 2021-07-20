<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- sweetalert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style type="text/css">
   
   #filter_popup{
      width: 400px;
      min-height: 500px;
      border:2px solid blue;
      position: absolute;
      left: 400px;
      top:  100px;
      background: gray;
      display: none;   /* hide속성 처음부터 안나온다. */   
      padding: 20px; 
   }
   
   #filter_popup > img{
      width: 356px;
      height: 356px;
      border: 1px solid white;
   }
   
   #pop_title{
      
      border: 1px solid #cccccc;
      margin-top: 10px;
      color: yellow;
   }
   
   #pop_content{
      min_height: 50px;
      height: auto;
      border: 1px solid #cccccc;
      margin-top: 10px;
      margin-bottom: 10px;
      color: white;
   }
   
   #pop_regdate{
      color: white;
   }
   
   
</style>

<script type="text/javascript">
   function close_me() {
      $("#filter_popup").hide();
   }
   //download파일이름
   //var filename;

   
</script>


</head>
<body>
   
   <div id="filter_popup">
      <div style="text-align: right;">
         <span id="pop_regdate">올린날짜...</span>
         <input class="btn btn-danger" type="button" value="x" onclick="close_me();">
      </div>
      <img id="pop_image" src="">
      <div id="pop_title">제목부분</div>
      <div id="pop_content">내용</div>
      <div style="text-align: center;">
         

      </div>
   </div>
   
</body>
</html>
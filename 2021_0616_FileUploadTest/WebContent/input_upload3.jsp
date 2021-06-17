<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- SweetAlert사용설정 : 알림박스 -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">

   function send(f) {
      var title = f.title.value.trim();
      var photo = f.photo.value;
      
      if(title==''){
         swal("제목","제목을 입력하세요!!","error");
         f.title.value='';
         f.title.focus();
         return;
      }
      
      if(photo==''){
         swal("사진","업로드할 사진을 선택하세요!!","error");
         return;
      }
      
      f.action = "upload3.do"; //FileUploadAction
      f.submit();
   }

</script>

</head>
<body>

<!-- 예제3 . 무시 나중에 sprig에서 처리 -->

<!-- file upload시 설정사항 
   method="POST"
   enctype="multipart/form-data"
-->

<form action="upload2.do" method="POST" enctype="multipart/form-data">
   제목:<input name="title"><br>
   사진:<input type="file" name="photo" multiple="multiple"><br>
   <input type="button" value="전송" onclick="send(this.form);"><br>
</form>

</body>
</html>
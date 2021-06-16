<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f){
	
		var title = f.title.value.trim();
		var photo = f.photo.value;
		
		if(title==''){
			alert('제목을 입력하세요!!!');
			/* swal("제목","제목을 입력하세요","error"); */
			f.title.value='';
			f.title.focus();
			return;
		}
		if(photo==''){
			alert('업로드할 사진을 선택하세요!!');
			return;
		}
		f.action = "upload.do";//fileuploadaction
		f.submit();
	}

</script>
</head>
<body>

<!-- file upload시 설정사항 
	method="POST"
	enctype="multipart/form-data"
-->

<form action="upload.do" method="POST" enctype="multipart/form-data">
제목: <input name="title"><br>
사진: <input type="file" name="photo"> <br>
	  <input type="button" value="전송1" onclick="send(this.form);"> <br> <!-- this form은 얘가 속해있는 form -->
	  
	  <!-- 주의 button / input type=image 자동으로 onsubnit()호출 
	  			해결방법 : onclick="send(this.form);		return false;
	  						return false의미 : onsubnit() 하지 말아라
	  -->
	  <button onclick="send(this.form); return false;">전송2</button> <br>
	  <input type="image" src="image/click_bt.png" onclick="send(this.form); return false;">
</form>

</body>
</html>
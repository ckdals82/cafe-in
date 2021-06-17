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
		var photo1 = f.photo1.value;
		var photo2 = f.photo2.value;
		
		if(title==''){
			
			alert('제목을 입력하세요!!!');
			//swal("제목","제목을 입력하세요","error");
			f.title.value='';
			f.title.focus();
			return;
		}
		
		if(photo1==''){
			
			alert('업로드할 사진1을 선택하세요!!');
			return;
		}
		
		if(photo2==''){
			
			alert('업로드할 사진2을 선택하세요!!');
			return;
		}
		
		f.action = "upload2.do";//fileupload2action=> file업로드처리  
								//=>	result_upload2.jsp로 forward
		f.submit();
	}

</script>
</head>
<body>

<!-- file upload시 설정사항 
	method="POST"
	enctype="multipart/form-data"
-->

<form action="upload2.do" method="POST" enctype="multipart/form-data">
제목: <input name="title"><br>
사진1: <input type="file" name="photo1"> <br>
사진2: <input type="file" name="photo2"> <br>
	  <input type="button" value="전송1"  onclick="send(this.form);">
	  
	  <!-- this form은 얘가 속해있는 form -->
	  
	  
</form>

</body>
</html>
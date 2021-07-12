<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function send1(f){
		
		var title = f.title.value.trim();
		var photo = f.photo.value;
		
		if(title==''){
			alert('제목을 입력하세요')
			f.title.value='';
			f.title.focus();
			return;
		}
		
		if(photo==''){
			alert('사진을 선택하세요')
			return;
		}
		
		f.action = "upload1.do";//전송대상
		f.submit();//전송
	}
	
function send2(f){
		
		var title = f.title.value.trim();
		var photo = f.photo.value;
		
		if(title==''){
			alert('제목을 입력하세요')
			f.title.value='';
			f.title.focus();
			return;
		}
		
		if(photo==''){
			alert('사진을 선택하세요')
			return;
		}
		
		f.action = "upload2.do";//전송대상
		f.submit();//전송
	}
	
function send3(f){
	
	var title = f.title.value.trim();
	var photo = f.photo.value;
	
	if(title==''){
		alert('제목을 입력하세요')
		f.title.value='';
		f.title.focus();
		return;
	}
	
	if(photo==''){
		alert('사진을 선택하세요')
		return;
	}
	
	f.action = "upload3.do";//전송대상
	f.submit();//전송
}
</script>

</head>
<body>
	<form method="POST" enctype="multipart/form-data">
		<table border="1">
			
			<tr>
				<th>제목</th>
				<td> <input name="title"> </td>    
			</tr>
			
			<tr>
				<th>내용</th>
				<td> <input name="content" value="이미지 설명내용입니다"> </td>    
			</tr>
			
			<tr>
				<th>사진</th>
				<td><input type="file" name="photo"></td>
			</tr>
			
			<tr>
				
				<td colspan="2" align="center">
					 <input type="button" value="낱개로받기" onclick="send1(this.form);" >
					 <input type="button" value="객체로받기" onclick="send2(this.form);" > 
					 <input type="button" value="객체 + 업로드 파일만 따로 받기" onclick="send3(this.form);" >
				</td>    
			</tr>
		</table>
	</form>
	
	<a href="insert_form2.do">멀티파일업로드1</a> <br>
	
	<a href="insert_form3.do">멀티파일업로드2</a>
	
	
</body>
</html>
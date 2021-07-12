<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	
function send4(f){
	
	var title = f.title.value.trim();
	var photo1 = f.photo[0].value;
	var photo2 = f.photo[1].value;
	
	if(title==''){
		alert('제목을 입력하세요')
		f.title.value='';
		f.title.focus();
		return;
	}
	
	if(photo1==''){
		alert('사진1을 선택하세요')
		return;
	}
	
	if(photo2==''){
		alert('사진2을 선택하세요')
		return;
	}
	
	
	f.action = "upload4.do";//전송대상
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
				<th>사진(2장)</th>
				<td>
					<input type="file" name="photo"> <br>
					<input type="file" name="photo">
				</td>
			</tr>
			
			<tr>
				
				<td colspan="2" align="center">
					 <input type="button" value="객체 + 업로드 파일만 따로 받기" onclick="send4(this.form);" >
				</td>    
			</tr>
		</table>
	</form>
	
	<a href="insert_form.do">단일파일업로드</a>
	
	
</body>
</html>
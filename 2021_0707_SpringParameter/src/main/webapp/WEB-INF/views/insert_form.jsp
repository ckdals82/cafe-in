<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function send1(f){
		//입력값 체크
		
		
		
		f.action="insert1.do"
		f.submit();
	}
	
	function send2(f){
		//입력값 체크
		
		
		
		f.action="insert2.do"
		f.submit();
	}
	
	function send3(f){
		//입력값 체크
		
		
		
		f.action="insert3.do"
		f.submit();
	}
</script>


</head>
<body>
	
	<form>
		<table border="1" width="400">
		
			<tr>
				<th>이름</th>
				<td> <input name="name" value="홍길동"> </td>			
			</tr>
			
			<tr>
				<th>나이</th>
				<td> <input name="age" value="20"> </td>			
			</tr>
			
			<tr>
				<th>주소</th>
				<td> <input name="addr" value="서울시 구로구 개봉2동"> </td>			
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="전송1(낱개)" onclick="send1(this.form);">
					<input type="button" value="전송2(객체)" onclick="send2(this.form);">
					<input type="button" value="전송3(Map)" onclick="send3(this.form);">
	 			</td>
			</tr>
			
			
			
		</table>
	</form>
	
</body>
</html>
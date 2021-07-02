<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />

<style type="text/css">
	#box{
		width: 600px;
		
		margin: auto;
		
		margin-top: 50px;
	}
	textarea{
		width: 98%;
		resize: none;
	}	

</style>

<script type="text/javascript">
	
	function send(f){
		
		var p_title   = f.p_title.value.trim();
		var p_content = f.p_content.value.trim();
		var photo 	  = f.photo.value;
		
		if(p_title==''){
			//sweetalert사용법은 구를링 하세용
			swal({title:'[제목오류]',text:'제목을 입력하세요!!',icon:'warning',timer:1000});
			f.p_title.value='';
			f.p_title.focus();
			return;
		}
		
		if(p_content==''){
			swal('[내용오류]','내용을 입력하세요','warning');
			f.p_content.value='';
			return;
		}
		
		if(photo==''){
			swal('[사진오류]','업로드할 사진을 입력하세요!','warning');
			return;
		}
		
		
		f.action = 'insert.do';// photoInsertaction
		f.submit();
	}
</script>

</head>
<body>
	<div id="box">
		<form method="POST" enctype="multipart/form-data">
			
			<input type="hidden" name="m_idx" value="${ user.m_idx }">
		
			<div class="panel panel-primary">
     		<div class="panel-heading"> <h3>사진등록</h3> </div>
      		<div class="panel-body">
      			<table class="table table-striped">
      			 <tr>
      			 	<th>제목 </th>
      			 	<td> <input name="p_title" size="60"> </td>
      			 </tr>
      			 <tr>
      			 	<th>내용 </th>
      			 	<td> <textarea name="p_content" rows="5" cols=""></textarea> </td>
      			 </tr>
      			 <tr>
      			 	<th>사진 </th>
      			 	<td> <input type="file"  name="photo"> </td>
      			 </tr>
      			 <tr>
      			 		<td colspan="2" align= "center"> 
      			 		<input class="btn btn-primary" type="button" value="사진등록" onclick="send(this.form);"> 
      			 		<input class="btn btn-success" type="button" value="메인화면" 
      			 				onclick="location.href='list.do'"> 
      			 		</td>
      			 	</tr>
      			 </table>
      		</div>
   			</div>
		</form>
	</div>

</body>
</html>
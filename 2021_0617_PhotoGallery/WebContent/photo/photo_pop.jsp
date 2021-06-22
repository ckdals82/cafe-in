<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- sweetalert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



	<style type="text/css">
	
	#photo_popup{
		width: 400px;
		min-height: 500px;
		
		border: 2px solid blue;
		
		position: absolute;
		left: 400px;
		top: 100px;
		background: black;
		display: none; /* hide속성임 */
		padding: 20px;
	}
	/* 이 아이디를 가진 애에 아래에 있는 이미지 */
	#photo_popup > img {
	width: 356px;
	height: 356px;
	border: 1px solid white;
	}
	
	#pop_title{
		
		border: 1px solid #cccccc;
		margin-top: 10px;
		color: white;
	}
	#pop_content{
		min-height: 50px;
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
		function close_me(){
			$("#photo_popup").hide();
		}
		//download파일이름
		//var filename;
		
		function download(){
			//alert(filename);
			
			alert('한글=' + encodeURIComponent('한글'));
			// /FileDownload.do?dir=/upload/&filename=a.jpg
			//현재 작업경로 : /photo/list.do	
			//자바스크립트에서 서버로 데이터전송시 인코딩주의
			
			location.href="../FileDownload.do?dir=/upload/&filename=" + 
					encodeURIComponent(filename,"utf-8") ;		
		}
		
		function del(){
			
			Swal.fire({
				  title: '삭제',
				  text: "정말 삭제하시겠습니까?",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '야쓰',
				  cancelButtonText: '놉'
				}).then((result) => {
				  if (result.isConfirmed) {
				    
					//global_p_idx <= 삭제할 p_idx
						//delete.do =>
						location.href = "delete.do?p_idx=" + global_p_idx;
				  }
				  //lamda code
				  //function(result){} => (result) => {}
				});
				//photo.list 파일이 인크루드 하고 있어 global_p_idx를 찾고 싶음 거기로가라! 삭제 또는 수정에 사용됨
		}//end del()
		
		function modify_form(){
			//	PhotoModifyFormAction
			location.href="modify_form.do?p_idx=" + global_p_idx;
		}
		
	</script>

</head>
<body>

	<div id="photo_popup">
		<div style="text-align: right;"> 
			<span id="pop_regdate">올린날짜</span>
			<input type="button" value="x" onclick="close_me();" > 
		</div>
		<img  id="pop_image" src="">
		<div id="pop_title">제목부분</div>
		<div id="pop_content">내용</div>
		<div style="text-align: center; ">
			
			<!-- 로그인상태에서만 가능 -->
			<c:if test="${ not empty user }">			
				<input class="btn-primary" type="button" value="다운로드" onclick="download();">
			</c:if>
			
			
				<input id="pop_btn_del"    class="btn-danger" type="button" value="삭제하기"
					onclick="del();">
				<input id="pop_btn_modify" class="btn-info" type="button" value="수정하기"
					onclick="modify_form()">
			
		</div>
	</div>

</body>
</html>
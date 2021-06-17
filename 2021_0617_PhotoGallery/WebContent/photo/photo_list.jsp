<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>




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


<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/photo.css">

<script type="text/javascript">
	
	function upload_photo(){
		
		//로그인여부체크
		if('${ empty user }'=='true'){
			
			swal({
					title: "사진올리기",
					text: "사진올리기는 로그인후 이용가능합니다\n로그인 하시겠습니까?",
					type: "warning"	,
					showCancelButton   : true,
					confirmButtonClass : "btn-danger",
					confirmButtonText  : "예",
					cancelButtonText   : "아니요",
					closeOnConfirm     : false,
					closeOnCancel      : true
			}, function(isConfirm){
				
				if(isConfirm) 
					location.href='../member/login_form.do';
				
			
			});
			//if(confirm('사진올리기는 로그인후 이용가능합니다\n로그인 하시겠습니까?')==false)return;
			
			//로그인 창으로 이동
		/* 	location.href = '../member/login_form.do)';
			return; */
		}else{
		//로그인된 상태면
		//사진올리기 폼으로 이동
		location.href='insert_form.do';//PhotoInsertFormAction
		//return;
		}
	}
</script>


</head>
<body>
	<div id="main_box">
		<h1 id="title">:::PhotoGallery::::</h1>
		<div id="type_login"> 
			
			<c:if test="${empty user }">
			<!-- 로그인이 안된경우 -->
			<input class="btn btn-primary" type="button" value="로그인">
			</c:if>
			
			<c:if test="${not empty user }">
			<!-- 로그인이 된경우 -->
			<input class="btn btn-primary" type="button" value="로그아웃">
			</c:if>
			
		</div>
		<div id="type_photo_insert">
			<input class="btn btn-primary" type="button" value="사진올리기" onclick="upload_photo();">
		</div>
		<div id="photo_box">
			
			<!-- Data가 없는경우 -->
			<c:if test="${ empty list }">
				<div id="empty_message">등록된 데이터가 없습니다</div>
			</c:if>
			
			<!-- Data가 있는 경우 -->
			<c:forEach var="vo" items="${list }">
				<div class="photo_box_style">
				<img  src="${pageContext.request.contextPath }/upload/배경.jpg">
				<div>${vo.p_title }</div>
				<div>...</div>
			</div>
			</c:forEach>
		</div>
		
	</div>
	
	
</body>
</html>
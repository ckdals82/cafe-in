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

<!-- sweetalert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/photo.css">

<script type="text/javascript">
	
	//download파일이름
	var filename;
	
	var global_p_idx;//삭제 또는 수정할 photo p_idx
	
	function upload_photo(){
		
		//로그인여부체크
		if('${ empty user }'=='true'){
			Swal.fire({
				  title: '사진올리기',
				  html: "사진올리기는 로그인후 이용가능합니다<br>로그인 하시겠습니까?",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '예',
				  cancelButtonText   : "아니요"
				}).then((result) => {
				  if (result.isConfirmed) {
					
					//현재경로 : /photo/list.do
					location.href='${ pageContext.request.contextPath }/member/login_form.do';
				    
				  }
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
	
	function total_view(p_idx){
		
	/* 	alert(p_idx); */
	//팝업화면 띄우기(보여주기)
	//브라우저 크기 구함
	var w = $(window).width();
	var h = $(window).height();
	
	/* alert(w + "x" + h); */
	/* 1440 789 */
	//팝업창의 중앙위치 구하기
	var pop_left = (w / 2) - (500/2)
	var pop_top  = (h / 2) - (550/2)
	
	$("#photo_popup").css({left:pop_left,top:pop_top});
	$("#photo_popup").show();
	
	//데이터가져오기
	//p_idx에 해당되는 데이터 1건을 ajax로 요청
	$.ajax({
		url		: 'photo_one.do',	//photoOneaction
		data 	: {'p_idx': p_idx},	//parameter
		dataType: 'json',			//수신data타입
		success : function(result_data){
			//정상수신되었을경우
			//{"p_idx":"1","p_title":"1번째 사진"..}
			//alert(result_data.p_title);
			$("#pop_title").html(result_data.p_title);
			$("#pop_image").attr('src','../upload/'+result_data.p_filename);
			$("#pop_content").html(result_data.p_content);
			$("#pop_regdate").html(result_data.p_modifydate.substring(0,16));
			
			//download할 파일이름
			filename = result_data.p_filename;
			//삭제 또는 수정될 p_idx
			global_p_idx = p_idx;
			
			
			//수정/삭제버튼 사용유무 결정
			if(("${ user.m_idx }"==result_data.m_idx) 
				|| 
			  ("${ user.m_grade eq '관리자'}"=="true")
			)
			{
				//보여줘라		
				$("#pop_btn_del").show();
				$("#pop_btn_modify").show();
			}else{
				//숨겨라
				//alert('hide');
				$("#pop_btn_del").hide();
				$("#pop_btn_modify").hide();
			}
		},
		error	: function(err){
			alert(err.responseText);
		}
	});
	
	
	}
	
</script>


</head>
<body>
		<!-- 전체보기 팝업화면 -->
	<%@include file="photo_pop.jsp" %>

	<div id="main_box">
		<h1 id="title">:::PhotoGallery::::</h1>
		<div id="type_login"> 
			
			<c:if test="${empty user }">
			<!-- 로그인이 안된경우 -->
			<input class="btn btn-primary" type="button" value="로그인" 
							onclick="location.href='${ pageContext.request.contextPath }/member/login_form.do'">
			</c:if>
			
			<!-- 로그인이 된경우 -->
			<c:if test="${not empty user }">
			
			<b> [${ user.m_name }]</b> 님 로그인 하셨습니다.
			<input class="btn btn-primary" type="button" value="로그아웃"
							onclick="location.href='${ pageContext.request.contextPath }/member/logout.do'">
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
				<img  src="${pageContext.request.contextPath }/upload/${vo.p_filename}">
				<div class="title_style">${vo.p_title }</div>
				<div style="text-align: center;"> <input class="btn btn-info" type="button" value="전체보기"
							 onclick="total_view('${vo.p_idx}' );" >
				 </div>
			</div>
			</c:forEach>
		</div>
		
	</div>
	
	
</body>
</html>
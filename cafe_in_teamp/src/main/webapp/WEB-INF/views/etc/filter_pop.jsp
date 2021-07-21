<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script
      src="https://kit.fontawesome.com/6478f529f2.js"
      crossorigin="anonymous"
    >
      >
    </script>
<!-- sweetalert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!-- <style type="text/css">
#filter_popup {
	width: 400px;
	min-height: 500px;
	border: 2px solid blue;
	position: absolute;
	left: 400px;
	top: 100px;
	background: gray;
	display: none; /* hide속성 처음부터 안나온다. */
	padding: 20px;
}



#pop_title {
	border: 1px solid #cccccc;
	margin-top: 10px;
	color: yellow;
}

#pop_content {
	min_height: 50px;
	height: auto;
	border: 1px solid #cccccc;
	margin-top: 10px;
	margin-bottom: 10px;
	color: white;
}

#pop_regdate {
	color: white;
}
</style> -->

<script type="text/javascript">


function frameclose() { 
parent.close() 
window.close() 
self.close() 



}
function in_filter(f) {
    
    
       return;
    }
    
    f.action = "filter_in.do";
    f.submit();
 }

</script>

<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/_css/filter_pop.css">
</head>
<body>
	<form method="get" action="form-action.html" class="filter_f">
		<div class="filter_box">
			<div id="filter_popup">
				
					<a class="bt_x" onclick="this.parentNode.parentNode.style.display = 'none'"><i class="far fa-times-circle"></i></a>
					<p class="f_name">필터</p>
					<h1></h1>
					<p>분위기</p>
					<div class="mood_box" >
						<label><input type="checkbox">공부</label> 
						<label><input type="checkbox">데이트</label>
						<label><input type="checkbox">엔티크</label>
						<label><input type="checkbox">빈티지</label>
						<label><input type="checkbox">러블리</label>
						<label><input type="checkbox">모던</label>
					</div>
					<h1></h1>
					<p>디저트</p>
					<div class="desert_box">
						<label><input type="checkbox">마카롱</label>
						<label><input type="checkbox">빵</label>
						<label><input type="checkbox">빙수</label>
						<label><input type="checkbox">케이크</label>
						<label><input type="checkbox">와플</label>
					</div>
					<div class="send_reset">
						
						<input class="btn btn-default" class="sub_btn" type="submit" value="Submit"> <input type="reset"
							class="btn btn-default" value="Reset">
					</div>
				
			</div>
		</div>
	</form>
</body>
</html>
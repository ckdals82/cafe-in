<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL -->
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
							<!-- 현재 context경로 구하는식: 2021_0608_visit -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/visit.css"> <!-- visit_list.jsp의 경로가 바껴도 수정할 필요가\ 없다 -->
														
<script type="text/javascript">
	
	function del(f){
		
		var idx = f.idx.value;
		var c_pwd = f.c_pwd.value.trim();
		
		if(c_pwd==''){
			alert('삭제 비밀번호를 입력하세요!!')
			f.c_pwd.value='';
			f.c_pwd.focus();
			return;
		}
		//Ajax이용해서 비번 확인
		$.ajax({
			url	: 'check_pwd.do', // visitCheckPwdAction
			data : {'idx': idx, 'c_pwd': c_pwd},
			dataType: 'json',
			success: function(result_data){},
			error:function(err){}
		});
		
		
		
	}
	
	
	function modify_form(f){
		
		var c_pwd = f.c_pwd.value.trim();
		var pwd	  = f.pwd.value;
		
		
		if(c_pwd==''){
			alert('비밀번호를 입력하세요!!')
			f.c_pwd.value='';
			f.c_pwd.focus();
			return;
		}
		
		if(pwd != c_pwd){
			alert('비밀번호가 틀립니다!!')
			f.c_pwd.value='';
			f.c_pwd.focus();
			return;
		}
		
		
		//수정폼 띄우기
		location.href = "modify_form.do?idx=" + f.idx.value;
		
	}


</script>
																			  
</head>
<body>

	<div id="box">
		<h1 id="title">::::방명록::::</h1>
		<div id="type_btn">
			<input class="btn btn-primary" type="button" value="글쓰기" onclick="location.href='insert_form.do'">
		</div>
		
		<!-- 게시물이 없으면 -->
		<c:if test="${ empty list }">
			<div id="empty_message">
				게시물이 존재하지 않습니다...
			</div>
		</c:if>
		
		<!-- 게시물이 있는경우 -->
		<!-- for(VisitVo vo : list) -->
		<c:forEach var="vo" items="${ list }">
			<div class="panel panel-info">
      			<div class="panel-heading"><span class="type_name">${vo.name }님이 남기신 글 ...</span></div>
      			<div class="panel-body">
      				<div class="type_content">${ vo.content }</div>
      				<div class="type_regdate">작성일시:${ fn:substring(vo.regdate,0,16) }(${ vo.ip })</div>
      				<div class="type_pwd">
      					<form>
      						<input type="hidden" name="idx" value="${ vo.idx }">
      						
      					비밀번호(${ vo.pwd }):<input type="password" name="c_pwd">
      						   <input class="btn btn-success" type="button" value="수정" onclick="modify_form(this.form)">
      						   <input class="btn btn-danger"  type="button" value="삭제" onclick="del(this.form);">
      					</form>
      				</div>
      			</div>
    		</div>
			
		</c:forEach>
		
	</div>

</body>
</html>
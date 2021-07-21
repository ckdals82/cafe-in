<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--bootstrap  -->
<link rel='stylesheet'
   href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script
   src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script
   src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
   
<!-- sweetalert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style type="text/css">
   #main_box{
      width: 1000px;
      margin: auto;
      margin-top: 20px;
      
   }
   
   #title{
      text-align: center;
      font-size: 24pt;
      font-weight: bold;
      color: #3366ff;
      text-shadow: 1px 1px 1px black;
   }
   
   input[type='button']{
      width: 100px;
   }
   
   th,td{
      text-align: center;
   }
   
   #empty_message{
      text-align: center;
      color: red;
      font-size: 16pt;
      font-weight: bold;
      margin-top: 50px;
       
   }
</style>
<script type="text/javascript">
	//새글쓰기
	function insert_form(){
		//로그인여부체크
		if('${ empty user }'=='true'){
			Swal.fire({
				  title: '새글쓰기',
				  html: "새글쓰기는 로그인후 이용가능합니다<br>로그인 하시겠습니까?",
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

</script>

</head>
<body>
   <div id="main_box">
      <h1 id="title">::::게시판::::</h1>
      <!-- login기능 -->
      <div style="text-align: right;">
         <!-- 로그인 안된경우 -->
         <c:if test="${empty user }">
            <input class="btn btn-primary" type="button" value="로그인"
            onclick="location.href='${ pageContext.request.contextPath}/member/login_form.do'"		>   
         </c:if>
         
         <!-- 로그인 안된경우 -->
         <c:if test="${not empty user }">
            <b>${user.m_name }</b>님 방문하셨습니다.
            <input class="btn btn-primary" type="button" value="로그아웃"
            onclick="location.href='${ pageContext.request.contextPath}/member/logout.do'"		>   
         </c:if>
      </div>
      <!--새글쓰기  -->
      <div style="margin-bottom: 10px;">
         <input class="btn btn-primary" type="button" value="새글쓰기"
         		onclick="insert_form()">
      </div>
      
      <table class="table">
         <!-- 제목 -->
         <tr class="success">
            <th>번호</th>
            <th width="50%">제목</th>
            <th>작성자</th>
            <th>작성일자</th>
            <th>조회수</th>
         </tr>
         
         <!-- Data없는 경우 -->
         <c:if test="${empty list }">
            <tr>
               <td colspan="5">
                  <div id="empty_message">게시물이 존재하지 않습니다.</div>
               </td>
            </tr>
         </c:if>   
         
         <!--  Data 있는경우  -->
         <!-- for(BoardVo vo: list -->
         <c:forEach var="vo" items="${list }">
            <tr>
               <td>${vo.no }</td>
               
               <!-- 제목 -->
               <td style="text-align: left;">
               		
               		<!-- b_depth만큼 들여쓰기 -->
               		<c:forEach begin="1" end="${ vo.b_depth }">
               			&nbsp;&nbsp;
               		</c:forEach>
               		
               		<!-- 답글인경우에만 붙인다 -->
               		<c:if test="${ vo.b_depth ne 0 }">
               		ㄴ
               		</c:if>
               		
               		<!-- 사용가능한 게시글일떄  -->
               		<c:if test="${ vo.b_use_yn eq 'y' }">
               			<a href="view.do?b_idx=${vo.b_idx }&page=${ (empty param.page) ? 1 : param.page }">${vo.b_subject }"</a>
               		</c:if>
               		
               		<!-- 삭제된 게시글일때 -->
               		<c:if test="${ vo.b_use_yn eq 'n' }">
               			<span style="color:red;">삭제된 글입니다(${vo.b_subject })</span>
               		</c:if>
               </td>
               
               
               <td>${vo.m_name }</td>
               <td>${fn:substring(vo.b_regdate,0,16) }</td>
               <td>${vo.b_readhit }</td>
            </tr>
         </c:forEach>
         
      </table>
      <!-- 페이지에 메뉴넣기 -->
      <div style="text-align: center; font-size: 15px;">
      	${ pageMenu }
      
      
      <!--     <a href="list.do?page=1">1</a> &nbsp;&nbsp;&nbsp;
          <a href="list.do?page=2">2</a> &nbsp;&nbsp;&nbsp;
          <a href="list.do?page=3">3</a> &nbsp;&nbsp;&nbsp;
          <a href="list.do?page=4">4</a> &nbsp;&nbsp;&nbsp;
          <a href="list.do?page=5">5</a> &nbsp;&nbsp;&nbsp;
          <a href="list.do?page=6">6</a> &nbsp;&nbsp;&nbsp; -->
       </div>
      		
      		
   </div>
</body>
</html>
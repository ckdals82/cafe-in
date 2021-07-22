<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #box{
     width: 600px;
     margin: auto;
     margin-top: 50px;
  
  }
  
  #subject,#content,#regdate{
      width: 500px;
      margin: 2px;
      border: 1px solid gray;
      padding: 5px;
      
      box-shadow: 1px 1px 1px black;
      
  }
  
  #content{
       min-height: 200px;
  }
  
  input[type='button']{
      width: 100px;
  }

</style>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- sweetalert2  -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript">
  
   function reply_form(b_idx){
	   
	   //로그인여부 체크
	   if('${ empty user }'=='true'){
		   
		   Swal.fire({
			   title: '답글쓰기',
			   html: "<h5>답글쓰기는 로그인후 이용가능합니다<br>로그인 하시겠습니까?</h5>",
			   icon: 'warning',
			   showCancelButton: true,
			   confirmButtonColor: '#3085d6',
			   cancelButtonColor: '#d33',
			   confirmButtonText: '예',
			   cancelButtonText : "아니오"
			 }).then((result) => {
			   if (result.isConfirmed) {
			     
				  //현재경로 : /board/list.do
				  location.href='${ pageContext.request.contextPath }/member/login_form.do?url=' + location.href;
			   }
			 });
		   
		  
	   }else{
		   //로그인된 상태면...
		   //답글쓰기 폼으로 이동
		   location.href = 'reply_form.do?b_idx=' + b_idx + "&page=${ param.page }";
	   }
	   
   }//end-reply_form
   
   
   //삭제
   function del(b_idx){
	   
	   Swal.fire({
		   title: '게시물삭제',
		   html: "<h4>정말 삭제 하시겠습니까?</h4>",
		   icon: 'question',
		   showCancelButton: true,
		   confirmButtonColor: '#3085d6',
		   cancelButtonColor: '#d33',
		   confirmButtonText: '예',
		   cancelButtonText : "아니오"
		 }).then((result) => {
		   
			 //예 버튼클릭
			 if (result.isConfirmed) {
		      location.href="delete.do?b_idx=" + b_idx + "&page=${ param.page }&search=${ param.search }&search_text=${ param.search_text }";
		   
			 }
		 });
   }//end-del
   
   
   function modify_form(b_idx){
	   
	   location.href="modify_form.do?b_idx=" + b_idx +"&page=${ param.page }&search=${ param.search }&search_text=${ param.search_text }";
	   
   }//end-modify_form
   
   


</script>


</head>
<body>

	<div id="box">
		<div class="panel panel-primary">
			<div class="panel-heading"><h4><b>${ vo.m_name }(${ vo.b_ip })</b>님이 작성한 글:</h4></div>
			<div class="panel-body">
			    <table class="table">
			       <tr>
			          <th>제목</th>
			          <td><div id="subject">${ vo.b_subject }</div></td>
			       </tr>
			       
			       <tr>
			          <th>내용</th>
			          <td><div id="content">${ vo.b_content }</div></td>
			       </tr>
			    
			       <tr>
			           <th>작성일자</th>
			           <td><div id="regdate">${ fn:substring(vo.b_regdate,0,16) }</div></td>
			       </tr>
			       
			       <tr>
			           <td colspan="2" align="center">

			               <input class="btn btn-primary" type="button"  value="목록보기"
			                      onclick="location.href='list.do?page=${ param.page }&search=${ param.search }&search_text=${ param.search_text }'" >
			               
			               <!-- 메인글일경우만 사용가능 -->
			               <c:if test="${ vo.b_depth eq 0 }">
			                   <!-- 전체보기일때만 답글달기 해라 -->
			                   <c:if test="${ (empty param.search) or (param.search eq 'all') }">
					               <input class="btn btn-success" type="button"  value="답글쓰기"
					                      onclick="reply_form('${ vo.b_idx }');">
				               </c:if>       
			               </c:if>       
			               
			               <!-- 본인 또는 관리자 -->
			               <c:if test="${ (vo.m_idx eq user.m_idx)  or (user.m_grade eq '관리자') }">
				               <input class="btn btn-info"    type="button"  value="수정"  onclick="modify_form('${ vo.b_idx }');">
				               <input class="btn btn-danger"  type="button"  value="삭제"  onclick="del('${ vo.b_idx }');">
			               </c:if>
			               
			               
			           </td>
			       </tr>
			    
			    </table>
			
			</div>
		</div>

	</div>
</body>
</html>
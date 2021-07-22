<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- sweetalert2  -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<style type="text/css">
   #main_box{
      width: 1000px;
      margin: auto;
      margin-top: 20px;
   }

   #title{
       text-align: center;
       font-size: 26pt;
       font-weight: bold;
       color: #3388dd;
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
 
  //jQuery초기화
  $(document).ready(function(){
	 
	  if('${ not empty param.search }'=='true'){
	  	$("#search").val('${param.search}');
	  	
	  	//전체보기면 검색어 지워라..
	  	if("${param.search eq 'all'}"=="true"){
	  		$("#search_text").val("");
	  	}
	  	
	  }
	  
	  
	  
  });
 
 
 
  //새글쓰기폼띄우기
  function insert_form() {
	  //로그인여부 체크
	   if('${ empty user }'=='true'){
		   
		   Swal.fire({
			   title: '새글쓰기',
			   html: "새글쓰기는 로그인후 이용가능합니다<br>로그인 하시겠습니까?",
			   icon: 'warning',
			   showCancelButton: true,
			   confirmButtonColor: '#3085d6',
			   cancelButtonColor: '#d33',
			   confirmButtonText: '예',
			   cancelButtonText : "아니오"
			 }).then((result) => {
			   if (result.isConfirmed) {
			     
				  //현재경로 : /board/list.do
				  location.href='${ pageContext.request.contextPath }/member/login_form.do';
			   }
			 });
		   
		  
	   }else{
		   //로그인된 상태면...
		   //글쓰기 폼으로 이동
		   location.href = 'insert_form.do'; 
	   }
	  
  }//end-insert_form
  
  //검색버튼 클릭시
  function find(){
	  
	  var search      = $("#search").val();
	  var search_text = $("#search_text").val().trim();
	  
	  //전체검색이면 검색창내용 지워라..
	  if(search=='all'){
		  $("#search_text").val("");
	  }
	  
	  if(search!='all' && search_text==''){
		  
		  alert('검색어를 입력하세요');
		  $("#search_text").val("");//값 지우기
		  $("#search_text").focus();
		  return;
	  }
	  
	  
	  //자바스크립트 이용 요청
	  //encodeURIComponent(search_text,"utf-8") 
	  //  : search_text 한글또는 특수문자인경우 인코딩해서 넘겨야 서버가 제대로 인식한다
	  location.href = "list.do?search=" + search + "&search_text=" + encodeURIComponent(search_text,"utf-8") ;

	  
  }//end-find
  
  

</script>

</head>
<body>
  <div id="main_box">
       <h1 id="title">::::게시판::::</h1>
       <!-- login기능 -->
       <div style="text-align: right;">
             <!-- 로그인 안된경우 -->
             <c:if test="${ empty user }">
                 <input class="btn  btn-primary" type="button"  value="로그인"
                        onclick="location.href='${ pageContext.request.contextPath }/member/login_form.do'"     >
             </c:if>
             
             <!-- 로그인 된경우 -->
             <c:if test="${ not empty user }">
                 <b>${ user.m_name }</b>님 방문하셨습니다
                 <input class="btn  btn-primary" type="button"  value="로그아웃"
                        onclick="location.href='${ pageContext.request.contextPath }/member/logout.do'" >
             </c:if>     
       </div>
       
       
       <!-- 새글쓰기 -->
       <div style="margin-bottom: 10px;">
           <input class="btn  btn-primary" type="button"  value="새글쓰기"  
                  onclick="insert_form();">
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
           <c:if test="${ empty list }">
              <tr>
                 <td colspan="5">
                    <div id="empty_message">게시물이 존재하지 않습니다</div>
                 </td>
              </tr>
           </c:if>
           
           <!-- Data있는 경우 -->
           <!-- for(BoardVo vo : list)         -->
           <c:forEach var="vo"  items="${ list }">
              <tr>
                 <td>${ vo.no }</td>
                 
                 <!-- 제목 -->
                 <td style="text-align: left;">
                  
                     <!-- b_depth만클 들여쓰기 -->
                     <c:forEach begin="1"  end="${ vo.b_depth }">
                         &nbsp;&nbsp;
                     </c:forEach>
                 
                     <!-- 답글인경우에만 붙인다 -->
                     <c:if test="${ vo.b_depth ne 0 }">
                        ㄴ
                     </c:if>
                     
                     <!--사용가능한 게시글일때  -->
                     <c:if test="${ vo.b_use_yn eq 'y' }">
                     	<a href="view.do?b_idx=${ vo.b_idx }&page=${ (empty param.page) ? 1 :  param.page }&search=${ (empty param.search) ? 'all' : param.search }&search_text=${ param.search_text }">${ vo.b_subject }</a>
                     </c:if>
                        
                     <!-- 삭제된 게시글일때 -->
                     <c:if test="${ vo.b_use_yn eq 'n' }">
                     	<span style="color:red;">삭제된 글입니다(${ vo.b_subject })</span>
                     </c:if>    
                        
                 </td>
                 
                 
                 <td>${ vo.m_name }</td>
                 <td>${ fn:substring(vo.b_regdate,0,16) }</td>
                 <td>${ vo.b_readhit }</td>
              </tr>
           </c:forEach>
           
           
       </table>
       
       <!-- 검색메뉴  -->
       <div style="text-align: center;">
       
           <select id="search">
               <option value="all">전체보기</option>
               <option value="name">이름</option>
               <option value="subject">제목</option>
               <option value="content">내용</option>
               <option value="subject_content">제목+내용</option>
           </select>
           <input id="search_text" value="${ param.search_text }">
           <input class="btn btn-primary"  style="width:60px;" type="button"  value="검색" onclick="find();">
           
       </div>
       
       
       
       <!-- Page메뉴 넣기 -->
       <div style="text-align: center; font-size: 15pt;">

             ${ pageMenu }
              
       </div>
       
       
       
       
  </div>
</body>
</html>
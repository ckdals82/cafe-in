<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!-- JSTL설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<link rel="stylesheet"
   href="${pageContext.request.contextPath }/css/visit.css">
<!-- 내가쓸 css 경로지정 여기서 style태그 쓰면 코드길어져서 따로씀. -->
<!--나중에 유지보수할때 편하게하려면 ../ 보다 ${pageContext.request.contextPath }/ 쓰는게낫다  -->

<script type="text/javascript">
function del(f) {
   
   var idx = f.idx.value;
   var c_pwd = f.c_pwd.value.trim();
   
   if(c_pwd==''){
      alert('삭제 비밀번호를 입력하세요!!')
      f.c_pwd.value='';
      f.c_pwd.focus();
      return;
   }
   
   //Ajax 이용해서 비번 확인
   $.ajax({
      url      : 'check_pwd.do', //VisitCheckPwdAction
      data   : {'idx': idx, 'c_pwd': c_pwd},
      dataType: 'json',
      success:function(result_data){
         //result_data = {"result":true} or {"result":false} 
         if(result_data.result == false){
            alert('비밀번호가 틀립니다');
            return;
         }
         
         //삭제확인
         if(confirm("정말 삭제하시겠습니까?")==false){
            return;
         }
         //삭제
         location.href ="delete.do?idx=" + idx;
         
      },
      error  :function(err){
         alert(err.responseText);
      }
      
   });
   
   
}
   
function modify_form(f){
      
      var c_pwd = f.c_pwd.value.trim();
      var pwd     = f.pwd.value;
      
      
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
   
   function search() {
      var search       = $("#search").val();
      var search_text = $("#search_text").val().trim();
      
      //전체보기가 아니면서 검색내용이 입력이 안되었으면
      if(search != 'all' && search_text==''){
         
         Swal.fire({
              title: '검색 내용을 입력 하세요',
              icon : 'warning',
              confirmButtonText: `확인`,
              denyButtonText: `Don't save`,
            }).then((result) => {
              if (result.isConfirmed) {
                 
                 $("#search_text").focus();    
                 $("#search_text").val('');   //값비우기 
                 return;
              }
            });
         //alert('검색 내용을 입력 하세요');
          
         return;
      }else if(search=='all'){
         search_text = '';
         $("#search_text").val('');
      }//end if 
      
      //서버로 요청내용 전송
      location.href="list.do?search=" + search + "&search_text=" + encodeURIComponent(search_text,"utf-8");
   }
	
   /* jQuery초기화 */
   $(function(){
	  
	   //list.do?search=all
		//검색카테고리(search)가 있으면 아래 내용 처리해라
	   if('${not empty param.search}'=='true'){
		   $("#search").val('${param.search}');
	   }
		   
	   
	  /*  $("#search").val('${param.search}'); */
	   
   });
   
</script>


</head>
<body>


   <div id="box">
      <h1 id="title">::::방명록::::</h1>
      <div id="type_btn">
         <input class="btn btn-primary" type="button" value="글쓰기"
            onclick="location.href='insert_form.do'">
      </div>
      
      <!-- 검색기능 -->
      <hr>
         <div style="margin-top:10px; margin-bottom: 10px; text-align: center;">
            <select id="search">
               <option value="all">전체보기</option>
               <option value="name">이름</option>
               <option value="content">내용</option>
               <option value="name_content">이름+내용</option>
               <option value="regdate">작성일자</option>
            </select>
            <input id="search_text" value="${ param.search_text }">
            <input class="btn btn-primary" type="button" value="검색" onclick="search();">      
         </div>
      <hr>
      <!-- 게시물이 없으면 -->
      <c:if test="${ empty list }">
         <div id="empty_message">게시물이 존재하지 않습니다...</div>
      </c:if>

      <!-- 게시물이 있는경우 -->
      <!-- for(VisitVo vo : list) -->
      <c:forEach var="vo" items="${ list }">
         <div class="panel panel-info">
            <div class="panel-heading">
               <span class="type_name">${vo.name }님이 남기신 글 ...</span>
            </div>
            <div class="panel-body">
               <div class="type_content">${ vo.content }</div>
               <div class="type_regdate">작성일시:${ fn:substring(vo.regdate,0,16) }(${ vo.ip })</div>
               <div class="type_pwd">
                  <form>
                     <input type="hidden" name="idx" value="${ vo.idx }"> 
                     <input type="hidden" name="pwd" value='${ vo.pwd }'> 
                     비밀번호:<input type="password" name="c_pwd"> 
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
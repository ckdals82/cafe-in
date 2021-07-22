<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #box{
     width: 700px;
     margin: auto;
     margin-top: 30px;
  }
  
</style>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- daum 주소찾기 라이브러리 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript">

  var regular_id = /^[a-zA-Z0-9]{4,10}$/;

  $(document).ready(function(){
	  
	  
	  //주소찾기 버튼 클릭시
	  $("#btn_find").click(function(){
		  
		  var width  = 500;  //팝업의 너비
		  var height = 600;  //팝업의 높이
		  
		  new daum.Postcode({
			    width: width, //생성자에 크기 값을 명시적으로 지정해야 합니다.
			    height: height,
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            // data = {'zonecode':'12345', 'address':'서울시 관악구 시흥대로 552', 'roadAddress':''서울시 관악구 시흥대로 552''}
		            $("#m_zipcode").val(data.zonecode);
		            $("#m_addr").val(data.roadAddress);
		        },
		        theme: {
		            searchBgColor:  "#0B65C8", //검색창 배경색
		            queryTextColor: "#FFFFFF"  //검색창 글자색
		        }     
		    }).open(
		    		{
		    		    left: (window.screen.width / 2) - (width / 2),
		    		    top: (window.screen.height / 2) - (height / 2)
		    		}	
		    );
	  });// end 찾기버튼 클릭
	  
	  
	  //회원구분값 체크
	  if("${ vo.m_grade eq '일반'}"=="true"){
	     $("#user_normal").attr('checked',true);
	  }else{
	  	 $("#user_admin").attr('checked',true);
	  }
	  
	  
  });// end  jQuery초기화 

  
  
  function send(f){
	  
	  //입력값 체크...
	  //var m_name = f.m_name.value.trim();
	  var m_pwd  = f.m_pwd.value.trim();
	  //우편번호/주소...
	  var m_zipcode  = f.m_zipcode.value.trim();
	  var m_addr     = f.m_addr.value.trim();
	  
	  /* if(m_name==''){
		  alert('이름을 입력하세요');
		  f.m_name.value='';
		  f.m_name.focus();
		  return;
	  } */
	  
	  if(m_pwd==''){
		  alert('비밀번호를 입력하세요');
		  f.m_pwd.value='';
		  f.m_pwd.focus();
		  return;
	  }
	  
	  if(m_zipcode==''){
		  alert('우편번호를 입력하세요');
		  f.m_zipcode.value='';
		  f.m_zipcode.focus();
		  return;
	  }
	  
	  if(m_addr==''){
		  alert('주소를 입력하세요');
		  f.m_addr.value='';
		  f.m_addr.focus();
		  return;
	  }
	  	  
	  
	  
	  //
	  f.action = "modify.do";// MemberModifyAction
	  f.submit();//전송
	  
	  
  }
  
  
  
  
  
</script>


</head>
<body>
  <div id="box">
     <form>
        
        <input type="hidden"  name="m_idx"  value="${ vo.m_idx }">
        
        <div class="panel panel-primary">
	      <div class="panel-heading">회원수정</div>
	      <div class="panel-body">
	         <table class="table table-striped">
	             <tr>
	                 <th>이름(수정불가)</th>
	                 <td><input name="m_name"  value="${ vo.m_name }"  readonly="readonly"></td>
	             </tr>
	             <tr>
	                 <th>아이디(수정불가)</th>
	                 <td><input name="m_id"  id="m_id"  value="${ vo.m_id }" readonly="readonly">
	             </tr>
	             <tr>
	                 <th>비밀번호</th>
	                 <td><input type="password" name="m_pwd"  value="${ vo.m_pwd }"></td>
	             </tr>
	             
	             <tr>
	                 <th>우편번호</th>
	                 <td>
	                    <input name="m_zipcode"  id="m_zipcode" value="${ vo.m_zipcode }">
	                    <input class="btn btn-info" type="button"  id="btn_find" value="주소찾기">    
	                 </td>
	             </tr>
	             
	             <tr>
	                 <th>주소</th>
	                 <td><input name="m_addr"  id="m_addr" size="60"  value="${ vo.m_addr }"></td>
	             </tr>
	             
	             
	             <!-- 관리자일때만 수정가능 -->
	             <c:if test="${ user.m_grade eq '관리자' }">
		             <tr>
		                 <th>회원등급</th>
		                 <td>
	                          <input type="radio" name="m_grade" value="일반"   id="user_normal">일반 
	                          <input type="radio" name="m_grade" value="관리자" id="user_admin">관리자 		                 
		                 </td>
		             </tr>
	             </c:if>
	             
	             <!-- 관리자 아닐때 -->
	             <c:if test="${ user.m_grade ne '관리자' }">
	                  <input type="hidden" name="m_grade" value="일반" >	             
	             </c:if>
	             
	             
	             <tr>
	                 <td colspan="2" align="center">
	                     <input class="btn btn-primary" type="button" id="btn_register" value="수정하기"  
	                                                    onclick="send(this.form);">
	                            
	                     <input class="btn btn-success" type="button"  value="메인화면" 
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
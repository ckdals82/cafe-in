<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" 
  		content="text/html; charset=UTF-8">
    <title></title>
    
    <style>
        a:link{text-decoration:none; color:navy}
        a:visited{text-decoration:none; color:navy}
        a:hover{text-decoration:none; color:red}
    </style>
    

  </head>
  <body>
  <hr width="600" border="1" noshade color="navy">
  <center>
      <font size="4" color="maroon">
          <b>ITLAND SHOPPING CENTER</b>
      </font>
  </center>
  <hr width="600" border="1" noshade color="navy">
  <center>
      <a href="list.do?p_category=com001">컴퓨터</a> | 
      <a href="list.do?p_category=ele002">가전 제품</a> | 
      <a href="list.do?p_category=sp003">스포츠</a>
  </center>
  <hr width="600" border="1" noshade style="color: navy" color="navy">
  
  <center>
	  <div style="width: 600px; text-align: right;">
	  	
	  		<!-- 로그인 안된경우 -->
	  		<c:if test="${ empty sessionScope.user }">
	  			<input class="btn btn-primary" type="button" value="로그인"
	  					onclick="location.href='${pageContext.request.contextPath }/member/login_form.do'">
	  		</c:if>
	  		<!-- 로그인된 경우 -->
	  		<c:if test="${ not empty sessionScope.user }">
	  		<b>${user.m_name }님 입장 </b>
	  		<input class="btn btn-primary" type="button" value="로그아웃"
	  					onclick="location.href='${pageContext.request.contextPath }/member/logout.do'">
	  		<input class="btn btn-primary" type="button" value="장바구니보기"
	  					onclick="location.href='cart_list.do'">			
	  		</c:if>
	  </div>
  </center>
  <hr width="600" border="1" noshade color="navy">
  
  <!-- 관리자일떄만 사용 -->
  <c:if test="${ user.m_grade eq '관리자' }">
  <center>
	<div style="width: 600px; text-align: left;">
		<input  class="btn btn-primary" type="button" value="상품올리기" 
							onclick="location.href='insert_form.do'">
	
	</div>      
  </center>
  <hr width="600" border="1" noshade style="color: navy" color="navy">
  	</c:if>
  </body>
</html>
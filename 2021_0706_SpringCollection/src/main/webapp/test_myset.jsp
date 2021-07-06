
<%@page import="myutil.MySet"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%
   //Spring bean이 저장된 위치정보를 얻어온다
   
   WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);

   //MySet객체정보 얻어오기
   MySet mySet = wc.getBean("mySetBean",MySet.class);
   
   
   //EL로 하려면..
   pageContext.setAttribute("mySet", mySet);
   
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
   <hr>
      시도 목록
   <hr>
   
   <ul>
      <!-- for(String sido: mySet.getSido_set()) -->
      <c:forEach var="sido" items="${mySet.sido_set }">
         <li>${sido }</li>
      </c:forEach>
   </ul>

</body>
</html>

<%@page import="java.util.Properties"%>
<%@page import="myutil.MyProp"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- c for 문 같은거 사용하기 위해 -->  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	//spring bean이 저장된 위치정보를 얻어온다
	WebApplicationContext wc 
	= WebApplicationContextUtils.getWebApplicationContext(application);
	
	//저장된 MyProp객체정보 얻어온다
	MyProp myProp = wc.getBean("myPropBean",MyProp.class);
	
	//MyProp내의 prop정보 얻어온다.
	Properties prop = myProp.getProp();
	
	//el사용하려고 쓰는
	pageContext.setAttribute("myProp", myProp);
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
		방법1)드라이버
	<hr>
	<ul>
		<c:forEach var="prop" items="${ myProp.prop }">
		<li> [${ prop.key }]  [${ prop.value }]입니다 </li>
		</c:forEach>
	</ul>
	
	
	
</body>
</html>
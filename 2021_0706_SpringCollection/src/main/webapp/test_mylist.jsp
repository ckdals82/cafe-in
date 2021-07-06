<%@page import="java.util.List"%>
<%@page import="myutil.MyList"%>
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
	
	//저장된 MyList객체정보 얻어온다
	MyList myList = wc.getBean("myListBean",MyList.class);
	//MyList내의 ArrayList정보 얻어온다
	List fruit_list = myList.getFruit_list();
	
	//EL사용하려고 쓰는거임 el은 4개 scope영역 저장되잇는거만 사용
	pageContext.setAttribute("fruit_list", fruit_list);
	 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
		과일목록
	<hr>
	<ul>
		<!-- for(String fruit: fruit list) -->
		<c:forEach var="fruit" items="${ fruit_list }">
			<li>${ fruit } </li>
		</c:forEach>
	</ul>
	
</body>
</html>
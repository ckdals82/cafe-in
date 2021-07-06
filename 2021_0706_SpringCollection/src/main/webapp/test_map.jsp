

<%@page import="java.util.Set"%>
<%@page import="myutil.MyList"%>
<%@page import="java.util.Map"%>
<%@page import="myutil.MyMap"%>
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
	
	//저장된 MyMap객체정보 얻어온다
	MyMap mymap = wc.getBean("myMapBean",MyMap.class);
	
	//Mymap내의 map정보 얻어온다
	Map map = mymap.getMap();
	//방법2
	Set keySet = mymap.getMap().keySet();
	
	//EL사용하려고 쓰는거임 el은 4개 scope영역 저장되잇는거만 사용
	pageContext.setAttribute("myMap", mymap);
	
	//방법2
	pageContext.setAttribute("keySet", keySet);
	pageContext.setAttribute("map1", map); 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
		방법1)단어찾기
	<hr>
	<ul>
		<c:forEach var="map" items="${ myMap.map }">
		<li>영어단어 [${ map.key }]의 뜻은 [${ map.value }]입니다 </li>
		</c:forEach>
	</ul>
	
	<hr>
		방법2)단어찾기
	<hr>
	<ul>
		<!-- for(string key : keySet) -->
		<c:forEach var="key" items="${ keySet }">
		<li>영어단어 [${ key }]의 뜻은 [${ map1[key] }]입니다 </li>
		</c:forEach>
	</ul>
	
</body>
</html>
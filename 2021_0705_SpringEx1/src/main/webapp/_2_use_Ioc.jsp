<%@page import="vo.PersonVo"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//Spring Container정보를 얻어오기 : spring bean이 저장된 저장소 정보를 얻어온다.
	//JSP내장객체: request,response,session,application,out,...
	//			ServletContext application
	WebApplicationContext wc 
		= WebApplicationContextUtils.getWebApplicationContext(application);
	
	//이미 생성된 객체를 사용하기 위한 코드

	//id=p1인 bean정보를 획득
	PersonVo p1 = (PersonVo)wc.getBean("p1");
	
	//id=p2인 bean정보를 획득
	PersonVo p2 = wc.getBean("p2", PersonVo.class);
	
	//id=p3인 scope="prototype": 요청시마다 생성 
	PersonVo p3 = wc.getBean("p3", PersonVo.class);		
	
	//EL사용하려고...
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
	pageContext.setAttribute("p3", p3);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	use-ioc p1's info
<hr>
	이름: ${ p1.name } <br>
	나이: ${ p1.age }<br>
	전화: ${ p1.tel }<br>
	
	<hr>
	use-ioc p2's info
<hr>
	이름: ${ p2.name } <br>
	나이: ${ p2.age }<br>
	전화: ${ p2.tel }<br>

</body>
</html>
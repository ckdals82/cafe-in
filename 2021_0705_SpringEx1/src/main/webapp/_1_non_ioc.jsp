<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//1.객체생성1
	PersonVo p1 = new PersonVo();
	p1.setName("일길동");
	p1.setAge(20);
	p1.setTel("010-111-1234");
	
	//2.객체성성2번째 방법
	PersonVo p2 = new PersonVo("이길동",30,"010-222-1234");
	
	//el사용하기 위해서 scope내에 객체를 저장
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	non-ioc p1's info
<hr>
	이름: ${ p1.name } <br>
	나이: ${ p1.age }<br>
	전화: ${ p1.tel }<br>
	
	<hr>
	non-ioc p2's info
<hr>
	이름: ${ p2.name } <br>
	나이: ${ p2.age }<br>
	전화: ${ p2.tel }<br>
</body>
</html>
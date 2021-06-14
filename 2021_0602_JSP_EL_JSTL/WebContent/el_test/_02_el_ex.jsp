<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    //EL을 사용하려면 각Scope에 저장되어야 한다.
    //String msg= "안녕하세요";
    
    //각공간에 데이터를 저장 // 왜 내장객체라고 부를까? 실행단계에서
    pageContext.setAttribute("msg", "pageContext's message");
    request.setAttribute("msg", "requestScope's message");
    session.setAttribute("msg", "sessionScope's message");
    application.setAttribute("msg", "applicationScope's message");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			  <%-- ${영역이름.변수명 } --%>
pageContext : ${ pageScope.msg } <br>
request		: ${ requestScope.msg } <br>
session		: ${ sessionScope.msg } <br>
application : ${ applicationScope.msg } <br>
</body>
</html>
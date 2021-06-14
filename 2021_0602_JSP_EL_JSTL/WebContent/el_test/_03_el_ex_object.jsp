<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //Java Code
    
    PersonVo p = new PersonVo("홍길동",30,"010-111-1234");
    
    // why? Scope등록했냐? => EL로 표현해보려고
    pageContext.setAttribute("p", p);
    
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	JSP의 표현식:p표현
<hr>
	이름:<%= p.getName() %> <br>
	나이:<%= p.getAge() %><br>
	전화:<%= p.getTel() %><br>
<hr>
	person's info(EL)
<hr>
	이름: ${ pageScope.p.name } <br> <!-- 결과적으로 p.getName() call -->
	나이: ${ p.age }<br> <!-- 결과적으로 p.getAge() call -->

</body>
</html>
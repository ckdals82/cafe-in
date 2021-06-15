<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //JSP내장객체내에 session존재 /request존재
    
    String id = session.getId();
    
    HttpSession session1 = request.getSession();
    String id1 = session1.getId();
    
    session.setMaxInactiveInterval(60);//1분
    
    System.out.printf("id =%s\n", id);
    System.out.printf("id1 =%s\n", id1);
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
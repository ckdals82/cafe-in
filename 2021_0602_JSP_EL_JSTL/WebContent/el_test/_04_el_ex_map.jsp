<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Map map = new HashMap();
    
    	map.put("driver", "orcle.jdbc.driver.OracleDriver");
    	map.put("url"   , "jdbc:oracle:thin:@localhost:1521:xe");
    	map.put("username", "scott");
    	map.put("password", "tiger");
    	
    	//EL사용하려면 데이터를 scope에 등록
    	pageContext.setAttribute("map", map);
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	JSP Scripting(표현식)
<hr>
	Driver:<%= map.get("driver") %> <br>
<hr>
	EL로 표현
<hr>
Driver : ${ requestScope.map.driver } <br>
Url	   : ${ map.url } <br>
Username: ${ map['username'] } <br>
Password: ${ map[ "username"] } <br>

</body>
</html>
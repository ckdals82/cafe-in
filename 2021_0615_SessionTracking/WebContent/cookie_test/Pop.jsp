<%@page import="com.sun.jdi.Value"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //cookie정보 읽어오기
    Cookie [] cookie_array = request.getCookies();
    String visit_content="";
    
    
    if(cookie_array!=null){
    	StringBuffer sb = new StringBuffer("<h3>[최근 방문 페이지]</h3>");	
    	for(Cookie c : cookie_array){
    		String name = c.getName();
    		String value= c.getValue();
    		/* System.out.printf("%s : %s\n" ,name,value); */
    		if(!name.equals("JSESSIONID"))
    		sb.append(String.format("<a href='%s'>%s</a><br>", value, name));
    	}
    	visit_content = sb.toString();
    }
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#disp{
		position: absolute;
		top: 100px;
		right: 100px;
		width: 200px;
		height: 200px;
		background: black;
		color: white;
		padding: 30px;
	
	}
	a{
	text-decoration: none;
	color: green;
	}
</style>
</head>
<body>
	<div id="disp"><%= visit_content %> 여기 방문정보기록
	
	
	</div>
</body>
</html>
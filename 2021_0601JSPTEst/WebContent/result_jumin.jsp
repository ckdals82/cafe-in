<%@page import="util.Jumin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //scriptlet
    //coding 위치 : _jspService(request,response)
    request.setCharacterEncoding("utf-8");
		
		//2.parameter받기
		String jumin_no = request.getParameter("jumin_no");
		
		//3.주민번호 ->부가정보 추출
		Jumin jumin = new Jumin();
		jumin.setJummin_no(jumin_no);
		
		int year 		= jumin.getYear();
		int age 		= jumin.getAge();
		String tti 		= jumin.getTti();
		String gangi 	= jumin.getGanji();
		String season 	= jumin.getSeason();
		String local 	= jumin.getLocal();
		
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border='1' width='400'>
	<tr>
		<th>주민번호 </th>
		<td><%= jumin_no %> </td>
	</tr>
	<tr>
		<th>출생년도 </th>
		<td><%= season %> </td>
	</tr>
	<tr>
		<td colspan ="2" align="center"><a he></a>
	</tr>
	</table>
</body>
</html>
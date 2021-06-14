<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%! //선언부
   int count =0;
   public void sub(){
	   
   }
   Random rand = new Random();
   
   %> 
   
   
   <% //scriptlet
   	  //Java code service()영역내에 삽입
   	  count++;
   
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
안녕하세요 JSP입니다.<br>
<%-- 표현식 : <%=변수 %>
		=>out.print(변수)
		_jspService()메소드내에기록 --%>


<%= count %>번째 방문하셨습니다.

<%	//_jspService(request,response)내에 작성
	//	JSP내장객체: 숨어있
	// : pageContext,request,session,application
	//	out
String ip = request.getRemoteAddr();
%>
[<%=ip %>]님이 접속하셨습니다.

</body>
</html>
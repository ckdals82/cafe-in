<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  JSTL을 사용하려면 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	/*
	JSTL(JSP Stanadard Tag Library)
	: JSTL내에서 참조하는 데이터는 EL표현된 데이터만 사용(상수도 사용)
	1.core		: if forEach
	2.format	: 숫자 날짜 형식
	3.functions : 문자열편집 
	*/
	String [] fruit_array = {"사과","참외","수박","딸기","포도","복숭아"};
	
	
	request.setAttribute("fruit_array", fruit_array);
	
	/*
	for(String fruit : fruit_array){
		System.out.println(fruit);
	}
	
	*/
	List<String> sido_list = new ArrayList();
	sido_list.add("서울");
	sido_list.add("경기");
	sido_list.add("인천");
	sido_list.add("대전");
	sido_list.add("강원");
	
	request.setAttribute("sido_list", sido_list);
	
/* 	for(String sido : sido_list){
		System.out.println();
	} */
	
	//숫자 포맷
	int money = 125600000;
	pageContext.setAttribute("money", money);
	
	//날짜 포맷
	Date today = new Date();//현재 시스템 날짜
	pageContext.setAttribute("today", today);
	
	//			  01234567890123456789012
	String now = "2021-06-02 16:58:30,001";
	pageContext.setAttribute("now", now);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<hr>
Fomatter연습 & Functions기능
<hr>
	내가갖은돈 : <fmt:formatNumber type="currency" value="${ money }" />  <br>
	
	오늘날짜 : <fmt:formatDate pattern="YYYY년 MM월 dd일" value="${ today }"/> <br>
	
	문자열형식의 날짜 : ${ fn:substring(now,0,16) } <br>
	
	<!-- for(int i=1;i<=5;i++) -->
	<c:forEach var="i" begin="1" end="5" step="1">
	
		<!-- 홀수면 red -->
		
		<!-- JSTL내의  EL표현식에서는 공백 조심할것 -->  
	  <c:if test= "${ i%2 == 1 }">
	  <font color='red'>${ i } : 안녕</font> <br>
	  </c:if>
	  
	  <!-- 짝수면 blue -->
	  <c:if test= "${ i%2 == 0 }">
	  <font color='blue'>${ i } : 안녕</font> <br>
	  </c:if>
	</c:forEach>
	
	<hr>
	forEach배열 예제
	<hr>
		<ul>
			<!-- items : 배열,ArrayList,Set등등의 컬렉션 -->
			<!-- for(String fruit : fruit_array) 와 동일함 -->
			<c:forEach var="fruit" items="${ requestScope.fruit_array }">
			<li>${ pageScope.fruit }  </li>
			</c:forEach>
			
		</ul>
		
	<hr>
	forEach ArrayList 예제
	<hr>
		<ul>
			<!-- items : 배열,ArrayList,Set등등의 컬렉션 -->
			<!-- for(String fruit : fruit_array) 와 동일함 -->
			<c:forEach var="city" items="${ requestScope.sido_list }">
			<li>${ pageScope.city }  </li>
			</c:forEach>
			
		</ul>
	
	
</body>
</html>
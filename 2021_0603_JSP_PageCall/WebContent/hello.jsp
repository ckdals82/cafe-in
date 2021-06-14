<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>국가명 : ${ requestScope.nation_name }</h3>

<h4>인사말 : ${ requestScope.greeting_message }</h4>

<a href="input_nation.html">다시하기</a>

</body>
</html>
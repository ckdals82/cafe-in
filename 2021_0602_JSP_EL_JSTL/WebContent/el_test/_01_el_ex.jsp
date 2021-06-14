<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%	
	/*
	EL(Expression :anguage): 표현언어
	1.JSP내에서 사용되는 언어
	2.각영역 + parameter의 데이터만 사용가능함
		scotp :	(pageScope,requestScope,sessionScope,applicationScope)
		parm : xxx.jsp?msg=hi  <=  ${ param.msg }
	
	3.형식)
		$    { 영역이름.변수명   }
		ex) ${ pageScope.msg }
		영역이름(EL내장객체)
		
	4.EL 연산자
		산술연산자: + - * / %
		논리연산자: and or not
		비교연산자: >= > <= < == !=
				  ge: greater equal
				  gt: greater than
				  le: less equal
				  lt: less than
				  eq: equal
				  ne: not equal
				  
		삼항연산자 (조건)? 값1 " 값2
		기타연산자: empty	대상		
	*/
%>



<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	산술연산자
	<hr>
	 \${ 3 + 2 } => ${ 3 + 2 } <br>
	\${ 3 - 2 } => ${ 3 - 2 }<br>
	\${ 3 * 2 } => ${ 3 * 2 }<br>
	\${ 3 / 2 } => ${ 3 / 2 }<br>
	\${ 3 % 2 } => ${ 3 % 2 } or ${ 3 mod 2 } <br>
	
	<hr>
		비교연산자
	<hr>
	\${ 3>=2 } or \${ 3 ge 2 } => ${ 3 >= 2 } or ${ 3 ge 2 } <br>
	\${ 3>2 } or \${ 3 gt 2 } => ${ 3 > 2 } or ${ 3 gt 2 } <br>
	
	\${ 3<=2 } or \${ 3 le 2 } => ${ 3 <= 2 } or ${ 3 le 2 } <br>
	\${ 3<2 } or \${ 3 lt 2 } => ${ 3 < 2 } or ${ 3 lt 2 } <br>
	
	\${ 3==2 } or \${ 3 ep 2 } => ${ 3 == 2 } or ${ 3 eq 2 } <br>
	\${ 3!=2 } or \${ 3 ne 2 } => ${ 3 != 2 } or ${ 3 ne 2 } <br>
	
	<hr>
	논리연산자
	<hr>
	\${ true and ture } => ${ true and true } or ${true && true } <br>
	\${ true and false } => ${ true and false } or ${true && false } <br>
	\${ not true } => ${ not true } or ${ ! true } <br>
	
	<hr>
	삼항연산자
	<hr>
	파라메터로 전달된 메시지: ${ empty param.msg ? 'No Message' : param.msg }
</body>
</html>
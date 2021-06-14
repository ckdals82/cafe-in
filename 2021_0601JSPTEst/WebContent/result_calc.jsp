<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%//자바코드작성
request.setCharacterEncoding("utf-8");

//2.parameter구하기		/
String str_su1 = request.getParameter("su1"); 
String str_su2 = request.getParameter("su2");



//정수로 변환
 int su1 = Integer.parseInt(str_su1); 
 //System.out.println(name);
 int su2 = Integer.parseInt(str_su2);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#box{
	width: 400px;
	margin: auto;
	margin-top: 20px;
}
</style>

</head>
<body>
	<div id="box">
	<table class="table table-striped">
		<tr>
			<th>더하기</th>
			<td><%= su1 %> +<%= su2 %> = <%= (su1 + su2)%> </td>
		</tr>
		
		
			<td><a href='input_calc.html'>다시하기</a></td>
	</table>
	</div>
     <%--  <tr>
		<th>주민번호 </th>
		<td><%= "%d + %d = %d<br>", su1,su2,(su1+su2) %> </td>
	</tr>
      <%="%d + %d = %d<br>", su1,su2,(su1+su2)%>
      <%="%d - %d = %d<br>", su1,su2,(su1-su2)%>
      <%="%d * %d = %d<br>", su1,su2,(su1*su2)%>
      <tr><td colspan='2' align='center'><a href='input_calc.html'>다시하기</a></td></tr>
      
  --%>
      
</body>
</html>
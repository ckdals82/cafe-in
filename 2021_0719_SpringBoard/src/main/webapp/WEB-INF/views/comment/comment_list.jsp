<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- for(CommentVo comment_vo : list) -->
<c:forEach var="comment_vo" items="${ list }" >
	<hr>
	<div style="border: 1px solid #dddddd;">
	<c:if test="${ user.m_idx eq comment_vo.m_idx }">
	<div style="text-align: right;"> 
		<input style="width: 20px;" type="button" value="x">
    </div>
    </c:if>
    
	<div> ${ comment_vo.m_name }님 작성글: </div>
	<div>작성일자: ${ fn:substring( comment_vo.c_regdate,0,16 ) }</div>
	<div style="min-height: 50px; border: 1px solid #eeeeee; box-shadow: 1px 1px 1px #cccccc;" > ${ comment_vo.c_content } </div>
</div>	
</c:forEach>	
</body>
</html>
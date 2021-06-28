<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script type="text/javascript">
		function add_cart(){
			
			//로그인 여부 체크
			if('${ empty user}'=='true'){
				//로그인이 안된상태
		   		 Swal.fire({
					  title: '로그인',
					  html: "장바구니담기는 로그인이 필요합니다.<br> 로그인하세요!",
					  icon: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  confirmButtonText: 'Yes, delete it!',
					  cancelButtonText: '아니오'
					}).then((result) => {
					  if (result.isConfirmed) {
					    	location.href='../member/login_form.do'
					    
					  }
					});
				
				
			}else{
				//로그인이 된상태
				//장바구니 담기
				location.href='cart_insert.do?p_idx=${ vo.p_idx }&m_idx=${ user.m_idx}' ;
			}
		}
		
	</script>
	
</head>
<body>

<jsp:include page="index.jsp"/>

<table align="center" width="600" border="1"
 style="border-collapse:collapse;font-size:8pt"
 bordercolor="navy" cellpadding="4" cellspacing="0">
		<tr>
			<td width="40%">제품분류</td>
			<td width="60%">${ vo.p_category }</td>
		</tr>
		<tr>
			<td width="40%">제품번호</td>
			<td width="60%">${ vo.p_num }</td>
		</tr>
		<tr>
			<td width="40%">제품명</td>
			<td width="60%">${ vo.p_name }</td>
		</tr>
		<tr>
			<td width="40%">제조사</td>
			<td width="60%">${ vo.p_company }</td>
		</tr>
		<tr>
			<td width="40%">제품가격</td>
			<td width="60%">
				<fmt:formatNumber value="${ vo.p_price }"/>원
				(할인가:<fmt:formatNumber value="${ vo.p_saleprice }"/>)
			</td>
		</tr>
		<tr>
			<td colspan="2">제품설명</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
		<img src="../images/${ vo.p_image_l }">
			</td>
		</tr>
		<tr>
			<td colspan="2">${ vo.p_content }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="장바구니에 담기" 
									 onclick="add_cart();"/>
				<!-- 로그인 상태에서만 -->
				<c:if test="${ not empty user }">
				<input type="button" 	value="장바구니 보기" 
										onclick="location.href='cart_list.do'"/>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>
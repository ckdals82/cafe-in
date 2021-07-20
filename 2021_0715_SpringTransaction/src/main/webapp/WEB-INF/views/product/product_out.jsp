<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

   $(document).ready(function() {
      
      $("#ck_idx_all_out").change(function() {
         var checked = ($(this).is(":checked"))
         //alert(checked);
         
         //아래쪽 체크박스 모두를 checkd
         $("input.check_out").prop("checked",checked);
      });
      
      //아래쪽 체크박스 이벤트
      $("input.check_out").change(function() {
         
         //아래 체크박스 모두 검사
         $("#ck_idx_all_out").prop("checked", true);
         
         $("input.check_out").each(function(){
            
            if( $(this).is(":checked")==false ){
               $("#ck_idx_all_out").prop("checked", false);
               
            }

         }); //반복문
         
      });
      
   });

   function in_out(f) {
      
      //alert( $("input[name='idx']:checked").length);
      //삭제할 상품 선택여부
      if( $("input.check_out:checked").length==0 ){
         alert('삭제할 상품을 선택하세요');
         return;
      }
      
      f.action = "delete_out.do";
      f.submit();
   }

</script>


</head>
<body>
	<form>
	<div>
      <input type="checkbox" id="ck_idx_all_out">전체
      <input type="button" value="삭제" onclick="out_del(this.form);">
   </div>

<table>
	<caption>::::출고목록::::</caption>
	<tr>
		<th width="40%">제품명</th>
		<th width="20%">수량</th>
		<th width="40%">출고일자</th>
	</tr>
	
	<c:if test="${ empty map.out_list }">
		<td colspan="3" align="center">
		   출고목록이 없습니다
		</td>
	</c:if>
	
	
	<c:forEach var="vo" items="${ map.out_list }">
		
		<tr>
			<td><input  class="check_out" type="checkbox" name="idx" value="${ vo.idx }">&nbsp;&nbsp;${ vo.name }</td>
			<td>${ vo.name }</td>
			<td>${ vo.cnt }</td>
			<td>${ vo.regdate }</td>
		</tr>
	</c:forEach>
	
</table>
</form>

</body>
</html>
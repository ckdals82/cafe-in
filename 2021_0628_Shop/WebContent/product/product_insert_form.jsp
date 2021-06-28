<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<script type="text/javascript">

var regular_number =/^[0-9]+$/

function send(f)
{
   var p_category = f.p_category.value;
   var p_num = f.p_num.value;
   var p_name = f.p_name.value;
   var p_company = f.p_company.value;
   
   //얘 둘은 숫자만 입력하도록
   var p_price = f.p_price.value;
   var p_saleprice = f.p_saleprice.value;
   
   
   var p_content = f.p_content.value;   
   var photo_s = f.photo_s.value;
   var photo_l = f.photo_l.value;
   
   if(p_category=="")
   {
      Swal.fire({
         icon: 'error',
         title: '카테고리',
         text: '카테고리를 선택하세요!',
        
       })
      return;
   }
   if(p_num=="")
   {
      Swal.fire({
         icon: 'error',
         title: '제품번호',
         text: '제품번호를 입력하세요!',
         confirmButtonText: '확인',
         returnFocus: false
       }).then((result) => {
         if(result.isConfirmed){
            f.p_num.value='';
            f.p_num.focus();
         }
       });
     
      return;
   }
   if(p_name=="")
   {
      Swal.fire({
         icon: 'error',
         title: '제품명',
         text: '제품명을 입력하세요!',
         confirmButtonText: '확인',
         returnFocus: false
       }).then((result) => {
         if(result.isConfirmed){
            f.p_name.value='';
            f.p_name.focus();
         }
       });
      return;
   }
   if(p_company=="")
   {
      Swal.fire({
         icon: 'error',
         title: '제품판매사',
         text: '제품판매사를 입력하세요!',
         confirmButtonText: '확인',
         returnFocus: false
       }).then((result) => {
         if(result.isConfirmed){
            f.p_company.value='';
            f.p_company.focus();
         }
       });
      return;
   }
   if(regular_number.test(p_price)==false)
   {
      Swal.fire({
         icon: 'error',
         title: '제품가격',
         text: '제품가격을 입력하세요!',
         confirmButtonText: '확인',
         returnFocus: false
       }).then((result) => {
         if(result.isConfirmed){
            f.p_price.value='';
            f.p_price.focus();
         }
       });
      return;
   }
   if(regular_number.test(p_saleprice)==false)
   {
      Swal.fire({
         icon: 'error',
         title: '제품할인가격',
         text: '제품할인가격을 입력하세요!',
         confirmButtonText: '확인',
         returnFocus: false
       }).then((result) => {
         if(result.isConfirmed){
            f.p_saleprice.value='';
            f.p_saleprice.focus();
         }
       });
   }
   if(p_content=="")
   {
      Swal.fire({
         icon: 'error',
         title: '제품설명',
         text: '제품설명을 입력하세요!',
         confirmButtonText: '확인',
         returnFocus: false
       }).then((result) => {
         if(result.isConfirmed){
            f.p_content.value='';
            f.p_content.focus();
         }
       });
      return;
   }
   if(photo_s=="")
   {
      Swal.fire({
         icon: 'error',
         title: '작은이미지',
         text: '작은이미지를 선택하세요!',
       })
      return;
   }
   if(photo_l=="")
   {
      Swal.fire({
         icon: 'error',
         title: '큰이미지',
         text: '큰이미지를 선택하세요!',
       })
      return;
   }
   
   f.submit();
   
}
</script>
</head>
<body>

<!-- title -->
<jsp:include page="index.jsp"/>
<form method="post" action="insert.do" enctype="multipart/form-data"> 
<table align="center" width="600" border="1" 
    style="border-collapse:collapse;font-size:8pt" bordercolor="navy"
    cellpadding="2" cellspacing="0">
    <tr>
        <td>제품Category</td>
        <td><select name="p_category">
              <option value="">카테고리 선택</option>
              <option value="com001">컴퓨터</option>
              <option value="ele002">가전제품</option>
              <option value="sp003">스포츠</option>
        </select></td>
    </tr>
    <tr>
        <td>제품번호</td>
        <td><input name="p_num" type="text" ></td>
    </tr>
    <tr>
        <td>제품이름</td>
        <td><input name="p_name" type="text" ></td>
    </tr>
    <tr>
        <td>제품 판매사</td>
        <td><input name="p_company" type="text" ></td>
    </tr>
    <tr>
        <td>제품가격</td>
        <td><input name="p_price" type="text" ></td>
    </tr>
    <tr>
        <td>제품할인가격</td>
        <td><input name="p_saleprice" type="text" ></td>
    </tr>    
    <tr>
        <td>제품설명</td>
        <td><TEXTAREA name="p_content" rows="5" cols="50"></TEXTAREA></td>
    </tr>
    <tr>
        <td>제품사진(작은사진)</td>
        <td><input type="file" name="photo_s">
    </tr>
    <tr>
        <td>제품사진(큰사진)</td>
        <td><input type="file" name="photo_l">
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="등록" onclick="send(this.form);" >
            <input type="reset" value="Clear" >
        </td>
    </tr>    
</table>
</form>
</body>
</html>
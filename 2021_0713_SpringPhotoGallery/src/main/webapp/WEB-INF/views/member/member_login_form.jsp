<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--bootstrap  -->
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>

<style type="text/css">
   #box{
      width: 400px;
      margin: auto;
      margin-top: 100px;
      
   }
   
   input[type='button']{
      width: 100px;
   }
</style>

<script type="text/javascript">
   
   $(document).ready(function(){
      
      setTimeout(show_message,100); // 0.1초후에 show_message 함수 호출
                             // 이걸안하고 바로 실행시키면 그냥 아이디가 틀립니다 alert만 뜨고 뒤에 form이 안나온다.
      
   });
   
   function show_message(){
      // parameter로 들어온게 fail_id이면(MemberLoginAction에서 if문보기)
      if("${param.reason eq 'fail_id'}"=="true"){ //위에 $(document)는 jquery 지금 if문의 $는 EL true를 따옴표준이유는 jquery인지 EL인지 구분하려고
         
         alert('아이디가 틀립니다');
      }
      
      if("${param.reason eq 'fail_pwd'}"=="true"){ 
         
         alert('비밀번호가 틀립니다');
   }

}

   function send(f) {
      var m_id = f.m_id.value.trim();
      var m_pwd = f.m_pwd.value.trim();
      
      if(m_id==''){
         alert('아이디를 입력하세요')
         f.m_id.value='';
         f.m_id.focus();
         return;
      }
      
      if(m_pwd==''){
         alert('비밀번호를 입력하세요')
         f.m_pwd.value='';
         f.m_pwd.focus();
         return;
      }
      
            
      f.action = "login.do"; // MemberLoginAction
      f.submit(); // 전송
      
   }
</script>

</head>
<body>
   
   <div id="box">
      <form>
         
         <div class="panel panel-primary">
            <div class="panel-heading">로그인</div>
            <div class="panel-body">
               <table class="table">
                 <tr>
                     <th>아이디</th>
                     <td><input name="m_id"></td>
                 </tr>
                 <tr>
                     <th>비밀번호</th>
                     <td><input type="password" name="m_pwd"></td>
                 </tr>
                 <tr>
                     <td colspan="2" align="center">
                         <input class="btn btn-primary" type="button" value="로그인" onclick="send(this.form);">
                         <input class="btn btn-success" type="button" value="메인화면" onclick="location.href='${ pageContext.request.contextPath }/photo/list.do'">
                         <input class="btn btn-info"    type="button" value="회원가입" onclick="location.href='insert_form.do'">
                     
                     </td>
                 </tr>
                </table>
            </div>
         </div>
      </form>
   </div>
   
</body>
</html>
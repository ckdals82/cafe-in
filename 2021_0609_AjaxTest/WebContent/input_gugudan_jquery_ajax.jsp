<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
   #disp{
      width: 200px;
      height: 300px;
      padding: 20px;
      background: black;
      color: white;
   }
</style>

<!-- jquery 라이브러리 연결  라이브러리 연결안에는 코드 작성하면 안됨-->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script> 

<script type="text/javascript">
   var regular_gugudan = /^[2-9]{1}$/;
   
   //jQuery 초기화
   $(document).ready(function(){
      //결과 보기 버튼이 눌리면 함수호출
      $("#btn_result").click(function(){
         
         var dan = $("#dan").val().trim();
         if(regular_gugudan.test(dan)==false){
            alert('2~9사이의 숫자만 입력하세요');
            $("#dan").val('');
            $("#dan").focus();
            return;
         }   
         
         // 요청 : gugudan.do?dan=5&dan1=5&dan2=5
         //jQuery Ajax
         //$.ajax(연결옵션); <= 연결옵션 타입: JSON형태
         // $.ajax({key:value,key:value,key:value}); 
         $.ajax({  
            type   :'GET',
            url    :'gugudan.do',
            data   : {'dan':dan},   // param전달형식: JSON
            success : function(result_data){
               //result_data <=서버가 전송해준 결과데이터
               $("#disp").html(result_data);
            }
            
         }); 
         
         
         
      });
      
      
   });
   
</script>


<script type="text/javascript">
   
   var regular_gugudan = /^[2-9]{1}$/;
   function show_result() {
      
      var dan = document.getElementById("dan").value.trim();
      if(regular_gugudan.test(dan)==false){
         alert('2~9사이의 숫자만 입력하세요');
         document.getElementById("dan").value='';
         document.getElementById("dan").focus();
         return;
      }
      
      
      
      //foreground통신(페이지가 바뀐다)
      //location.href="gugudan.do?dan=5";
      
      //서버에게 요청(Background통신기술 : Ajax)
      var url   = "gugudan.do"; // GugudanAction => gugudan.do?dan=5
      var param = "dan=" + dan; // 전달인자 
      
      //Ajax 기능을 쉽게 사용하도록 만들어 놓은 사용자 함수
      sendRequest(url,param,resultFn,"GET");
      
   }
   
   function resultFn() {
      
      console.log("xhr.readyState=" + xhr.readyState + " xhr.status=" + xhr.status)
      
      if(xhr.readyState==4 && xhr.status==200){
         
         //서버로부터 받은 결과 데이터
         var data = xhr.responseText;
         //alert(data);
         
         document.getElementById("disp").innerHTML = data;
         
      }
   }
   
   
   
</script>

</head>
<body>
   단:<input id="dan">
      <input type="button" value="결과보기"  id="btn_result">
   <hr>
   <div id="disp">여기에 결과 출력</div> 
</body>
</html>
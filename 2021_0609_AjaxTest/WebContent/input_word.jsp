<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
   #disp{
      width: 300px;
      height: 100px;
      padding: 20px;
      background: black;
      color: white;
   }
</style>

<!-- jquery 라이브러리 연결  라이브러리 연결안에는 코드 작성하면 안됨-->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script> 

<script type="text/javascript">

	/* //jQuery초기화 */
	$(function(){
		
		//키가 눌렸다 떼어졌을때
		$("#word").keyup(function(){
			
			//Event주체 위에 워드
			var word = $(this).val();
			//document.title = word; 모니터 출력확인용도 탭에 출력된다
			//console.log(word);
			
			$.ajax({
				//요청정보
				type	:'GET',
				url		:'finder.do', //FinderAction
				data	: {'word':word},
				//수신정보
				dataType: 'json',
				success: function(result_data){
				//result_data =	{"word":"html" , "result" :"HyperText Markup Language"}
				$("#disp").html(result_data.result);
					
				},
				error	: function(err){
					alert(err.responseText);
					//console.log(err.responseText)
				}
			});
			
			
		});
		
	});

</script>


</head>
<body>
단어:<input id="word">
<hr>
<div id="disp"></div>

</body>
</html>
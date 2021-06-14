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

	<!-- Javascript사용자 Ajax구현 객체 -->
	<script type="text/javascript" src="js/httpRequest.js"></script>

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
	//location.href = "gugudan.do?dan=5";//foreground 통신 (페이지가 바뀐다)
	
	//서버에게 요청(background통신기술:Ajax)
	var url = "gugudan.do"; //GugudanAction	=> gugudan.do?dan=5
	var param= "dan=" + dan; //전달인자
	//Ajax기능을 쉽게 사용하도록 만들어 놓은 사용자함수
	sendRequest(url, param, resultFn , "GET");
}
function resultFn(){
	
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

단: <input id="dan">
	 <input type="button" value="결과보기" onclick="show_result();">
	 <hr>
	 <div id="disp">여기에 결과 출력</div>
	 
	 
</body>
</html>
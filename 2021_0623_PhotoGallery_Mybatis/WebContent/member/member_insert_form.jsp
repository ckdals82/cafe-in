<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#box{
width: 700px;
margin: auto;
margin-top: 30px;

}
#id_msg{

display: inline-block;
width: 200px;
padding-left: 30px;


}


</style>
<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- daum 주소찾기 라이브러리  -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript">

var regular_id = /^[a-zA-Z0-9]{4,10}$/; //아이디 4자리부터 10자리까지

$(document).ready(function(){
	
	//m_id입력내용이 변경되면
	$("#m_id").keyup(function(event){
	
		var m_id = $(this).val();
		
		//회원가입버튼을 비활성화 시킴
		$("#btn_register").attr('disabled',true);
		
		if(regular_id.test(m_id)==false){
			$("#id_msg").html('영문자숫자조합 4~10자리로 작성하세요');
			$("#id_msg").css('color','red');
			return;
		}
		//Ajax를 이용해서 아이디 중복체크
		$.ajax({
			url  :  'check_id.do', //MemberCheckIdAction
			data : {'m_id' : m_id},
			dataType: 'json',
			success : function(result_data){
				//result_data = {"result" : true} or {'result' : false}
				
				
				
				if(result_data.result){//사용가능
					$("#id_msg").html('사용가능한 아이디 입니다');
					$("#id_msg").css('color','blue');
					
					//회원가입버튼을 비활성화 시킴
					$("#btn_register").attr('disabled',false);
					
				}else{//사용불가 ( 이미 사용중)
					$("#id_msg").html('이미 사용중인 아이디 입니다');
					$("#id_msg").css('color','red');
				}
				
			},
			
			error   : function(err){
				//alert(err.responseText);
				console.log(err.responseText);
			}
			
		});
		
		
		
	});//end keyup
	
	//주소찾기 버튼 클릭시
	$("#btn_find").click(function(){
		
		var width = 500; //팝업의 너비
		var height = 600; //팝업의 높이
		
		 new daum.Postcode({
			 width: width, //생성자에 크기 값을 명시적으로 지정해야 합니다.
			    height: height,
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            //data = {'zonecode' : '12345', 'address','서울시 관악구 시흥대로 552', 'roadAddress','t서울'}
		            $("#m_zipcode").val(data.zonecode);
		            $("#m_addr").val(data.roadAddress);
		        }
		    }).open({
		    		left: (window.screen.width / 2) - (width / 2),
		    	    top: (window.screen.height / 2) - (height / 2)
		    }
		    );
	});//end 찾기버튼 클릭
	
	
	
});// end jQuery초기화

	function send(f){
	
		//입력값 체크
		var m_name = f.m_name.value.trim();
		var m_pwd  = f.m_pwd.value.trim();
		//우편번호/주소 체크
		var m_zipcode  = f.m_zipcode.value.trim();
		var m_addr  = f.m_addr.value.trim();
		
		if(m_name==''){
			alert('이름을 입력하세요');
			f.m_name.value='';
			f.m_name.focus();
			return;
		}
		if(m_pwd==''){
			alert('비밀번호를 입력하세요');
			f.m_pwd.value='';
			f.m_pwd.focus();
			return;
		}
		if(m_zipcode==''){
			alert('우편번호를 입력하세요');
			f.m_zipcode.value='';
			f.m_zipcode.focus();
			return;
		}
		if(m_addr==''){
			alert('주소를 입력하세요');
			f.m_addr.value='';
			f.m_addr.focus();
			return;
		}
		
		
		//
		f.action = "insert.do"; //member InsertAction
		f.submit();//전송
		
}




</script>


</head>
<body>
	<div id="box">
		<form>
		<div class="panel panel-primary">
      		<div class="panel-heading">회원가입</div>
      		<div class="panel-body">
      			<table class="table table-striped">
      				<tr>
      					<th>이름 </th>
      					<td> <input name= "m_name"> </td>
      				</tr>
      				<tr>
      					<th>아이디 </th>
      					<td> <input name= "m_id" id="m_id"><span id="id_msg"></span> </td>
      				</tr>
      				<tr>
      					<th>비밀번호 </th>
      					<td> <input type= "password" name="m_pwd"> </td>
      				</tr>
      				<tr>
      					<th>우편번호 </th>
      					<td>
      					 	<input name= "m_zipcode" id="m_zipcode">
      						<input type= "button" id="btn_find" value="주소찾기">
      					 </td>
      				</tr>	 
      					<tr>
      						<th>주소 </th>
      						<td> <input name= "m_addr" id="m_addr" size="60">  </td>
      					</tr>
      					<tr>
      						<td colspan="2" align="center">
      							<input class="btn btn-primary" type="button" id="btn_register" value="회원가입" 
      								   disabled="disabled" onclick="send(this.form);">
      							
      							<input class="btn btn-success" type="button" value="메인화면"
      												onclick="location.href='../photo/list.do'">
      						</td> 
      					</tr>
      				
      			</table>
      		</div>
    	</div>
		
		
		</form>
		
		
	</div>
</body>
</html>
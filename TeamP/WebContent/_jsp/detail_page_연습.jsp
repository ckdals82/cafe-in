<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jquery -->
<script src="../resource/js/jquery-3.6.0.min.js"></script>

<!-- bootstrap -->
<link href="../resource/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="../resource/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>

<!-- semantic ui -->
<link rel="stylesheet" href="../resource/Semantic-UI-CSS-master/semantic.css">
<script src="../resource/Semantic-UI-CSS-master/semantic.js"></script>

<!-- common -->
<link rel="stylesheet" href="../_css/common.css">
<script src='../_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="../_css/detail_page.css">
<script src='../_js/detail_page.js'></script>

 <script
src="https://kit.fontawesome.com/6478f529f2.js"
      crossorigin="anonymous">
      >
    </script>
    
<!-- daum 주소찾기 라이브러리  -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>    
    
    <script type="text/javascript">
    $(document).ready(function(){   
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
    </script>

</head>
<body>

	<div class="tp_layer">
		<div class="tp_button_layout">
			<%@ include file="top_button.jsp" %>
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_menu_layout">
			<%@ include file="top_menu.jsp" %>
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_main_layout">
			
			<div class="cafe_name"><i class="fas fa-star"></i> 카페명 <i  class="fab fa-hotjar"></i></div>
				<div class="img_cafe_info">
				<div class="cafe_img"></div>

					<table class="cafe_info">
					<thead>
					  <tr class="tg-0lax">
					    <th class="tg-m_img" colspan="2"></th>
					    <th class="tg-0lax"></th>
					  </tr>
					</thead>
					<tbody>
					  <tr class="tb_h">
					    <td class="tg-0lax">카페위치</td>
					    <td class="tg-0lax"></td>
					    <td class="tg-0lax"> 
					    <div class="review_w"> <button onclick="window.open('https://map.kakao.com/link/to/18577297')">길찾기</button>


					    			</div>
					    	</td>
					  </tr>
					  <tr class="tb_h">
					    <td class="tg-0lax">전화번호</td>
					    <td class="tg-0lax"></td>
					    <td class="tg-0lax"></td>
					  </tr>
					  <tr class="tb_h">
					    <td class="tg-0lax">키워드</td>
					    <td class="tg-0lax, cafe_hashT">#조용한분위기 #공부</td>
					    <td class="tg-0lax"></td>
					  </tr>
					  <tr class="tb_h">
					    <td class="tg-0lax">메뉴</td>
					    <td class="tg-0lax"></td>
					    <td class="tg-0lax"></td>
					  </tr>
					  <tr class="tb_h" >
					    <td class="tg-0lax">리뷰</td>
					    <td class="tg-0lax"></td>
					    <td class="tg-0lax"> 
					    		<div class="review_w"> <a class="icon_C_change" href="review_write_page.jsp"> <i  class="fas fa-pen fa-2x" class="cafe_icon" ></i></a>
					    			<span>길찾기</span> </div>
					    	</td>
					  </tr>
					</tbody>
					</table>
			</div>
		</div>
	</div>
	
	<div class="tp_layer">
		<div class="tp_bottom_layout">
			<%@ include file="bottom.jsp" %>
		</div>
	</div>

</body>
</html>
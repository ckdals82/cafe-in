function filter_view() {
		
		//브라우저 크기구하기
		var w = $(window).width();
		var h = $(window).height();
		
		//팝업창의 중앙위치 구하기
		var pop_left = (w / 2) - (400/2);
		var pop_top = (h / 2) - (500/2);
		
		//    Map방식
		$("#photo_popup").css({left:pop_left, top:pop_top});
		$("#photo_popup").show();
		
		//p_idx에 해당되는 데이터 1건을 ajax로 요청
		$.ajax({
			url		 : 'photo_one.do', 	//PhotoOneAction
			data	 : {'p_idx':p_idx},	//parameter
			datatype : 'json', 			//수신data타입
			success  : function(result_data){
				//정상수신되었을 경우
				// result_data = {"p_idx":"1","p_title":"1번째 사진",....}
				//alert(result_data.p_title);
				$('#pop_title').html(result_data.p_title);
				$("#pop_image").attr('src','../resources/upload/' + result_data.p_filename);
				$('#pop_content').html(result_data.p_content);
				$('#pop_regdate').html(result_data.p_modifydate.substring(0,16));
				
				//download할 파일이름
				filename = result_data.p_filename;
				//삭제 또는 수정ehlf p_idx
				global_p_idx = p_idx;
				
				//수정/삭제버튼 사용유무 결정
				if( ("${ user.m_idx }"==result_data.m_idx) || ("${ user.m_grade eq '관리자'}"=="true") ){
					//보여줘라
					$("#pop_btn_del").show();
					$("#pop_btn_modify").show();
				} else{
					//숨겨라
					//alert('hide');
					$("#pop_btn_del").hide();
					$("#pop_btn_modify").hide();
				}

			},
			error    : function(err){
				alert(err.responseText);
			}
		});
		
	} 
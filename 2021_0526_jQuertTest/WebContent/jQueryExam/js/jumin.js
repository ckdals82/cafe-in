/**
 * 
 */

/*클래스설계*/

//      클래스명
function Jumin(jumin_no)
{
	//Member Field(변수)
	this.jumin_no = jumin_no;
	//Member Function(함수)
	this.getYear = function(){
		
		var str_year = this.jumin_no.substring(0,0+2);
		var year     = parseInt(str_year);// 90
		var gender   = this.jumin_no.substring(7,7+1);
		if(gender=='1' || gender=='2' || gender=='5' ||gender=='6')
			  year += 1900;
		else 
			  year += 2000;
		
		return year;
	}
	
	this.getAge = function(){
		
		var today = new Date();//현재시스템날짜
		var current_year = today.getFullYear();//
		var age = current_year - this.getYear() + 1;
		return age;
	}
	
	this.getTti = function(){
		
		var tti_array = ['원숭이','닭','개','돼지','쥐','소','호랑이','토끼','용','뱀','말','양'];
		var tti_index = this.getYear()%12;
		
		return tti_array[tti_index];
	}
	
	this.getGender = function(){
		
		var gender = this.jumin_no.substring(7,8);
		if(gender=='1' || gender=='3' || 
		   gender=='5' || gender=='7')
		   return "남자";
		
		return "여자";
	}
	
	
	this.getLocal = function(){
		
		var local_code = parseInt(this.jumin_no.substring(8,10));
		
		if(local_code>=0 && local_code<=8) return "서울";
		else if(local_code>=9 && local_code<=12) return "부산";
		else if(local_code>=13 && local_code<=15) return "인천";
		else if(local_code>=16 && local_code<=25) return "경기도";
		else if(local_code>=26 && local_code<=34) return "강원도";
		else if(local_code>=35 && local_code<=39) return "충청북도";
		else if(local_code==40) return "대전";
		else if(local_code>=41 && local_code<=47) return "충청남도";
		else if(local_code==44 || local_code==49) return "세종시";
		else if(local_code>=48 && local_code<=54) return "전라북도";
		else if(local_code>=55 && local_code<=56) return "광주";
		else if(local_code>=57 && local_code<=64) return "전라남도";
		else if(local_code>=70 && local_code<=75
				|| local_code>=77 && local_code<=81
		          ) return "경상북도";
		else if(local_code>=82 && local_code<=84
				|| local_code>=86 && local_code<=92
		          ) return "경상북도";
		else if(local_code==85) return "울산";
		else if(local_code>=93 && local_code<=95) return "경상북도";
		
		return "기타";
	}
}


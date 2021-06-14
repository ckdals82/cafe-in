/**
 * 현재 클래스 설계
 */
class Jumin{
	constructor(jumin_no){
		this._jumin_no = jumin_no;
	}
	set jumin_no(jumin_no){
		this._jumin_no = jumin_no;
	}
	get jumin_no(){
		return this._jumin_no;
	}
	//				   01234567890123
	//this._jumin_no = 801212-1234560
	/*		내국인		외국인
			남  여		남  여
	1900	1	 2		5	 6
	2000	3	 4		7	 8
	1800	9	 0		
	*/
	
	
	
	//일반멤버함수
	getYear(){
		
		var str_year = this._jumin_no.substring(0,2);
		var gender = parseInt(this._jumin_no.charAt(7));
		var year = parseInt(str_year);
		
		if(gender==1 || gender==2 || gender==5 || gender==6)
			year += 1900;
		else if(gender==3 || gender==4 || gender==7 || gender==8)	
			year +=2000;
		else
			year += 1800;	
		return year;
		}
		getAge(){
			
		//자바스크립트에서 날짜 구하기
		var today = new Date();//현재시스템날짜 구하기
		var curr_year = today.getFullYear();
		
		return curr_year - this.getYear()+1;
		}
		
				//4 5 6 7 8 9 0 1 2 3	<=year%10
		//10간 : 갑을병정무기경신임계
		//		 4 6 7 8 9 1011 0 1 2 3 4  <=year%12	
		//12지 : 자축인묘진사오미신유술해
		
		getTti(){
			var tti_index = this.getYear()%12;//0~11
			var tti_array = ['원숭이','닭','개','돼지','쥐','소','호랑이','토끼','용','뱀','말','양']
		return tti_array[tti_index];
		}
		
		getSeason(){
			var month = parseInt(this._jumin_no.substring(2,2+2));
			
			switch(Math.floor(month/3))
			{
				case 1 : return "봄";  // 3 4 5
				case 2 : return "여름";// 6 7 8
				case 3 : return "가을";// 9 10 11
			}
		return "계절";
		}
		getLocal(){
		return "서울";
		}				
		getGanji(){		//	0 1 2 3 4 5 6 7 8 9
			var gan_list = "경신임계갑을병정무기";
			//				0 1 2 3 4 5 6 7 8 9 10 11
			var ji_list =  "신유술해자축인묘진사오미"
			
			var gan = gan_list.charAt(this.getYear()%10);
			var ji  = ji_list.charAt(this.getYear()%12);
		return gan + ji + "년"
		}	
		getLocal(){
		var local_code = parseInt(this._jumin_no.substring(8,10));
		
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
		
		return "서울";				
		}	
}
//var jumin = new Jumin('901212-1234567');
//	
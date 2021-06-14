package util;

import java.util.Calendar;

public class Jumin {

	
	private String jumin_no;
	
	

	public void setJummin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}
	
	//              01234567890123   <=index
	//  jumin_no = "801212-1234560";
	
	/*
	      char gender = jumin_no.charAt(7); 
	       
	               국내인     외국인
	               남  여     남  여
	     1900      1   2      5   6  
	     2000      3   4      7   8
	     1800      9   0
	 */
	
	public int getYear() {
		
		//주민번호로 부터 2자리년도(문자열) 추출
		String strYear = this.jumin_no.substring( 0 , 0 + 2 ); // "80"
		//문자열->정수변환
		int year = Integer.parseInt(strYear);// "80" => 80
		
		//성별정보 얻어온다
		char gender = this.jumin_no.charAt(7);
		
		if(gender=='1' || gender=='2' || gender=='5' || gender=='6')
			year = year + 1900;
		else if(gender=='3' || gender=='4' || gender=='7' || gender=='8')
			year = year + 2000;
		else
			year = year + 1800;
				
		return year;
	}
	
	public int getAge() {
		
		//  int 나이 = 올해년도 - 출생년도 + 1
		//  올해년도 구하기
		Calendar c = Calendar.getInstance();
		int current_year = c.get(Calendar.YEAR);
		
		int age = current_year  - this.getYear() + 1;
		
		return age;
	}
	
	
	//  					 0       1    2     3     4    5      6       7     8    9    10   11   
	String [] tti_array = {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};

	public String getTti() {
		//배열활용
		
		//출생년도구하기
		int year = this.getYear();
		int tti_index = year%12;//띠 index
		
		return tti_array[tti_index];// return tti_array[getYear()%12];
	}
	
	
    //       4  5  6  7  8  9  0  1  2  3       <=출생년도%10
	//10간 : 갑 을 병 정 무 기 경 신 임 계
	//       4  5  6  7  8  9  10 11 0  1  2  3 <=출생년도%12
	//12지 : 자 축 인 묘 진 사 오 미 신 유 술 해
	
	public String getGanji() {
		
		//출생년도구하기
		int year = this.getYear();
		
		//String : charAt(index)활용
		
		//                 0 1 2 3 4 5 6 7 8 9
		String gan_list = "경신임계갑을병정무기";
		
		//                 0 1 2 3 4 5 6 7 8 9 10 11
		String ji_list  = "신유술해자축인묘진사오미";
		
		// 0 : '경'  1 : '신'
		char gan = gan_list.charAt(year%10); 
		char ji  = ji_list.charAt(year%12);
		
		
		return String.format("%c%c년", gan,ji);
	}
	
	
	public String getGender() {
		
		//성별정보 얻어온다
		char gender = this.jumin_no.charAt(7);
		//방법1
		//if(gender=='1' || gender=='3' || gender=='5' || gender=='7' || gender=='9')
		//	return "남자";
		
		//방법2
		// '1'-'0' => 1
		// 49 - 48 => 1
		if( (gender-'0')%2==1 ) //홀수면 남자
			return "남자";
		

		return "여자";
	}
	
	
	public String getSeason() {
		String strMonth = this.jumin_no.substring(2, 2+2);
		int    month    = Integer.parseInt(strMonth);//"12"->12
		
		//방법1
		/*
		switch(month)
		{
		   case 3:
		   case 4:
		   case 5: return "봄";
		   case 6:
		   case 7:
		   case 8: return "여름";
		   case 9:
		   case 10:
		   case 11: return "가을";
		}
		*/
		
		//방법2
		switch(month/3)
		{
		   case 1: return "봄";
		   case 2: return "여름";
		   case 3: return "가을";
		}
		
		return "겨울";
		
	}
	
//              01234567890123   <=index
//  jumin_no = "801212-1234560";
	
	public String getLocal() {
		
		//지역코드
		String strLocal = this.jumin_no.substring(8, 8+2);
		int    local    = Integer.parseInt(strLocal); //"23" => 23
		
		if(local>=0 && local<=8)  return "서울";
		else if(local>=9 && local<=12)  return "부산";
		else if(local>=13 && local<=15) return "인천";
		else if(local>=16 && local<=25) return "경기도";
		else if(local>=26 && local<=34) return "강원도";
		else if(local>=35 && local<=39) return "충청북도";
		else if(local==40) return "대전";
		else if(local==44 || local==49) return "세종시";
		else if(local>=41 && local<=47) return "충청남도";
		else if(local>=48 && local<=54) return "전라북도";
		else if(local==55 || local==56) return "광주";
		else if(local>=57 && local<=66) return "전라남도";
		else if(local>=67 && local<=69 || local==76) return "대구";
		
		else if(local>=70 && local<=81) return "경상북도";
		else if(local==85) return "울산광역시";
		else if(local>=82 && local<=92) return "경상남도";
		else if(local>=93 && local<=95) return "제주특별시";
		
		return "기타";
	}
	
//              01234567890123   <=index
//  jumin_no = "801212-1234560";
//              2345670892345    	
	
	public boolean isValid() {
		
		int sum = 0;
		
		//방법1
		/*
		sum = sum + (jumin_no.charAt(0)-'0')  * 2;
		sum = sum + (jumin_no.charAt(1)-'0')  * 3;
		sum = sum + (jumin_no.charAt(2)-'0')  * 4;
		sum = sum + (jumin_no.charAt(3)-'0')  * 5;
		sum = sum + (jumin_no.charAt(4)-'0')  * 6;
		sum = sum + (jumin_no.charAt(5)-'0')  * 7;
		sum = sum + (jumin_no.charAt(7)-'0')  * 8;
		sum = sum + (jumin_no.charAt(8)-'0')  * 9;
		sum = sum + (jumin_no.charAt(9)-'0')  * 2;
		sum = sum + (jumin_no.charAt(10)-'0') * 3;
		sum = sum + (jumin_no.charAt(11)-'0') * 4;
		sum = sum + (jumin_no.charAt(12)-'0') * 5;
        */
		
		
		//방법2
		/*
		int su = 2;
		for(int i=0;i<=12;i++) {  //i = 0 1 2 3 ... 12
			if(i==6)continue;
			sum = sum + (jumin_no.charAt(i)-'0')  * su;
			su++;
			if(su>9) su = 2;
		}
		*/
		
		//방법3
		int [] su_array = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		for(int i=0;i<=12;i++) {  //i = 0 1 2 3 ... 12
			sum = sum + (jumin_no.charAt(i)-'0')  * su_array[i];
		}
		//               (45-48)*0
		
		
		
		
		int check_su = sum % 11;
		check_su = 11 - check_su;
		check_su = check_su%10;
		
		System.out.println(check_su);
		
		//주민번호의 마지막수
		int last_su = jumin_no.charAt(13)-'0';
		
		return (check_su == last_su);
	}
	
	
	
	
	
	
	
	
	
	
	
}

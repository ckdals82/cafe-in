/**
 * 이전에 클래스 설계
 */		//	class
function Jumin_old(jumin_no){
	//멤버변수
	this.jumin_no = jumin_no;
	//setter
	this.setJumin_no = function(jumin_no){
		this.jumin_no = jumin_no;
	}
	//getter
	this.getJumin_no = function(){
		return this.jumin_no;
	}
	//일반멤버함수
	this.getYear = function(){
		return 0;
	}
	
}


//var jumin = new Jumin

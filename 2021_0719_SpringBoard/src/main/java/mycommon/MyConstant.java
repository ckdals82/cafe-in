package mycommon;

//           pascal표기법   : MyConstant  <= class명
//           camel표기법    : int myMoney <= 변수/메소드명
//           snake표기법    : int my_money<= 변수/메소드명
//           헝가리언표기법 : booean bOk   int  nNumber

public class MyConstant {

	//게시판 상수
	public static class Board{
		
		public static final int BLOCK_LIST  = 5; //1화면당 보여질 목록수
		public static final int BLOCK_PAGE  = 3; //1화면당 보여질 페이지수
	}
	
	//공지사항 상수
	public static class Notice{
		
		public static final int BLOCK_LIST  = 5; //1화면당 보여질 목록수
		public static final int BLOCK_PAGE  = 5; //1화면당 보여질 페이지수
	}
	
	
}

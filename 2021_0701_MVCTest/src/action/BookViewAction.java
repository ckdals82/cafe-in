package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookViewAction {
	
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.parameter받기
		String book = request.getParameter("book");
		
		//System.out.println("view:" + book);
		String book_content="";
		
		if(book.equalsIgnoreCase("JAVA")) {
			book_content= "자바는 제임스 고슬링";
		}else if(book.equalsIgnoreCase("Oracle")) {
			book_content= "DBMS중에서 가장 성능이 우수한 데이터베이스프로그램입니다";
		}else if(book.equalsIgnoreCase("Html")) {
			book_content= "html이다";
		}else if(book.equalsIgnoreCase("javascript")) {
			book_content= "자바스크립트다";
		}else if(book.equalsIgnoreCase("Jsp")) {
			book_content= "줴이에씈";
		}
		
		request.setAttribute("book", book);
		request.setAttribute("book_content", book_content);
		
		return "book_view.jsp";
	}
}

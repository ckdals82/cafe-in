package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import annotation.RequestMapping;

public class BookController {
	
	public BookController() {
		// TODO Auto-generated constructor stub
		System.out.println("--bookcontroller()");
	}
	
	@RequestMapping("/book/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		
		//가상 데이터 생성
				List<String> book_list = new ArrayList<String>();
				book_list.add("Java");
				book_list.add("Oracle");
				book_list.add("Html");
				book_list.add("Javascript");
				book_list.add("jsp");
				
				//request binding
				request.setAttribute("book_list", book_list);
				
				
		
		return "book_list.jsp";
	}
	
	@RequestMapping("/book/view.do")
	public String view(HttpServletRequest request,HttpServletResponse response) {
		
	
				
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

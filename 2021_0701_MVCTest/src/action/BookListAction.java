package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//POJO(plain old java Object) : 순수자바객체
public class BookListAction {
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		//가상 데이터 생성
		List<String> book_list = new ArrayList<String>();
		book_list.add("Java");
		book_list.add("Oracle");
		book_list.add("Html");
		book_list.add("Javascript");
		book_list.add("jsp");
		
		//request binding
		request.setAttribute("book_list", book_list);
		
		return "book_list.jsp";//FrontController에게 forwad view에 대한 정보
	}
}

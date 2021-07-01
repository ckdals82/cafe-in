package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.BookListAction;
import action.BookViewAction;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		String param = config.getInitParameter("action");
		String [] action_array = param.split(",");
		for(String action:action_array) {
			System.out.println(action);
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//1.요청분류		
		//요청 URI을 구한다
		String uri = request.getRequestURI();
		//		 012345678901234567890
		// uri = /2021_0701_MVCTest/list.do
//		System.out.println(uri);
		
		int index = uri.lastIndexOf("/");//뒷쪽부터 검색
		//System.out.println(index);
		String cmd = uri.substring(index+1).replaceAll(".do", "");
//		System.out.println(cmd);
//2.작업지시
		String forward_page= "";
		if(cmd.equals("list")) {//전체목록
			
			//작업수행객체 생성
			BookListAction action = new BookListAction();
			forward_page = action.execute(request, response);
			
			
		}else if(cmd.equals("view")) {//상세보기
			
			//작업수행객체 생성
			BookViewAction action = new BookViewAction();
			try {
				forward_page = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		//3.뷰선택
		if(!forward_page.isEmpty()) {
		
			RequestDispatcher disp = request.getRequestDispatcher(forward_page);
			disp.forward(request, response);
		}
		
	}

}

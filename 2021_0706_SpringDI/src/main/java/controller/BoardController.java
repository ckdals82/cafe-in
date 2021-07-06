package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;
@Controller
public class BoardController {
	
	BoardService service;
	
	//setter injection
	public void setService(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping("/board/list.do")
	public String list(HttpServletRequest request) {
		
		List list = service.selectList();
		
		//request binding//스프링 mvc는 이렇게 안함.
		request.setAttribute("list", list);
		
		return "board_list";//포워딩할뷰 /WEB-INF/views/board_list.jsp
	}
	
}

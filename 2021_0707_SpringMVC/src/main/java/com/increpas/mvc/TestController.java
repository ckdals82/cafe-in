package com.increpas.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	public TestController() {
		// TODO Auto-generated constructor stub
		System.out.println("-TestController()-");
	}
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		
		String msg = "안녕 점심 처먹어라 10새야";
		
		//model통해서 해당 데이터(msg)를 dispatcherServlet에게 전달
		//2.DispatcherServlet은 전달받는 데이터를 request binding
		model.addAttribute("msg",msg);
		
		
		
		//DispatcherServlet에게 뷰정보(test)전달
		//DispatherServlet ViewResolver통해서 forward페이지완성
//		/WEB-INF/views/test.jsp로 forward해라 라고 DispatcherServlet에게 전달
		return "test";
	}
	
	@RequestMapping("/test2.co")
	public ModelAndView test2() {
		
		String title = "ModelAndView";
		String msg2 = "ModelAndView에 담은 data";
		
		//Data + view 정보를 담는 객체
		ModelAndView mv = new ModelAndView();
		//1.Data담기 <=결과적으로 dispatcherServlet이 request에 바인딩 시킴
		//			  Key  value
		mv.addObject("title",title);
		mv.addObject("msg2",msg2);
		
		//2.View정보 닫기 viewresolver를 불러내 앞뒤로 붙임
		mv.setViewName("test2");
		
		return mv;
	}
}

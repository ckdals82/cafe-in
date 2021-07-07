package com.increpas.param;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vo.PersonVo;

@Controller
public class TestParameterController {
	
	public TestParameterController() {
		// TODO Auto-generated constructor stub
		
	}
	//입력폼 띄우기
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		
		return "insert_form";
	}
	
	//@RequestParam("name")이것만 달랑 써놓고 파람이 안들어오면 에러가남
	//required 필수 입력 여부 
	
	//@RequestParam(value =  "name",required = false,defaultValue = "아무게")
	
	//낱개로 받기
	//param/insert1.do?name=홍길동&age=20&addr=서울시+구로구+개봉2동
	@RequestMapping("/insert1.do")
	public String insert1(
			@RequestParam(value =  "name",required = false) String irum,
								  int age,
								  String addr) {
		
		System.out.println("--수신데이터에오--");
		System.out.println(irum);
		System.out.println(age);
		System.out.println(addr);
		
		
		// return 뷰정보 <= redirect: 접두어 붙어있으면
		//					dispatcherServlet이 해당 뷰정보를 sendRedirect시킴
		return "redirect:insert_form.do";
	}
	
	@RequestMapping("/insert2.do")
	public String insert2(PersonVo vo) {
						  //Vo의 속성명과 parameter명이 일치해야 받을수 있다.
		
		System.out.println("--객체로받기--");
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		System.out.println(vo.getAddr());
		return "redirect:insert_form.do";	
	}
	//Map으로 받기
	@RequestMapping("/insert3.do")
	public String insert3(@RequestParam Map map) {
		//method의 인자는 DispacherServlet에 대한 요구사항
		
		System.out.println("---Map으로 Parameter수신---");
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("addr"));
		
		System.out.println("map=" + map);
		
		return "redirect:insert_form.do";
	}
	
}

package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.SawonService;
import service.TotalService;
import vo.DeptVo;
import vo.SawonVo;

@Controller
public class MainController {
	
	//@autowired => Spring Container에 생성된 객체중에서 Type또는 Name이 일치하는 객체를 자동연결
	
	@Autowired
	TotalService total_service;
	
	@Autowired
	SawonService sawon_service;
	
	@RequestMapping("/dept/list.do")
	public String dept_list(Model model) {
		
		List<DeptVo> list = total_service.selectDeptList();
		
		model.addAttribute("list",list);
		
		return "dept/dept_list";
	}
	
	@RequestMapping("/sawon/list.do")
	public String sawon_list(Model model) {
		
		List<SawonVo> list = sawon_service.selectList();
		
		model.addAttribute("list",list);
		
		return "sawond/sawon_list"; 
			
	}
}

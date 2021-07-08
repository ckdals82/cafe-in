package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDao;
import vo.DeptVo;

@Controller
public class DeptController {
	
	//interface
	DeptDao dept_dao;

	public DeptController(DeptDao dept_dao) {
		super();
		this.dept_dao = dept_dao;
	}
	
	//부서조회
	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		//data가져오기
		List<DeptVo> list = dept_dao.selectList();
		
		//model통해서 데이터를 누구 에게 전달하면
		//누구 request binding
		model.addAttribute("list",list);
		
		//view Resolver에 의해서 어떻게 완성
		//	
		//	"/WEB-INF/views/" + "dept/dept_list" + ."jsp"
		return "dept/dept_list";
	}
	
	
	
}

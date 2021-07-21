package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.FilterDao;
import vo.CafeSearchVo;

@Controller
public class FilterController {

	FilterDao filter_dao;
	
	public void setFilter_dao(FilterDao filter_dao) {
		this.filter_dao = filter_dao;
	}

	@RequestMapping("search.do")
	public String list(CafeSearchVo vo) {
		
		List<CafeSearchVo> list = filter_dao.selecList(vo);
		
		return "recommend_list"; 
	}
}

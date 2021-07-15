package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ProductService;
import vo.ProductVo;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	ProductService product_service;
	
	 
	public void setProduct_service(ProductService product_service) {
		this.product_service = product_service;
	}


	@RequestMapping("list.do")
	public String list(Model model) {
		
		Map map = product_service.selectList();
		
		//결과적으로 request binding
		model.addAttribute("map",map);
		
		return "product/product_list";
	}
	
	//입고처리
	@RequestMapping("insert_in.do")
	public String insert_in(ProductVo vo) {
		
		try {
			product_service.insert_in(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:list.do";
	}
}

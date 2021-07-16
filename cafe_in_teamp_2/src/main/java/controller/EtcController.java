package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/etc/")
public class EtcController {
	
	@RequestMapping("list.do")
	public String list(Model model) {
		
		return "etc/main_list";
	}
	
}

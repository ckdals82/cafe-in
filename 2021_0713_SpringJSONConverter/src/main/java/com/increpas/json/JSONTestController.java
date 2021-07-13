package com.increpas.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVo;

@Controller
public class JSONTestController {
	
	//Map -> JSON변환
	@RequestMapping("/test_map.do")
	@ResponseBody
	public Map test_map() {
		
		Map map = new HashMap();
		
		map.put("result", false);
		map.put("reson", "fail_id");
		
		return map;
	}
	
	//PersonVo - > JSON변환
	@RequestMapping("/test_person.do")
	@ResponseBody
	public PersonVo test_person() {
		
		PersonVo vo = new PersonVo("홍길동",20,"010-111-1234");
		
		return vo;
	}
	
	@RequestMapping("/test_person_list.do")
	@ResponseBody
	public Map test_person_list() {
		
		List list = new ArrayList();
		
		
		
		list.add(new PersonVo("일길동",21,"010-111-1234"));
		list.add(new PersonVo("이길동",21,"013-111-1234"));
		list.add(new PersonVo("삼길동",21,"014-111-1234"));
		
		Map map = new HashMap();
		
		map.put("count", list.size());
		map.put("person_list", list);
		
		
		
		return map;
	}
	
	
	//ArrayList-> Json변환(받아서 사용하는 측에서는 인식 안된다: JSON형식 포장 보내야함)
	@RequestMapping("/test_list.do")
	@ResponseBody
	public List test_list() {
		
		List list = new ArrayList();
		list.add("참외");
		list.add("딸기");
		list.add("수박");
		
		return list;
	}
	
	//모든언어에서 사용가능하도록 표준 JSON으로 포장해서 전송
	@RequestMapping("/test_fruit_list.do")
	@ResponseBody
	public Map test_fruit_list() {
		
		List list = new ArrayList();
		list.add("참외");
		list.add("딸기");
		list.add("수박");
		
		Map map = new HashMap();
		map.put("fruit_list", list);
		
		return map;
	}
	
	
	
}

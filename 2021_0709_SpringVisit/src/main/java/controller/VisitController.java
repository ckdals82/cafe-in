package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDao;
import vo.VisitVo;

@Controller
@RequestMapping("/visit/")
public class VisitController {
	
	VisitDao visitDao;
	
	//setter injection
	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	//				"list.do?search=name&search_text=길동"
	@RequestMapping("list.do")
	public String list(String search,String search_text,Model model) {
		//			@Request(value="search",required=false)String search
		//2.parameter받기 => method의 인자로 넣어주면 dispathcherServlet이 parameter받아서 넣어준다
		
		if(search==null) search="all";
		
		//검색조건을 담을 객체
		Map <String,String>map = new HashMap<String,String>();
		
		//전체검색이 아니면
		if(!search.equals("all")) {
			if(search.equals("name_content")) {
				map.put("name", search_text);
				map.put("content", search_text);
				
			}else if(search.equals("name")) {
				//이름	 key		value
				map.put("name", search_text);
			}else if(search.equals("content")) {
				//내용	 key		value
				map.put("content", search_text);
			}else if (search.equals("regdate")) {
				//내용	 key		value
				map.put("regdate", search_text);
			}
		}
		
		// 1. ���� ��� ��������     
		List<VisitVo> list = visitDao.selectList(map);
		
		// 2. request binding
//		request.setAttribute("list", list);
		model.addAttribute("list",list); //결과적으로 dispatcherServlet에게 넘긴다.
										 //=> dispatcgerServlet이 request binding시킴
		return "visit/visit_list";
	}
		//입력폼띄우기			/visit/insert_form.do
	@RequestMapping("insert_form.do")
	public String insert_form() {
		
		
		//		/Web-INF/views/visit/visit_insert_form.jsp
		return "visit/visit_insert_form";
	}
	//글쓰기
	//			/visit/insert.do?name=홍길동&content=내용&pwd=1234
	@RequestMapping("insert.do")
	public String insert(VisitVo vo, HttpServletRequest request) {
		
		//2.parameter 받기 : method인자에서 받는다.
		
		String ip = request.getRemoteAddr();
		
		String content = vo.getContent().replaceAll("\r\n", "<br>");
		vo.setContent(content);
		vo.setIp(ip);
		
		//DBinsert
		int res = visitDao.insert(vo);
		
		return "redirect:list.do";
	}
	//비밀번호 체크
	//	/visit/check_pwd.do?idx=10&c_pwd=1234
	//responsebody 반환되는 값을 바로 클라이언트에게 전송해라
	@RequestMapping("check_pwd.do")
	@ResponseBody
	public String check_pwd(int idx,String c_pwd) {
		//2.parameter 받기: method인자로 받음
		
		
		//3.id에 해당되는 객체 1건 가져오기
		VisitVo vo = visitDao.selectOne(idx);
		
		//방법1
		//boolean bResult = vo.getPwd().equals(c_pwd);
		//아래와 같은 의미
		//방법2
		boolean bResult;
		if(vo.getPwd().equals(c_pwd)) {
			//같은경우
			bResult = true;
		}else {
			//틀린경
			bResult = false;
		}
		
		//결과데이터 생성 : json
		String json = String.format("{\"result\":%b}", bResult);
		
		return json;//
	}
	//삭제하기
	@RequestMapping("delete.do")
	public String delete(int idx) {
		
		// 1. parameter�ޱ� ~> ������ȯ
		
		
		
		// 2. DB delete
		int res = visitDao.delete(idx);
		
		
		return "redirect:list.do";
	}
	//수정하기
	@RequestMapping("modify.do")
	public String modify(VisitVo vo, HttpServletRequest request) {
		
		//2.parameter 받기 : method인자에서 받는다.
		
		String ip = request.getRemoteAddr();
		
		String content = vo.getContent().replaceAll("\r\n", "<br>");
		vo.setContent(content);
		vo.setIp(ip);
		
				
		// 4. DB�� update
		int res = visitDao.update(vo);
		
		//5.목록보기 : redirect:list.do => response.sendRedirect("list.do")
		return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet
	}
	@RequestMapping("modify_form.do")
	public String modify_form(int idx,  Model model) {
		
		// 1. parameter�ޱ� ~> ������ȯ
		VisitVo vo = visitDao.selectOne(idx);
		
		String content = vo.getContent().replaceAll("<br>", "\r\n");
		vo.setContent(content);
		
		//request binding
		model.addAttribute("vo",vo);
		
		return "visit/visit_modify_form";
	}
	
}

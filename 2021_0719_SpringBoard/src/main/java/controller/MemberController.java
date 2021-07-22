package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDao;
import vo.MemberVo;

@Controller
@RequestMapping("/member/")
public class MemberController {

	
	// DispatcherServlet에게 자동으로 넣어달라...요청
	// 1.해당컨트롤러가 Auto-Detacting으로 생성되면 자동주입이 된다
	// 2.수동생성시 생성코드(<bean>) 윗쪽에  <context:annotation-config/> 작성해야 지원된다
	// 3.언제 Injection : 대상 메소드 호출시마다 넣어준다
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
			
	
	MemberDao member_dao;

	public void setMember_dao(MemberDao member_dao) {
		this.member_dao = member_dao;
	}
	
	//로그인폼 띄우기
	@RequestMapping("login_form.do")
	public String login_form() {
		
		return "member/member_login_form";
	}
	
	
	@RequestMapping("login.do")
	public String login(String m_id,String m_pwd,String url,Model model) {
		
		// 메소드의 인자?  의미? : DispatcherServlet에 대한 요청사항
		// Model용도?
		// 1.forward시에는  request binding 시킨다.
		// 2.redirect시에는 parameter변수(query)로 이용된다.
	  
		//3.m_id에 해당되는 MemberVo 1건 얻어오기
		MemberVo user = member_dao.selectOne(m_id);
		
		if(user==null) { //ID가 없는경우
			//return "redirect:login_form.do?reason=fail_id";
			
			model.addAttribute("reason", "fail_id");
			
			return "redirect:login_form.do";
		}
		
		//비밀번호 비교
		if(user.getM_pwd().equals(m_pwd)==false) {
			
			model.addAttribute("reason", "fail_pwd");
			return "redirect:login_form.do";
		}
		
		//정상적인 로그인상태
		//현재 user가 사용할수 있는 session정보 구하기
		session.setAttribute("user", user);
			
		//메인화면으로 이동
		//현재위치 : /member/
		//이동위치 : /board/
		
		if(url==null)url="";
		
		if(url.isEmpty())
		    return "redirect:../board/list.do";
		else
			return "redirect:" + url;
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String logout() {
		
		session.removeAttribute("user");
		
		return "redirect:../board/list.do";
	}
	
	
	@RequestMapping("check_id.do")
	@ResponseBody
	public Map check_id(String m_id) {
		
		//  /member/check_id.do?m_id=hong
	
		//3.DB내에 m_id존재여부 검사
		MemberVo  vo = member_dao.selectOne(m_id);
		
		Map map = new HashMap();
		map.put("result", (vo==null));
		
		return map;
	}
		
	
	@RequestMapping("delete.do")
	public String delete(int m_idx) {
		
		//2.DB delete
		int res = member_dao.delete(m_idx);
				
		return "redirect:list.do";
	}
	
	//폼띄우기
	@RequestMapping("insert_form.do")
	public String insert_form() {
		
		return "member/meber_insert_form";
	}


	@RequestMapping("insert.do")
	public String insert(MemberVo vo) {
		
		// /member/insert.do?m_name=오길동&m_id=five&m_pwd=1234&m_zipcode=08768&m_addr=서울+관악구+시흥대로+552
		
		//3.ip받기
		String m_ip			= request.getRemoteAddr();
		vo.setM_ip(m_ip);
		
		
		//5.DB insert
		int res = member_dao.insert(vo);
		
		return "redirect:login_form.do";
	}
	
	@RequestMapping("list.do")
	public String list(Model model) {
		//회원목록 읽어오기
		List<MemberVo> list = member_dao.selectList();
			
		//request binding
		model.addAttribute("list", list);
		
		return "member/member_list";
	}
	
	
	@RequestMapping("modify_form.do")
	public String modify_form(int m_idx,Model model) {
		// /member/modify_form.do?m_idx=5
		
		//2.m_idx에 대한 MemberVo를 얻어오기
		MemberVo vo = member_dao.selectOne(m_idx);
		
		//3.request binding
		model.addAttribute("vo", vo);
		
		return "member/member_modify_form";
	}
	
	@RequestMapping("modify.do")
	public String modify(MemberVo vo,Model model) {
		
		// /member/modify.do?m_idx=5&m_name=오길동&m_id=five&m_pwd=1234&m_zipcode=08768&m_addr=서울&m_grade=일반
		//3.ip받기
		String m_ip			= request.getRemoteAddr();
		vo.setM_ip(m_ip);
		
		//5.DB update
		int res = member_dao.update(vo);
	
		
		return "redirect:list.do";
	}
	
		
		
	
	
}

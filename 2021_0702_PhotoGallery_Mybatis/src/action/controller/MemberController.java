package action.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import annotation.RequestMapping;
import annotation.ResponseBody;
import dao.MemberDao;
import vo.MemberVo;

public class MemberController {

	
	@RequestMapping("/member/check_id")
	@ResponseBody
	public String check_id(HttpServletRequest request, HttpServletResponse response) {

		//2.parameter 받기
		String m_id = request.getParameter("m_id");
		
		//3.DB내에 m_id존재여부 검사
		boolean bResult;
		MemberVo vo = MemberDao.getInstance().selectOne(m_id);
		
		if(vo==null) {//사용가능한 ID
			bResult = true;
		}else {
			//사용중인 ID
			bResult = false;
		}
		//전송타입지정
		response.setContentType("text/json; charest=utf-8;");
		
		//결과-> JSON로 포장
		String json = String.format("{\"result\":%b}", bResult);
		
		
		
		
		return json;

	}
	@RequestMapping("/member/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. parameter받기
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));

		// 2. DB delete
		int res = MemberDao.getInstance().delete(m_idx);
		
		return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet

	}
	@RequestMapping("/member/insert.do")
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		
		//2.parameter 받기
		String m_id  = request.getParameter("m_id");
		String m_name = request.getParameter("m_name");
		String m_pwd = request.getParameter("m_pwd");
		String m_zipcode = request.getParameter("m_zipcode");
		String m_addr = request.getParameter("m_addr");
		
		//3. ip구하기
		String m_ip = request.getRemoteAddr();
		
		//MemberVo 포장
		MemberVo vo = new MemberVo( m_name, m_id, m_pwd, m_zipcode, m_addr, m_ip);
		
		//DB insert
		int res = MemberDao.getInstance().insert(vo);
		
		return "redirect:login_form.do";//누구에게 알려줬을까유? dispacherServletlogin_form

	}
	
	@RequestMapping("/member/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response) {

		//2.parameter받기
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		
		String url = request.getParameter("url");
		
		if(url==null)
			url="";
		
		//3.m_id에 해당되는 MemberVo 1건 얻어오기
		MemberVo user = MemberDao.getInstance().selectOne(m_id);
		
		if(user==null) { //ID가 없는 경우
				if(url.isEmpty())
				return	"redirect:login_form.do?reason=fail_id";
				else
					   
				return	"redirect: login_form.do?reason=fail_id&url=" + url;
				 
		}
		//비밀번호 비교
		if(user.getM_pwd().equals(m_pwd)==false) {//비밀번호가 틀려서로그인못해~ 
			if(url.isEmpty())
				return	"redirect:login_form.do?reason=fail_pwd";
			else
				return	"redirect:login_form.do?reason=fail_pwd&url=" + url;
			
			
			
		}
		//정상적인 로그인 상태
		//현재 user가 사용 할수 있는 session정보 구하기 
		HttpSession session = request.getSession();
		session.setAttribute("user", user);//로그인한 멤버 브이오 정보를 통째로 넣음
		
		//메인화면으로 이동
		//현재위치 : /member/
		//이동위치 : /product/
		if(url.isEmpty())
			return	"redirect:../product/list.do";
		else
			return	"redirect:url";
		
		

	}
	@RequestMapping("/member/insert_form.do")
	public String insert_form(HttpServletRequest request, HttpServletResponse response) {

		return "member_insert_form.jsp";

	}
////	
	@RequestMapping("/member_list.do")
	public String method명(HttpServletRequest request, HttpServletResponse response) {
		
		//회원목록 읽어오기
		List<MemberVo> list = MemberDao.getInstance().selectList();
		
		//request binding
		request.setAttribute("list", list);
		
		return "member_list.jsp";

	}
	@RequestMapping("/member/login_form.do")
	public String login_form(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "member_login_form.jsp";

	}
//	
	@RequestMapping("/member/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession().removeAttribute("user");;//로그인한 멤버 브이오 정보를 통째로 넣음
		//2.메인페이지 이동
		//현재위치 : /member/
		//이동위치 : /product/
		
		
		return "redirect:../photo/list.do";//누구에게 알려줬을까유? dispacherServletlogin_form

	}
//	
	@RequestMapping("/member/modify.do")
	public String modify(HttpServletRequest request, HttpServletResponse response) {
		
		//2.parameter받기
		int m_idx= Integer.parseInt(request.getParameter("m_idx"));
		String m_name = request.getParameter("m_name");
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		String m_zipcode = request.getParameter("m_zipcode");
		String m_addr = request.getParameter("m_addr");
		String m_grade = request.getParameter("m_grade");
		
		//3.ip받기
		String m_ip = request.getRemoteAddr();
		
		//member vo 퓨ㅗ장
		MemberVo vo = new MemberVo(m_idx, m_name, m_id, m_pwd, m_zipcode, m_addr, m_ip, m_grade);
		
		//DB update
		int res = MemberDao.getInstance().update(vo);
		
		return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet

	}
//	
	@RequestMapping("/member_modify_form.do")
	public String modify_form(HttpServletRequest request, HttpServletResponse response) {
		
		//1.parameter받기
		int m_idx =Integer.parseInt(request.getParameter("m_idx"));
		
		//2.m_idx에 대한 MemberVo를 얻어오기
		MemberVo vo= MemberDao.getInstance().selectOne(m_idx);
		
		//3.request binding
		request.setAttribute("vo", vo);
		
		return "member_modify_form.jsp";

	}
//	
	
}

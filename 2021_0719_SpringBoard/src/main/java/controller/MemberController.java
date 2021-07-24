//package controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import dao.MemberDao;
//import vo.MemberVo;
//
//@Controller
//@RequestMapping("/member/")
//public class MemberController {
//
//	
//	// DispatcherServlet���� �ڵ����� �־�޶�...��û
//	// 1.�ش���Ʈ�ѷ��� Auto-Detacting���� �����Ǹ� �ڵ������� �ȴ�
//	// 2.���������� �����ڵ�(<bean>) ���ʿ�  <context:annotation-config/> �ۼ��ؾ� �����ȴ�
//	// 3.���� Injection : ��� �޼ҵ� ȣ��ø��� �־��ش�
//	@Autowired
//	HttpSession session;
//	
//	@Autowired
//	HttpServletRequest request;
//	
//			
//	
//	MemberDao member_dao;
//
//	public void setMember_dao(MemberDao member_dao) {
//		this.member_dao = member_dao;
//	}
//	
//	//�α����� ����
//	@RequestMapping("login_form.do")
//	public String login_form() {
//		
//		return "member/member_login_form";
//	}
//	
//	
//	@RequestMapping("login.do")
//	public String login(String m_id,String m_pwd,String url,Model model) {
//		
//		// �޼ҵ��� ����?  �ǹ�? : DispatcherServlet�� ���� ��û����
//		// Model�뵵?
//		// 1.forward�ÿ���  request binding ��Ų��.
//		// 2.redirect�ÿ��� parameter����(query)�� �̿�ȴ�.
//	  
//		//3.m_id�� �ش�Ǵ� MemberVo 1�� ������
//		MemberVo user = member_dao.selectOne(m_id);
//		
//		if(user==null) { //ID�� ���°��
//			//return "redirect:login_form.do?reason=fail_id";
//			
//			model.addAttribute("reason", "fail_id");
//			
//			return "redirect:login_form.do";
//		}
//		
//		//��й�ȣ ��
//		if(user.getM_pwd().equals(m_pwd)==false) {
//			
//			model.addAttribute("reason", "fail_pwd");
//			return "redirect:login_form.do";
//		}
//		
//		//�������� �α��λ���
//		//���� user�� ����Ҽ� �ִ� session���� ���ϱ�
//		session.setAttribute("user", user);
//			
//		//����ȭ������ �̵�
//		//������ġ : /member/
//		//�̵���ġ : /board/
//		
//		if(url==null)url="";
//		
//		if(url.isEmpty())
//		    return "redirect:../board/list.do";
//		else
//			return "redirect:" + url;
//	}
//	
//	//�α׾ƿ�
//	@RequestMapping("logout.do")
//	public String logout() {
//		
//		session.removeAttribute("user");
//		
//		return "redirect:../board/list.do";
//	}
//	
//	
//	@RequestMapping("check_id.do")
//	@ResponseBody
//	public Map check_id(String m_id) {
//		
//		//  /member/check_id.do?m_id=hong
//	
//		//3.DB���� m_id���翩�� �˻�
//		MemberVo  vo = member_dao.selectOne(m_id);
//		
//		Map map = new HashMap();
//		map.put("result", (vo==null));
//		
//		return map;
//	}
//		
//	
//	@RequestMapping("delete.do")
//	public String delete(int m_idx) {
//		
//		//2.DB delete
//		int res = member_dao.delete(m_idx);
//				
//		return "redirect:list.do";
//	}
//	
//	//������
//	@RequestMapping("insert_form.do")
//	public String insert_form() {
//		
//		return "member/meber_insert_form";
//	}
//
//
//	@RequestMapping("insert.do")
//	public String insert(MemberVo vo) {
//		
//		// /member/insert.do?m_name=���浿&m_id=five&m_pwd=1234&m_zipcode=08768&m_addr=����+���Ǳ�+������+552
//		
//		//3.ip�ޱ�
//		String m_ip			= request.getRemoteAddr();
//		vo.setM_ip(m_ip);
//		
//		
//		//5.DB insert
//		int res = member_dao.insert(vo);
//		
//		return "redirect:login_form.do";
//	}
//	
//	@RequestMapping("list.do")
//	public String list(Model model) {
//		//ȸ����� �о����
//		List<MemberVo> list = member_dao.selectList();
//			
//		//request binding
//		model.addAttribute("list", list);
//		
//		return "member/member_list";
//	}
//	
//	
//	@RequestMapping("modify_form.do")
//	public String modify_form(int m_idx,Model model) {
//		// /member/modify_form.do?m_idx=5
//		
//		//2.m_idx�� ���� MemberVo�� ������
//		MemberVo vo = member_dao.selectOne(m_idx);
//		
//		//3.request binding
//		model.addAttribute("vo", vo);
//		
//		return "member/member_modify_form";
//	}
//	
//	@RequestMapping("modify.do")
//	public String modify(MemberVo vo,Model model) {
//		
//		// /member/modify.do?m_idx=5&m_name=���浿&m_id=five&m_pwd=1234&m_zipcode=08768&m_addr=����&m_grade=�Ϲ�
//		//3.ip�ޱ�
//		String m_ip			= request.getRemoteAddr();
//		vo.setM_ip(m_ip);
//		
//		//5.DB update
//		int res = member_dao.update(vo);
//	
//		
//		return "redirect:list.do";
//	}
//	
//		
//		
//	
//	
//}

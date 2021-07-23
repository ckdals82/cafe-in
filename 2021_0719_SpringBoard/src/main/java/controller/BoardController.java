package controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.BoardDao;
import mycommon.MyConstant;
import util.Paging;
import vo.BoardVo;
import vo.MemberVo;

@Controller
@RequestMapping("/board/")
public class BoardController {

	//�ڵ������ÿ��� �������ش�
	//���������� : <context:annotation-config/> �ؾ� ����ȴ�
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	
	BoardDao  board_dao;
	
	public void setBoard_dao(BoardDao board_dao) {
		this.board_dao = board_dao;
	}

	//��Ϻ���
    //  /board/list.do
	//  /board/list.do?page=1
	
    //  /board/list.do?search=all&search_text=
	//  /board/list.do?search=name&search_text=�浿
    //  /board/list.do?search=subject&search_text=����
    //  /board/list.do?search=content&search_text=����
    //  /board/list.do?search=subject_content&search_text=����Ǵ³���
	
	@RequestMapping("list.do")
	public String list(@RequestParam(value="page", required=false,defaultValue="1")        int nowPage, 
			           @RequestParam(value="search",required=false,defaultValue="all")     String search,
			           @RequestParam(value="search_text",required=false,defaultValue="")   String search_text,
			           Model model) {
		 
		//���� ������ ������ : nowPage
		
		//������ �������
		int start = (nowPage-1) * MyConstant.Board.BLOCK_LIST + 1;
		int end   = start + MyConstant.Board.BLOCK_LIST - 1;
		
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		//�˻������� Map�� �߰�
		if(search.equals("name")) {
		    map.put("name", search_text);	
		}else if(search.equals("subject")) {
			map.put("subject", search_text);	
		}else if(search.equals("content")) {
			map.put("content", search_text);	
		}else if(search.equals("subject_content")) {
			map.put("subject", search_text);
			map.put("content", search_text);	
		}
		
		
		List<BoardVo> list = board_dao.selectList(map);
		//System.out.println(list.size());
		
		//�˻����ǿ� ���� �Խù��� ���ϱ�
		int rowTotal = board_dao.selectRowTotal(map);
				
		//System.out.println(rowTotal);
		
		//PagingMenu�����...
		
		//list.do?page=1&search=all&search_text=
		
		String search_filter = String.format("&search=%s&search_text=%s", search,search_text);
				
		
		String pageMenu = Paging.getPaging("list.do", 
				                           nowPage, 
				                           rowTotal,
				                           search_filter,
				                           MyConstant.Board.BLOCK_LIST,
				                           MyConstant.Board.BLOCK_PAGE);
		
				
		
		//view.do���� �ó�?�� �������� ����س��� �� => ����
		session.removeAttribute("show");
		
		//model���ؼ� DispatcherServlet���� ����=>��������� request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu",pageMenu);
		
		return "board/board_list";
	}
	
	//���۾����� ����
	@RequestMapping("insert_form.do")
	public String insert_form() {
		
		return "board/board_insert_form";
	}
	
	
	// /board/insert.do?b_subject=����&b_content=����
	@RequestMapping("insert.do")
	public String insert(BoardVo vo,Model model) {
		
		//�߰��� ���ؾ� �� �׸� : b_ip,m_idx ,m_name
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		//���� �����...
		if(user==null) {
			
			//2���� �뵵
			//1. forward : request binding
			//2. redirect: query���  ?reason=end_session
			model.addAttribute("reason", "end_session");
			return "redirect:../member/login_form.do";
		}
		
		//������ȣ�� �̸��� vo�� ��´�
		vo.setM_idx(user.getM_idx());
		vo.setM_name(user.getM_name());
		
		//�ۼ���IP
		String b_ip = request.getRemoteAddr();
		vo.setB_ip(b_ip);
		
		//\r\n -> <br>
		String b_content = vo.getB_content().replaceAll("\r\n", "<br>");
		vo.setB_content(b_content);
		
		//DB Insert
		try {
			
			int res = board_dao.insert(vo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "redirect:list.do";
	}
	
	
	
	//  /board/view.do?b_idx=12
	@RequestMapping("view.do")
	public String view(int b_idx,Model model) {
		
		BoardVo vo = board_dao.selectOne(b_idx);
		
		//��ȸ�� ����
		try {
			
			//�Խù��� �ó�?
			if(session.getAttribute("show")==null) {
			    //�Ⱥ�����  null
			    int res = board_dao.update_readhit(b_idx);//��ȸ������
			    
			    //�ôٰ� ���
			    session.setAttribute("show", true);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		//model���� ����(DispatcherServlet) => request binding
		model.addAttribute("vo", vo);
		
		
		return "board/board_view";
	}
	
	
	
	
	//��۾����� ����
	@RequestMapping("reply_form.do")
	public String reply_form() {
		
		return "board/board_reply_form";
	}
	
	
	//  /board/reply.do?b_idx=8&b_subject=[�亯]���&b_content=�ٳ�Խ��ϴ�&page=3
	@RequestMapping("reply.do")
	public String reply(BoardVo vo, @RequestParam(value="page",required=false,defaultValue="1") int page, Model model) {
		
		//�߰��� ���ؾ� �� �׸� : b_ip,m_idx ,m_name
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		//���� �����...
		if(user==null) {
			
			//2���� �뵵
			//1. forward : request binding
			//2. redirect: query���  ?reason=end_session
			model.addAttribute("reason", "end_session");
			return "redirect:../member/login_form.do";
		}
		
		//������ȣ�� �̸��� vo�� ��´�
		vo.setM_idx(user.getM_idx());
		vo.setM_name(user.getM_name());
		
		//�ۼ���IP
		String b_ip = request.getRemoteAddr();
		vo.setB_ip(b_ip);
		
		//\r\n -> <br>
		String b_content = vo.getB_content().replaceAll("\r\n", "<br>");
		vo.setB_content(b_content);
				
		
		
		//1.���ر� ���� ������
		BoardVo baseVo = board_dao.selectOne(vo.getB_idx());
		
		try {
			//2.���رۺ��� step�� ū�Խù��� step�� 1�� ������Ų��=>��?(���� ����� �� �ڸ��� ����)
			int  res = board_dao.update_step(baseVo);
			
			//3.����� b_ref,b_step,b_depth���
			vo.setB_ref(baseVo.getB_ref());      // ���b_ref  = ���ر�b_ref
			vo.setB_step(baseVo.getB_step()+1);  // ���b_step = ���ر�b_step  + 1
			vo.setB_depth(baseVo.getB_depth()+1);// ���b_depth= ���ر�b_depth + 1
			
			res = board_dao.reply(vo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���� model�� ������ DispatcherServlet�� ��� ó���ұ�?=> �� : query�� ���
		model.addAttribute("page", page);
	
		return "redirect:list.do";
	}
	
	
	//board/delete.do?b_idx=17&page=3&search=name&search_text=����
	//����...
	@RequestMapping("delete.do")
	public String delete(int b_idx,@RequestParam(value="page",required=false,defaultValue="1") int page,
			              String search,String search_text, 
			              Model model) {
		
		try {
			
			int res = board_dao.update_use_yn(b_idx);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���� model�� ������ DispatcherServlet�� ��� ó���ұ�?=> �� : query�� ���
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		
		return "redirect:list.do"; // list.do?page=5&search=name&search_text=����
	}
	
	//  /board/modify_form.do?b_idx=5&page=3
	//������ ����
	@RequestMapping("modify_form.do")
	public String modify_form(int b_idx,Model model) {
		
		//1.���������� ���� 1�� ������
		BoardVo  vo = board_dao.selectOne(b_idx);
		
		// <br> -> \r\n ����
		String content = vo.getB_content().replaceAll("<br>", "\r\n");
		vo.setB_content(content);
				
		
		//2.��������� request binding
		model.addAttribute("vo", vo);
		
		return "board/board_modify_form";
	}
	
	
	//�����ϱ�
	//  /board/modify.do?b_idx=33&page=3&b_subject=�ų���&b_content=��!�ų���
	@RequestMapping("modify.do")
	public String modify(BoardVo vo,int page,
			 @RequestParam(value="search",required=false,defaultValue="all")     String search,
	         @RequestParam(value="search_text",required=false,defaultValue="")   String search_text,
			Model model) {
		//�߰��� ���ؾ� �� �׸� : b_ip,m_idx ,m_name
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		//���� �����...
		if(user==null) {
			
			//2���� �뵵
			//1. forward : request binding
			//2. redirect: query���  ?reason=end_session
			model.addAttribute("reason", "end_session");
			return "redirect:../member/login_form.do";
		}
		
		//������ȣ�� �̸��� vo�� ��´�
		vo.setM_idx(user.getM_idx());
		vo.setM_name(user.getM_name());
		
		
		
		//�ۼ���IP
		String b_ip = request.getRemoteAddr();
		vo.setB_ip(b_ip);
		
		//\r\n -> <br>
		String b_content = vo.getB_content().replaceAll("\r\n", "<br>");
		vo.setB_content(b_content);
		
		//DB update
		try {
			
			int res = board_dao.update(vo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//model���ؼ� ���޵� �����Ͱ� query�̿�
		model.addAttribute("b_idx", vo.getB_idx());
		model.addAttribute("page", page);
		model.addAttribute("search",search);
		model.addAttribute("search_text",search_text);
		
		return "redirect:view.do";  //   view.do?b_idx=5&page=3
	}
	
	
	
	
	
	
	
	
}

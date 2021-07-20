package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDao;
import vo.BoardVo;
import vo.MemberVo;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	//자동생성시에는 연결해준다
	//수동생성시 : <context:annotation-config/>
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session; //idx m_name을 구하는
	
	BoardDao board_dao;
	
	
	
	public void setBoard_dao(BoardDao board_dao) {
		this.board_dao = board_dao;
	}



	//목록보기
	@RequestMapping("list.do")
	public String list(Model model) {
		
		List<BoardVo> list = board_dao.selectList();
		
		//System.out.println(list.size());
		
		//view.do에서 봣냐?에 대한 정보 기록해놓은 값 => 제거
		session.removeAttribute("show");
		
		//model을 통해서 DispatcherServlet에게 전달 => 결과적으로 request binding
		model.addAttribute("list",list);
		
		return "board/board_list";
	}
	
	//목록보기
		@RequestMapping("insert_form.do")
		public String insert_form() {
			
			
			
			
			return "board/board_insert_form";
		}
	//board/insert.do?b_subject=오홍&b_content=안녕하세요
	@RequestMapping("insert.do")
	public String insert(BoardVo vo,Model model) {
		
		//추가로 구해야할 항목 : b_ip,m_idx,m_name
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		//세션 만료시
		if(user==null) {
			
			//2가지 용도
			//1. forward: request binding
			//2. redirect: query사용 ?reason=end_session
			model.addAttribute("reason","end_session");
			return "redirect:../member/login_form.do";
			
		}
		//유저번호와 이름을 vo에 담는다
		vo.setM_idx(user.getM_idx());
		vo.setM_name(user.getM_name());
		
		//작성자IP
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
	
	@RequestMapping("view.do")
	public String view(int b_idx, Model model ) {
		
		BoardVo vo = board_dao.selectOne(b_idx);
		
		//조회수 증가
		try {
			
			//게시물을 봤냐?
			if(session.getAttribute("show")==null) {
				//안봤으면 null
				int res = board_dao.update_readhit(b_idx);//조회수증가
				
				//봤다고 기록
				session.setAttribute("show", true);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//model통해 전달(DispatcherServlet) => request binding
		model.addAttribute("vo",vo);
		
		return "board/board_view";
	}
	//목록보기
	@RequestMapping("reply_form.do")
	public String reply_form() {
		
		return "board/board_reply_form";
	}
	
	@RequestMapping("reply.do")
	public String reply(BoardVo vo, Model model) {
		
		
		//추가로 구해야할 항목 : b_ip,m_idx,m_name
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		//세션 만료시
		if(user==null) {
			
			//2가지 용도
			//1. forward: request binding
			//2. redirect: query사용 ?reason=end_session
			model.addAttribute("reason","end_session");
			return "redirect:../member/login_form.do";
			
		}
		//유저번호와 이름을 vo에 담는다
		vo.setM_idx(user.getM_idx());
		vo.setM_name(user.getM_name());
		
		//작성자IP
		String b_ip = request.getRemoteAddr();
		vo.setB_ip(b_ip);
		
		//\r\n -> <br>
		String b_content = vo.getB_content().replaceAll("\r\n", "<br>");
		vo.setB_content(b_content);
		
		
		//1.기준글 정보 얻어오기
		BoardVo baseVo = board_dao.selectOne(vo.getB_idx());
		
		try {
			//2.기준글보다 step이 큰 게시물의 step을 1씩 증가시킴 => 왜 하는거임? (현재 답글이 들어갈 자리를 마련)
			int res = board_dao.update_step(baseVo);
			
			//3.답글의 b_ref,b_step,b_step계산
			vo.setB_ref(baseVo.getB_ref());//답글b_ref = 기준글b_ref
			vo.setB_step(baseVo.getB_depth()+1); //답글b_step = 기준글b_step + 1
			vo.setB_depth(baseVo.getB_depth()+1);//답글b_depth= 기준글b_depth +1
			
			res = board_dao.reply(vo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:list.do";
	}

		
		
		
}

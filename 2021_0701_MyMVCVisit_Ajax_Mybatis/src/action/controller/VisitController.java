package action.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import annotation.RequestMapping;
import annotation.ResponseBody;
import dao.VisitDao;
import vo.VisitVo;

public class VisitController {
	//조회하기
	@RequestMapping("/visit/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		
				//2.parameter받기
				String search = request.getParameter("search");
				String search_text = request.getParameter("search_text");
				
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
				List<VisitVo> list = VisitDao.getInstance().selectList(map);
				
				// 2. request binding
				request.setAttribute("list", list);
		
		
		return "visit_list.jsp";
	}
	//등록폼 띄우기
	@RequestMapping("/visit/insert_form.do")
	public String insert_form(HttpServletRequest request,HttpServletResponse response) {
		return "visit_insert_form.jsp";
	}
	
	//등록하기
	@RequestMapping("/visit/insert.do")
	public String insert(HttpServletRequest request,HttpServletResponse response) {

		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		//DBinsert
		int res = VisitDao.getInstance().insert(vo);
		
		
		//5.목록보기 : redirect:list.do => response.sendRedirect("list.do")
		return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet
	}
	//비밀번호체크
	//@ResponseBody : 반환되는 값을 바로 클라이언트에게 전송해라
	//				안붙으면 return된는 값을 뷰로 인식
	@RequestMapping("/visit/check_pwd.do")
	@ResponseBody
	public String check_pwd(HttpServletRequest request,HttpServletResponse response) {
		
		//2.parameter 받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		//3.id에 해당되는 객체 1건 가져오기
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
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
	@RequestMapping("/visit/delete.do")
	public String delete(HttpServletRequest request,HttpServletResponse response) {
		
		// 1. parameter�ޱ� ~> ������ȯ
		int idx = Integer.parseInt(request.getParameter("idx"));

		// 2. DB delete
		int res = VisitDao.getInstance().delete(idx);
		
		//3.목록보기 : redirect:list.do => response.sendRedirect("list.do")
		return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet
	}
	@RequestMapping("/visit/modify.do")
	public String modify(HttpServletRequest request,HttpServletResponse response) {
		
		// 2. parameter �ޱ�
		int    idx      = Integer.parseInt(request.getParameter("idx"));
		String name 	= request.getParameter("name");
		String content	= request.getParameter("content");
		String pwd		= request.getParameter("pwd");
		
		String ip  		= request.getRemoteAddr();
		
		// ���뿡�� \r\n  ~> <br>��ȯ
		content = content.replace("\r\n", "<br>");
				
		// 3. ����
		VisitVo vo = new VisitVo(idx, name, content, pwd, ip);

		// 4. DB�� update
		int res = VisitDao.getInstance().update(vo);
		
		//5.목록보기 : redirect:list.do => response.sendRedirect("list.do")
		return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet
		
	}
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(HttpServletRequest request,HttpServletResponse response) {
		
		// 1. parameter �ޱ�
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 2. idx�� �ش�Ǵ� �Խù� 1�� ������
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		// <br> ~> \r\n
		String content = vo.getContent().replaceAll("<br>", "\r\n");
		
		vo.setContent(content);
		
		// 3. request binding
		request.setAttribute("vo", vo);
		
		
		return "visit_modify_form.jsp";
	}
	
	
	
}

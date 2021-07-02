package action.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import annotation.RequestMapping;
import annotation.ResponseBody;
import dao.PhotoDao;
import vo.PhotoVo;

public class PhotoController {

	@RequestMapping("/photo/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));

	      //2. PhotoVo <= p_idx
	      PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
	      
	      //3. 웹경로(상대경로) => 절대경로 구하기
	      
	      String web_path = "/upload/";
	      String save_dir = request.getServletContext().getRealPath(web_path);
	      
	      //4. 파일삭제       저장된경로        파일이름
	      File f = new File(save_dir, vo.getP_filename());
	      f.delete();
	      
	      //5. DB delete
	      int res = PhotoDao.getInstance().delete(p_idx);
		
	      return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet

	}
	
	@RequestMapping("/photo/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		
		List<PhotoVo> list = PhotoDao.getInstance().selectList();
		
		//request binding
		request.setAttribute("list", list);
		
		return "photo_list.jsp";

	}
	
	@RequestMapping("/photo/insert.do")
	public String insert(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String web_path = "/upload";
		String save_dir = request.getServletContext().getRealPath(web_path);
		
		System.out.println(save_dir);
		
		//2.업로드 최대 사이즈 지정(byte단위)
		int max_size = 1024 * 1024 * 100; // 100MB
		
		//파일 업로드시에는 멀티파트 리퀘스트를 이용해서 처리
		//객체 생성과 동시에 업로드 완료된다.
		MultipartRequest mr = new MultipartRequest(request,//수신처리객체(mr에 위임했다) //파라미터받는 권한을 mr에게 넘겨줬
									                save_dir,//저장위치
									                max_size,//업로드최대용량
									                "utf-8",//수신인코딩
									                new DefaultFileRenamePolicy() //동일파일이 있을시 이름을 변경해서 저장
									                );
		//업로드된 화일정보 얻어오기
		File f = mr.getFile("photo");
		String p_filename = "no_file";
		if(f != null) {
			p_filename = f.getName();
		}
		
		
		//로그인된 상태의 세션에 저장된 유저정보 얻어오기
//		MemberVo user = (MemberVo)request.getSession().getAttribute("user");
//		int		m_idx = user.getM_idx();
		
		
		//파라미터 수신(mr이용해서 parameter받아야함)
		int    m_idx = Integer.parseInt(mr.getParameter("m_idx"));
		String p_title = mr.getParameter("p_title");
		// \r\n -> <br> 변경
		String p_content = mr.getParameter("p_content").replaceAll("\r\n", "<br>");
		
		//ip 구하기
		String p_ip = request.getRemoteAddr();
		
		
		//PhotoVo 포장
		PhotoVo vo = new PhotoVo(p_title, p_content, p_filename, p_ip, m_idx);
		
		//DB Insert
		int res = PhotoDao.getInstance().insert(vo);
		
		 return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet

	}
	
	@RequestMapping("/photo/insert_form.do")
	
	public String insert_form(HttpServletRequest request, HttpServletResponse response) {

		return "photo_insert_form.jsp";

	}
	
	@RequestMapping("/photo/photo_one.do")
	@ResponseBody
	public String photo_one(HttpServletRequest request, HttpServletResponse response) {
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));// 값을 p_idx로 파라미터로 넘어온 값은스트링으로 넘어오니깐 정수로 변
		
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);// dao 에 있는 selectone 메소드를 활용하고 sql문을 활용하여 db에 있는 값을 가져
		
		//자바객체정보 => JSON Data로 변환
		String json = vo.toJSONString();
		
		//전송타입 지정
		response.setContentType("text/json; charset=utf-8;");
		
		return json;

	}
	
	@RequestMapping("/photo/modify_form.do")
	public String modify_form(HttpServletRequest request, HttpServletResponse response) {
		
		//1.parameter받기
		int p_idx =Integer.parseInt(request.getParameter("p_idx"));
		
		
		//2.PhotoVo구하기
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		// p_content :  <br> => "\r\n"
		String p_content = vo.getP_content().replace("<br>", "\r\n");
		
		//3.request binding
		request.setAttribute("vo", vo);
		
		return "photo_modify_form.jsp";

	}
	
	@RequestMapping("/photo/modify.do")
	public String modify(HttpServletRequest request, HttpServletResponse response) {
		
		int p_idx 		= Integer.parseInt(request.getParameter("p_idx"));
		int m_idx 		= Integer.parseInt(request.getParameter("m_idx"));
		String p_title  = request.getParameter("p_title");
		//2-1 p_content : "\r\n" =>  <br>  
		String p_content = request.getParameter("p_content").replaceAll("\r\n","<br>");
		//2-2 IP	
		String p_ip     = request.getRemoteAddr();
		
		//PhotoVo 포장
		PhotoVo vo = new PhotoVo(p_idx, p_title, p_content, p_ip, m_idx);
		
		
		//DB update
		int res = PhotoDao.getInstance().update(vo);
		
		return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet

	}
}

package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CommentDao;
import vo.CommentVo;

@Controller
@RequestMapping("/comment/")
public class CommentController {
	
	@Autowired
	HttpServletRequest request;
	
	CommentDao comment_dao;

	
	public void setComment_dao(CommentDao comment_dao) {
		this.comment_dao = comment_dao;
	}


	//게시물(b_idx)별 조회
	@RequestMapping("list.do")
	public String list(int b_idx, Model model){
		
		List<CommentVo> list = comment_dao.selectList(b_idx);
		
		model.addAttribute("list",list);
		
		return "comment/comment_list";
	}
	
	
	// /comment/insert.do?c_content=댓글내용&b_idx=3&m_idx=1&m_name=홍길동
	@RequestMapping("insert.do")
	@ResponseBody
	public Map insert(CommentVo vo) {
		
		String c_content = vo.getC_content().replaceAll("\r\n", "<br>");
		vo.setC_content(c_content);
		
		String c_ip = request.getRemoteAddr();
		vo.setC_ip(c_ip);
		
		int res = 0;
		
		try {
			res = comment_dao.insert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Map => JSON코드로 변환
		Map map = new HashedMap();
		
		map.put("result", (res==1) ? "success": "fail"); //{"result":"success"}
		
		return map;
		
	}
}

package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberModifyAction
 */
//@WebServlet("/member/modify.do")
public class X_MemberModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.수신인코딩설정
		request.setCharacterEncoding("utf-8");
		
//		2.parameter받기
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
		
		//6.메인화면
		response.sendRedirect("list.do");
		
		
	}

}

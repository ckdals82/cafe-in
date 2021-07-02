package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
//@WebServlet("/member/modify_form.do")
public class X_MemberModifyfomAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /member/modify_form.do?m_idx=5
		
		//1.parameter받기
		int m_idx =Integer.parseInt(request.getParameter("m_idx"));
		
		//2.m_idx에 대한 MemberVo를 얻어오기
		MemberVo vo= MemberDao.getInstance().selectOne(m_idx);
		
		//3.request binding
		request.setAttribute("vo", vo);
		
		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "member_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}


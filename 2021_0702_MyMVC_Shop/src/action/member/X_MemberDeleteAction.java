package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

/**
 * Servlet implementation class MemberDeleteAction
 */

// 여기 / 이렇게 놔구고 코딩하면 안된다고....

//@WebServlet("/member/delete.do")
public class X_MemberDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//member/delets.do?m_idx=4
		
		
		// 1. parameter받기
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));

		// 2. DB delete
		int res = MemberDao.getInstance().delete(m_idx);
		
		// 3. ��Ϻ���
		response.sendRedirect("list.do");

	}

}


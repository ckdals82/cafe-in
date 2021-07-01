package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class SungModifyAction
 */
//@WebServlet("/visit/modify.do")
public class X_VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. �������ڵ�����
		request.setCharacterEncoding("utf-8");
		
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
		
		response.sendRedirect("list.do");
	}

}

package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitModifyFormAction
 */
//@WebServlet("/visit/modify_form.do")
public class X_VisitModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. parameter �ޱ�
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 2. idx�� �ش�Ǵ� �Խù� 1�� ������
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		// <br> ~> \r\n
		String content = vo.getContent().replaceAll("<br>", "\r\n");
		
		vo.setContent(content);
		
		// 3. request binding
		request.setAttribute("vo", vo);
		
		
		
		
		
		//Dispatcher(forward) : ���� ���ο��� forward_page ȣ���Ѵ�
		String forward_page = "visit_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

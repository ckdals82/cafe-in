package action.photo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoModifyFormAction
 */
//@WebServlet("/photo/modify_form.do")
public class X_PhotoModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.parameter받기
		int p_idx =Integer.parseInt(request.getParameter("p_idx"));
		
		
		//2.PhotoVo구하기
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		// p_content :  <br> => "\r\n"
		String p_content = vo.getP_content().replace("<br>", "\r\n");
		
		//3.request binding
		request.setAttribute("vo", vo);
		
		

		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "photo_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

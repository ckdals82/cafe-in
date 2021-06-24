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
 * Servlet implementation class SungModifyAction
 */
@WebServlet("/visit/modify.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. 수신인코딩설정
		request.setCharacterEncoding("utf-8");
		
		// 2. parameter 받기
		int    idx      = Integer.parseInt(request.getParameter("idx"));
		String name 	= request.getParameter("name");
		String content	= request.getParameter("content");
		String pwd		= request.getParameter("pwd");
		String ip  		= request.getRemoteAddr();
		
		// 내용에서 \r\n  ~> <br>변환
		content = content.replace("\r\n", "<br>");
				
		// 3. 포장
		VisitVo vo = new VisitVo(idx, name, content, pwd, ip);

		// 4. DB에 update
		int res = VisitDao.getInstance().update(vo);
		
		response.sendRedirect("list.do");
	}

}

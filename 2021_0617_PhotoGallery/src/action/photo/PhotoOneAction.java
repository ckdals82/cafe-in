package action.photo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoOneAction
 */
@WebServlet("/photo/photo_one.do")
public class PhotoOneAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /photo/photo_one.do?p_idx=2
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		//자바객체정보 => JSON Data로 변환
		String json = vo.toJSONString();
		
		//전송타입 지정
		response.setContentType("text/json; charset=utf-8;");
		
		response.getWriter().print(json);
		
		
		
		
	}

}


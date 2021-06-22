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
 * Servlet implementation class PhotoModifyAction
 */
@WebServlet("/photo/modify.do")
public class PhotoModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /photo/modify.do?m_idx=1&p_idx=2&p_title=해커스토익&p_content=영어공부
		//1.수신인코딩설
		request.setCharacterEncoding("utf-8");
		
		//2.parameter받기(눈에 보이는 대로 파라미터 받기)//파일 업로드가 아니라서 request로 받는다.
		
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
		
		//목록보기
		response.sendRedirect("list.do");

	}

}


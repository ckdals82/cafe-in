package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoDeleteAction
 */
@WebServlet("/photo/delete.do")
public class PhotoDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.idx수신(정수변환)
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		//2.photoVo <= p_idx
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		//3.웹경로(상대경로) -? 절대경로를 구함
		String web_path = "/upload";
		String save_dir = request.getServletContext().getRealPath(web_path);
		
		//4.ㅠ파일삭제
		File f = new File(save_dir, vo.getP_filename());
		f.delete();
		
		//5.DB delet(idx)
		int res = PhotoDao.getInstance().delete(p_idx);
		
		//5. 목록보기이동
		response.sendRedirect("list.do");

	}

}

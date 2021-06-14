package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungInsertAction
 */
@WebServlet("/sung/insert.do")
public class SungInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request, //수신처리객체 
			HttpServletResponse response)//응답처리객체
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter받기: name, kor, eng, mat
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));//90이란 문자열을 숫자로 변환한거 파라미터는 다 문자열로들어옴
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		
		//3.SungVo로 포장
		SungVo vo = new SungVo(name, kor, eng, mat);
		
		//4.DB insert
		int res = SungTBDao.getInsteance().insert(vo);
		
		//목록보기 이동 : 현재 요청 클라이언트(Browser)에게 list.do로 다시 재요청해라,,
		response.sendRedirect("list.do");
	}

}


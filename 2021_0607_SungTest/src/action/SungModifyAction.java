package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungModifyAction
 */
@WebServlet("/sung/modify.do")
public class SungModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request, //수신처리객체   
			HttpServletResponse response //응답처리객체
			)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /2021_0607_SungTest/sung/modify.do?no=10&name=홍길동&kor=90&eng=100&mat=88
		
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter받기:   name kor eng mat
		String name = request.getParameter("name");
		int    no   = Integer.parseInt(request.getParameter("no"));
		int    kor  = Integer.parseInt(request.getParameter("kor"));
		int    eng  = Integer.parseInt(request.getParameter("eng"));
		int    mat  = Integer.parseInt(request.getParameter("mat"));
		
		//3.SungVo로 포장
		SungVo vo = new SungVo(no,name, kor, eng, mat);
		
		//4.DB update
		int res = SungTBDao.getInsteance().update(vo);
		
		//5.목록보기 이동 : 현재 요청 클라이언트(Browser)에게 "list.do로 다시 재요청해라" 라는 명령을 응답
		response.sendRedirect("list.do");
		
	

	}

}
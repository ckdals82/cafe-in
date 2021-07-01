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
 * Servlet implementation class VisitCheckPwdAction
 */
//@WebServlet("/visit/check_pwd.do")
public class X_VisitCheckPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		//3.id에 해당되는 객체 1건 가져오기
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		//방법1
		//boolean bResult = vo.getPwd().equals(c_pwd);
		//아래와 같은 의미
		//방법2
		boolean bResult;
		if(vo.getPwd().equals(c_pwd)) {
			//같은경우
			bResult = true;
		}else {
			//틀린경
			bResult = false;
		}
		
		//결과전송
		response.setContentType("text/json; charset=utf-8;");
		
		//결과데이터 생성 : json
		String json = String.format("{\"result\":%b}", bResult);
		
		//전송
		response.getWriter().print(json);
	}
	

}

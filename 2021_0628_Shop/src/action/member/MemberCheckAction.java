package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberCheckAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /member/check_id.do?m_id=hong
		
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받기
		String m_id = request.getParameter("m_id");
		
		//3.DB내에 m_id존재여부 검사
		boolean bResult;
		MemberVo vo = MemberDao.getInstance().selectOne(m_id);
		
		if(vo==null) {//사용가능한 ID
			bResult = true;
		}else {
			//사용중인 ID
			bResult = false;
		}
		//전송타입지정
		response.setContentType("text/json; charest=utf-8;");
		
		//결과-> JSON로 포장
		String json = String.format("{\"result\":%b}", bResult);
		//응답처리
		response.getWriter().print(json);
		
	}

}


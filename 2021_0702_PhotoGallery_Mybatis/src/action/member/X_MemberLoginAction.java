package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class X_MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//member/login.do?m_id=life3&m_pwd=123
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter받기
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		
		//3.m_id에 해당되는 MemberVo 1건 얻어오기
		MemberVo user = MemberDao.getInstance().selectOne(m_id);
		
		if(user==null) { //ID가 없는 경우
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		}
		//비밀번호 비교
		if(user.getM_pwd().equals(m_pwd)==false) {//비밀번호가 틀려서로그인못해~ 
			response.sendRedirect("login_form.do?reason=fail_pwd");
			return;
		}
		//정상적인 로그인 상태
		//현재 user가 사용 할수 있는 session정보 구하기 
		HttpSession session = request.getSession();
		session.setAttribute("user", user);//로그인한 멤버 브이오 정보를 통째로 넣음
		
		//메인화면으로 이동
		//현재위치 : /member/
		//이동위치 : /photo/
		response.sendRedirect("../photo/list.do");
	}

}
//로그인 폼에서 아이디 패스워드 넘겨줌


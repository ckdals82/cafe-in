package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonSajobListAction
 */
@WebServlet("/sawon/sajob_list.do")
public class SawonSajobListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /sawon/sajob_list.do					<= null
		// /sawon/sajob_list.do?sajob			<= ""
		// /sawon/sajob_list.do?sajob=부장		<= 
		//1.수신인코딩
		request.setCharacterEncoding("utf-8");
		
		//2.parameter받기 
		String sajob = request.getParameter("sajob");
		
		//검색조건이 없으면 전체조회
		if(sajob==null || sajob.isEmpty())
			sajob = "all";
		
		
		List<SawonVo> list = null;
		
		if(sajob.equals("all")) {
			//전체조회
			list = SawonDao.getInstance().selectList();
		}else {
			//직급별조회
			list = SawonDao.getInstance().selectList(sajob);
		}
		
		//requst binding
		request.setAttribute("list", list);
		
		
		
		
		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}


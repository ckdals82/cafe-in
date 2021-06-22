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
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /sawon/list.do				<= null
		
		// /sawon/list.do?deptno=		<= ""
		
		// /sawon/list.do?deptno=10 		
		
		int deptno = 0;
		String str_deptno = request.getParameter("deptno");
		
		if(str_deptno!=null && !str_deptno.isEmpty()) //정상적으로 파라메터가 들어왔으면
		   deptno = Integer.parseInt(str_deptno);
		
		List<SawonVo> list = null;
		
		if(deptno==0) {
			//전체조회
			list = SawonDao.getInstance().selectList();
		}else {
			//부서별조회
			list = SawonDao.getInstance().selectList(deptno);
		}
		
		
		//request binding
		request.setAttribute("list", list);
		
		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}


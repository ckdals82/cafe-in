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
 * Servlet implementation class SawonSahireListAction
 */
@WebServlet("/sawon/sapay_list.do")
public class SawonSapayListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sapay =0;
		String str_sapay = request.getParameter("sapay");
		
		if(str_sapay!=null && !str_sapay.isEmpty()) //정상적으로 파라메터가 들어왔으면
			   sapay = Integer.parseInt(str_sapay);
			
			List<SawonVo> list = null;
		
		if(sapay==0) {
			//전체조회
			list = SawonDao.getInstance().selectList();
		}else  {
			
			list = SawonDao.getInstance().selectpayList(sapay);
		}
		
		//request binding
		request.setAttribute("list", list);
		
		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

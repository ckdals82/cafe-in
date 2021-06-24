package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitListAction
 */
@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /visit/list.do
		// /visit/list.do?search=all&search_text=
		// /visit/list.do?search=name&search_text=짱구
		
		//1.수신인코딩
		request.setCharacterEncoding("utf-8");
		
		//2.parameter받기
		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");
		
		if(search==null) search="all";
		
		//검색조건을 담을 객체
		Map <String,String>map = new HashMap<String,String>();
		
		//전체검색이 아니면
		if(!search.equals("all")) {
			if(search.equals("name_content")) {
				map.put("name", search_text);
				map.put("content", search_text);
				
			}else if(search.equals("name")) {
				//이름	 key		value
				map.put("name", search_text);
			}else if(search.equals("content")) {
				//내용	 key		value
				map.put("content", search_text);
			}else if (search.equals("regdate")) {
				//내용	 key		value
				map.put("regdate", search_text);
			}
		}
		
		// 1. ���� ��� ��������     
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		// 2. request binding
		request.setAttribute("list", list);
		
		//Dispatcher (forward) : ���� ���ο��� forward_page ȣ���Ѵ�. 
		String forward_page = "visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

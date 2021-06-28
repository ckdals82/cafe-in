package action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVo;

/**
 * Servlet implementation class ProductListAction
 */
@WebServlet("/product/list.do")
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /product/list.do					  <= null
		// /product/list.do?p_category=com001 <=컴퓨터
		// /product/list.do?p_category=ele002 <=가전제품
		// /product/list.do?p_category=sp003  <=스포츠
		
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2,파라미터받기
		String p_category = request.getParameter("p_category");
		if(p_category==null) p_category="com001";
		
		//3.목록가져오기
		List<ProductVo> list = ProductDao.getInstance().selectList(p_category);
		
		//4.request binding
		request.setAttribute("list", list);
		

		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "product_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}


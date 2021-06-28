package action.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVo;

/**
 * Servlet implementation class ProductViewAction
 */
@WebServlet("/product/view.do")
public class ProductViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	/product/view.do?p_idx=2
		
		//1.p_idx받기
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		//2.p_idx에 해당되는 상품정보 1건 얻어오기
		ProductVo vo = ProductDao.getInstance().selectOne(p_idx);
		
		//3.request binding
		request.setAttribute("vo", vo);
		

		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "product_content.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}


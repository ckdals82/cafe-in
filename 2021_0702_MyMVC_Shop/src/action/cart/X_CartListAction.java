package action.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.CategoryDao;
import vo.CartVo;
import vo.CategoryVo;
import vo.MemberVo;

/**
 * Servlet implementation class CartListAction
 */
//@WebServlet("/product/cart_list.do")
public class X_CartListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//로그인한 유저정보 구하기
		HttpSession session = request.getSession();
		
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		if(user==null) {
			response.sendRedirect("../member/login_form.do?reason=fail_cart");
			return;
		}
		
		List<CartVo> list = CartDao.getInstance().selectList(user.getM_idx());
		
		//카테고리 목록가져오기
		List<CategoryVo> category_list = CategoryDao.getInstance().selectList();
		
		int total_amout = CartDao.getInstance().selectTotalAmount(user.getM_idx());
		
		//request binding
		request.setAttribute("list", list);
		request.setAttribute("total_amount", total_amout);
		request.setAttribute("category_list", category_list);
		
		
		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "cart_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}


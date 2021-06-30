package action.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import vo.CartVo;
import vo.MemberVo;

/**
 * Servlet implementation class CartInsertAction
 */
@WebServlet("/product/cart_insert.do")
public class CartInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /product/cart_insert.do?p_idx=3&m_idx=3
		
		//1.parameter받기
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		//int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		//
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		if(user==null) {
			response.sendRedirect("../member/login_form.do?reason=fail_cart");
			return;
		}
		
		
		
		//2.CartVo포장
		CartVo paramVo = new CartVo();
		paramVo.setP_idx(p_idx);
		paramVo.setM_idx(user.getM_idx());
		
		//3.기등록여부확인
		CartVo vo = CartDao.getInstance().selectOne(paramVo);
		
		String result="";
		if(vo==null) {//미등록 상태
			
			//장바구니 등록작업
			int res = CartDao.getInstance().insert(paramVo);
			
			if(res==1)//res : 처리된행수 1이나오면성공 0이 나오면 실패
			result="cart_success";
			else
			result="cart_fail";
			result = "cart_success";
		}else {// 기등록상태
			result = "cart_exist";
		}
		
		//결과 전송(JSON포장)
		String json = String.format("{\"result\":\"%s\"}", result);

		//전송타입지정
		response.setContentType("text/json; charset=utf-8;");
		//전송
		response.getWriter().print(json);
	}

}


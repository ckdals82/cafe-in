package action.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import annotation.RequestMapping;
import annotation.ResponseBody;
import dao.CartDao;
import dao.CategoryDao;
import vo.CartVo;
import vo.CategoryVo;
import vo.MemberVo;

public class CartController {

	@RequestMapping("/product/cart_update.do")
	public String cart_update(HttpServletRequest request, HttpServletResponse response) {

		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int c_cnt = Integer.parseInt(request.getParameter("c_cnt"));
		
		//CartVo포장
		CartVo vo = new CartVo();
		vo.setC_idx(c_idx);
		vo.setC_cnt(c_cnt);
		
		//DB Update
		int res = CartDao.getInstance().update(vo);
		
		return "cart_list.do";

	}
	
	@RequestMapping("/product/cart_list.do")
	public String cart_list(HttpServletRequest request, HttpServletResponse response) {
		
	HttpSession session = request.getSession();
		
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		if(user==null) {
			
			return "redirect:../member/login_form.do?reason=fail_cart";
		}
		
		List<CartVo> list = CartDao.getInstance().selectList(user.getM_idx());
		
		//카테고리 목록가져오기
		List<CategoryVo> category_list = CategoryDao.getInstance().selectList();
		
		int total_amout = CartDao.getInstance().selectTotalAmount(user.getM_idx());
		
		//request binding
		request.setAttribute("list", list);
		request.setAttribute("total_amount", total_amout);
		request.setAttribute("category_list", category_list);
		
		return "cart_list.jsp";

	}
	
	@RequestMapping("/product/cart_insert.do")
	@ResponseBody
	public String cart_insert(HttpServletRequest request, HttpServletResponse response) {
		
		//1.parameter받기
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		//int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		//
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		if(user==null) {
			
			return "redirect:\"../member/login_form.do?reason=fail_cart\"";
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
			}
			else {// 기등록상태
			result = "cart_exist";
			}
		
		//결과 전송(JSON포장)
		String json = String.format("{\"result\":\"%s\"}", result);

		//전송타입지정
		
		
		return json;

	}
	
	@RequestMapping("/product/cart_delete.do")
	public String cart_delete(HttpServletRequest request, HttpServletResponse response) {

		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		//DB delete
		int res = CartDao.getInstance().delete(c_idx);
		
		return "redirect:list.do";

	}
	
	
}

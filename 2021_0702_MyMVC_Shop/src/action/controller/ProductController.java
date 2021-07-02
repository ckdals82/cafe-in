package action.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import annotation.RequestMapping;
import dao.CategoryDao;
import dao.ProductDao;
import vo.CategoryVo;
import vo.ProductVo;

public class ProductController {
	
	@RequestMapping("/product/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		
		//2,파라미터받기
		String p_category = request.getParameter("p_category");
		if(p_category==null) p_category="com001";
		
		//3.목록가져오기
		List<ProductVo> list = ProductDao.getInstance().selectList(p_category);
		
		//카테고리 목록가져오기
		List<CategoryVo> category_list = CategoryDao.getInstance().selectList();
		
		//4.request binding
		request.setAttribute("list", list);
		request.setAttribute("category_list", category_list);
				
		
		return "product_list.jsp";
	}
	
	@RequestMapping("/product/insert.do")
	public String insert(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		 String web_path = "/images/";
	      
	      ServletContext application = request.getServletContext();
	      String save_dir = application.getRealPath(web_path);
	      
	      int    max_size = 1024 * 1024 * 100;
	      
	      MultipartRequest mr = new MultipartRequest(request,  //수신 처리 객체 (파라미터에 대한 권한 수신에 대한 모든것은 mr에 위임했다)
	               save_dir, //저장 위치
	               max_size, //업로드 최대 용량
	               "utf-8" , //수신 인코딩 
	               new DefaultFileRenamePolicy() //동일파일명 있을시 이름을 변경해서 저장
	               );
	      
	      String p_image_s = "no_file";
	      String p_image_l = "no_file";
	      
	      File f1 = mr.getFile("photo_s");
	      File f2 = mr.getFile("photo_l");
	      
	      if(f1!=null) {
	         p_image_s = f1.getName();
	      }
	      
	      if(f2!=null) {
	         p_image_l = f2.getName();
	      }
	      
	      
	      String p_category = mr.getParameter("p_category");
	      String p_num     = mr.getParameter("p_num");
	      String p_name     = mr.getParameter("p_name");
	      String p_company  = mr.getParameter("p_company");
	      int    p_price     = Integer.parseInt(mr.getParameter("p_price"));
	      int      p_saleprice= Integer.parseInt(mr.getParameter("p_saleprice"));
	      
	      String p_content = mr.getParameter("p_content").replace("\r\n", "<br>");
	      
	      ProductVo vo = new ProductVo(p_category, p_num, p_name, p_company, p_price, p_saleprice, p_image_s, p_image_l, p_content);
	      
	      int res = ProductDao.getInstance().insert(vo);
		
		
	      return "redirect:list.do";//누구에게 알려줬을까유? dispacherServlet

	}
	@RequestMapping("/product/insert_form.do")
	public String insert_form(HttpServletRequest request, HttpServletResponse response) {
		
		//카테고리 목록가져오기
		List<CategoryVo> category_list = CategoryDao.getInstance().selectList();
		
		//4.request binding
		request.setAttribute("category_list", category_list);
		
		return "product_insert_form.jsp";

	}
	
	@RequestMapping("/product/view.do")
	public String view(HttpServletRequest request, HttpServletResponse response) {
		
		//1.p_idx받기
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		//2.p_idx에 해당되는 상품정보 1건 얻어오기
		ProductVo vo = ProductDao.getInstance().selectOne(p_idx);
		
		//카테고리 목록
		List<CategoryVo> category_list = CategoryDao.getInstance().selectList();
		//카테고리 request bindeing
		request.setAttribute("category_list", category_list);
		
		//3.request binding
		request.setAttribute("vo", vo);
		
		return "product_content.jsp";

	}
	
	
}

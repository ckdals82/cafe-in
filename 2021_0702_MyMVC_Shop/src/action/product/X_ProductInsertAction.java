package action.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import vo.ProductVo;

/**
 * Servlet implementation class ProductInsertAction
 */
//@WebServlet("/product/insert.do")
public class X_ProductInsertAction extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
         
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
      
      response.sendRedirect("list.do");
      
      
   }
}
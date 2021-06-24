package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoDeleteAction
 */
@WebServlet("/photo/delete.do")
public class PhotoDeleteAction extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      //  /photo/delete.do?p_idx=5 
      
      //1. parameter 받기
      int p_idx = Integer.parseInt(request.getParameter("p_idx"));

      //2. PhotoVo <= p_idx
      PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
      
      //3. 웹경로(상대경로) => 절대경로 구하기
      
      String web_path = "/upload/";
      String save_dir = request.getServletContext().getRealPath(web_path);
      
      //4. 파일삭제       저장된경로        파일이름
      File f = new File(save_dir, vo.getP_filename());
      f.delete();
      
      //5. DB delete
      int res = PhotoDao.getInstance().delete(p_idx);
      
      //6. 목록보기
      response.sendRedirect("list.do");
      
      
      
      
   }

}
package action;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/all_list.do")
public class SawonAllListAction extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      // /sawon/all_list.do                         
      // /sawon/all_list.do?deptno=0&sajob=사원&sasex=남자 
      
      //1.수신인코딩 
      request.setCharacterEncoding("utf-8");   
      
      //2.parameter받기
      String str_deptno = request.getParameter("deptno");
      String sajob = request.getParameter("sajob");
      String sasex = request.getParameter("sasex");
      
      int deptno = Integer.parseInt(str_deptno);
            
      if(str_deptno==null) deptno = 0;
                  
      if(sajob==null)      sajob = "all";
         
      if(sasex==null)      sasex = "all";
      

      //검색조건을 담을 객체
      Map map = new HashedMap();
      
      if(deptno!=0) {
         map.put("deptno", deptno);
      }
      if(!sajob.equals("all")) {
         map.put("sajob", sajob);
      }
      if(!sasex.equals("all")) {
         map.put("sasex", sasex);
      }
      
      List<SawonVo> list = SawonDao.getInstance().selectList(map);
      
      request.setAttribute("list", list);
      
      //Dispatcher(forward)  : 서버내부에서 forward_page호출한다
      String forward_page = "sawon_list.jsp";
      RequestDispatcher disp = request.getRequestDispatcher(forward_page);
      disp.forward(request, response);

   }

}
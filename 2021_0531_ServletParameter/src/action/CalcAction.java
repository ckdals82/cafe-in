package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, //요청처리객체 client -> server
         HttpServletResponse response //응답처리객체 server -> client
         ) throws ServletException, IOException {
	   
	 
	   
      // TODO Auto-generated method stub
      
      //ms949 => '가' 100
      //utf-8 => '가' 1000
      
//----------Business Logic : Data 처리 로직 
      //1. 수신인코딩 설정(POST시에는 utf-8로 설정) : GET/POST 무관하게 무조건 해라
      request.setCharacterEncoding("utf-8");
      
      //2.parameter구하기		/
      String str_su1 = request.getParameter("su1"); 
      String str_su2 = request.getParameter("su2");
      
      
      
      //정수로 변환
       int su1 = Integer.parseInt(str_su1); 
       //System.out.println(name);
       int su2 = Integer.parseInt(str_su2);
      
       //결과 전송(응답)
       response.setContentType("text/html; charset=utf-8;"); //주의 : 콜론이아니라 세미콜론이다  
       
     //출력(전송:응답)객체 얻어오기
       PrintWriter out = response.getWriter();
       
      
      
      
      //동적으로 HTML 생성
      out.print("<html>");
      out.print("<body>");
      out.printf("%d + %d = %d<br>", su1,su2,(su1+su2));
      out.printf("%d - %d = %d<br>", su1,su2,(su1-su2));
      out.printf("%d * %d = %d<br>", su1,su2,(su1*su2));
      out.print("<tr><td colspan='2' align='center'><a href='input_calc.html'>다시하기</a></td></tr>");
      
      out.print("</div>");
      out.print("</body>");
      out.print("</html>");
      
      
   }

}
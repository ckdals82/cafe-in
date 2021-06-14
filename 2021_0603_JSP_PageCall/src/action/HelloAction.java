package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
//#####Business Logic
      
      // /hello.do         <=null
      // /hello.do?nation=   <=""
      // /hello.do?nation=kor
      // /hello.do?nation=eng
      // 1. 요청접수
      String nation = request.getParameter("nation");
      if(nation==null || nation.isEmpty())
         nation = "kor";
      
      
      // 2. 요청에 따른 데이터 가공
      String nation_name = "기타";
      String greeting_message ="뭐지?";
      
      switch(nation)
      {
         case "kor": nation_name = "한국";
                  greeting_message = "안녕하세요";
                  break;
         
         case "eng": nation_name = "미국";
                  greeting_message = "Hi~ Everyone!";
                  break;
         case "chn": nation_name = "중국";
                  greeting_message="니하오";
                  break;
         case "jpn": nation_name = "일본";
                  greeting_message="곤니찌와";
                  break;
         case "ger": nation_name = "독일";
                  greeting_message="구텐탁";
                  break;
      }
      
      // request binding
      request.setAttribute("nation_name", nation_name);
      request.setAttribute("greeting_message", greeting_message);
      
      
      // Dispatcher (forward)
      RequestDispatcher disp = request.getRequestDispatcher("hello.jsp");
      disp.forward(request, response);// request,response를 hello.jsp와 공유
   }

}
package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanAction
 */
@WebServlet("/gugudan.do")
public class GugudanAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		
		//gugudan.do?dan=5
		
		//1.parameter받기
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		//결과 전송
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		
		out.printf("<h3>[%d]단 보기</h3><br>", dan);
		
		for(int i=1;i<=9; i++) {
			out.printf("%d x %d =%2d<br>", dan , i , dan*i);
		}
	}

}


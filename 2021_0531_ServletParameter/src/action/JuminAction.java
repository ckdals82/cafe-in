package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Jumin;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JuminAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.수신인코딩
		request.setCharacterEncoding("utf-8");
		
		//2.parameter받기
		String jumin_no = request.getParameter("jumin_no");
		
		//3.주민번호 ->부가정보 추출
		Jumin jumin = new Jumin();
		jumin.setJummin_no(jumin_no);
		
		int year 		= jumin.getYear();
		int age 		= jumin.getAge();
		String tti 		= jumin.getTti();
		String gangi 	= jumin.getGanji();
		String season 	= jumin.getSeason();
		String local 	= jumin.getLocal();
		
		//파라미터 출력관련 코드
		response.setContentType("text/html; charset=utf-8;");
		
		//결과전송
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>::::주민번호결과::::</title></head>");
		out.print("<body>");
		out.print("<table border='1' width='400'>");
		out.printf("<tr><th>주민번호</th><td>%s</td></tr>",jumin_no);
		out.printf("<tr><th>출생년도</th><td>%d(%s)</td></tr>",jumin_no);
		out.printf("<tr><th>나이</th><td>%d</td></tr>",jumin_no);
		out.printf("<tr><th>주민번호</th><td>%s</td></tr>",jumin_no);
		out.print("</table>");
		out.print("</body>");
		out.print("<html>");
	}

}

package action;

import java.io.IOException;
import java.io.PrintWriter;

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
	protected void service(
			HttpServletRequest request,	//요청처리객체 : client->server
			HttpServletResponse response//응답처리객체	: server->client
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("helloAction3.x call--");
		//http://localhost:9090/2021_0528_ServletEx2_3x/hello.do?nation=kor
		//http://localhost:9090/2021_0528_ServletEx2_3x/hello.do?nation=jpn
		//http://localhost:9090/2021_0528_ServletEx2_3x/hello.do?nation=chn
		//http://localhost:9090/2021_0528_ServletEx2_3x/hello.do?nation=eng
		//http://localhost:9090/2021_0528_ServletEx2_3x/hello.do?nation=ger
		String nation = request.getParameter("nation");
		//parameter가 없으면 kor을 기본으로 하자
		if(nation==null)
			nation = "kor";
		
		String greet_msg = "[기 타] : 어떤나라일까요?";
		if(nation.equals("kor"))
			greet_msg = "[한국어 인사말] : 안녕하세요!!!";
		else if(nation.equals("eng"))
			greet_msg = "[영어 인사말] : Hi!!!";
		else if(nation.equals("jpn"))
			greet_msg = "[일본어 인사말] : Hi!!!";
		else if(nation.equals("chn"))
			greet_msg = "[중국어 인사말] : Hi!!!";
		else if(nation.equals("ger"))
			greet_msg = "[독일어 인사말] : Hi!!!";
		//결과전송
		
		//전송타입에 대한 정보 전달(mine type)
		response.setContentType("text/html;charset=utf-8;");
		//전송객체
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>각나라 인사말</title></head>");
		out.print("<body>");
		out.print(greet_msg +"<br>");
		out.print("<a href='input_nation.html'>다시하기</a>");
		out.print("</body>");
		out.print("</html>");
		
	}

}

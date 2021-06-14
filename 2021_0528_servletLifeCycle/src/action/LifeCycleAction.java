package action;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleAction
 */
@WebServlet("/lifecycle.do")
public class LifeCycleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleAction() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("-1.LifeCycleAction()");
    }

    
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("--2.init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("4.destroy()");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request,  //client의 요청(정보)를 받아서 처리하는 객체
			HttpServletResponse response //요청한 client에게 응답하는 객체
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--3.service()");
		
		//수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		String msg = request.getParameter("msg");
		
		//요청자 IP
		String ip = request.getRemoteAddr();
		System.out.printf("전달된 메시지는 [%s]\n", ip,msg);
		
		
//		String method = request.getMethod();
//		System.out.println(method);
//		
//		if(method.equals("GET"))
//			doGet(request, response);
//		
//		if(method.equals("POST"))
//			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--3-1.doGet()--");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--3-2.doPost()--");
	}

}

package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//upload.do?title=%EB%B2%84%ED%8A%BC&photo=click_bt.png
//		request.setCharacterEncoding("utf-8"); 필요 없다 왜: 밑에 multipartrequest 에서 처리
		
		String web_path = "/upload/";
		
		//String save_dir = "document:\\upload_data";
		
		//상대경로(웹경로) -> 절대경로로 변경(구해야함)
		//현재 웹application을 관리하는 전역객체
		ServletContext application = request.getServletContext();
		String save_dir = application.getRealPath(web_path);
		
		System.out.println(save_dir);
		
		int	max_size = 1024 * 1024 * 100;//	100MB 업로드 최대용량(초과시 에러)
		
		//화일 업로드시에는 multipartRequest를 이용해서 처리를해야합니다.
		//객체 생성과 동시에 업로드 완료된다.
		MultipartRequest mr = new MultipartRequest(request,//수신처리객체(mr에 위임했다) //파라미터받는 권한을 mr에게 넘겨줬
				                                   save_dir,//저장위치
				                                   max_size,//업로드최대용량
				                                   "utf-8",//수신인코딩
				                                   new DefaultFileRenamePolicy() //동일파일이 있을시 이름을 변경해서 저장
				                                   );
		//업로드된 화일명 얻어오기
		String filename = "no_file";
		//업로드된 화일정보
		File f = mr.getFile("photo");
		if(f!=null) {
			filename = f.getName();
		}
		
		//String title = request.getParameter("title");//절대로 안된다. 이렇게 하면 null떨어짐
		String title = mr.getParameter("title");
		
		//단 클라이언트 IP구하기
		String ip = request.getRemoteAddr();//파라미터 권한만 넘긴거지 나머지 리퀘스트는 정상적으로 쓰면됨
		
		System.out.printf("제목:%s\n",title);
		System.out.printf("화일명:%s\n",filename);
		System.out.printf("아이피:%s\n",ip);
		
		//request binding
		request.setAttribute("filename", filename);
		request.setAttribute("title", title);
		
		
		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "result_upload.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

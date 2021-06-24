package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/insert.do")
public class PhotoInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /photo/insert.do?m_idx1%p_title=제목&p_content=내용&photo=aaa.jpg
		
		//1.웹경로(상대경로) -? 절대경로를 구함
		String web_path = "/upload";
		String save_dir = request.getServletContext().getRealPath(web_path);
		
		System.out.println(save_dir);
		
		//2.업로드 최대 사이즈 지정(byte단위)
		int max_size = 1024 * 1024 * 100; // 100MB
		
		//파일 업로드시에는 멀티파트 리퀘스트를 이용해서 처리
		//객체 생성과 동시에 업로드 완료된다.
		MultipartRequest mr = new MultipartRequest(request,//수신처리객체(mr에 위임했다) //파라미터받는 권한을 mr에게 넘겨줬
									                save_dir,//저장위치
									                max_size,//업로드최대용량
									                "utf-8",//수신인코딩
									                new DefaultFileRenamePolicy() //동일파일이 있을시 이름을 변경해서 저장
									                );
		//업로드된 화일정보 얻어오기
		File f = mr.getFile("photo");
		String p_filename = "no_file";
		if(f != null) {
			p_filename = f.getName();
		}
		
		
		//로그인된 상태의 세션에 저장된 유저정보 얻어오기
//		MemberVo user = (MemberVo)request.getSession().getAttribute("user");
//		int		m_idx = user.getM_idx();
		
		
		//파라미터 수신(mr이용해서 parameter받아야함)
		int    m_idx = Integer.parseInt(mr.getParameter("m_idx"));
		String p_title = mr.getParameter("p_title");
		// \r\n -> <br> 변경
		String p_content = mr.getParameter("p_content").replaceAll("\r\n", "<br>");
		
		//ip 구하기
		String p_ip = request.getRemoteAddr();
		
		
		//PhotoVo 포장
		PhotoVo vo = new PhotoVo(p_title, p_content, p_filename, p_ip, m_idx);
		
		//DB Insert
		int res = PhotoDao.getInstance().insert(vo);
		
		//목록보기
		response.sendRedirect("list.do");
		
		
		
		
		
		
		
	
		
		
	}

}

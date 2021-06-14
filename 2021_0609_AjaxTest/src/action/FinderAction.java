package action;

import java.awt.JobAttributes;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FinderAction
 */
@WebServlet("/finder.do")
public class FinderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, String> wordMap = new HashMap<String, String>();
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
		wordMap.put("html", "HyperText Markup Language");
		wordMap.put("css", "Cascading style sheet");
		wordMap.put("javascript", "Browser제어용 언어");
		wordMap.put("dbcp", "Database Connection Pool");
		wordMap.put("jndi", "Java Naming Directory Interface");
		wordMap.put("ajax", "Asynchrous");
		wordMap.put("먹방", "먹는 방송(김태균이 추천한 단어)");
		wordMap.put("jQuery", "javascript를 쉽게 사용할수 있도록 구현한 라이브러리");
		wordMap.put("bootstrap", "UI구현 라이브러리 :jQuery + 반응형웹");
		wordMap.put("정기덕", "정기덕쿵더러러");
		wordMap.put("장경령", "엘레베이터 섹시가이");
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.수신인코딩설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter수신
		String word = request.getParameter("word");
		
		//3.검색
		String result = wordMap.get(word.toLowerCase());
		
		//검색된 단어가 없을경우
		if(result==null) {
			result = "검색중...";
		}
		//결과전송...
		response.setContentType("text/json; charset=utf-8;");
		//json 데이터 구조 => {key : value}
		//		{"word": "result : "}
		String json = String.format("{\"word\":\"%s\" , \"result\" :\"%s\"}", word,result);
		//System.out.println(json);
		//요청한 클라이언트 에게 결과(JSON)전송
		response.getWriter().print(json);
	}

}

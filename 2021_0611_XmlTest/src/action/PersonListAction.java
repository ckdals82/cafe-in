package action;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import vo.PersonVo;

/**
 * Servlet implementation class PersonListAction
 */
@WebServlet("/person/list.do")
public class PersonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<PersonVo> list = new ArrayList<PersonVo>();
		//Xml parsing
		
		//XML Parser
		try {
			SAXBuilder builder = new SAXBuilder();
			
			URL url = new URL("http://localhost:9090/2021_0611_XmlTest/person.xml");
			
			//XML읽어오기
			Document doc = builder.build(url);
			
			//RootElement얻어오기
			Element root = doc.getRootElement();
			
			//person정보 읽어오기
			List<Element> p_List = root.getChildren("person");
			
			
			for(Element person : p_List) {
			
				String name = person.getChildText("name");
				
				String nickname = person.getChild("name").getAttributeValue("nickname");
				
				int age = Integer.parseInt(person.getChildText("age"));
				String tel = person.getChildText("tel");
				String homtel = person.getChild("tel")
						.getAttributeValue("hometel");
				
				//퍼슨브이오 포장
				PersonVo vo = new PersonVo(name, nickname, age, tel ,homtel);
				
				//ArratList추가
				list.add(vo);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
		
		//request binbing
		request.setAttribute("list", list);
		
		//Dispatcher (forward) : 서버내부에서forward_page호출한다
		String forward_page = "person_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}


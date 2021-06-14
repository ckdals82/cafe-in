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
@WebServlet("/member_register.do")
public class MemberRegisterAction extends HttpServlet {
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
      
      //클라이언트의 IP정보 구하기
      String ip = request.getRemoteAddr();
      
      
      
      //parameter: 전달인자    
      String name = request.getParameter("name"); 
       //System.out.println(name);
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
      String gender = request.getParameter("gender");
      String blood = request.getParameter("blood");
      String profile = request.getParameter("profile");
      
      //parameter 이름이 동일하게 여러개 들어올 경우 배열로 수신
      String [] hobby_array = request.getParameterValues("hobby");
      String [] friend_array = request.getParameterValues("friend");
      
      //취미 : checkbox <= 체크항목만 넘어온다.  <=파라메터가 없을수도 있다.
      String hobby_list = "취미없음";
      
      //취미가 있으면...
      if(hobby_array !=null) {
         //String []hobby_array = {"독서","영화"};
         StringBuffer sb1 = new StringBuffer();
         for(String hobby: hobby_array) {
            sb1.append(hobby);
            sb1.append(" ");
         }
         
         hobby_list = sb1.toString().trim(); //hobby_list =  "독서 영화"
      }
      
      //친구 : input_type ='text' <=무조건 넘어온다
      //String [] friend_array = {'홍길자','박길동',''}; 
      String friend_list ="친구없음";
      StringBuffer sb2 = new StringBuffer();
      for(String friend: friend_array) {
         sb2.append(friend);
         sb2.append(" ");
      }
      
      // friend list = "홍길자 박길동" 
      if(sb2.toString().trim().isEmpty()==false); //비어있지 않으면
         friend_list = sb2.toString().trim();
   
         
         
         
//-------------Presentation Logic : 화면 구성하는 로직 ------------------------------         
      //응답 코드 작성
      //클라이언트측에 응답결과 문서의 종류 및 문자셋정보 전달
      //                   mime type 
      response.setContentType("text/html; charset=utf-8;"); //주의 : 콜론이아니라 세미콜론이다  
      
      //출력(전송:응답)객체 얻어오기
      PrintWriter out = response.getWriter();
      
      //동적으로 HTML 생성
      out.print("<html>");
      out.print("<head><title>:::입력결과:::</title></head>");
      out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
      out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
      out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
      out.print("<style> #box{width : 500px; margin : auto; margin-top : 100px;}</style>");
      out.print("</head>>");
      out.print("<body>");
      out.print("<div id='box'>");
      out.print("<table class='table table-striped' border='0' width='500'>");
      
      out.print("<tr><th>아이피</th><td>");
      out.print(ip);
      out.print("</td></tr>");
      
      out.print("<tr><th>이름</th><td>");
      out.print(name);
      out.print("</td></tr>");
      
      out.print("<tr><th>아이디</th><td>");
      out.print(id);
      out.print("</td></tr>");
      
      out.print("<tr><th>비밀번호</th><td>");
      out.print(pwd);
      out.print("</td></tr>");
      
      out.print("<tr><th>성별</th><td>");
      out.print(gender);
      out.print("</td></tr>");
      
      out.print("<tr><th>혈액형</th><td>");
      out.print(blood);
      out.print("</td></tr>");
      
      out.print("<tr><th>취미</th><td>");
      out.print(hobby_list);
      out.print("</td></tr>");
      
      out.print("<tr><th>친구</th><td>");
      out.print(friend_list);
      out.print("</td></tr>");
      
      out.print("<tr><th>자기소개</th><td>");
      out.print(profile);
      out.print("</td></tr>");
      
      out.print("<tr><td colspan='2' align='center'><a href='input_data.html'>다시하기</a></td></tr>");
      
      out.print("</div>");
      out.print("</body>");
      out.print("</html>");
      
      
   }

}
package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDao;
import vo.MemberVo;

@Controller
@RequestMapping("/member/")
public class MemberController {

   // DispatcherServlet에게 자동으로 넣어달라...요청
   // 1. 해당 컨트롤러가 Auto-Detacting으로 생성되면 자동주입이 된다 
   // 2. 수동생성시 생성코드(<bean>) 위쪽에 <context:annotation-config/> 작성해야 지원된다 
   @Autowired
   HttpSession session;
   
   @Autowired
   HttpServletRequest request;
   
   MemberDao member_dao;

   public void setMember_dao(MemberDao member_dao) {
      this.member_dao = member_dao;
   }
   
   //로그인폼 띄우기 
   @RequestMapping("login_form.do")
   public String login_form() {
      
      return "member/member_login_form";
   }
   
   //로그인
   @RequestMapping("login.do")
   public String login(String m_id,String m_pwd,Model model) {
      
      //메소드의 인자? 의미? : DispatcherServlet에 대한 요청사항
      //Model용도?
      // 1. foward시에는 request binding 시킨다
      // 2. redirect시에는 parameter변수(query)로 이용된다 
      
      //.m_id에 해당되는 MemberVo 1건 얻어오기
      MemberVo user = member_dao.selectOne(m_id);
      
      if(user==null) { //ID가 없는경우
         //return "redirect:login_form.do?reason=fail_id";
         
         model.addAttribute("reason", "fail_id");
         
         return "redirect:login_form.do";
      }
      
      //비밀번호 비교
      if(user.getM_pwd().equals(m_pwd)==false) {   
         //return "redirect:login_form.do?reason=fail_pwd";
         
         model.addAttribute("reason", "fail_pwd");
         
         return "redirect:login_form.do";
      }
      
      session.setAttribute("user", user);
      
      return "redirect:../photo/list.do";
   }
   
   //로그아웃
   @RequestMapping("logout.do")
   public String logout() {
      
      session.removeAttribute("user");
      
      return "redirect:../photo/list.do";
      
   }
   
   //회원목록 읽어오기
   @RequestMapping("list.do")
   public String list(Model model) {
      
      //회원목록 읽어오기 
      List<MemberVo> list = member_dao.selectList();
      
      model.addAttribute("list", list);
      
      return "member_list";
   }
   
   //회원가입
   @RequestMapping("insert.do")
   public String insert(MemberVo vo) {
      
      String m_ip = request.getRemoteAddr();
      vo.setM_ip(m_ip);
      
      // 4.DB insert
      int res = member_dao.insert(vo);
      
      // 5.목록페이지로 이동 : redirect:list.do => response.sendRedirect("list.do")
      return "redirect:login_form.do";
   }
   
   //회원가입폼
   @RequestMapping("insert_form.do")
   public String insert_form() {
      
      return "member/member_insert_form";
   }
   
   //회원수정
   @RequestMapping("modify.do")
   public String modify(MemberVo vo) {
      
      String m_ip = request.getRemoteAddr();
      vo.setM_ip(m_ip);
      
      //DB update
      int res = member_dao.update(vo);
      
      //메인화면...
      return "redirect:list.do";
   }
   
   //회원수정폼
   @RequestMapping("modify_form.do")
   public String modify_form(int m_idx,Model model) {
      
      MemberVo vo = member_dao.selectOne(m_idx);
      
      model.addAttribute("vo", vo);

      return "member/member_modify_form";
   }
   
   //삭제
   @RequestMapping("delete.do")
   public String delete(int m_idx) {
      
      //DB delete
      int res = member_dao.delete(m_idx);
      
      //메인화면...
      return "redirect:list.do";
   }
   
   //아이디체크
   @RequestMapping("check_id.do")
   @ResponseBody
   public Map check_id(String m_id) {
      
      Map map = new HashMap();
      
      //DB내에 m_id존재여부 검사 
      boolean bResult;
      MemberVo vo = member_dao.selectOne(m_id);
         
      if(vo==null) {//사용가능한 ID
         bResult = true;
      }else {
         //사용중인 ID
         bResult = false; 
      }
      map.put("result", bResult);
      
      return map;
   }
   
   
}
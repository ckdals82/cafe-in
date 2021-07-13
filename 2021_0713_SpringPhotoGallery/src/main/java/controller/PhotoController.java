package controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.PhotoDao;
import vo.PhotoVo;

@Controller
@RequestMapping("/photo/")
public class PhotoController {
   
   @Autowired
   ServletContext application;
   
   @Autowired
   HttpServletRequest request;
   
   PhotoDao photo_dao;

   public void setPhoto_dao(PhotoDao photo_dao) {
      this.photo_dao = photo_dao;
   }
   
   @RequestMapping("list.do")
   public String list(Model model) {
      
      List<PhotoVo> list = photo_dao.selectList();
      
      model.addAttribute("list", list);
      
      return "photo/photo_list";
   }
   
   //글쓰기폼
   @RequestMapping("insert_form.do")
   public String insert_form() {

      return "photo/photo_insert_form";
   }
   
   //글쓰기
   // 데이터는 객체로 받고 업로드 파일은 따로 받는다(일반적 방법)
   // /upload2.do?title=캐로로&content=내용입니다&photo=캐로로.jpg
   @RequestMapping("insert.do")
   public String insert(PhotoVo vo, @RequestParam MultipartFile photo) throws Exception {

      // 임시로 저장해 놓은 업로드 파일(MultipartFile photo)을 지정한 위치로 복사해야 한다.
      // 저장할 웹경로
      String web_path = "/resources/upload/";
      // 웹경로->절대경로 얻어온다( 처리객체 : ServletContext application )
      String abs_path = application.getRealPath(web_path);

      // (임시경로에)저장파일명
      String filename = photo.getOriginalFilename();

      // 저장할 파일정보 설정
      File f = new File(abs_path, filename);

      // 동일 파일 여부 체크(동일파일명이 없을때까지 반복)
      while (f.exists()) {// 파일명이 같은 파일 있으면

         long time = System.currentTimeMillis();
         // filename = "87651234511111_a.jpg"
         filename = String.format("%d_%s", time, filename);

         f = new File(abs_path, filename);
      }

      // 업로드된 파일명
      vo.setP_filename(filename);

      // 임시->복사
      photo.transferTo(f);

      // \r\n -> <br> 변경
      String p_content = vo.getP_content().replaceAll("\r\n", "<br>");
      vo.setP_content(p_content);

      // ip 구하기
      String p_ip = request.getRemoteAddr();
      vo.setP_ip(p_ip);
      
      //DB insert
      int res = photo_dao.insert(vo);

      return "redirect:list.do";
   }
   
   //수정폼
   @RequestMapping("modify_form.do")
   public String modify_form(int p_idx,Model model) {

      //2.PhotoVo구하기
      PhotoVo vo = photo_dao.selectOne(p_idx);
      
      //p_content : "<br>" -> "\r\n"
      String content = vo.getP_content().replaceAll("<br>", "\r\n");
      vo.setP_content(content);
      
      model.addAttribute("vo", vo);

      return "photo/photo_modify_form";
   }
   
   //수정
   @RequestMapping("modify.do")
   public String modify(PhotoVo vo) {

      String p_ip = request.getRemoteAddr();
      
      String p_content = vo.getP_content().replaceAll("\r\n", "<br>");
      vo.setP_ip(p_ip);
      vo.setP_content(p_content);
      
      //DB update
      int res = photo_dao.update(vo);
      
      return "redirect:list.do";
   }
   
   //삭제
   @RequestMapping("delete.do")
   public String delete(int p_idx) {
      
      //2.p_idx에 해당되는 PhotoVo얻기
      PhotoVo vo = photo_dao.selectOne(p_idx);
      
      // 저장할 웹경로
      String web_path = "resources/upload/";
      // 웹경로->절대경로 얻어온다( 처리객체 : ServletContext application )
      String abs_path = application.getRealPath(web_path);
      
      //4.파일삭제
      File f = new File(abs_path,vo.getP_filename());
      f.delete();
      
      //5.DB delete
      int res = photo_dao.delete(p_idx);
      
      //6.목록보기이동
      return "redirect:list.do";
   }
   
   //selectOne
   //PersonVo -> JSON 변환
   @RequestMapping("photo_one.do")
   @ResponseBody
   public PhotoVo test_person(int p_idx) {
      
      PhotoVo vo = photo_dao.selectOne(p_idx);
      
      return vo;
   }
   
}
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
   
   @RequestMapping("modify.do")
   public String modify(PhotoVo vo) {
	   
	   
		//2-2 IP	
		String p_ip     = request.getRemoteAddr();
		String p_content = vo.getP_content().replaceAll("\r\n","<br>");
		vo.setP_ip(p_ip);
		vo.setP_content(p_content);
		
		//DB update
		int res = photo_dao.update(vo);
		
		
	   
	   return "redirect:list.do";
   }
   
   @RequestMapping("modify_form.do")
   public String modify_form(int p_idx,Model model) {
	
		
		//2.PhotoVo구하기
		PhotoVo vo = photo_dao.selectOne(p_idx);
		
		// p_content :  <br> => "\r\n"
		String p_content = vo.getP_content().replaceAll("<br>", "\r\n");
		
		//3.request binding
		model.addAttribute("vo",vo);
		
		return "photo/photo_modify_form";
		
	   
   }
   
   @RequestMapping("insert.do")
   public String insert(PhotoVo vo, @RequestParam MultipartFile photo) throws Exception {
      
      
      //웹경로(상대경로) -> 절대경로를 구함
      String web_path = "/resources/upload/";
      String abs_path = application.getRealPath(web_path);
      
      //ip구하기
      String p_ip = request.getRemoteAddr();
      vo.setP_ip(p_ip);
      
      
      //업로드된 파일정보 얻어오기...
      String filename = "no_file";
      
      //업로드된 파일이 있으면
      if(!photo.isEmpty()) {
         //(임시경로에 저장된)저장파일명
         filename = photo.getOriginalFilename();
         
         //저장할 파일정보 설정
         File f = new File(abs_path,filename);
         
         //동일파일 여부 체크(동일파일명이 없을때까지 반복) 
         while(f.exists()) {//같은파일이 있으면
            
            long time = System.currentTimeMillis();
            // filename = "임의의시간_a.jpg";
            filename = String.format("%d_%s", time,filename);
            
            f = new File(abs_path,filename);
         }
         
         //임시 -> 복사
         photo.transferTo(f);
         
      }
      //업로드 파일이름 넣기
      vo.setP_filename(filename);
      
      //DB insert
      int res = photo_dao.insert(vo);
      
      return "redirect:list.do";   
      
   }
   
   
   @RequestMapping("delete.do")
   public String delete(int p_idx) {
	   
	 //2.photoVo <= p_idx
	PhotoVo vo = photo_dao.selectOne(p_idx);
	
	//3.웹경로(상대경로) -? 절대경로를 구함
	String web_path = "/resources/upload/";
	String save_dir = application.getRealPath(web_path);
	
	//4.ㅠ파일삭제
	File f = new File(save_dir, vo.getP_filename());
	f.delete();
	
	//5.DB delet(idx)
	int res = photo_dao.delete(p_idx);
	 		
	   
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
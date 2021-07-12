package com.increpas.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vo.Photo2Vo;
import vo.Photo4Vo;
import vo.Photo5Vo;
import vo.PhotoVo;

@Controller
public class FileUploadController {

	@RequestMapping("/insert_form.do")
	public String insert_form() {
		
		return "insert_form";
	}
	
	//낱개로 받기
	//	/upload1.do?title=캐로로&photo=캐로로.jpg
	
	//@Autowired : 자동엮기( 자동으로 injection시키기 )
	//				해당컨트롤러가 Auto-Detact가 되면 자동연결
	
	//				만약 수동생성되면 수동생성되는 위치의 상단에 다음옵션설정해야한다.
	//				<config-annotation></config-annotation>				
	
	//MainController(dispatcherServlet)에게 요청하면 다 준다.
	
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/upload1.do")
	public String upload1(String title,
						  @RequestParam("photo") MultipartFile photo, String content ,Model model ) throws Exception, IOException {
		
		//임시로 저장해 놓은 업로드 파일(MultipartFile photo)을 지정한 위치로 복사해야 한다.
		//저장할 웹경로 
		String web_path = "/resources/upload/";
		//웹경로->절대경로 얻어온다( 처리객체 : ServeletContext application)
		String abs_path = application.getRealPath(web_path);
		
		//(임시경로에)저장파일명
		String filename = photo.getOriginalFilename();
		
		//저장할 파일정보 설정
		File f = new File(abs_path,filename);
		
		//동일파일여부체크(동일파일명이 없을때까지 반복 ) 
		while(f.exists()) {//있으면 
			
			long time = System.currentTimeMillis();
			//filename = "123456789_a.jpg";
			filename = String.format("%d_%s", time,filename);
			
			f = new File(abs_path,filename);
		}
		
		//임시폴더 ->  복사
		photo.transferTo(f);
		
		//model을 통해서 request binding
		model.addAttribute("title",title);
		model.addAttribute("filename",filename);
		
		return "result_upload1";
	}
	//객체로 받기
	@RequestMapping("/upload2.do")
	public String upload2(PhotoVo vo ,Model model ) throws Exception, IOException {
		
		//임시로 저장해 놓은 업로드 파일(MultipartFile photo)을 지정한 위치로 복사해야 한다.
		//저장할 웹경로 
		String web_path = "/resources/upload/";
		//웹경로->절대경로 얻어온다( 처리객체 : ServeletContext application)
		String abs_path = application.getRealPath(web_path);
		
		//(임시경로에)저장파일명
		String filename = vo.getPhoto().getOriginalFilename();
		
		//저장할 파일정보 설정
		File f = new File(abs_path,filename);
		
		//동일파일여부체크(동일파일명이 없을때까지 반복 ) 
		while(f.exists()) {//있으면 
			
			long time = System.currentTimeMillis();
			//filename = "123456789_a.jpg";
			filename = String.format("%d_%s", time,filename);
			
			f = new File(abs_path,filename);
		}
		//업로드된 파일명
		vo.setFilename(filename);
		
		//임시폴더 ->  복사
		vo.getPhoto().transferTo(f);
		
		//model을 통해서 request binding
		model.addAttribute("vo",vo);
		
		
		return "result_upload2";
	}
	//데이터는 객체로 받고 업로드 파일은 따로 받는다.
	@RequestMapping("/upload3.do")
	public String upload3(Photo2Vo vo ,@RequestParam MultipartFile photo, Model model ) throws Exception, IOException {
		
		//임시로 저장해 놓은 업로드 파일(MultipartFile photo)을 지정한 위치로 복사해야 한다.
		//저장할 웹경로 
		String web_path = "/resources/upload/";
		//웹경로->절대경로 얻어온다( 처리객체 : ServeletContext application)
		String abs_path = application.getRealPath(web_path);
		
		//(임시경로에)저장파일명
		String filename = photo.getOriginalFilename();
		
		//저장할 파일정보 설정
		File f = new File(abs_path,filename);
		
		//동일파일여부체크(동일파일명이 없을때까지 반복 ) 
		while(f.exists()) {//있으면 
			
			long time = System.currentTimeMillis();
			//filename = "123456789_a.jpg";
			filename = String.format("%d_%s", time,filename);
			
			f = new File(abs_path,filename);
		}
		//업로드된 파일명
		vo.setFilename(filename);
		
		//임시폴더 ->  복사
		photo.transferTo(f);
		
		//model을 통해서 request binding
		model.addAttribute("vo",vo);
		
		
		return "result_upload3";
	}
	//멀티파일업로드용
	@RequestMapping("/insert_form2.do")
	public String insert_form2() {
		
		return "insert_form2";
	}
//	/upload1.do?title=캐로로&content=내용입니다&photo=캐로로.jpg&photo=캐로로.jpg
	@RequestMapping("/upload4.do")
	public String upload4(Photo4Vo vo,@RequestParam("photo") MultipartFile [] photo_array, Model model) throws Exception, IOException {
		
	//임시로 저장해 놓은 업로드 파일(MultipartFile photo)을 지정한 위치로 복사해야 한다.
			//저장할 웹경로 
			String web_path = "/resources/upload/";
			//웹경로->절대경로 얻어온다( 처리객체 : ServeletContext application)
			String abs_path = application.getRealPath(web_path);
			
			//이미지 배열을 반복
			for(int i=0;i<photo_array.length;i++) {
				
				MultipartFile photo = photo_array[i];
			
			
			//(임시경로에)저장파일명
			String filename = photo.getOriginalFilename();
			
			//저장할 파일정보 설정
			File f = new File(abs_path,filename);
			
			//동일파일여부체크(동일파일명이 없을때까지 반복 ) 
			while(f.exists()) {//있으면 
				
				long time = System.currentTimeMillis();
				//filename = "123456789_a.jpg";
				filename = String.format("%d_%s", time,filename);
				
				f = new File(abs_path,filename);
			}
			
			//업로드된 파일명
			if(i==0)
			vo.setFilename1(filename);
			else if(i==1)
			vo.setFilename2(filename);
			
			//임시폴더 ->  복사
			photo.transferTo(f);
			}
			
			//결과적으로는 request binding
			model.addAttribute("vo", vo);
			
		return "result_upload4";
	}
	
	//멀티파일업로드용
		@RequestMapping("/insert_form3.do")
		public String insert_form3() {
			
			return "insert_form3";
		}
	
//		/upload1.do?title=캐로로&content=내용입니다&photo=캐로로.jpg&photo=캐로로.jpg
		@RequestMapping("/upload5.do")
		public String upload5(Photo5Vo vo,@RequestParam("photo") List<MultipartFile> photo_list, Model model) throws Exception, IOException {
			
		//임시로 저장해 놓은 업로드 파일(MultipartFile photo)을 지정한 위치로 복사해야 한다.
				//저장할 웹경로 
				String web_path = "/resources/upload/";
				//웹경로->절대경로 얻어온다( 처리객체 : ServeletContext application)
				String abs_path = application.getRealPath(web_path);
				
				//이미지 리스트를 반복
				for(MultipartFile photo : photo_list) {
					
				//(임시경로에)저장파일명
				String filename = photo.getOriginalFilename();
				
				//저장할 파일정보 설정
				File f = new File(abs_path,filename);
				
				//동일파일여부체크(동일파일명이 없을때까지 반복 ) 
				while(f.exists()) {//있으면 
					
					long time = System.currentTimeMillis();
					//filename = "123456789_a.jpg";
					filename = String.format("%d_%s", time,filename);
					
					f = new File(abs_path,filename);
				}
				
				//업로드된 파일명
				vo.getFile_list().add(filename);
				
				//임시폴더 ->  복사
				photo.transferTo(f);
				}
				
				//결과적으로는 request binding
				model.addAttribute("vo", vo);
				
			return "result_upload5";
		}

	
	
}

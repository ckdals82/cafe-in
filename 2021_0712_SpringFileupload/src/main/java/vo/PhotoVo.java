package vo;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVo {
	
	String title;
	String content;
	
	String filename;
	
	//upload된 임시파일을 관리할 spring객체
	MultipartFile photo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	
}

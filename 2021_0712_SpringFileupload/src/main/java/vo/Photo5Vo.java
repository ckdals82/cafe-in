package vo;

import java.util.ArrayList;
import java.util.List;

public class Photo5Vo {
	
	String title;
	String content;
	
	List<String> file_list = new ArrayList<String>();
	


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

	public List<String> getFile_list() {
		return file_list;
	}

	public void setFile_list(List<String> file_list) {
		this.file_list = file_list;
	}


	

	

	
	
}

package vo;

public class PhotoVo {
	int p_idx;
	String p_title;
	String p_content;
	String p_filename;
	String p_ip;
	String p_regdate;
	String p_modifydate;
	int m_idx;
	
	
	
	public PhotoVo(String p_title, String p_content, String p_filename, String p_ip, int m_idx) {
		super();
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_filename = p_filename;
		this.p_ip = p_ip;
		this.m_idx = m_idx;
	}
	public PhotoVo() {
		
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_filename() {
		return p_filename;
	}
	public void setP_filename(String p_filename) {
		this.p_filename = p_filename;
	}
	public String getP_ip() {
		return p_ip;
	}
	public void setP_ip(String p_ip) {
		this.p_ip = p_ip;
	}
	public String getP_regdate() {
		return p_regdate;
	}
	public void setP_regdate(String p_regdate) {
		this.p_regdate = p_regdate;
	}
	public String getP_modifydate() {
		return p_modifydate;
	}
	public void setP_modifydate(String p_modifydate) {
		this.p_modifydate = p_modifydate;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	
	public String toJSONString() {
		//{"key":"value","key","value"}
		StringBuffer sb = new StringBuffer("{");
		
		sb.append(String.format("\"p_idx\":\"%d\",", p_idx));
		sb.append(String.format("\"p_title\":\"%s\",", p_title));
		sb.append(String.format("\"p_content\":\"%s\",", p_content));
		sb.append(String.format("\"p_filename\":\"%s\",", p_filename));
		sb.append(String.format("\"p_ip\":\"%s\",", p_ip));
		sb.append(String.format("\"p_regdate\":\"%s\",", p_regdate));
		sb.append(String.format("\"p_modifydate\":\"%s\",", p_modifydate));
		sb.append(String.format("\"m_idx\":\"%d\"", m_idx));
		
		
		
		sb.append("}");
		return sb.toString();
	}
	
	
}

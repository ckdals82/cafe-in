package vo;

public class MemberVo {

	int    m_idx;
	String m_name;
	String m_id;
	String m_pwd;
	String m_zipcode;
	String m_addr;
	String m_ip;
	String m_regdate;
	String m_modifydate;
	String m_grade;
	
	//password-> 외부출력용
	String m_pwd_mask;
	
	public String getM_pwd_mask() {
		
		//1.original pwd의 1/2만 노출 나머지는 ***
		//             012345  <=index
		//  ex) m_pwd="123456" =>  "123***"
	    //  ex) m_pwd="123456" =>  "12**56"
	    //  ex) m_pwd="123456" =>  "1*3*5*"
		int len  = m_pwd.length();//비번길이
		int half = len/2;
		StringBuffer sb = new StringBuffer();
		
		//방법1)
		/*
		for(int i=0;i<len;i++) {
			if(i<half)
				sb.append(m_pwd.charAt(i));
			else
				sb.append("*");		
		}*/
		
		//방법2)
		sb.append(m_pwd.substring(0, half));
		
		for(int i=0;i<(len-half) ;i++)
			sb.append("*");
		
		
		return sb.toString();
	}
	
	
	public MemberVo() {
		// TODO Auto-generated constructor stub
	}
	//추가
	public MemberVo(String m_name, String m_id, String m_pwd, String m_zipcode, String m_addr, String m_ip,
			String m_grade) {
		super();
		this.m_name = m_name;
		this.m_id = m_id;
		this.m_pwd = m_pwd;
		this.m_zipcode = m_zipcode;
		this.m_addr = m_addr;
		this.m_ip = m_ip;
		this.m_grade = m_grade;
	}
	
	public MemberVo(String m_name, String m_id, String m_pwd, String m_zipcode, String m_addr, String m_ip) {
		super();
		this.m_name = m_name;
		this.m_id = m_id;
		this.m_pwd = m_pwd;
		this.m_zipcode = m_zipcode;
		this.m_addr = m_addr;
		this.m_ip = m_ip;
	}
	//수정
	public MemberVo(int m_idx, String m_name, String m_id, String m_pwd, String m_zipcode, String m_addr, String m_ip,
			String m_grade) {
		super();
		this.m_idx = m_idx;
		this.m_name = m_name;
		this.m_id = m_id;
		this.m_pwd = m_pwd;
		this.m_zipcode = m_zipcode;
		this.m_addr = m_addr;
		this.m_ip = m_ip;
		this.m_grade = m_grade;
	}
	
	
	
	public int getM_idx() {
		return m_idx;
	}
	
	
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_zipcode() {
		return m_zipcode;
	}
	public void setM_zipcode(String m_zipcode) {
		this.m_zipcode = m_zipcode;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public String getM_ip() {
		return m_ip;
	}
	public void setM_ip(String m_ip) {
		this.m_ip = m_ip;
	}
	public String getM_regdate() {
		return m_regdate;
	}
	public void setM_regdate(String m_regdate) {
		this.m_regdate = m_regdate;
	}
	public String getM_modifydate() {
		return m_modifydate;
	}
	public void setM_modifydate(String m_modifydate) {
		this.m_modifydate = m_modifydate;
	}
	public String getM_grade() {
		return m_grade;
	}
	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}
	
	
	
	
	
}

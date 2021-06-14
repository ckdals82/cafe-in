package vo;

//3위일체
// DB Column명 == Vo Property명 == 입력폼 Parameter명
//DTO(Data Transfer Object) : setter/getter
// VO (Value Object)	   : getter
// DTD == VO 동일개념으로 사용해라

public class DeptVo {
	
	int deptno;
	String dname;
	String loc;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}

package vo;

import java.util.List;

public class DeptVo {

	int deptno;
	String dname;
	String loc;
	
	//deptno에 해당되는 사원목록
	List<Sawon2Vo> sa_list;

	
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

	public List<Sawon2Vo> getSa_list() {
		return sa_list;
	}

	public void setSa_list(List<Sawon2Vo> sa_list) {
		this.sa_list = sa_list;
	}
	
	
}

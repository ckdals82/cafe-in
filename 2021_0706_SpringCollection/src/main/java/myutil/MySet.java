package myutil;

import java.util.Set;

public class MySet {
	
	//constructor injection
	Set sido_set;
	
	public MySet() {
		// TODO Auto-generated constructor stub
	}

	public MySet(Set sido_set) {
		super();
		this.sido_set = sido_set;
	}

	public Set getSido_set() {
		return sido_set;
	}

	public void setSido_set(Set sido_set) {
		this.sido_set = sido_set;
	}
	
	
	
}

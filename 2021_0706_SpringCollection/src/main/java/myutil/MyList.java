package myutil;

import java.util.List;

public class MyList {
	
	//setter injection이용해서 넣는다.
	List fruit_list;

	public List getFruit_list() {
		return fruit_list;
	}

	public void setFruit_list(List fruit_list) {
		this.fruit_list = fruit_list;
	}
	
	
}

package vo;

public class PersonVo {
	
	String name;
	int age;
	String tel;
	
	public PersonVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PersonVo(String name, int age, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
	}



	public String getName() {
		System.out.println("--getName()");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}

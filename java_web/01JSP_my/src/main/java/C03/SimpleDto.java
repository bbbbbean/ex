package C03;

public class SimpleDto {
	private String name;
	private Integer age;
	private String addr;
	
	// 생성자
	// 디폴트
	public SimpleDto(){}
	// 모든 인자
	public SimpleDto(String name, Integer age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	// toString
	@Override
	public String toString() {
		return "SimpleDto [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}

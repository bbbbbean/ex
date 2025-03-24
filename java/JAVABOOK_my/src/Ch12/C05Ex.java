package Ch12;

class Employee{
	String name;
	private int age;
	private String addr;
	
	public Employee(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}

class Parttimer extends Employee{
	private int hour_pay;

	public Parttimer(String name, int age, String addr, int hour_pay) {
		super(name,age,addr);
		this.hour_pay = hour_pay;
	}

	public void setHour_pay(int hour_pay) {
		this.hour_pay = hour_pay;
	}

	@Override
	public String toString() {
		return "Parttimer [hour_pay=" + hour_pay + ", name=" + name + "]";
	}

}

class Regular extends Employee{
	private int salary;
	
	public Regular(String name, int age, String addr, int salary) {
		super(name, age, addr);
		this.salary = salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Regular [salary=" + salary + ", name=" + name + "]";
	}


}


public class C05Ex {

	public static void main(String[] args) {
		Parttimer emp1 = new Parttimer("홍길동",25,"대구",20000);
		Regular emp2 = new Regular("서길동",45,"울산",50000000);
		System.out.println(emp1);
		System.out.println(emp2);		
		// 나이, 주소는 private 정보 -> 표시되지 않음
		// 1. private 속성을 protected로 수정 후 출력
		// 2. private는 Employee에서만 접근 가능 -> getter 사용해서 출력(getAge, getAddr)
	}

}

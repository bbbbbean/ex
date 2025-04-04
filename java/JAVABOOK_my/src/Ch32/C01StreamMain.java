package Ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Person{
	protected String name;
	protected int age;
	// 생성자(디폴트, 모든 인자)
	Person() {};
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	// toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	// getter and setter
	public String getName() {
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
}

class Employee extends Person{
	String company;
	String department;
	String role;
	
	// 생성자
	Employee(){};
	Employee(Person person){
		this.name = person.getName();
		this.age = person.getAge();
	};
	
	public Employee(String name, int age) {
		super(name,age);
	}
	public Employee(String company, String department, String role) {
		super();
		this.company = company;
		this.department = department;
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "Employee [company=" + company + ", department=" + department + ", role=" + role + ", toString()="
				+ super.toString() + ", getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}
	
	// getter and setter
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}

public class C01StreamMain {
	public static void main(String[] args) {
		// 컬렉션에 자주 적용
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		
		// filter
		// 반환 자료형 : 스트림 -> 계속해서 스트림 함수를 이어쓸 수 있음
		// 요소 하나하나를 item으로 받음
		// return에는 조건식
		// 반환형을 결정짓지 않으면 계속해서 스트림을 이어나감
		List<Integer> list2 = 
		list.stream().filter((item)->{return item%2==0;})
					 .collect(Collectors.toList());	// 반환형 결정
		System.out.println("짝수들 : "+list2);
		
		// 필터링한 결과로 또다른 연산처리
		// map : 형태 재구성
		List<Integer> list3 = 
		list.stream().filter((item)->{return item%2==0;})
					 .map((item)->{return item*item;})
					 .collect(Collectors.toList());
		System.out.println("Map 적용 : "+list3);
		
		// person class
		// 정렬
		List<Person> list4 =  Arrays.asList(
							new Person("홍길",55),
							new Person("청길동",20),
							new Person("백",80),
							new Person("흑길동동",5)
						);
		// 나이 정렬
		List<Integer> list5 = 
//		list4.stream().map((person)->{return person.getAge();})
//					  .collect(Collectors.toList());
//		list4.stream().map(person -> person.getAge())
//					  .collect(Collectors.toList());
		// 단일 메서드 사용 시 메서드 참조 기호(::)사용 가능
		list4.stream().map(Person::getAge)
					  .sorted((a,b)->{return b-a;})	// 내림차순 <-> a-b : 오름차순
					  .collect(Collectors.toList());
		System.out.println(list5);
		
		// 이름 정렬
		List<Integer> list6 =
		list4.stream()
//					.map((person)->{return null;})
					.map(Person::getName)
					.map(String::length)	// 문자열이 가지는 길이 정보
					.sorted((a,b)->b-a)
					.collect(Collectors.toList());
		System.out.println(list6);
		
		List<Employee> list7 =
		list4.stream()
					//.map((person)->{return new Employee(person.getName(),person.getAge());})	// 길어용
					.map(Employee::new)	// 위 코드를 줄인 거 : person을 받는 생성자가 없어서 호출할 생성자가 없었던 것 -> 지정해주고옴
					.collect(Collectors.toList());
					
		list7.forEach(System.out::println);
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
	}
}

package Ch31;

import java.util.ArrayList;
import java.util.List;

class Person{
	private String name;
	private int age;
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


public class C01Lamda {
	public static void main(String[] args) {
		
		// 람다식
		// ()->{}
		// 인자 형태 맞춰주기 return값 입력하기
		
		// 람다 스트림 : 물줄기가 흐르듯 식을 이어붙여 다양한 기능 사용
		// ()->{}.stream()
		
		List<Person> list = new ArrayList<>();
		list.add(new Person("jung",55));
		list.add(new Person("hong",22));
		list.add(new Person("bang",33));
		
		list.forEach(System.out::println);
		System.out.println("--");
		
		// 정렬
		list.sort((a,b)->{return b.getAge()-a.getAge();});
		list.forEach((item)->{System.out.println(item);});
		
		
		
		
		
	}
}

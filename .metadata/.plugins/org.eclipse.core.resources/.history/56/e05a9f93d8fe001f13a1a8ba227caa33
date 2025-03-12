package Ch17;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person{
	String name;
	int age;
	
	// 생성자
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

	// equals를 재정의해서 name, age가 동일하면 true, 아니면 false
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {			
			Person down = (Person)obj;	// downcasting
			return this.name.equals(down.name) && this.age == down.age;
		}
		return false;
	}

	// hashCode() 재정의 -> hashCode의 동등객체 판단
	@Override
	public int hashCode() {
		return Objects.hash(name,age);
	}
	
	
	
	
}

public class C05SetMain {
	public static void main(String[] args) {
		Set<Person> set = new HashSet();
		
		Person ob1 = new Person("홍길동",55);
		Person ob2 = new Person("남길동",35);
		Person ob3 = new Person("홍길동",55);
		
		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));
		
		set.add(ob1);
		set.add(ob2);
		set.add(ob3);
		
		System.out.println("SIZE : "+set.size());
		// set : 해시값으로 동일 개체인지 판단 -> 내용이 같아도 새객체 생성하면 다른 개체로 인식
		// => 해시값을 조정해 같은 객체로 판단하게 만들기
	}
}

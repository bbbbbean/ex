package Ch10;

class C04Person{
	String name;
	int age;
	// 디폴트 생성자
	public C04Person() {
	}
	// 모든 인자 생성자
	public C04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	// toString 재정의
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}
}


public class C04ClassArrayMain {
	public static void main(String[] args) {
		C04Person list[] = new C04Person[3];
		// C04Person : 클래스 자료형 -> 객체 위치를 담을 수 있는 참조변수형 요소가 됨
		// 객체가 연결이 된 게 아니라 참조 변수가 연결됨 -> 생성자를 이용해 객체와 요소 연결을 해줘야함
		// 클래스 타입 배열은 각 요소에 해당 클래스에 맞는 요소를 만들고 연결해줘야함
		
		list[0]=new C04Person();
		list[0].name="홍길동";
		list[0].age=55;
		
		list[1]=new C04Person();
		list[1].name="김영희";
		list[1].age=35;
		
		list[2]=new C04Person();
		list[2].name="김범수";
		list[2].age=40;
		
		for(C04Person person : list) {
			System.out.println(person);
		}
	}
}

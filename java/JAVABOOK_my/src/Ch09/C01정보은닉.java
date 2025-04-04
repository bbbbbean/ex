package Ch09;

// 민감한 데이터 : private 설정
// 접근 한정자
// 멤버 클래스의 접근 범위 제한을 위한 예약어

// public		: 모든 클래스에서 접근 가능
// private		: 해당 클래스에서만 접근 가능
// protected	: 상속 관계를 가지는 경우에 접근 가능
// default(기본)	: 동일 패키지에 속한 클래스에서 접근 가능

class C01Person{
	private String name;
	private int age;
	String addr;
	
	
	public C01Person(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	// vo	: 읽기 전용
	// dto	: 읽기, 수정 가능
	
	// private 속성을 전제로 함
	// getter 함수 (데이터를 외부로 반환)
	public String getName() {
		return this.name;
	}
	// setter 함수 (기존 데이터를 수정)
	public void setAge(int age) {
		this.age=age;
	}
	// 우클릭 > 소스 > getter, setter 자동 생성
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}


public class C01정보은닉 {
	public static void main(String[] args) {
		
		C01Person person1 = new C01Person("홍길동",17,"대구");
		// private : 생성자를 통해 생성할때부터 데이터를 저장해야함
		
//		person1.name="홍";	// 접근 불가
		// name 내용을 보여주길 원함
		// getter 함수로 접근해 내용을 내보내거나 수정 가능
		System.out.println(person1.getName());
		
//		person1.age=18;	// 접근 불가
		// age 내용을 수정하길 원함
		// setter 함수로 접근해 내용 수정
		person1.setAge(13);
		
	}
}

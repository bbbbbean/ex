package Ch12;


//메서드에 집중
class C08Super{
	
	void func1() {
		System.out.println("C08Super.func1() call");
	}
	void func2() {}
}
class C08Sub extends C08Super{
	
	void func2() {
		System.out.println("C08Sub.func2() call");
	}
	
}


public class C08UpDownCastingMain {
	public static void main(String[] args) {
		// 
		C08Super ob1 = new C08Super();		// No-casting
		ob1.func1();
		
		System.out.println("-------------------------");
		C08Sub ob2 = new C08Sub();			// No-casting
		ob2.func1();
		ob2.func2();
		
		System.out.println("-------------------------");
		C08Super ob3 = new C08Sub();		// Upcasting
		ob3.func1();
		// ob3.func2();		// 접근 불가, 부모 객체는 자식 개체에 접근 불가
		// 함수에 한해 쓸 수 있는 방법이 있음 -> 부모 객체에 해당 함수의 이름만 정의해 자식 함수를 오버라이딩 형태로 만들기
		ob3.func2();
		
		// UpCasting 상태에서
		// 확장된(멤버 추가) 멤버 변수 접근 불가 -> downcasting 후 접근
		// 확장된(멤버 추가) 멤버 함수 접근 불가 -> downcasting 후 접근
		// 재정의된 메서드 접근 가능
		
		
	}
}

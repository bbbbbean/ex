package Ch13;

// 일반 클래스 상속 관계
class Super1{
	void func() {}	// 내용은 없지만 구조가 맞으면 완성된 함수 취급
}
class Sub1 extends Super1{
	// 아래 메서드 없어도 error 발생 X
	void func() {System.out.println("Overrided-Sub1.func() call");}	 // func 재정의
}


// 추상 클래스 상속 관계
abstract class Super2{	// 클래스 명에도 abstract 써주기
	abstract void func();	// 미완성된 함수, 의도됨을 알려주기 위해 abstract 붙임
}
class Sub2 extends Super2{	// 추상 클래스의 메서드가 하나라도 빠지면 error 발생

	@Override
	void func() {
		System.out.println("Overrided-Sub2.func() call");
	}	
}

public class C01AbstractMain {
	public static void main(String[] args) {
		// 01
		Super1 ob1 = new Super1();	// 상위 클래스형으로 객체 생성 가능
		Sub1 ob2 = new Sub1();		// 하위 클래스형으로 객체 생성 가능
		Super1 ob3 = new Sub1();	// upcasting 가능
		ob3.func();					// 재정의된 함수 접근 가능
					
		// 02
		// Super2 ob4 = new Super2();	// 상위 클래스형으로 객체 생성 불가
		Sub2 ob5 = new Sub2();			// 하위 클래스형으로 객체 생성 가능 (전제 조건 : 미완성된 함수 완성)
		Super2 ob6 = new Sub2();		// upcasting 가능
		ob6.func();						// 재정의된 함수 접근 가능
		
	}
}

package Ch15;

// 예외를 생성 : throw
// 예외를 던짐 : throws

class A{
	
	public void Ex1() throws NullPointerException {
		System.out.println("Ex1 process..1");
		// throw new NullPointerException("Ex1 Null Exception");	// 예외 직접 생성
		// 예외 발생시 대처
		// 1. 상단 예외 직접 관리하는 try-catch방식
		// 2. 다음 실행창으로 오류를 던지겠다 throws 방식 - 아래로 내려가서 try-catch로 잡아야함
	}
	
}
class B{
	public void Ex2() throws NullPointerException {
		System.out.println("Ex1 process..2");
		throw new NullPointerException("Ex2 Null Exception");	// 예외 직접 생성
	}
}

public class C05ThrowAndThrowsMain {
	public static void main(String[] args) {
		
		System.out.println("실행코드1");
		System.out.println("실행코드2");
		A a = new A();
		B b = new B();
		
		try {
			a.Ex1();
			b.Ex2();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("실행코드3");
		

	}
}

package Ch14;

class A{
	int x;
	int y;
	
	
	@Override
	public String toString() {	// toString 재정의 
		return "A [x=" + x + ", y=" + y + "]";
	}
}


public class C01ObjectMain {
	public static void main(String[] args) {
		
		// object 상속 함수
		// getclass : Reflection기반?
		// notify, notifyAll : 스레드 관련 처리, 비동기 처리를 위한 우선순위 선정을 위해 사용
		
		// toString : 기존 Object에서 상속, 재정의시 해당 toString 출력
		A ob1 = new A();
		System.out.println(ob1);	// Ch14.A@2ff4acd0 : toString 사용한 값 출력
		System.out.println(ob1.toString());	// Ch14.A@2ff4acd0 : 위랑 값 동일한 걸 볼 수 있음
		// toString 재정의시 재정의된 toString으로 출력됨
		
		Object ob2 = new Object();
		System.out.println(ob2);	// java.lang.Object@54bedef2, 
		System.out.println(ob2.toString());	// java.lang.Object@54bedef2 : 위랑 값 동일한 걸 볼 수 있음
		
		// native: 다른 언어에서 만든 함수 땡겨옴

		
		
	}
}

package Ch11;

class C02Simple{
	static int n1;	// 객체가 생기건 말건 일단 만들어져 있는 변수
	int n2;	// 해당 객체가 생성된 이후 공간을 차지하는 변수
	
	void fun1(){	// 일반 멤버 함수 == 문제 없음, 객체가 생성된 이후 함수가 적재됨
		n1=100;
		n2=200;
	}
	static void fun2(){	// class 객체가 생성되기 이전에 적재되어 있음
		n1=100;
		// n2=200;	// 스테틱은 객체 생성 이전부터 정의 -> n2는 아직 정의되지 않은 시점 -> 없는 객체를 정의하려고 해서 오류
	}
	// static 함수에 사용되는 변수 == static변수, 지역 변수(선언 이후 사용가능)
	// 일반 멤버 변수로의 접근은 불가능
}

public class C02StaticMain {
	public static void main(String[] args) {
		
	}
}

package Ch08;

// 멤버 변수		: 클래스 내부에서 - 메서드 영역 바깥에서 생성
//				: 생성된 객체의 개별 정보 저장
	
// 지역 변수		: 동일 클래스로부터 만든 여러 객체 간 공유하는 멤버변수
	
// static 변수	: 메서드 영역 내{}범위에서 생성되는 변수
//				: 매서드 영역 내의 {}범위에서 포함
//				: 파라미터 (==매개 변수), 일반 변수 포함


class C05Simple{	// 상위 중괄호
	int num=10;	// 멤버 변수
	
	void Func1() {	// 하위 중괄호
		System.out.println("Func1's 멤버 변수 num : "+num);
		// 좁은 범위에서 넓은 범위 접근 O
		int num = 5;	// func1에서 새롭게 정의한 num
		System.out.println("Func1's 지역 변수 num : "+num);
		// 안에서 새롭게 정의한 순간 좁은 범위의 변수를 따름
		num++;	// 그냥 호출하면 해당 중괄호 안의 지역변수에 연산
		this.num++;	// this : 멤버 변수에 접근. 멤버 변수와 지역변수를 구분하기 위한 예약어
	}
	// 괄호를 빠져나오면 지역변수 num은 소멸
	
	void Func2() {
		System.out.println("Func2's 멤버 변수 num : "+num);
		if(true) {
			int num=100;	// 중괄호 내에서 생성된 지역 변수
			System.out.println("Func2's if 안 지역 변수 num : "+num);
		}
		System.out.println("Func2's 멤버 변수 num : "+num);
		// 중괄호를 벗어난 시점에서 지역변수에 할당된 공간 소멸
		
		while(num<15) {
			System.out.println("Func2's while 안 멤버 변수 num : "+num);
			int num=7;
			System.out.println("Func2's while 안 지역 변수 num : "+num);
			num++;
		}
		System.out.println("Func2's 멤버 변수 num : "+num);
	}
	
	void Func3(int num) {
		num++;	// 파라미터 안의 num이 증가 -> 일종의 지역변수
		this.num = num;
	}
}


public class C05LocalVarMain {
	public static void main(String[] args) {
		C05Simple obj = new C05Simple();
		obj.Func1();
		obj.Func2();
	}
}

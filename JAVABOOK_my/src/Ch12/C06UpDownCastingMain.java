package Ch12;

class Super{
	int n1;
}

class Sub extends Super{
	int n2;
}


public class C06UpDownCastingMain {
	public static void main(String[] args) {
		
		// NoCasting : 자료형의 일치
		// 부모는 부모, 자식은 자식으로 생성
		Super ob1 = new Super();
		ob1.n1 = 10;
		
		Sub ob2 = new Sub();
		ob2.n1 = 10;
		ob2.n2 = 20;
		
		
		
		// UpCasting : 상위 클래스 참조변수 = 하위 클래스형 객체 / 자동 형변환
		// 하위 : 기존 속성등 삭제 불가, 확장만 가능 -> 확장 == 메모리 영역을 더 잡아먹을 예정 == 더 넓은 범위
		// 상속 관계로 연결된 모든 하위 객체를 연결할 수 있다.
		Super ob3 = new Sub();
		ob3.n1 = 100;
		// ob3.n2 = 200; // 부모는 부모까지만 이해 가능
		
		Super ob4 = ob2;
		ob4.n1 = 100;
		// ob4.n2 = 200;
		
		
		
		// DownCasting : 하위 클래스 참조 변수 = 상위 클래스형 객체 / 강제 형변환
		// UpCasting된 상태에서 확장된 멤버에 접근하기 위한 용도
		// Sub ob5 = ob1;
		// Sub ob5 = (Sub)ob1; // 컴파일러가 못잡는 에러 - runtime error 치명적..
							// 메모리 침범 가능성 때문에 에러 띄움 - 
		Sub ob6 = (Sub)ob3;
		
		
	}
}

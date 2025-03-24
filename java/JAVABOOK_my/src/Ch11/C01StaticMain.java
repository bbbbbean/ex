package Ch11;

// ### 사용 빈도 높음, 잘 알아두기! ###

class C01simple{
	
	static int num1;
	int num2;
	
	// static	: 클래스 내의 멤버에 적용하는 경우
	// 			: 해당 클래스로 객체 생성 시 모든 객체 간 공유되는 멤버로 지정
	// 			: 클래스 이름으로도 static 멤버에 접근이 가능
	
	public C01simple() {
		num1=0;
		num2=0;
	}
	
	public C01simple(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	
	@Override
	public String toString() {
		return "C01simple [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
}


public class C01StaticMain {
	public static void main(String[] args) {
		
		C01simple.num1=100;		// class 이름으로도 접근이 가능하다
		System.out.println(C01simple.num1);	// 100
		
		C01simple ob1 = new C01simple();
		C01simple ob2 = new C01simple();
		// 디폴트 생성자()로 생성시 기본값 0,0
		
		System.out.println(ob1);
		System.out.println(ob2);
		
		System.out.println(C01simple.num1);	// 0
		
	}
}

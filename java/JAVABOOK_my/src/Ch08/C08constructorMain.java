package Ch08;

// 생성자 메서드
// 특수한 형태의 메서드
// 객체 생성시 한번만 호출되는 메서드
// -> 객체 생성에 관여하는 메서드
// 생성된 객체 내에서는 사용이 불가능
// 객체 생성시에 필요한 메모리 공간 형성과 "초기값 부여"에 사용
// 생성자 메서드 이름은 클래스 이름과 동일하며 반환 자료형은 가지지 않는다


// 생성자 함수를 클래스 내에 명시하지 않으면(코드 삽입 X) 컴파일러에 의해 주입되는
// 생성자가 있는데 이를 디폴트 생성자라 한다

// 생성자 코드가 있으면 디폴트 생성자는 추가되지 않음

class C08Simple{
	// 속성
	int n1;
	double n2;
	boolean n3;
	String n4;
	
	C08Simple(){	// 기본 생성자(디폴트 생성자)는 하나 써두는 버릇 들이기
		System.out.println("C08Simple() 생성자 호출 - 디폴트생성자");
	}
	public C08Simple(int n1) {
		this.n1=n1;	// 외부의 값을 내부 멤버 변수로 넣겠다.
		System.out.println("C08Simple(int n1) 생성자 호출");
	}
	public C08Simple(int n1,double n2) {
		this.n1=n1;
		this.n2=n2;
		System.out.println("C08Simple(int n1,double n2) 생성자 호출");
	}
	public C08Simple(int n1,double n2,boolean n3) {
		this.n1=n1;
		this.n2=n2;
		this.n3=n3;
		System.out.println("C08Simple(int n1,double n2,boolean n3) 생성자 호출");
	}
//	public C08Simple(int n1,double n2,boolean n3,String n4) {
//		this.n1=n1;
//		this.n2=n2;
//		this.n3=n3;
//		this.n4=n4;
//		System.out.println("C08Simple(int n1,double n2,boolean n3,String n4) 생성자 호출");
//	}
	// 생성자 함수 오버로딩 가능
	// 자동으로 생성 가능 : 우클릭 - 소스 - constructor using fields
	public C08Simple(int n1, double n2, boolean n3, String n4) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
		System.out.println("C08Simple(int n1,double n2,boolean n3,String n4) 생성자 호출");
	}
	
	
	// to string 재정의
	@Override
	public String toString() {
		return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}
	
	
	
}


public class C08constructorMain {
	public static void main(String[] args) {
		C08Simple ob0 = new C08Simple();	// 기본 생성자(디폴트 생성자) : 외부 인자를 받지 않는 형태
		
		C08Simple ob1 = new C08Simple(10);
		C08Simple ob2 = new C08Simple(10, 10.5);
		C08Simple ob3 = new C08Simple(10, 10.5, true);
		C08Simple ob4 = new C08Simple(10, 10.5, true, "홍길동");
		
		System.out.println(ob1);
		System.out.println(ob2);
		System.out.println(ob3);
		System.out.println(ob4);
		// 변수 초기화 전 : C08Simple [n1=0, n2=0.0, n3=false, n4=null]
		// 기본값 출력
		// false = 0, true = 1
	}
}

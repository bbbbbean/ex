package Ch09;

// this
// 클래스 내에서 사용되는 예약어
// 생성되는 객체의 위치정보(메모리 주소 - 해시코드값)을 확인하는데 사용

// this	: 멤버 변수와 지역 변수 구별에 사용
// this	: 다른 생성자 호출에 사용


class C03Simple{
	int x;
	int y;
	
	C03Simple(){
		this(0,0);	// 세번째 C03Simple 폼. 해당으로 인해 세번째 생성자가 호출됨
		System.out.println("C03Simple()...생성자 호출");
	}
	C03Simple(int x){
		this(x,0);
		System.out.println("C03Simple(int x)...생성자 호출");
		// this.x=x;
	}
	C03Simple(int x, int y){
		System.out.println("C03Simple(int x, int y)...생성자 호출");
		this.x=x;
		this.y=y;
	}
	
	C03Simple getThis() {
		return this;
	}
	
	
}


public class C03This {
	public static void main(String[] args) {
		
		C03Simple ob = new C03Simple();
		System.out.println(ob);				// Ch09.C03Simple@2ff4acd0
		System.out.println(ob.getThis());	// Ch09.C03Simple@2ff4acd0
		
	}
}

package Ch12;

// 각 클래스에 모든 인자를 받는 생성자
// toString
class A{
	int a;

	public A(int a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
}

class B extends A{
	int b;

	public B(int a, int b) {
		super(a);
		this.b = b;
	}

	@Override
	public String toString() {
		return "B [b=" + b + ", a=" + a + "]";
	}	
}

class C extends A{
	int c;

	public C(int a, int c) {
		super(a);
		this.c = c;
	}

	@Override
	public String toString() {
		return "C [c=" + c + ", a=" + a + "]";
	}
}
class D extends B{
	int d;

	public D(int a, int b, int d) {
		super(a, b);
		this.d = d;
	}

	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", a=" + a + "]";
	}

	
	}
class E extends B{
	int e;

	public E(int a, int b, int e) {
		super(a, b);
		this.e = e;
	}

	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", a=" + a + "]";
	}

	
	}
class F extends C{
	int f;

	public F(int a, int c, int f) {
		super(a, c);
		this.f = f;
	}

	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", a=" + a + "]";
	}

	
	}
class G extends C{
	int g;

	public G(int a, int c, int g) {
		super(a, c);
		this.g = g;
	}

	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", a=" + a + "]";
	}

	
	}


public class C07UpDownCastingMain {
	public static void UpDownCastingFunc(A obj,int...arg) {
		// 용도 : A-G 모든 객체를 받아 속성 출력
		// 모든 객체의 공통 객체인 A로 받기
		System.out.println(obj);
		
		
		// Upcasting -> 확장된 멤버에 대한 접근이 불가능
		obj.a = arg[0];
		
		// instanceOf : 현재 전달 받은 obj가 어느 클래스의 것인지 판별
		if(obj instanceof B) {
			B down = (B)obj;		// DownCasting(확장된 멤버에 접근을 하기 위해서)
			down.b = arg[1];
		}
		if(obj instanceof C){
			C down = (C)obj;
			down.c = arg[1];
		}
		if(obj instanceof D){
			D down = (D)obj;
			down.b = arg[1];
			down.d = arg[2];
		}
		if(obj instanceof E){
			E down = (E)obj;
			down.b = arg[1];
			down.e = arg[2];
		}
		if(obj instanceof F){
			F down = (F)obj;
			down.c = arg[1];
			down.f = arg[2];
		}
		if(obj instanceof G){
			G down = (G)obj;
			down.c = arg[1];
			down.g = arg[2];
		}
		
		
		
		
		
		System.out.println(obj);
	}
	
	public static void main(String[] args) {
		
		A ob1 = new A(0);
		B ob2 = new B(0,0);
		C ob3 = new C(0,0);
		D ob4 = new D(0,0,0);
		E ob5 = new E(0,0,0);
		F ob6 = new F(0,0,0);
		G ob7 = new G(0,0,0);
		
		UpDownCastingFunc(ob1,10);		// No-Casting
		UpDownCastingFunc(ob2,10,20);		// UpCasting
		UpDownCastingFunc(ob3,30,40);		// UpCasting
		UpDownCastingFunc(ob4,50,60,70);		// UpCasting
		UpDownCastingFunc(ob5,80,90,100);		// UpCasting
		UpDownCastingFunc(ob6,110,120,130);		// UpCasting
		UpDownCastingFunc(ob7,140,150,160);		// UpCasting
		
	}
}

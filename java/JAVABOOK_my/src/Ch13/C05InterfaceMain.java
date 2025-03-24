package Ch13;

// 다중 상속
// 일반 상속	 : 다중 상속 불가능
// interface : 다중 상속 가능
// interface 쓰는 이유	: 1. 작업 지시서
//					: 2. 결합도를 낮추기 위하여 (#결합도를 낮추고 응집도를 높혀야함 응집도는 캡슐화와 관련)
//					: 3. 강제성



interface A{
	void ab();
}
interface B{
	void ab();
}

class C{
	
}
class D{

}
class E extends C implements A,B{

	@Override
	public void ab() {
		System.out.println("다중상속파트");
	}
	
}



public class C05InterfaceMain {

	public static void main(String[] args) {
		E ob = new E();
		ob.ab();
	}
}

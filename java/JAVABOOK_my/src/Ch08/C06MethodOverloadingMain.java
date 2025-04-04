package Ch08;

// 메소드 오버로딩(overloading)이란 같은 이름의 메소드를 중복하여 정의하는 것을 의미합니다.
// 메서드 이름은 동일하지만 파라미터가 다른 여러 메서드를 만드는 것을 말한다.
// 파라미터의 개수 혹은 자료형이 달라야한다.
// 파라미터가 같고 반환 자료형이 다르면 새로운 함수가 생성됨 -> 오버로딩이 아님
// 함수의 헤더만 건들고있음, 바디는 어떻든 상관 X

// *** 이름은 같게 파라미터는 다양하게 ***


class C06Simple{
	int sum(int x, int y) {
		System.out.println("int sum(int x, int y)");
		return x+y;
	}
//	int sum(int x, int a) {
//		System.out.println("int sum(int x, int y)");
//		return x+y;
//	}
//	이름만 다르면 같은 함수로 취급 -> 자료형이 달라야 함 => 함수 중복
	
	int sum(int x, int y, int z) {
		System.out.println("int sum(int x, int y, int z)");
		return x+y+z;
	}
	
	int sum(double x, double y, double z) {
		System.out.println("int sum(double x, double y, double z)");
		return (int)(x+y+z);
	}
	
	
}

public class C06MethodOverloadingMain {
	public static void main(String[] args) {
		C06Simple obj = new C06Simple();
		
		obj.sum(10,20);
		obj.sum(10,20,30);
		obj.sum(10.5,20.5,30.5);
		
		System.out.println(obj.sum(10,20));
		System.out.println(obj.sum(10,20,30));
		System.out.println(obj.sum(10.5,20.5,30.5));
		C06Simple obj2 = new C06Simple();
	}
}

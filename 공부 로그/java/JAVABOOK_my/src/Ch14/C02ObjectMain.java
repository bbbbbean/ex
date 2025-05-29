package Ch14;

class C02Simple{
	int n;
	C02Simple(int n){
		this.n = n;
	}
	
	@Override	// equals함수 : 기존 위치 값(객체의 메모리주소값) 비교 -> n의 값 비교로 재정의
	public boolean equals(Object obj) {
		// int n에 접근하기 위해 downCasting 필요
		if(obj instanceof C02Simple) {
			C02Simple down = (C02Simple)obj;
			
			return this.n == down.n;
		}
	
		return false;
	}
	
}

public class C02ObjectMain {
	public static void main(String[] args) {
		C02Simple ob1 = new C02Simple(10);
		C02Simple ob2 = new C02Simple(10);
		C02Simple ob3 = new C02Simple(20);
		
		// 위치 값(객체의 메모리주소값) 비교
		// equals(Object obj) : boolean - Object
		// 모든 class = object의 하위 클래스 : 함수가 object를 인자로 받음 => 업캐스팅
		System.out.println(ob1.equals(ob2));	// false, 재정의 equals : true
		System.out.println(ob1.equals(ob3));	// false
		
		System.out.println(ob1);	// Ch14.C02Simple@2ff4acd0
		System.out.println(ob2);	// Ch14.C02Simple@54bedef2
		System.out.println(ob3);	// Ch14.C02Simple@5caf905d
		// 메모리 위치 정보 노출 : 지양 => 해시코드 재정의 필요
		
		
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		System.out.println(str1.equals(str2));	// true, class간의 값 비교
		System.out.println(str1);	// 문자열 class : 본인의 값 출력
		System.out.println(str2);	// 문자열 class : 본인의 값 출력
		
	}
}

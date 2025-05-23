package Ch16;

// class의 종류를 제한하고 싶다면? 상위 부모 클래스 만들어주기 -> 인자에 제한 걸기
class 호빵재료{
	
}

// 속재료 클래스
class 팥 extends 호빵재료{
	@Override
	public String toString() {
		return "팥";
	}	
}
class 슈크림 extends 호빵재료{
	@Override
	public String toString() {
		return "슈크림";
	}
}
class 야채 extends 호빵재료{
	@Override
	public String toString() {
		return "야채";
	}
}
class 민트초코{
	@Override
	public String toString() {
		return "민트초코";
	}
}


class 호빵 <T extends 호빵재료>{	// <T> : 다이아몬드 연산자 : Generic type 지정
	
	private T meterial;
	
	호빵(T meterial){		// 생성자
		this.meterial = meterial;
	}
	
	// toString 재정의
	@Override
	public String toString() {
		return "호빵 [meterial=" + meterial + "]";
	}
}



public class C01GenericMain {
	public static void main(String[] args) {
		
		// General(일반적인 : 어디에나 적용가능한) -> Generic(포괄적이다)
		// 보통의 클래스 : 자료형을 정해주고 시작 < 구체적
		// 제너릭 : <T>로 표시 : 자료형이 정해지지 않음, 그때그때에 맞게 적용 가능 < 포괄적
		
		호빵<팥> ob1 = new 호빵<팥>(new 팥());	// 팥 = 클래스, 새로운 팥 객체를 만들어 넣어준거
		System.out.println(ob1);
		
		호빵<슈크림> ob2 = new 호빵<슈크림>(new 슈크림());
		System.out.println(ob2);
		
		호빵<야채> ob3 = new 호빵<야채>(new 야채());
		System.out.println(ob3);
		
		// 호빵<민트초코> ob4 = new 호빵<민트초코>(new 민트초코());	// 호빵 재료로 포함되지 않았기때문에 실행되지 않음
		// System.out.println(ob4);
	}
}

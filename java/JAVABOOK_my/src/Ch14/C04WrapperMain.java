package Ch14;

public class C04WrapperMain {
	public static void main(String[] args) {
		
		// boxing (기본 자료형 -> Wrapper Class)
		Integer ob1 = new Integer(100); 	// 빗금 : 버전에 따라 작동은 하지만 권장되지 않는 형태 표시
		Integer ob2 = new Integer("100");
		Integer ob3 = Integer.valueOf("300");
		System.out.println(ob1+ob2+ob3);
		// Integer 형태는 기본적으로 연산 가능
		
		// UnBoxing
		int n1 = ob1.intValue();
		int n2 = ob2.intValue();
		int n3 = ob3.intValue();
		System.out.println(n1+n2+n3);
		
		// Auto Boxing
		Integer ob4 = 100;	// 100이 ob4에 들어가는 과정에서 자동으로 Boxing 작업이 일어남
		
		// 원시 타입 == null체크 불가
		// Integer null체크 가능 -> 큰 장점
		// 웬만한 숫자는 Integer로 작업해도 문제 없음
		
		int n4 = ob1 + ob2 + ob3;
		
		
		
		
		
		
	}
}

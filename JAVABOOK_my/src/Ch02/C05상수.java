package Ch02;

public class C05상수 {
	public static void main(String[] args) {
		
		// 리터럴 상수 : 이름 부여X, 상수Pool에 저장, 단순한 수치, 값
		// 심볼릭 상수 : 이름 부여O, final 예약어 사용, 한번 값을 지정하면 수정 불가
		
		// 리터럴 접미사 : 리터럴 상수가 저장되는 자료형을 지정
		// l,L : long 자료형
		// f,F : float 자료형
		
		int a = 'a';
		System.out.println((int)a);		// a의 숫자 값 출력
		System.out.println((char)a);	// 문자도 포함 -> a문자 출력
		
		int n1 = 100;	// 100은 리터럴 상수
		final int n2 = 200;	// n2는 심볼릭 상수 == final 예약어가 붙음, 값 초기화 불가
		n1 = 100;
		// n2 = 100; // The final local variable n2 cannot be assigned. It must be blank and not using a compound assignment
		
		final double PI = 3.14;	// 이름을 부여하는 이유? 계산에 필요하지만 긴 고정 숫자들 : 예시 파이을 쉽게 볼 수 있게
								//					프로그램이 실행되는 동안 변경될 일이 없는 값 : 환경 변수 값들에 사용
		
		double result = PI*4*4;
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

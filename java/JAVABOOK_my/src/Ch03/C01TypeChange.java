package Ch03;

public class C01TypeChange {
	public static void main(String[] args) {
		
		// (자료)형변환
		// 연산시 일치하지 않는 자료형을 일치시키는 작업
		
		// 자동 형변환(암시적 형변환)	: 컴파일러에 의해 자동 형변환, 눈에 보이지 않게 처리
		// 강제 형변환(명시적 형변환)	: 프로그래머에 의해 강제 형변환, 코드로 쳐 눈에 보이게 처리
		
		// 자동 형변환(=)
		// '변수 연산처리'시 범위가 넓은 공간에 작은 값이 대입되는 경우
		// '리터럴 상수 연산처리'시 리터럴 값에 따른 형변환 여부 결정
		// byte > short, char > int > long > float > double
		
		// 작은 공간에 있던 값 > 큰 공간에 대입 : 자료 손실 문제 없음 -> 자동으로 형변환 O
		// 실수냐 정수냐로 범위가 나뉨, long(8)/float(4) 근데? float가 더 크다고 정의됨 > 소수점을 지원하지 않기 때문
		// 변수간 연산처리(대표적인 예 대입) / 리터럴 : 상수풀에 int 박스에 값을 넣음 > 공간 생성 > 공간에 들어갈 수 있는 크기인지 값을 계산(형변환을 자동으로할지 안할지) > 판별 후 변환 대입
		
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println("intValue : "+ intValue);
		
		char charValue = '가';	// byte가 받아낼 수 있는 값을 가진 문자면 byte로 자동 변환됨
		intValue = charValue;	// int에 가의 숫자값 대입
		System.out.println("가의 유니코드 : "+ intValue);
		
		intValue = 50;
		long longValue = intValue;
		System.out.println("longValue : "+ longValue);
		
		longValue = 100;
		float floatValue = longValue;
		System.out.println("floatValue : "+ floatValue);
		
		floatValue = 100.5F;
		double doubleValue = floatValue;
		System.out.println("doubleValue : "+ doubleValue);
		
		
	}
}

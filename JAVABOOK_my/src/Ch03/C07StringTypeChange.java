package Ch03;

public class C07StringTypeChange {
	public static void main(String[] args) {
		
		// --------------------------------------
		// 문자열 + 문자열
		// --------------------------------------
		System.out.println("문자열1" + "문자열2");
		System.out.println("문자열1" + "문자열2");			// 문자열 +문자열
		System.out.println("문자열1" +',' + "문자열2");		// 문자열 + 문자 + 문자열
		System.out.println("문자열1" + 2);				// 문자열 + 숫자 -> 숫자가 문자로 형변환
		System.out.println("문자열" + ',' + '!');
		System.out.println(',' + '!' + "문자열");			// 단일 문자는 숫자로 취급함 -> ,의 숫자값 + !의 숫자값 = 77
		System.out.println(1 + "문자열" + 2);
		System.out.println(1 + 2 + "문자열");				// 3문자열
		System.out.println("문자열1" + "문자열2");
		
		
		
		// --------------------------------------
		// 문자열 -> 숫자열 변환
		// --------------------------------------
		// 문자열 -> 숫자형으로 변환(정수)
		// int n1 = "10";
		
		System.out.println("10"+"20");		// 1020 : 문자열의 연결 취급
		int n1 = Integer.parseInt("10");	// 문자형 데이터를 정수형 데이터로 변환, 원시 타입으로 변환 -> 웹개발코드시 폼으로부터 전달받은 값을 변환
		int n2 = Integer.parseInt("20");
		System.out.println(n1+n2);	// 30
		
		// 문자열 -> 숫자형으로 변환(실수)
		double n3 = Double.parseDouble("10.5");
		double n4 = Double.parseDouble("20.4");
		System.out.println(n3+n4);	// 30.9
		
		short n5 = Short.parseShort("5");
		short n6 = Short.parseShort("6");
		System.out.println(n5+n6);	// 11
		
		
		
		
		
	}
}

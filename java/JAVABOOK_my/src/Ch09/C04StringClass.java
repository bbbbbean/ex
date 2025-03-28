package Ch09;

public class C04StringClass {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		
		// 문자열 출력
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		System.out.println(str1.toString());	// 원래 위치값이 나와야하는데 클래스 차원에서 자동으로 tostring 정의가 이뤄져 문자열 출력
		// 위치 값 출력 - identityHashCode : 해시 코드 확인 메서드
		System.out.printf("%X\n",System.identityHashCode(str1));
		System.out.printf("%X\n",System.identityHashCode(str2));
		System.out.printf("%X\n",System.identityHashCode(str3));
		System.out.printf("%X\n",System.identityHashCode(str4));
		
		// 위치 값만 비교
		System.out.println("위치 값 비교");
		System.out.println("str1 == str2 ? "+(str1==str2));
		System.out.println("str3 == str4 ? "+(str3==str4));
		System.out.println("str1 == str3 ? "+(str1==str3));
		System.out.println("str2 == str4 ? "+(str2==str4));
		
		// 문자 값만 비교
		System.out.println("문자열 비교 : equals");
		System.out.println("str1 == str2 ? "+(str1.equals(str2)));
		System.out.println("str3 == str4 ? "+(str3.equals(str4)));
		System.out.println("str1 == str3 ? "+(str1.equals(str3)));
		System.out.println("str2 == str4 ? "+(str2.equals(str4)));
		
		
		// api : 라이브러리?
	}
}

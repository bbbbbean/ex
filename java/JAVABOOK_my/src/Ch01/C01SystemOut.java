package Ch01;

public class C01SystemOut {
	public static void main(String[] args) {
		
		// System.out.print()
		System.out.print("HELLOWORLD");
//		운영체제.outstream(출력장치, 모니터).기능(내용);
		
		// 탈출 문자
		// \n : 개행, 줄바꿈
		// \b : 백스페이스
		// \t : 탭길이(기본 8칸)만큼 커서 이동
		System.out.print("HELLOWORLD\n");
		System.out.print("HELLOWORLD\b");
		System.out.print("HELLOWORLD\t");
		System.out.print("HELLOWORLD\n");

		
		// System.out.printf();
		// format : 형식, 서식
		// %d	: 10진수 정수 서식문자
		// %f	: 10진수 실수 서식문자
		// %c	: 한문자 서식문자
		// %s	: 문자열 서식문자
		System.out.printf("%d %d %d \n", 10, 20, 30);
		System.out.printf("%f %f %f \n", 10.1, 20.1, 30.1);
		System.out.printf("%c %c %c \n", 'A', 'B', 'C');
		System.out.printf("%s %s %s \n", "this is", "String", "Test");
		System.out.printf("%d.%s : %d\n", 1, "국어", 100);
		// 한번에 여러 자료형들의 값을 표시(입력)해주기 위해 사용
		// 아직 구체적인 값이 정해지지 않은 변수들을 위해 미리 형태를 만들어 둠, 여기에는 정수, 여기에는 실수 이런 처리
		
		
		// System.out.println();
		// 개행문자를 포함시킨 형태의 출력 함수
		System.out.println("HELLOWORLD");
		System.out.println("HELLOWORLD");
		System.out.println("HELLOWORLD");
		System.out.println("HELLOWORLD");
		
		
		
		
	}
}

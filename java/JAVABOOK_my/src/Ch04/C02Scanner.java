package Ch04;

import java.util.Scanner;

public class C02Scanner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("입력된 정수 값 : "+num1);
		
		System.out.println("실수 입력 : ");
		double num2 = sc.nextDouble();
		System.out.println("입력된 실수 값"+num2);
		
		System.out.println("문자열 입력 : ");
		String str1 = sc.next();	// 문자열 입력받기 기능 함수, 띄어쓰기는 포함하지 않는다
		System.out.println("입력된 문자열 : "+str1);
		
		System.out.println("입력 : ");
		String s1 = sc.next();	
		String s2 = sc.next();
		String s3 = sc.next();
		System.out.printf("문자열 : %s %s %s\n",s1,s2,s3);
		// 띄어쓰기 == 문자열 구분
		// 세 단어의 연결(ex주소)를 받고싶으면 상단처럼 3개 필요. 1개만이면 제일 앞 단어만 출력
		
		sc.nextLine(); // 버퍼 비우기
		System.out.println("문자열 입력(띄어쓰기 포함) : ");
		String str2 = sc.nextLine();
		System.out.println("문자열 : " + str2);
		
		
		
		
		
		
	}
}

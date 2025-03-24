package Ch04;

import java.util.Scanner;

public class C03Scanner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("입력 : ");
		String s1 = sc.next();	
		String s2 = sc.next();
		String s3 = sc.next();
		System.out.printf("문자열 : %s %s %s\n",s1,s2,s3);
		// 위의 엔터키(\n)가 버퍼에 남아 있어서 문자가 입력됐다고 인식

		sc.nextLine(); // 버퍼 비우기
		
		System.out.println("문자열 입력(띄어쓰기 포함) : ");
		String str2 = sc.nextLine();
		System.out.println("문자열 : " + str2);
		
		// 버퍼(buffer)란? 완충제
		// 속도차를 해결하기 위함. 버퍼 공간에 데이터들을 모은 뒤 한번에 처리 -> 대신 엔터키 이슈 발생
		// nextline()이 문제
		
		
		
	}
}

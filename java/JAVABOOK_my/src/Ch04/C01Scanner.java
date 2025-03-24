package Ch04;

import java.util.Scanner;

public class C01Scanner {
	public static void main(String[] args) {
		
		// 스트림(stream : 시냇물, 물줄기(단방향성)) -> 데이터의 이동 통로
		// System.in : 표준입력 스트림
		// System.out : 표준출력 스트림
		
		// 키보드(표준입력장치) - system.in - [OS] - system.out - 모니터(표준출력장치)
		// OS내 java app내에서 scanner sc 생성
		
		Scanner sc = new Scanner(System.in);	// 객체 생성과정
		// new Scanner(System.in) : 표준입력 스트림을 연결한 scanner 객체 생성
		// Scanner sc : 생성된 scanner 객체의 위치정보(메모리주소)를 저장한 참조변수 sc
		//	표준입력 스트림에 연결된 scanner 객체를 생성 이후 위치정보를 main stack 영역의 scanner sc 참조변수에 초기화
		
		System.out.println("num1 입력 : ");
		int num1 = sc.nextInt();	// 엔터(\n), 스페이스바
									// 컨+쉬+o : 자동으로 util import
									// 버퍼 공간에 데이터가 남아잇음
		
		System.out.println("num2 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.println("num3 입력 : ");
		int num3 = sc.nextInt();
		
		System.out.println("num4 입력 : ");
		int num4 = sc.nextInt();
		
		int sum = num1+num2+num3+num4;
		System.out.printf("%d + %d + %d + %d = %d \n",num1,num2,num3,num4,sum);
		sc.close();
		
		
	}
}

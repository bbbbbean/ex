package Ch07;

import java.util.Scanner;

public class C04For {
	public static void main(String[] args) {
		
		// 10번 반복 - Hello World
		// 탈출용 변수 : i = 0
		// 특정 조건 만족 시 반복 탈출, 탈출용 조건식 : i<10
		// 탈출용 연산식 : i++
		int i=0;
		System.out.println("while문------------");
		while (i<10) {
			System.out.println("Hello World");
			i++;
		}
		
		// 해당 while문을 for문으로 변환
		// 기본 형태
		// for(탈출용 변수 선언, 탈출용 조건식, 탈출용 연산식){} 
		System.out.println("for문------------");
		for(i=0;i<10;i++) {
			System.out.println("Hello World");
		}
		
		// 1-10까지 합
//		int sum=0;
//		for(i=0;i<10;i++) {
//			sum+=i;
//		}
//		System.out.println(sum);
		
		// 1-n까지 합
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 n을 입력하세요");
//		int n = sc.nextInt();
//		int sum=0;
//		
//		for(i=0;i<=n;i++) {
//			sum+=i;
//		}
//		System.out.println("sum : "+sum);
		
		// n-m까지 합(n<m)
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 n,m을 입력하세요");
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
//		int sum=0;
//		
//		if(n>m) {
//			int tmp = m;
//			m=n;
//			n=tmp;
//		}
//		for(i=n;i<=m;i++) {
//			sum+=i;
//		}
//		System.out.println("sum : "+sum);
		
		// 2단
//		for(i=1;i<=9;i++) {
//			System.out.printf("%d x %d = %d\n",2,i,2*i);
//		}
		
		// n단 (2<=n<=9)
		// 2-9단
		// 2-n단
		// n-m단
		// 별찍기
		
//		*
//		**
//		***
//		****
		for(i=0;i<4;i++) {
			for(int star=0;star<i+1;star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
//		    *
//		   ***
//		  *****
//		 *******

//		int i=0;
//		while(i<4) {
//			//공백
//			int j=0;
//			while(j<3-i) {
//				System.out.print(" ");
//				j++;
//			}
//			//별
//			int k=0;
//			while(k<=2*i) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
		
		// 위의 while문 for문으로 바꿔보기
		for(i=0;i<4;i++) {
			for(int j=0;j<3-i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<=2*i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

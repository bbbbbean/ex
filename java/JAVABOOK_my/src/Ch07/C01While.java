package Ch07;

import java.util.Scanner;

public class C01While {
	public static void main(String[] args) {
		
		// 반복문
		// 조건식을 전제로 함
		
		// 기본 구조
//		int i=0;
//		while(조건식) {
//			조건식이 true인 동안 실행되는 종속 문장(반복 코드)
//			탈출용 연산식(i++, i--)
//		}
		
		// 10번 반복 - Hello World
		// 탈출용 변수 : i = 0
		// 특정 조건 만족 시 반복 탈출, 탈출용 조건식 : i<10
		// 탈출용 연산식 : i++
//		int i=0;
//		while (i<10) {
//			System.out.println("Hello World");
//			i++;
//		}
		
		
		// n번 반복 - Hello World
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		int j=0;
//		while (j<n) {
//			System.out.println("Hello World");
//			j++;
//		}
		
		
		// 1-10까지의 합
//		int i=1;		// 탈출용 변수
//		int sum = 0;	// 누적합 변수
//		while(i<=10) {	// 탈출용 조건식
//			System.out.println("i : "+i);
//			sum = sum+i;
//			i++;		// 탈출용 연산식
//		}
//		System.out.println("sum : "+sum);
		
		// 1-N까지의 합
//		Scanner sc = new Scanner(System.in);
//		
//		int n=sc.nextInt();
//		int i=1;
//		int sum = 0;
//		while(i<=n) {
//			sum = sum+i;
//			i++;
//		}
//		System.out.println(sum);
		
		// N부터 M까지의 합(N<M) - N>=M인 경우 N과 M을 swap하고 진행합니다.
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 두 개를 입력하세요");
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int i=n;
//		int sum = 0;
//		if(m<n) {	// 잘못 입력한 경우 : 시작값(n)이 끝값(m)보다 큰 경우
//			i=m;
//			m=n;
//		}
//		// 강사님 방식
////		if(n>m) {
////			int tmp = n;
////			n = m;
////			m = tmp;
////		}
//		while(i<=m) {
//			sum = sum + i;
//			i++;
//			}
//		System.out.println("합 : " +sum);
		
		
		// N부터 M까지 수중(N<M) 짝수의 합, 홀수의 합을 각각 구해서 출력하세요
		// 예시 )
		// n = 3 (키보드로 입력된 값)
		// m = 7 (키보드로 입력된 값)
		// 짝수의 합 : 10
		// 홀수의 합 : 15
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 두 개를 입력하세요");
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int sum_a=0;
//		int sum_b=0;
//		
//		if(n>m) {
//			int tmp = n;
//			n = m;
//			m = tmp;
//		}
//		int i=n;
//		while(i<=m) {
//			if(i%2==0) {
//				sum_a+=i;
//			}else {
//				sum_b+=i;
//			}
//			i++;
//		}
//		System.out.println("짝수의 합"+sum_a);
//		System.out.println("홀수의 합"+sum_b);
		
		
		// 1-N까지 수 중에 4의 배수를 출력하고 4의 배수가 아닌 나머지의 합을 구하세요
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수를 입력하세요");
//		int n = sc.nextInt();
//		int i=1;
//		int sum=0;
//		
//		while(i<=n) {
//			if(i%4==0) {
//				System.out.println("4의 배수 : "+i);
//			}else {
//				sum += i;
//			}
//			i++;
//		}
//		System.out.println("4의 배수가 아닌 수의 합 : "+sum);
		
		// 구구단 N단을 출력합니다. (2<=N<=9)
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("정수를 입력하세요");
			int n = sc.nextInt();
			int i=1;
			if(2<=n && n<=9) {
				System.out.println(n+"단\n");
				while(i<=9) {
					System.out.printf("%d x %d = %d\n",n,i,n*i);
					i++;
				}
				break;
			}else {
				System.out.println("2~9사이의 정수를 입력해주세요");
			}
		}
		 
//		// 강사님 방식
//		while(n<2 || n>9) {
//			System.out.println("구구단의 범위는 2-9 사이값을 입력해야 합니다.");
//			System.out.println("n입력 : ");
//			n = sc.nextInt();
//		}
//		// 이 방식으로 유효성 검사
		sc.close();
		
		
	}
}

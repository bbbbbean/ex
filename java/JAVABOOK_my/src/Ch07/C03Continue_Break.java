package Ch07;

import java.util.Scanner;

public class C03Continue_Break {
	public static void main(String[] args) {
		
		// 1. break
		// -1을 입력하기 전까지 정수값을 누적하여 합을 구하고 출력
		// 종료값 : -1
		// 결과 : 누적 합
		
//		Scanner sc = new Scanner(System.in);
//		
//		int n;
//		int sum =0;
//		while(true) {	// 무한 루프
//			System.out.println("정수를 입력하세요");
//			n=sc.nextInt();
//			
//			if(n==-1) {	// 탈출용 조건
//				break;	// 가장 가까운 위치의 반복문을 벗어나는데 사용 -> switch라면 해당 문을, while이라면 해당문 탈출
//			}
//			
//			sum+=n;
//		}
//		System.out.println("sum : "+sum);
//		
//		sc.close();
		
		
		// 만약 전체 while문을 벗어나고 싶다면? 1.flag이용(정석)		2. exit을 이용
		// while안에 while을 쓰는건 좋은 코드가 아님 -> 잘 안씀. 알아만 두기
		
		// 1-1. 모든 반복문 탈출 : flag
		// flag는 토글 스위치처럼도 사용
		
		// 2단~9단 출력
		// 7 x 7 =49 출력 이후 모든 반복문 탈출
		
		// 그냥 if문을 쓴다면?
//		int dan = 2;
//		while(dan<10) {
//			System.out.println(dan+"단");
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				// 7 x 7 =49 출력 이후 모든 반복문 탈출
//				if(dan==7 && i==7) {	// 해당만 탈출, 나머지는 그대로 실행
//					break;
//				}
//				i++;
//			}
//			dan++;
//			System.out.println();
//		}
		
		// flag를 사용해 탈출해보기
//		boolean flag = false;	// 특정한 상태 정보를 담아내기 위함
//		int dan = 2;
//		while(dan<10) {
//			System.out.println(dan+"단");
//			
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				// 7 x 7 =49 출력 이후 모든 반복문 탈출
//				if(dan==7 && i==7) {
//					flag=true;
//					break;
//				}
//				i++;
//			}
//			
//			if(flag)
//				break;
//			
//			dan++;
//			System.out.println();
//		}
		
		// 1-2. 모든 반복문 탈출 : exit
//		int dan = 2;
//		
//		Exit:	// 해당 예약어 삽입 후 하단부에서 사용시 전체 반복문 탈출
//		while(dan<10) {
//			System.out.println(dan+"단");
//			
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				// 7 x 7 =49 출력 이후 모든 반복문 탈출
//				if(dan==7 && i==7) {
//					break Exit;
//				}
//				i++;
//			}
//			
//
//			dan++;
//			System.out.println();
//		}
		
		
		
		// 2. Continue
		
		// 1부터 10까지의 수 중에 3의 배수를 제외한 합 출력
		
		int i=1;
		int sum = 0;
		while(i<=10) {
			
			if(i%3==0) {
				i++;
				continue;	// 반복문의 위로 다시 올라감 -> i값 설정이 없다면? 무한 루프에 빠짐, 탈출용 변수가 필요함
			}
			
			System.out.println("i : " +i);
			sum+=i;
			i++;
		}
		System.out.println("sum : "+sum);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

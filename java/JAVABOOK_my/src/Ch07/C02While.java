package Ch07;

import java.util.Scanner;

public class C02While {
	public static void main(String[] args) {
		
		// 2단~9단 출력
//		int dan = 2;
//		while(dan<10) {
//			System.out.println(dan+"단");
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				i++;
//			}
//			dan++;
//			System.out.println();
//		}
		
		
		// 2단~9단 역순 출력 (2x9, 2x8, 2x7 ... )
//		int dan = 2;
//		while(dan<10) {
//			System.out.println(dan+"단");
//			int i=9;
//			while(i>0) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				i--;
//			}
//			dan++;
//			System.out.println();
//		}

		
		// 9단~2단 역순 출력
//		int dan = 9;
//		while(dan>1) {
//			System.out.println(dan+"단");
//			int i=9;
//			while(i>0) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				i--;
//			}
//			dan--;
//			System.out.println();
//		}
		
		
		// 2단~N단 출력
//		Scanner sc = new Scanner(System.in);
//		// n 입력받기
//		System.out.println("정수 n을 입력하세요 : ");
//		int n = sc.nextInt();
//		int dan = 2;
//		while(dan<=n) {
//			System.out.println(dan+"단");
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
//		sc.close();
		
		
		// N단~M단 출력(N<M, N<9, M<9)
//		Scanner sc = new Scanner(System.in);
//		
//		while(true) {
//			// n,m 입력받기
//			System.out.println("정수 두개를 입력하세요");
//			int n = sc.nextInt();
//			int m = sc.nextInt();
//			
//			// 조건 검사
//			if( n<2 || n>9 || m<2 || m>9) {
//				System.out.println("1~9사이의 정수를 입력하세요");
//			}else {	// 제대로 된 수 들어온 경우
//				if(m<n) {	// 끝수가 시작수 보다 작은 경우
//					int tmp=m;
//					m = n;
//					n = tmp;
//				}
//				// 구구단 시작
//				int dan = n;
//				while(dan<=m) {
//					System.out.println(dan+"단");
//					int i=1;	// i 초기화 잘 시켜주기
//					while(i<10) {
//						System.out.printf("%d X %d = %d\n",dan,i,dan*i);
//						i++;
//					}
//					System.out.println();
//					dan++;
//				}
//				break;
//			}
//		}
		
		
		//별찍기(기본높이:4) 홀수값 입력을 전제로함 

		//*****
		//*****
		//*****
		//*****
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수n을 입력하세요");
//		int n = sc.nextInt();
//		int i=0;
//		while(i<n) {
//			int star=0;
//			while(star<5) {
//				System.out.print("*");
//				star++;
//			}
//			System.out.println();
//			i++;
//		}
		
			
		//*
		//**
		//***
		//****
		
		//1단일때 1, 2단일때 2, 3단일때 3
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수n을 입력하세요");
//		int n = sc.nextInt();
//		int i =0;
//		while(i<n) {
//			int star=0;
//			while(star<=i) {
//				System.out.print("*");
//				star++;
//			}
//			System.out.println();
//			i++;
//		}
		
				
		//****
		//***
		//**
		//*
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수n을 입력하세요");
//		int n = sc.nextInt();
//		int i = n;
//		while(i>0) {
//			int star=0;
//			while(star<i) {
//				System.out.print("*");
//				star++;
//			}
//			System.out.println();
//			i--;
//		}
		
//		// 강사님 답
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수n을 입력하세요");
//		int n = sc.nextInt();
//		int i = 0;
//		while(i<n) {
//			int star=0;
//			while(star<n-i) {
//				System.out.print("*");
//				star++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
				
		//   *
		//  ***
		// *****
		//*******
		// 공백3 별1(1*2-1), 공백2 별3(2*2-1), 공백1 별5(3*2-1), 공백0 별7(4*2-1)
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수n을 입력하세요");
//		int n = sc.nextInt();
//		int i = 0;
//		while(i<n) {
//			int space=n;
//			while(space>i+1) {	// 
//				System.out.print(" ");
//				space--;
//			}
//			int star=1;
//			while(star<=i*2+1) {	// 0에서 시작이니까 +1
//				System.out.print("*");
//				star++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		//*******
		// *****
		//  ***
		//   *
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수n을 입력하세요");
//		int n = sc.nextInt();
//		int i = 0;
//		int j = n;
//		while(i<n) {
//			int space=1;
//			while(space<i+1) {
//				System.out.print(" ");
//				space++;
//			}
//			int star=0;
//			while(star<j*2-1) {
//				System.out.print("*");
//				star++;
//			}
//			j--;
//			System.out.println();
//			i++;
//		}
				
			
		//   *
		//  ***
		// *****		
		//*******
		// *****
		//  ***
		//   *
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 n을 입력하세요");
//		int n = sc.nextInt();
//		int i = 0;	// 행 갯수
//		while(i<n) {
//			// 공백 줄어들기
//			int space = n;
//			while(space>i+1) {
//				System.out.print(" ");
//				space--;
//			}
//			// 별 늘어나기
//			int star = 0;
//			while(star<i*2+1) {	// 규칙 : n*2+1개 만큼 별이 찍힘
//				System.out.print("*");
//				star++;
//			}
//			System.out.println();
//			i++;
//		}
//		int j=1;	// 행갯수
//		int x=n;	// 별계산용 횟수
//		while(j<n) {
//			// 공백 늘어나기
//			int space=0;
//			while(space<j) {
//				System.out.print(" ");
//				space++;
//			}
//			// 별 줄어들기
//			int star = 1;	// 첫번째줄 스킵을 위한 1
//			while(star<x*2-2) {
//				System.out.print("*");
//				star++;
//			}
//			System.out.println();
//			x--;
//			j++;
//		}
		
		
		// 강사님 답
//		int i=0;
//		while(i<7) {
//			
//			if(i<4) {
//				int j=0;
//				while(j<3-i) {
//					System.out.print(" ");
//					j++;
//				}
//				int star=0;
//				while(star<=2*i) {
//					System.out.print("*");
//					star++;
//				}
//			}else {
//				int j=0;
//				while(j<i-3) {
//					System.out.print(" ");
//					j++;
//				}
//				int star=0;
//				while(star<13-(2*i)) {
//					System.out.print("*");
//					star++;
//				}
//			}
//			System.out.println();
//			i++;
//		}
		
		Scanner sc = new Scanner(System.in);
		while(true) {	// 홀수만 입력 가능하게 판별위한 루프
			System.out.println("정수를 입력하세요");
			int n = sc.nextInt();
			if(n%2==0) {	// 짝수의 경우
				System.out.println("홀수만 입력 가능합니다.");
			}else {	// 홀수가 들어온 경우
				System.out.println("높이 : "+n);
				int i=0;
				while(i<n) {	// 입력한 수 만큼 줄 출력
					if(i<(n+1)/2) {	// 중심점 잡기
						int space=0;	// 공백
						while(space<(n/2)-i) {
							System.out.print(" ");
							space++;
						}
						int star=0;	// 별
						while(star<2*i+1) {
							System.out.print("*");
							star++;
						}
					}else {
						int space=0;	// 공백
						while(space<=i-((n+1)/2)) {
							System.out.print(" ");
							space++;
						}
						int star=0;		// 별
						while(star<(2*n-1)-(2*i)) {	
							System.out.print("*");
							star++;
						}
					}
					System.out.println();
					i++;
				}
				break;	// 완료 후 종료
			}
		}
		sc.close();
		

				
		//*******
		// *****
		//  ***
		//   *		
		//   *
		//  ***
		// *****		
		//*******
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 n을 입력하세요");
//		int n = sc.nextInt();
//
//		int j=0;	// 행갯수
//		int x=n;	// 별계산용 횟수
//		while(j<n) {
//			// 공백 늘어나기
//			int space=0;
//			while(space<j) {
//				System.out.print(" ");
//				space++;
//			}
//			// 별 줄어들기
//			int star = 0;	// 첫번째줄 스킵을 위한 1
//			while(star<x*2-1) {
//				System.out.print("*");
//				star++;
//			}
//			System.out.println();
//			x--;
//			j++;
//		}
//		int i = 0;	// 행 갯수
//		while(i<n) {
//			// 공백 줄어들기
//			int space = n;
//			while(space>i+1) {
//				System.out.print(" ");
//				space--;
//			}
//			// 별 늘어나기
//			int star = 0;
//			while(star<i*2+1) {	// 규칙 : n*2+1개 만큼 별이 찍힘
//				System.out.print("*");
//				star++;
//			}
//			System.out.println();
//			i++;
//		}
		
		//*******
		// *****
		//  ***
		//   *		
		//  ***
		// *****		
		//*******
		
		// 강사님 답
		// 높이 7일 경우
//		int i = 0;
//		while(i<7) {
//			if(i<4) {
//				int space = 0;
//				while(space<=i-1) {
//					System.out.print(" ");
//					space++;
//				}
//				int star = 0;
//				while(star<=6-(i*2)) {
//					System.out.print("*");
//					star++;
//				}
//				System.out.println();
//				i++;
//			}else {
//				int space = 0;
//				while(space<=5-i) {
//					System.out.print(" ");
//					space++;
//				}
//				int star = 0;
//				while(star<=2*i-6) {
//					System.out.print("*");
//					star++;
//				}
//				System.out.println();
//				i++;
//			}
//		}
		
		// 높이 n일 경우
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			System.out.println("정수 n을 입력하세요");
//			int n = sc.nextInt();
//			if(n%2==0) {
//				System.out.println("홀수를 입력하세요");
//			}else {
//				int i = 0;
//				
//				while(i<n) {
//					if(i<(n+1)/2) {
//						int space = 0;
//						while(space<=i-1) {
//							System.out.print(" ");
//							space++;
//						}
//						int star = 0;
//						while(star<=(n-1)-(i*2)) {
//							System.out.print("*");
//							star++;
//						}
//						System.out.println();
//						i++;
//					}else {
//						int space = 0;
//						while(space<=(n-2)-i) {
//							System.out.print(" ");
//							space++;
//						}
//						int star = 0;
//						while(star<=2*i-(n-1)){
//							System.out.print("*");
//							star++;
//						}
//						System.out.println();
//						i++;
//					}
//				}
//				break;
//			}
//		}
		
		
		
	}
}
 
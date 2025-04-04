package Ch05;

import java.util.Scanner;

public class C01Basic {
	public static void main(String[] args) {
		
		
		//-------------------------
		// 기본 산술 연산자
		//-------------------------
		int a = 10, b = 20, c;
		System.out.println("a+b="+ (a + b));
		System.out.println("a-b="+ (a - b));
		System.out.println("a*b="+ (a * b));
		System.out.println("b/a="+ (b / a)); //나누기 - 몫
		System.out.println("a%b="+ (a % b)); //나누기 - 나머지(1.짝홀수구분, 2.배수구분, 3.자리수제한, 4.끝자리구하기)
		System.out.println("-a="+ -a);
		
		//문제	
//		두수를 입력 받아 두수의 합/차/곱을 출력하는 프로그램을 만들어보세요
//		Scanner 를 사용합니다
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수를 입력하세요");
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(m>n) {
			int tmp = n;
			n=m;
			m=tmp;
		}
		System.out.printf("합 : %d, 차 : %d, 곱 : %d\n",n+m,n-m,n*m);

		
		//-------------------------
		// 대입 연산자
		//-------------------------
		// LV = RV;
		// 공간 = 값(우선 처리);		
		
		//-------------------------
		// 복합 대입 연산자(기본 산술 연산자 + 대입 연산자)
		//-------------------------
		int d = 10;
		d += 10;	// d = d + 10;
		d -= 5;		// d = d-5;
		d *= 3;		// d = d*3;
		System.out.println("d="+d);

		
		
		//-------------------------
		// 비교 연산자(JS와 다르게 3항 불가)
		//-------------------------
		int e = 10;
		int f = 20;
		System.out.println("A == B : "+ (e == f)); // e = f
		System.out.println("A  > B : "+ (e > f));
		System.out.println("A  < B : "+ (e < f));
		System.out.println("A >= B : "+ (e >= f));
		System.out.println("A <= B : "+ (e <= f));
		System.out.println("A != B : "+ (e != f));
		
		
		
		
		//-------------------------
		// 논리 연산자
		//-------------------------
		// AND 연산자	&&	: (true)&&(true) = true , 그외는 거짓
		//				: && 기호를 기준으로 왼/오른쪽 둘 다 true면 true
		// OR 연산자	||	: t||t = t, t||f = t, f||t = t, f||f = f
		//				: ||기호를 기준으로 왼/오른쪽 중 하나만 true면 true
		// ! 연산자		: true면 false, false면 true

		int g=10; int h=20;
		System.out.println((g>=h)&&(g>5));
		System.out.println((g!=h)&&(h>15));
		
		System.out.println((g>=h)||(g>5));
		System.out.println((g!=h)||(h>15));
		System.out.println((g==h)||(g<=5));
		
		System.out.println("false AND false = " + (true && true));
		System.out.println("false AND true = " + (false && true));
		System.out.println("true AND false = " + (true && false));
		System.out.println("true AND true =  " + (false && false));
		
		int num1 = 100;
		int num2 = 200;
		boolean num3 = (num1<100) && (num2++>0);	// 연산자 기준 왼편이 false면 오른편은 실행 X
		System.out.printf("%d %d %b\n",num1,num2,num3);

		
		
		
		//-------------------------
		// 논리 부정 연산자(true를 false로, false를 true로)
		//-------------------------
		boolean play = true;
		System.out.println(play);

		play = !play;
		System.out.println(play);

		play = !play;
		System.out.println(play);
		



		//-------------------------
		// 증감연산자
		//-------------------------
		// ++a(--a) : 전치 연산자 : 먼저 값 1증가(1감소) 이후 다른 연산자 처리
		// a++(a--) : 후치 연산자 : 다른 연산자 처리 먼저 한 후 1증가(1감소)
		
		int i = 10, j = 10, k, l = 0;
		
		k = --i + j++;
		l = i-- + ++j;
		System.out.printf("a=%d , b=%d , c=%d, d=%d", i, j, k, l);
		
	

		//-------------------------
		// 삼항 연산자
		//-------------------------
		// (조건식)? 참인경우 실행코드 : 거짓인경우 실행코드;		
		int score = 85;
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(score + "점은 " + grade + "등급입니다.");
		
	}
}

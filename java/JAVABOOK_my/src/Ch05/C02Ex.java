package Ch05;

import java.util.Scanner;

public class C02Ex {

	public static void main(String[] args) {
		System.out.println("문제1------------------------------------");
		// 1.문제(삼항연산자)
		// 키보드로 국어/영어/수학 점수를 입력 받아 각각의 부분 점수가 40점이상이고
		// 총점수 평균이 70점이상이면 '합격'
		// 미만이면 '불합격'을 출력합니다
		
		Scanner sc = new Scanner(System.in);
		// 점수 입력 받기
		System.out.println("국어 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력하세요 : ");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력하세요 : ");
		int math = sc.nextInt();
		// 한줄로 받아도 O
		// System.out.println("국어/영어/수학 점수를 입력하세요 : ");
		// int kor, eng, math; (한번에 변수 지정 가능)
		// kor =sc.nextInt(); eng =sc.nextInt(); math =sc.nextInt();
		
		// 총 점수 평균 구하기
		// int sum = kor+eng+math;	
		// int aver = sum/3;
		// 평균 점수는 실수일 수 있으니까 double로 진행
		double avg = (double)(kor + eng + math)/3;

		
		// 출력
		String grade = (kor>=40 && eng>=40 && math>=40 && avg>=70)?"합격":"불합격";
		System.out.printf("평균이 %d점입니다. %s입니다.\n",avg,grade);
		
		
		System.out.println("문제2------------------------------------");
		// 2.미니문제(%연산자)
		// 키보드로 부터 정수값 2 를 입력받아
		// 두수의 합이 짝수이면 "짝수입니다"
		// 홀수이면 "홀수입니다" 를 출력하세요~
		
		// 정수 입력받기
		System.out.println("정수 값 1을 입력하세요");
		int num1 = sc.nextInt();
		System.out.println("정수 값 2를 입력하세요");
		int num2 = sc.nextInt();
		
		// 정수 합
		int sum_num = num1 + num2;
		
		// 정수 짝홀 판별
		String result = (sum_num%2==0) ? "짝수" : "홀수";
		
		// 출력
		System.out.println(result+"입니다.");
		
		
		System.out.println("문제3------------------------------------");
		// 3.문제
		// 국어 / 영어 / 수학 점수를 입력받아서
		// 국어 점수가 40점이상
		// 영어 점수가 40점이상
		// 수학 점수가 40점이상이면서 전체평균이 60점이상이면 합격을 출력
		// 아니면 불합격을 출력하세요
		// 삼항연산자와 논리연산자를 이용합니다.
		
		// 점수 입력받기
		System.out.println("국어 점수를 입력하세요");
		int kor3 = sc.nextInt();
		System.out.println("영어 점수를 입력하세요");
		int eng3 = sc.nextInt();
		System.out.println("수학 점수를 입력하세요");
		int math3 = sc.nextInt();
		
		// 평균 구하기
		int sum3 = kor3 + eng3 + math3;
		int aver3 = sum3/3;
		
		// 합불합 판별
		String result3 = (kor3>=40 && eng3>=40 && math3>=40 && aver3>=60)? "합격" : "불합격";
		System.out.println(result3+"입니다.");

		sc.close();
	}

}
    
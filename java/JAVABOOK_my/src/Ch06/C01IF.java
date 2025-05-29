package Ch06;

import java.util.Scanner;

public class C01IF {
	public static void main(String[] args) {
		// 분기문 -> 조건식 잘 짓기~~ 
		
		// ------------------------------------
		// 단순 if문
		// ------------------------------------
//		Scanner sc = new Scanner(System.in);
		
//		System.out.println("나이 : ");
//		int age = sc.nextInt();
//		
//		if(age >= 8) 
//			System.out.println("학교에 다닙니다.");	// 라인이 하나면 중괄호 생략 가능
//		System.out.println("첫번째 IF 코드 블럭 종료");
//		
//		if(age < 8) {
//			System.out.println("학교에 다니지 않습니다.");}
//		System.out.println("두번째 IF 코드 블럭 종료");
//		
//		System.out.println("프로그램을 종료합니다.");
//		sc.close();
		
		// ------------------------------------
		// if-else문
		// ------------------------------------
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("나이 : ");
//		int age = sc.nextInt();
//		
//		if(age >= 8) 
//			System.out.println("학교에 다닙니다.");	// 참
//		else
//			System.out.println("학교에 다니지 않습니다.");	// 거짓
//
//		System.out.println("프로그램을 종료합니다.");
//		sc.close();
		

		
		System.out.println("문제1 풀기");
		// 문제1
		// 정수 한개 값을 입력 받아 3의 배수이면 해당 수를 출력하세요
		// 3의 배수이면서 5의 배수라면 출력 -
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("정수를 입력하세요 : ");
//		int num = sc.nextInt();
//		
//		if(num%3 == 0 && num%5 == 0) {
//			System.out.println(num+"은/는 3과 5의 배수입니다.");
//		}else if(num%3 == 0){
//			System.out.println(num+"은/는 3의 배수입니다.");
//		}else {
//			System.out.println("-");
//		};
//		
//		if(num%3==0) {
//			System.out.println(num+"은/는 3의 배수입니다.");
//			if(num%5==0) {
//				System.out.println(num+"은/는 5의 배수입니다.");
//			}
//		}else {
//			System.out.println("-");
//		};
//		
//		sc.close();
		
		
		System.out.println("문제2 풀기");
		// 문제2
//		Scanner scan = new Scanner(System.in);
		
		// 2-1. 두개의 정수를 입력받아 큰 수 출력
		// 정수 입력받기
//		System.out.println("정수 2개를 입력하세요. (띄어쓰기로 구분) : ");
//		int num1=scan.nextInt();
//		int num2=scan.nextInt();
//		// 큰 수 출력
//		if(num1<num2) {
//			System.out.println(num2+"이/가 더 큰 수입니다.");
//		}else {
//			System.out.println(num1+"이/가 더 큰 수입니다.");
//		};
//		
		
		// 2-2. 세개의 정수를 입력받아 큰 수 출력
		// 정수 입력받기
//		System.out.println("정수 3개를 입력하세요. (띄어쓰기로 구분) : ");
//		int num1=scan.nextInt();
//		int num2=scan.nextInt();
//		int num3=scan.nextInt();
//		// 큰 수 판별
//		if(num2-num3<=0 && num1-num3<=0) {
//			System.out.println(num3+"이/가 가장 큰 수입니다.");
//		}else if(num1-num2<=0 && num2-num3>=0) {
//			System.out.println(num2+"이/가 가장 큰 수입니다.");
//		}else {
//			System.out.println(num1+"이/가 가장 큰 수입니다.");
//		}
		
		// 강사님 답 --------------------------------------------------
		// 세개의 수 -> 임시 공간을 만들어 다 밀어넣고 작업
//		int max = num1; // 최대값이 n1이라 가정하고 시작
//		if(max<num2) {
//			max = num2;
//		}if(max <num3) {
//			max=num3;
//		}
//		System.out.println("큰 수 :"+max);
//		
//		// n1이 제일 큰 경우(n1>n2 && n1>n3)
//		// n2가 제일 큰 경우(n2>n3 && n2>n1)
//		// n3이 제일 큰 경우(n3>n1 && n3>n2)
//		if(num1>=num2 && num1>=num3)
//			System.out.println("큰 수 :"+num1);
//		
//		if(num2>=num1 && num2>=num3)
//			System.out.println("큰 수 :"+num2);
//		
//		if(num3>=num1 && num3>=num2)
//			System.out.println("큰 수 :"+num3);
//		// 문제? 같은 수 입력시 -> if문이 3번 작동해 값이 3번 나옴 --> else if 쓰기
		
		// 2-3. 세개의 정수를 입력받아 해당수의 합과 평균을 출력
//		System.out.println("정수 3개를 입력하세요. (띄어쓰기로 구분) : ");
//		int num1=scan.nextInt();
//		int num2=scan.nextInt();
//		int num3=scan.nextInt();
//		// 합과 평균 출력
//		int sum = num1 + num2 + num3;
//		double aver = (double)sum/3;
//		System.out.println("세 정수의 합은"+sum+"평균은"+aver+"입니다.");
		
		
		// 2-4. 입력한 수가 짝수이고, 3의 배수라면 출력
		// 		입력한 수가 홀수이고, 5의 배수라면 출력
//		System.out.println("정수를 입력하세요. : ");
//		int num=scan.nextInt();
//		
//		if(num%2==0 && num%3==0) {
//			System.out.printf("입력한 수 %d은/는 짝수이고, 3의 배수입니다.\n",num);
//		}else if(num%2==1 && num%5==0) {
//			System.out.printf("입력한 수 %d은/는 홀수이고, 5의 배수입니다.\n",num);
//		}else {
//			System.out.println("-");
//		}
		
//		scan.close();
		
		
		
		// ------------------------------------
		// if - else if - else
		// ------------------------------------
		// 과목 1, 2, 3, 4 중 하나라도 40점 미만이면 불합격
		// 과목 평균이 100전 만점 기준으로 60점 미만이면 불합격
		// 아니라면 합격
		
		Scanner sc = new Scanner(System.in);
		int 과목1 = sc.nextInt();
		int 과목2 = sc.nextInt();
		int 과목3 = sc.nextInt();
		int 과목4 = sc.nextInt();
		double 평균 = (double)(과목1 + 과목2 + 과목3 + 과목4)/4;
		
		if(과목1<40) {
			System.out.println("불합격");
		}else if(과목2<40) {	// 과목1 >= 40 && 과목2 < 40
			System.out.println("불합격");
		}else if(과목3<40) {	// 과목1 >= 40 && 과목2 >= 40 && 과목3 < 40
			System.out.println("불합격");
		}else if(과목4<40) {	// 과목1 >= 40 && 과목2 >= 40 && 과목3 >= 40 && 과목4 < 40
			System.out.println("불합격");
		}else if(평균<60) {	// 과목1 >= 40 && 과목2 >= 40 && 과목3 >= 40 && 과목4 >= 40 && 평균 < 60
			System.out.println("불합격");
		}else {	// 과목1 >= 40 && 과목2 >= 40 && 과목3 >= 40 && 과목4 >= 40 && 평균 >= 60
			System.out.println("합격");
		}
		
		
		System.out.println("문제1");
		Scanner scan = new Scanner(System.in);
		// 문제1
		// 시험 점수를 입력 받아
		// 90~100점은 A
		// 80~89점은 B
		// 70~79점은 C
		// 60~69점은 D
		// 나머지 점수는 F를 출력하라
		
		System.out.println("시험 점수를 입력하세요 : ");
		int num = scan.nextInt();
		
		if(num>=90) {
			System.out.println("A");
		}else if(num>=80) {
			System.out.println("B");
		}else if(num>=70) {
			System.out.println("C");
		}else if(num>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		};
		
		System.out.println("문제2");
		// 문제2
		// 나이별로 요금을 부과하는 else if문을 만드세요
		// 8세 미만 : 요금은 1000원
		// 14세 미만 : 요금은 2000원
		// 20세 미만 : 요금은 2500원
		// 20세 이상 : 요금은 3000원
		
		System.out.println("나이를 입력하세요 : ");
		int age = scan.nextInt();
		
		if(age<8) {
			System.out.println("요금은 1000원입니다.");
		}else if(age<14) {
			System.out.println("요금은 2000원입니다.");
		}else if(age<20) {
			System.out.println("요금은 2500원입니다.");
		}else {
			System.out.println("요금은 3000원입니다.");
		}
		
		
	}
}

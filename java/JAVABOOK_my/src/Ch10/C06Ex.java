package Ch10;

import java.util.Scanner;

// 5개의 정수값을 입력 받아 int형 배열에 저장하고
// 최대값, 최소값, 전체합을 출력합니다.

// 5명 학생의 국영수 점수를 입력 받아 2차원 배열에 저장
// 각 학생의 국영수 점수의 합/평균을 구하고
// 각 과목당 합/평균을 구해보세요

public class C06Ex {
	public static void main(String[] args) {
		// 2중 for문 지양하기.. 
		
		// 점수, 정수 입력받기
		System.out.println("5명 학생의 국영수 점수를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int [][] test=new int[5][3];
		
		for(int i=0;i<test.length;i++) {
			System.out.println((i+1)+"번째 학생의 국영수 점수 입력");
			for(int j=0;j<test[i].length;j++) {
				test[i][j]=sc.nextInt();
			}
		}
		
		// 학생당 국영수 평균 1번 학생, 2번 학생 [1][1~3], [2][1~3] ...
		for(int i=0;i<test.length;i++) {	// 5번
			int sum=0;
			for(int j=0;j<test[i].length;j++) {	// 3번
				sum+=test[i][j];
			}
			double avg = (double)sum/test[i].length;
			System.out.printf("%d번째 학생의 총점 : %d점, 평균 : %f점\n",i+1,sum,avg);
		}
		
		// for문 하나만 써보기
		for(int i=0;i<test.length;i++) {
			int sum=test[i][0]+test[i][1]+test[i][2];
			double avg = (double)sum/3;
			System.out.printf("%d번째 학생의 총점 : %d점, 평균 : %f점\n",i+1,sum,avg);
		}
		
		
		// 과목당 합 평균
		int kor_sum=0;
		for(int i=0;i<test.length;i++) {
			kor_sum+=test[i][0];
		}
		int eng_sum=0;
		for(int i=0;i<test.length;i++) {
			eng_sum+=test[i][1];
		}
		int math_sum=0;
		for(int i=0;i<test.length;i++) {
			math_sum+=test[i][2];
		}
		// 2중 for문으로 풀어보기
		
		System.out.printf("국어 점수의 합은 %d점, 평균은"+(double)kor_sum/test.length+"점입니다.\n",kor_sum);
		System.out.printf("영어 점수의 합은 %d점, 평균은"+(double)eng_sum/test.length+"점입니다.\n",eng_sum);
		System.out.printf("수학 점수의 합은 %d점, 평균은"+(double)math_sum/test.length+"점입니다.\n",math_sum);
		
		
		
		
	}
}

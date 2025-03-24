package Ch06;

import java.util.Scanner;

public class C02Switch {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int ranking = sc.nextInt();
		char medalColor;
		switch (ranking) {
		case 1:	// case 뒤 값은 상수만 가능. 조건식 불가 -> 제약이 있음
			medalColor = 'G';
			System.out.println("메달 색상 : G");
			break;	// 해당 탈출문구가 없으면 넣은 값 아래의 모든 경우 실행
		case 2:
			medalColor = 'S';
			System.out.println("메달 색상 : S");
			break;
		case 3:
			medalColor = 'B';
			System.out.println("메달 색상 : B");
			break;
		default:
			medalColor = 'C';
			System.out.println("메달 색상 : C");
		}
		System.out.println(ranking + "등 메달의 색은" + medalColor + "입니다.");
		// switch -> if문으로 다 구현 가능
		// if문 -> switch로 다 구현 불가능
	}
}

package Ch06;

import java.util.Scanner;

public class C03Switch {
	public static void main(String[] args) {
		// 콘솔창에서 메뉴만들기
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println("-----< Join Menu >-----");
			System.out.println(" 1. 이메일 인증");
			System.out.println(" 2. 개인정보 입력");
			System.out.println(" 3. 회원가입 요청");
			System.out.println(" 4. 종료");
			System.out.println("-----< Join Menu >-----");
			System.out.print("번호 입력 : ");
			num = sc.nextInt();	// 입력하기 전까지 루프 정지, 입력하고 나면 되돌아 갈 것
			switch(num) {
			case 1:
				System.out.println("이메일 인증 처리 작업 -");
				break;
			case 2:
				System.out.println("이메일 개인정보 입력 작업 -");
				break;
			case 3:
				System.out.println("회원가입 처리 작업 -");
				break;
			case 4:
				System.out.println("Join 메뉴 종료 - ");
				System.exit(-1);
				break;
			default : 
				System.out.println("잘못된 메뉴 번호를 입력하셨습니다.-");
				break;
			}
			
			
			
			
		}
		
	}
}

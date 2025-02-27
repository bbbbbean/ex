package Ch04;

import java.util.Scanner;

public class C04Scanner {
	public static void main(String[] args) {
		System.out.println("문제 1번");
		// 이름을 입력하세요? 홍길동
		// 홍길동 님의 나이를 입력하세요? 35
		// 홍길동 님의 주소를 입력하세요? 대구광역시 달서구 000
		// 홍길동 님의 나이는 35세 주소는 대구광역시 ~~ 입니다
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요?");
		String name = sc.next();
		System.out.printf("%s님의 나이를 입력하세요?\n",name);
		int age = sc.nextInt();
		System.out.printf("%s님의 주소를 입력하세요?\n",name);
		sc.nextLine();
		String add = sc.nextLine();
		System.out.printf("%s님의 나이는 %d세 주소는 %s 입니다.\n",name, age, add);
		
		
		System.out.println("문제 2번");
		// Scanner를 이용해서 이름, 주미번호 앞 6자리 , 전화번호를 키보드에서
		// 입력받고 출력하는 코드를 작성해보세요
		
		System.out.println("[필수 정보 입력]\n1. 이름 : ");
		String userName = sc.next();
		System.out.println("2. 주민번호 6자리 : ");
		int id = sc.nextInt();
		System.out.println("3. 전화번호 : ");
		String phone = sc.next();

		System.out.printf("[입력한 내용]\n이름 : %s\n주민번호 : %s\nPH :  %s\n",userName,id,phone);
		
		sc.close();	// 자원 반환을 위해 꼭 닫아주기

//		[예시]
//		----------------------------
//		[필수 정보 입력]
//		1. 이름 : ______________ENTER
//		2. 주민번호 6자리 : ______________ENTER
//		3. 전화번호 : ____________ENTER
//
//		[입력한 내용]
//		이름 : 홍길동
//		주민번호 : 123456
//		PH : 010-222-3333
//		----------------------------
	}
}

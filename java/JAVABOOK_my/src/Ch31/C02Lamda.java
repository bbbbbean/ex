package Ch31;

import java.util.Scanner;

interface Printer{
//	void print(String message);	// 추상메서드
//	String print(String message);	// 추상메서드
	String print();				// 추상메서드
	
}

// 람다식 적용을 위해 추상 메서드는 하나만!

public class C02Lamda {
	public static void main(String[] args) {
		
		// 01
//		Printer printer = (message)->{System.out.println(message);};
//		printer.print("Hello World");
		
		// 02
//		Printer printer = (message)->{return message+"_HelloWorld";}; // 람다식 입력
//		Printer printer = message->message+"_HelloWorld"; // 약식 표현
//		String returnValue = printer.print("Test");
//		System.out.println(returnValue);	// Test_HelloWorld 출력
		
		// 03 키보드로 입력받아 String 반환
		Printer printer = ()->{
			Scanner sc = new Scanner(System.in);
			System.out.print("입력 : ");
			String str = sc.nextLine();
			sc.close();
			return str;
		};
		String returnValue = printer.print();
		System.out.println(returnValue);
	}
}

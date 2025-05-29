package Ch08;

import java.util.Scanner;

class MethodTest{
	// 속성
	Scanner sc = new Scanner(System.in);
	
	// 기능
	public int sum1(int n1, int n2) {
		return n1+n2;
	}

	public int sum2() {
		return sc.nextInt() + sc.nextInt();
 	}

	public void sum3(int n1, int n2) {
		System.out.println(n1+n2);
	}

	public void sum4() {
		System.out.println(sc.nextInt() + sc.nextInt());
	}

}


public class C04MethodMain {
	
	public static void main(String[] args) {
		
		MethodTest sumCale = new MethodTest();
		
		System.out.println(sumCale.sum1(10, 20));
		System.out.println(sumCale.sum2());
		sumCale.sum3(10,20);
		sumCale.sum4();
		// 함수 호출 시 저장 된 주소값을 보고(stack) 해당 위치로 찾아가 함수 실행(heap)
		
	}
}

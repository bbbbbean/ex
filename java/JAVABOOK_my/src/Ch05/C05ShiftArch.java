package Ch05;

// 중요도 낮음, C언어로 물려받은 거
// bit 연산자
// 오브젝트의 정밀한 위치값 추적 이런데 잘쓰임 ex게입 포물선 계산

public class C05ShiftArch {	// 밀어내는 작업, 좌우로
	public static void main(String[] args) {
		int num1 = 15;		//00000000 00000000 00000000 00001111
		int num2 = 20;		//00000000 00000000 00000000 00010100
		int num3 = num1<<3; //00000000 00000000 00000000 01111000	- 왼쪽으로 3칸 밀기
		int num4 = num1>>3; //00000000 00000000 00000000 00000001	- 오른쪽으로 3칸 밀기
		int num5 = num2<<3; //00000000 00000000 00000000 10100000	- 왼쪽으로 3칸 밀기
		int num6 = num2>>3; //00000000 00000000 00000000 00000010	- 오른쪽으로 3칸 밀기
		// 왼쪽으로 민다 2^3을 곱해준다
		// 오른쪽으로 민다 2^-3을 곱해준다
		
		System.out.println("<<Shift 연산결과 :" + num3);
		System.out.println(">>Shift 연산결과 :" + num4);
		System.out.println("<<Shift 연산결과 :" + num5);
		System.out.println(">>Shift 연산결과 :" + num6);
	}
}	

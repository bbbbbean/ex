package Ch05;

// 중요도 낮음, C언어로 물려받은 거
// bit 연산자

public class C04BitArith {
	public static void main(String[] args) {
		int num1 = 15;			//00000000 00000000 0000000 00001111
		int num2 = 20;			//00000000 00000000 0000000 00010100
		int num3 = num1&num2;	//00000000 00000000 0000000 00000100 = 4 - (0,0 == 0)(1,0 == 0)(0,1 == 0)(1,1 == 1)동일하면 씀
		int num4 = num1|num2;	//00000000 00000000 0000000 00011111 = 31 - (0,0 == 0)(1,0 == 1)(0,1 == 1)(1,1 == 1)전부 다 반영
		int num5 = num1^num2;	//00000000 00000000 0000000 00011011 = 27 - (0,0 == 0)(1,0 == 1)(0,1 == 1)(1,1 == 0)다 1이면 반전
		int num6 = ~num1;		//11111111 11111111 1111111 11110000 = num1의 1의 보수
								// num1과 num2를 세로로 비교해서 결과 내는 거
		
		System.out.println("AND 비트 연산 결과 : " + num3);
		System.out.println("OR 비트 연산 결과 : " + num4);
		System.out.println("XOR 비트 연산 결과 : " + num5);
		System.out.println("NOT 비트 연산 결과 : " + num6);
	}
}	

package Ch03;

public class C03TypeChange {
	public static void main(String[] args) {
		int num1 = 129;			// 00000000 00000000 00000000 10000001
		int num2 = 130;			// 00000000 00000000 00000000 10000010
		byte ch1 = (byte)num1;	// 마지막 1byte만 존재 10000001, 앞 24bit가 날아감, 제일 앞의 1이 음수 역할 -> -127로 변환됨
		byte ch2 = (byte)num2;	// 마지막 1byte만 존재 10000010
		
		System.out.printf("%d\n", ch1);
		System.out.printf("%d\n", ch2);
		
		int a = (int)100F;	// F: 접미사 - 형변화와 관련없이 공간을 마련하는 것
							// (int) : 접두사 - 형변화와 관련됨 것, 후처리
	
	}
}

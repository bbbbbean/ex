package Ch03;

public class C04TypeChange {
	public static void main(String[] args) {
		
		// 정수 연산식 (int보다 작은 변수자료형(short, char, byte))
		// int로 자동 형변환
		byte x = 10;
		byte y = 20;
		// byte result1 = x + y;	// Type mismatch: cannot convert from int to byte
								// + 연산 요청이 오면 -> x의 자료형이 int로 변환 == int + int
		byte result1_1 = (byte)(x + y);	// 덧셈 처리 후 변환
		
		int result1_2 = x + y;
		System.out.println(result1_1);
		
		
		
		// 정수 연산식 (int보다 큰 변수자료형(long))
		// 큰 타입으로 자동 형 변환
		byte var1 = 10;
		int var2 = 100;
		long var3 = 1000L;	
		// int result2 = var1 + var2 + var3;	// Type mismatch: cannot convert from long to int
												// 덧셈 연산 처리시 데이터 손실을 최소한으로 하기 위해 중간에 long이 포함되어 있으면 전부 long으로형변환해 연산 처리 함
												// int result2 = long 결과값 의 상태
		int result2 = (int)(var1 + var2 + var3);
		long result2_2 = var1 + var2 + var3;
		System.out.println(result2);
		
		
		
		// 실수 연산식
		// 큰 타입으로 자동 형 변환
		int intvar = 10;
		float flvar = 3.3F;
		double dbvar = 5.5;
		//int result3 = intvar + flvar + dbvar;	// Type mismatch: cannot convert from double to int
		int result3 = (int)(intvar + flvar + dbvar);
		double result3_1 = intvar + flvar + dbvar;
		System.out.println(result3);
		
		
		
	}
}

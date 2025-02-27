package Ch02;

// 원시형태의 자료형 : C언어로부터 물려받은 자료형, 기본 자료형, 미리 공간을 형성 후 저장(공간의 크기를 넘어서지 못함)

// 정수
// 1byte : byte / 2byte : short, char(양수값만 지원) / 4byte : int - 기본 / 8byte : long <== 정수값을 담기 위한 용도
// char : 숫자, 문자 == 2진 데이터로 변환 저장, 숫자도 한문자도 담을 수 있음. 단일 문자 == 양수로만 지원 ==> 양수, 문자열을 위한 단위 필요해짐
//		: 단일 문자를 담는 용으로 자주 쓰임

// 실수
// 4byte : float / 8byte : double - 기본
// 실수 : 오차가 생길 수 밖에 없는 수. 연산을 할수록 오차가 발생함 ==> 실수는 올림 처리를 하거나 정수로 변환 후 유지보수해야함

// 단일 문자
// 2byte : char

// 문자열 (얘는 저장 방식이 좀 다르다라고만 인지)
// class 자료형 사용 : string
// class 자료형 : 객체의 크기마다 다르게 동적 할당, 들어오는 데이터의 사이즈에 맞게 공간이 만들어짐

public class C04자료형 {
	public static void main(String[] args) {
		
		//---------------------------
		// 정수 int - 4byte 정수 부호 O
		//---------------------------
		int n1 = 0b10101101;	// 2진수값, 0b
		int n2 = 173;			// 10진정수값, 별도의 표기 없음
		int n3 = 0255;			// 8진수값, 0
		int n4 = 0xad;			// 16진수값, 0x
		System.out.printf("%d %d %d %d\n", n1, n2, n3, n4);
		
		//---------------------------
		// 정수 byte - 1byte 정수 부호 O
		//---------------------------
		byte n5 = (byte)-129;	// 강제 형변환, 1byte에서 담을 수 있는 수 범위 넘어감. 큰 공간의 수를 작은 공간에 넣으려고 하는 행위, 데이터 손실 감안
		System.out.println(n5);
		byte n6 = -30;
		byte n7 = 30;
		byte n8 = 127;
		byte n9 = (byte)129;		// 1byte에서 담을 수 있는 수 범위 넘어감
		System.out.printf("%d\n",n9);
		System.out.println(0b10101101);	// 173
		System.out.println(Integer.toBinaryString(-129));	// 11111111111111111111111101111111
		
//		
//		byte a = 10;
//		byte b = 20;
//		byte c = a+b;
		
		//-----------------------------------------------------------
		// 정수 short - 2byte 정수 부호 O | char - 2byte 정수 부호X (양수만)
		//-----------------------------------------------------------
		
		char n10 = 65535;	// (0~2^16-1) == (0~65535)
		short n11 = 32767;	// (-2^15 ~ +2^15-1) == (-32768 ~ +32767)
		// 정수값 : 기본적으로 int 자료형에 저장했다가 할당 공간에 넣음 ==> 왜 int로 먼저 저장? 메모리의 효율적 사용을 위해 임의로 상수풀에 저장함
		// 여간.. int값을 새로운 공간에 넣는 과정(자동 형변환)에서 문제가 발생하거나 그러는 거
		
		char n12 = 60000;
		short n13 = (short)n12;	// short범위를 넘어서는 값, 같은 2byte지만 short는 양수만이라 범위가 양수쪽으로 더 넓고, char는 음수도 포함이 되어 반토막
							// 공간의 크기가 같다해서 무조건 형변환이 되는게 아니란 거 알아두기.
		System.out.printf("%d\n",n13);
		
		
		//---------------------------
		// 정수 long - 8byte 정수 부호 O
		//---------------------------
		
		long n14 = 10000000000L;	// L접미사를 붙여 백억이 들어갈 수 있는 공간을 만들어 줌, 자료형이 일치해 형변화 필요X
		long n15 = 20;				// L,l(리터럴 접미사) : long 자료형을 사용하여 값 저장
		
		//long n16 = 10000000000;
		long n17 = 10000000000L;
		// 4byte -> 32bit 2^32 = 약 42억(+-21억) 저장가능
		// 8byte -> 64bit 2^64 저장 가능 == 많이 쓰임
		
		
		//---------------------------
		// 실수
		//---------------------------
		// 유리수와 무리수의 통칭
		// 소수점 이하 값을 가지는 수 123.456
		// float : 4byte 실수 (6-9자리)
		// double : 8byte 실수 (15-18자리), 기본 자료형
		
		// 정밀도 확인
		float n18 = 0.123456789123456789F;	// F,f : float형 접미사
		double n19 = 0.123456789123456789;
		System.out.println(n18);	
		System.out.println(n19);
		// 단정밀도, 배정밀도 - 실수값을 저장하는 방법
		// 소수점 : 고정 소수점(소수점 위치가 고정값 -> 앞 칸이 남고 뒤에 공간이 부족해도 유동적으로 사용 불가) / 부동 소수점(현재 쓰는 방법, 뜰 부 -> 소수점의 위치가 정해지지 않음. 일단 수를 넣고 소수점을 유동적으로 찍는 것)
		// 		: 부동 소수점이 메모리 효율이 좋음
		
		// 오차 확인
		float num = 0.1F;
		for(int i=0;i<=1E8;i++) {
			num=num+0.1F;
			System.out.println(i);
		}
		System.out.println("num : " + num);	// num : 2097152.0
		
		
		//---------------------------
		// 단일문자 char 2byte 정수
		//---------------------------
		// 문자는 사람의 편의를 위함, 모두 숫자 형태로 저장됨 (아스키 코드표)
		// 양수값만 정의가 되어 있음
		
		char ch1 = 'a';
		System.out.println(ch1);
		System.out.println((int)ch1); // 011000001
	
		
		char ch2 = 98;
		System.out.println(ch2);
		System.out.println((int)ch2); // 011000010
		
		char ch3 = 'b'+1;
		System.out.println(ch3);
		System.out.println((int)ch3); // 011000011
		
		byte ch4 = 'c'+2;
		System.out.println((char)ch4);
		System.out.println(ch4); // 011000011
		
		char ch5  = 0xac00;
		char ch6 = 44032;
		
		System.out.println(ch5);
		System.out.println(ch6);
		System.out.println((char)(0b1010110000000000+1));
		 
		char ch7 = 0xac00+1;
		System.out.printf("%c %c\n", ch5,ch7);
		
		// \\u :유니코드값 이스케이프문자
		System.out.printf("%c\n", '\uACa1');
		
		System.out.printf("TEST : %c\n", '\uabcd');
		
		
		char n = 10;
		System.out.printf("HELLO %c WORLD", n);
		
		
		
		//---------------------------
		//문자열 : String (클래스자료형)
		//---------------------------
		// 참조 변수를 만들 때 사용되는게 클래스 자료형 == 데이터를 담아내기 위한 자료형
				
		//기본자료형(원시타입)
		byte num1;
		short num2;
		double num3;
		long num4;
				
		//클래스자료형
		//클래스자료형으로 만든변수는 '참조변수'라고 하고
		//참조변수는 데이터가 저장된 위치정보(메모리주소값)이 저장된다.
		int num5 = 10;
		byte num6 = 20;
		char num7 = 40;
				
		String name = "홍길동";	// 상수풀에 저장, 객체로 저장, string 객체 => "" 뒤에 (.)찍으면 함수 뜸
		String job = "프로그래머";
		System.out.println(name);
		System.out.println(job);
		

		//--------------------
		//boolean : 논리형(true/false 저장)
		//--------------------
				
		boolean flag = (10>11); 	// 참(긍정)
		if(flag) 
		{
			System.out.println("참인경우 실행");
		}
		else 
		{
			System.out.println("거짓인경우 실행");
		}
		
		
		
	}
}

package Ch03;

public class C05TypeChange {
	public static void main(String[] args) {
		
		// 나눗셈
		int num1 = 10, num2 = 4;	// 나누는 대상이 되는 수가 int형이기 때문에 정수 값만 출력, 소수점이하값도 확인 원할 시 실수형으로 만들어 줘야 함
		double dnum1 = (double)num1 / num2;		// 대상 강제 형변환
		double dnum2 = (num1*1.0) / num2;		// 1.0과의 연산을 통해 자동 형변환
		double dnum3 = num1 / num2;
		System.out.println("dnum1 : "+ dnum1);
		System.out.println("dnum2 : "+ dnum2);
		System.out.println("dnum3 : "+ dnum3);
		
		
		
		
		
		
		
		
		
	}
}

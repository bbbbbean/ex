package Ch31;

interface Calculator{
	int calculate(int num1, int num2);
}


public class C03Lamda {
	public static void main(String[] args) {
		// 덧셈 - Calculator add
//		Calculator add = (int num1, int num2)->{return num1+num2;};
		Calculator add = (int num1, int num2)-> num1+num2;
		// 뺄셈 - Calculator sub
//		Calculator sub = (int num1, int num2)->{
//			// 큰 수 에서 작은 수 빼기로??
//			if(num1-num2<0) {
//				int tpm = num1;
//				num1 = num2;
//				num2 = tpm;
//			}
//			return num1-num2;};
		Calculator sub = (int num1, int num2)-> num1>num2?num1-num2:num2-num1;
		// 곱셈 - Calculator mul
//		Calculator mul = (int num1, int num2)->{return num1*num2;};
		Calculator mul = (int num1, int num2)-> num1*num2;
		// 나눗셈 - Calculator div
//		Calculator div = (int num1, int num2)->{return num1/num2;};
		Calculator div = (int num1, int num2)-> num1/num2;
		
		// 결과
		System.out.println(add.calculate(10,20)); // 덧셈
		System.out.println(sub.calculate(30,10)); // 뺄셈
		System.out.println(mul.calculate(10,20)); // 곱셈
		System.out.println(div.calculate(100,5)); // 나눗셈
		
		
	}
}

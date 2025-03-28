package Ch33;

import java.util.Arrays;
import java.util.Optional;

@FunctionalInterface
interface Functional{
	Integer execute(int ...args);	
}
class Calc{
	Functional sum;	// 합
	Functional sub;	// 차
	Functional mul;	// 곱
	Functional div;	// 나누기
	Calc(){
		// Functional sum 에 대한 스트림 & 람다식 완성 할 것
		sum = (items) -> Arrays.stream(items).reduce(0,(a,b) -> a+b);
		
		// Functional sub 에 대한 스트림 & 람다식 완성 할 것
		sub = (items)->{
			// 음수가 연산자를 만나 양수화 됨 -> 값이 이상해진 이유
			// 절대값화 혹은 비교해서 큰수에서 작은 수 빼게 만들기
			return Arrays.stream(items).boxed().sorted((a,b) -> b-a).reduce(0,(a,b)->{return a<b?b-a:a-b;});
			};
			
		// Functional mul 에 대한 스트림 & 람다식 완성 할 것
		mul = (items)->{
			return Arrays.stream(items).reduce(1,(a,b)-> a*b);
		};
		
		// Functional div 에 대한 스트림 & 람다식 완성 할 것
		div = (items)->{
			// 뺄셈과 유사하게 큰수 비교 후 나눗셈 연산
			return Arrays.stream(items).boxed().sorted((a,b)-> b-a).reduce(1,(a,b)->{return a<b?b/a:a/b;});
		};
		
		// 조건
		// sum,sub,mul,div 각각에 람다&스트림함수를 적절히 이용해서 기능 구현을 합니다
		// 모든 인자를 받을 수있는 가변인자 처리로 구현합니다
		// 뺄셈,나눗셈은 큰수에서 작은수로 정렬(sorted)한다음 누적 감산 처리(reduce)를 합니다
	}
}
public class C02Ex {

	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println("합 :"+ calc.sum.execute(10,20,30,40,50,60));
		System.out.println("차 :"+ calc.sub.execute(1,4,2,9));//1,2,4,5
		System.out.println("곱 :"+ calc.mul.execute(10,20,30,40,50,60));
		System.out.println("나눗셈 :"+ calc.div.execute(10,20,30,40,50,60));
		
	}	

}

package Ch33;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface	// 함수형 인터페이스 선언(Compiler에게 전달) - 함수형은 추상메서드를 하나만 허용
interface Func1{
	void say(String message);	// 추상메서드
}

@FunctionalInterface	
interface Func2{
	int sum(Integer ...arg);	// 추상메서드
}

@FunctionalInterface	
interface Func3{
	// Integer로 잡는게 수월, null 체크도 쉽고 쓸 수 있는 형태도 많음
	List<Integer> createListDesc(int ...arg);	// 추상메서드
}


public class C01FunctionalInterfaceMain {
	public static void main(String[] args) {
		
		// 01
		Func1 func1 = (message)->{System.out.println(message+"-!");};
		func1.say("Hello World");
	
		Func1 func1_1 = System.out::println;
		func1_1.say("Hello World");
		
		
		// 02
		Func2 func2 = (items)->{
			int sum = 0;
			for(int el:items) 
				sum+=el;
			return sum;
			}; 	// {}의 모든 items를 더한 값을 리턴(반복문으로 items의 item을 누적해서 리턴)
		
		System.out.println(func2.sum(10,20,30,40,556,6,7,8,9));
		
		Func2 func2_2 = (items)->{
//			List<Integer> list = (List<Integer>) Array.get(items, items.length);
//			Integer result = list.stream().reduce(list.size(),(a,b)->a+b);
//			return result;
			
			// 배열 : 스트림 함수를 쓰기 위한 사전작업 필요
//			Arrays.stream(items).reduce(누적 초기값,()->{});
//			return Arrays.stream(items).reduce(0,(sum,el)->{return sum+el;});
			return Arrays.stream(items).reduce(0,(sum,el)->sum+el);
			}; 	// {}의 모든 items를 더한 값을 리턴(reduce)
		
		System.out.println(func2.sum(10,20,30,40,556,6,7,8,9));
		
		
		// 03
		// 원시타입 int[] 배열 받기 -> 내림차순 정렬 -> int-Integer boxing -> list<integer>로 변환
		Func3 func3 = (items)->{
			return Arrays.stream(items)
					.boxed()	// 박싱
					.sorted((a,b) -> b-a )	// 원시 타입이라 인자를 받지 않는 형태만 뜸 -> 박싱 처리 필요
					.collect(Collectors.toList());
		};
		
		List<Integer> li = func3.createListDesc(10,100,24,1612,42,123,15,4,1);
		System.out.println(li);
		
		
		
		
		
		
		
		
		
		
	}
}

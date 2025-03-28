package Ch33;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

// 기본 제공되는 함수형 인터페이스들
// Function<T, R> : 두개의 제너릭 타입으로 인자 받음
// apply 메서드 내장, 하나의 인자(T)를 받아서 결과(R)를 반환하는 함수형 인터페이스

// Supplier<T>:
// get 메서드 내장, 어떠한 인자도 받지 않고 결과만을 제공하는 함수형 인터페이스

// Consumer<T>:
// accept 메서드 내장, 어떠한 인자를 받아서 결과를 반환하지 않는 함수형 인터페이스

// Predicate<T>:
// test 메서드 내장, 어떠한 인자를 받아서 불리언 결과를 반환하는 함수형 인터페이스

// UnaryOperator<T>:
// apply 메서드 내장, 하나의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스

// BinaryOperator<T>:
// apply 메서드 내장, 두 개의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스


public class C03FunctionalInterfaceMain {
	
	// 01. Function<T, R> - R apply(T t);
	// 01_1. 제곱
	// x : 첫번째 Integer
	// 반환 자료 : 두번째 Integer
//	public static Function<Integer, Integer> func1 = (x)->{return x*x;};
	public static Function<Integer, Integer> func1_1 = x-> x*x;	// 약식
	
	// 01_2. 덧셈
	public static Function<Integer, Integer> func1_2 = x-> x+x;	// 약식
	
	// 01_3. 누적 합
	// List형으로 받을 수 있음 - 배열, 컬렉션
	public static Function<List<Integer>, Integer> func1_3 = (list)-> list.stream().reduce(0,(sum,el)-> sum+el);
	
	// 01_4. 정수만 선별하여 누적 합
	// 모든 요소를 받아내는 형태 - 모든 요소의 최상위 형태 넣어주기
	public static Function<List<Object>, Integer> func1_4 = (list)-> {
		// Integer 형만 필터링 (instance of)
		// 누적 합
//		List<Integer> in = new ArrayList<Integer>();
//		for(Object el : list) {
//			if(el instanceof Integer) {
//				// 배열에 저장
//				in.add((Integer) el);
//			}
//		}
//		return in.stream().reduce(0,(sum,sel)->{return sum+sel;});
		
		
//		return list.stream().filter((item)->{return item instanceof Integer == true;})
//				 .map((item)->{return (Integer)item;}).reduce(0,(sum,sel)->{return sum+sel;});
		
		// 최종 약식
//		return list.stream().filter((item)-> item instanceof Integer).map((item)->(Integer)item)
//							.reduce(0,(sum,el)->sum+el);
		
		// 강사님 답
		return list.stream()
				   .filter((item)->{return item instanceof Integer;})	// 조건만 적으면 해당 조건 필터. true등 판별 필요없음
				   .map((item)->{return (Integer)item;})
				   .reduce(0,(sum,item)->{return (Integer)sum+item;});
		 };

	// 01_5. 정수 재구성
	public static Function<List<Object>, List<Integer>> func1_5 = (list) -> {
		// List<Object>로 받은 파라미터 중에 Integer만 추출, 리턴
		// 재구성 (map)
		// 리스트로 변환 (collect)
//		return list.stream().filter((item)->{return item instanceof Integer == true;})
//					 .map((item)->{return (Integer)item;})
//					 .collect(Collectors.toList());
		
		return list.stream().filter((item)-> item instanceof Integer)
							.map((item)-> (Integer)item)
							.collect(Collectors.toList());
		 };
		 
	// 01_6. 함수를 인자로 받아 중첩 가능
	public static Function<Integer, Integer> func1_6 = func1_1.andThen(func1_2);
	
	// 01_7. 함수를 인자로 받아 중첩 가능
	public static Function<Integer, Integer> func1_7 = func1_2.andThen(func1_1);
	
	// 01_8. 함수를 인자로 받아 중첩 가능
	public static Function<List<Integer>, Integer> subfunc = (list)-> list.stream().reduce(0,(sum,el)-> sum+el);
	public static Function<List<Object>, Integer> func1_8 = func1_5.andThen(subfunc);
	
	// 01_9. 직접 체인형으로 함수 중첩 연결
	// Integer를 받아 함수의 로직 리턴
	// 파라미터를 중첩 함수로 전달 가능
	public static Function<Integer, Function<Integer, Integer>> func1_9 = (x)->{return (y)->{return x+y;};};
	
	// 01_11. 재기호출?? 재귀호출???
	// 첫번째 파라미터 -> 두번째 함수, 두번째 함수 파라미터 -> 세번째 함수
	public static Function<Integer, Function<Integer, Function<Integer, Integer>>> func1_11 = (x)->{return (y)->{return(z)->{return x+y+z;};};};
	
	
	public static void main(String[] args) {
		
		// 01. func1 안에 정의된 메서드의 이름이 apply 였음
		System.out.println(func1_1.apply(10));
		System.out.println(func1_2.apply(10));
		System.out.println(func1_3.apply(Arrays.asList(10,20,30,40)));	// asList : 배열 형태를 바로 리스트로 변환
		System.out.println(func1_4.apply(Arrays.asList(10,"마마",30,true,40,10.5)));	
		System.out.println(func1_5.apply(Arrays.asList(10,"마마",30,false,40,10.5)));	
		
		System.out.println(func1_6.apply(5));	// andThen : 체인형으로 이어 쓸 수 있도록 도와줌
		// default 함수 : 완성형 함수
		// Function T의 실행 결과를 andThen 함수의 인자로 넣음 -> 계단 이어주는 역할처럼 중첩중첩해서 쓸 수 있음
//		default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
//	        Objects.requireNonNull(after);
//	        return (T t) -> after.apply(apply(t)==func1_1의 수행결과);	// 
//	    }
		System.out.println(func1_7.apply(5));
		System.out.println(func1_8.apply(Arrays.asList(10,"마마",30,true,40,10.5)));
		
		System.out.println(func1_9.apply(5).apply(10));
		// 5를 넣으면 y리턴 -> 함수 자체가 리턴되는 것 : 함수 주소 값이 리턴됨
		// 값을 돌려받기 위해서는 apply를 두번 입력해 x, y값 둘 다 입력해줘야 함 -> 반환된 함수에 넣어줄 인자 넣어주기
		
		System.out.println(func1_11.apply(5).apply(10).apply(30));
		
		
		
		
		
	}
}

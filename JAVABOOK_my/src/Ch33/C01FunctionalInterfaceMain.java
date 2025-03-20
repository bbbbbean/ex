package Ch33;

@FunctionalInterface	// 함수형 인터페이스 선언(Compiler에게 전달) - 함수형은 추상메서드를 하나만 허용
interface Func1{
	void say(String message);	// 추상메서드
}


public class C01FunctionalInterfaceMain {
	public static void main(String[] args) {
		
		// 01
		Func1 func1 = (message)->{System.out.println(message+"-!");};
		func1.say("Hello World");
	
		Func1 func1_1 = System.out::println;
		func1_1.say("Hello World");
		
		
	}
}

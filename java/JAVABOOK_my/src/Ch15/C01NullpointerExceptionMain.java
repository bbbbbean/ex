package Ch15;

public class C01NullpointerExceptionMain {
	public static void main(String[] args) {
		
		try {
		String str = null;
		System.out.println(str.toString());
		}catch(NullPointerException e) {
			System.out.println("예외 발생 : "+e);
			System.out.println(e.getCause());	// null
			System.out.println(e.toString());
			System.out.println(e.getStackTrace());	// [Ljava.lang.StackTraceElement;@1be6f5c3
			e.printStackTrace();	// 예외 정보 표시, 우리가 보던 빨간 글씨
		}
		System.out.println("Hello Wolrd");
		System.out.println("Hello Wolrd");
		// 예외 처리 전 실행 시
		// Exception in thread "main" java.lang.NullPointerException : Cannot invoke "String.toString()" because "str" is null
		// 아래의 Hello Wolrd 블록이 실행 중지 처리가 됨 -> 이걸 막기위해? try-catch로 잡아냄
		// 잡아내면 예외 발생 고지 후 아래 블록이 중지 없이 실행됨
		
	}
}

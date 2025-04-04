package Ch15;

public class C04ExceptionMain {
	public static void main(String[] args) {
		
		String str = null;
		try {
			str.toString();				// Null Exception
		
		int arr[] = {10,20,30};
			arr[5] = 100;				// Bound Exception
			Integer.parseInt("a1234");	// Parse Exception
			
		Animal animal = new Dog();
		Cat yummi = (Cat)animal;	// Cast Exception
			
		}catch(NullPointerException e) {
			System.out.println("예외 발생 : "+e);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생 : "+e);
		}catch(NumberFormatException e) {
			System.out.println("예외 발생 : "+e);
		}catch(ClassCastException e) {
			System.out.println("예외 발생 : "+e);
		}catch(Exception e) {
			System.out.println("예외 발생 : "+e);
		}
		// 귀찮으면 Exception 던지면 됨
		// 단, 일부 예외는 따로 빼서 관리해야함
		
		finally {	// 예외가 발생하건 말건 무조건 실행해야할 코드가 있다면 해당 블록에 가두기
			// 자원 정리 작업
			// 스캐너 닫기 등
			System.out.println("Finally Test..");
		}
		
		System.out.println("Hello World");
		
		
	}
}




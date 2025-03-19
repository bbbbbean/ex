package Ch29_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class C01BASIC {

	public static void main(String[] args) throws Exception {
		
		// 클래스 메타 정보를 받아 올 수 있음
		Class<?> clazz =  Class.forName("java.lang.String");	// Class 정보를 뽑아낼 때 사용
		
		// 모든 Field 확인
//		Field[] fields = clazz.getDeclaredFields();	// clazz에서 선언된 모든 필드 정보 확인
//		for(Field field : fields) {
//			System.out.println(field);
//		}
		
		// 모든 생성자 확인
		Constructor[] constructors =  clazz.getDeclaredConstructors();	// clazz에서 선언된 모든 생성자 확인
		for(Constructor con : constructors) {
			System.out.println(con);
		}
		
		// 모든 메서드 확인
		Method [] methods = clazz.getDeclaredMethods();	// clazz에서 선언된 모든 메서드 확인
		for(Method m : methods)
			System.out.println(m);
		
	

	}

}

package Ch29_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Simple{
	
	String name;
	int age;
	String addr;
	
	public Simple() {}
	public Simple(String name) {this.name = name;}
	public Simple(String name,int age) {this.name = name;this.age = age;}
	public Simple(String name,int age, String addr) {this.name=name;this.age=age;this.addr=addr;}
	
	//getter and Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	//toString 
	@Override
	public String toString() {
		return "Simple [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

public class C02BASIC {

	public static void main(String[] args) throws Exception {
		//reflect로  매서드 사용하기
		Simple ob = new Simple();
		ob.setAge(10);
		ob.setAddr("Dsdsd");

		System.out.println(Simple.class);
		Class<?> clazz = Class.forName( String.valueOf(Simple.class).split(" ")[1] );
		// String.valueOf(Simple.class) 심플 클래스 이름 값을 문자열로 뽑아냄
		Method method = clazz.getDeclaredMethod("getAge", null);
		// 전달할 파라미터 없음 = null 처리
		Object result = method.invoke(ob,null);
		// .invoke 메서드 실행 함수
		System.out.println(result);
		
		//reflect로 생성자 사용하기
		Constructor<?> constructor = clazz.getConstructor(String.class); //인자 1개 받는 생성자
//		Constructor<?> constructor = clazz.getConstructor(new Class[]{String.class, int.class}); // 인자 2개 받는 생성자
		System.out.println(constructor);
		Object obj =  constructor.newInstance("홍길동");
		System.out.println(obj);
		
		//reflect로 field에 값넣기
		// 의존주의????????
		Field field = clazz.getDeclaredField("addr");
		field.set(ob, "대구");
		System.out.println(ob);
		
	}

}

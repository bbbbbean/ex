package Ch16;

// 함수

class Animal{
	String name;
}
class Panda extends Animal{

	public Panda(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}
}

class Tiger extends Animal{
	public Tiger(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
}



public class C04GenericMain {
	// 범위가 더 좁은게 generic
	
	// Generic
	// public static void PrintByGeneric(동물 클래스 [] arr)
	public static <T extends Animal> void PrintByGeneric(T [] arr) {
		for(T el:arr) {
			System.out.println(el);
		}
	}
	// Object
	// generic 안쓰고 모든 동물 받아내기 -> Object upcasting, downcasting
	public static void PrintByObject(Object[] animal) {
		for(Object el:animal) {
			System.out.println(el);
		}
	}
	
	public static void main(String[] args) {
		Tiger arr1[]={new Tiger("시베리안호랑이"),new Tiger("백두산호랑이"),new Tiger("대한민국호랑이")};
		PrintByGeneric(arr1);	// 배열 만들고 삽입
		
		Panda arr2[]={new Panda("래서판다"),new Panda("귤판다"),new Panda("동글판다")};
		PrintByGeneric(arr2);
		
		Object arr3[]= {new Panda("래서판다"),new Tiger("백두산호랑이")};
		PrintByObject(arr3);
	}
	
}

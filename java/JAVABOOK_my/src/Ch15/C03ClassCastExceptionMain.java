package Ch15;


class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}


public class C03ClassCastExceptionMain {
	public static void changeDog(Animal animal) {
		try {
			Dog down = (Dog)animal;	// 고양이 강아지로 형변환 불가 에러
		}catch(ClassCastException e) {
			System.out.println("예외 발생 : "+e);
		}
	}
	
	public static void main(String[] args) {
		
		Animal poppi = new Dog();
		Animal tori = new Cat();
		
			changeDog(tori);	
			changeDog(poppi);
		
		
		System.out.println("Hello World");
	}
}

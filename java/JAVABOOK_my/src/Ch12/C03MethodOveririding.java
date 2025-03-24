package Ch12;


// 함수 재정의(Method Overriding)
// 상속 관계를 전제로 상위 클래스의 메서드를 하위클래스가 재정의(고쳐사용)하는 것을 허용한 문법
// 메서드의 헤더 부분은 동일하게 두고 본체({})의 로직을 수정하게끔 허용함으로 다양한 형태의 객체가
// 형성될 수 있도록 유도 (== 다형성)
// 상위 클래스로 부터 동일한 메서드를 물려받더라도 각 하위 클래스마다 다른 기능 구현의 결과물을 만들어 낼 수 있다.


// 오버로딩 vs 오버라이딩
// 오버 로딩	: 상속 전제 X
//			: 함수 헤더 변경 (반환 자료형 고정, 함수명 고정, 파라미터 변경)
// 			: 개발자의 편의성에 중점 (함수 이름 단일화)

// 오버라이딩	: 상속을 전제로 함
//			: 함수의 본체(로직)변경 (헤더 고정)
// 			: 다형성을 목적으로 한 문법 요소


class Animal{
	void sound() {
		System.out.println("소리낸다");
	}
}
class Dog extends Animal{
	void sound() {
		System.out.println("멍멍");
	}
}
class Cat extends Animal{

	@Override
	void sound() {
		System.out.println("야옹");
	}

	
}


public class C03MethodOveririding {
	public static void main(String[] args) {
		
		Animal ani = new Animal();
		ani.sound();
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		// 물려받은 sound 함수 사용 가능 - 오버라이딩 이전 : 소리낸다 출력
		//							 오버라이딩 이후 : 각각 지정한 소리 출력
		dog.sound();
		cat.sound();
		
		System.out.println("참조 변수와 연결된 객체를 바꿔볼 것");
		ani = dog;	// 상위클래스 참조변수로 하위 객체 dog 연결
		ani.sound();	// 멍멍
		ani = cat;	// 상위클래스 참조변수로 하위객체 cat 연결
		ani.sound();	// 야옹
		// 업캐스팅 - 클래스 형변환이 자동으로 일어나고 있음
	}
	
	
}

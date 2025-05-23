package Ch08;

class C03Person{	// 패키지 내에서는 클래스 명이 겹치면 안됨
	// 속성
	String name;
	int age;
	float height;
	double weight;
	// 기능
	void talk() {System.out.printf("%s님이 말합니다.\n",this.name);}	// this : 이미 객체가 만들어 졌다 가정하고 씀
	void walk() {System.out.printf("%s님이 걷습니다.\n",this.name);}
	// 속성 정보 확인
	void showInfo() {
		System.out.printf("%s %d %f %f\n",this.name,this.age,this.height,this.weight);
	}
	// 객체 정보 확인(to String)
	@Override
	public String toString() {
		return "C03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	// 우클릭 > 소스 > to String 생성
}

public class C03PersonMain {

	public static void main(String[] args) {
		C03Person hong = new C03Person();
		hong.name="홍길동";
		hong.age=15;
		hong.height=177.5f;
		hong.weight=70.5;
		
		hong.talk();
		hong.walk();
		hong.showInfo();
		
		System.out.println(hong.toString());	// Object에게 물려받은 함수
		System.out.println(hong);
		// Ch08.C03Person@2e0fa5d3 -> 패키지명.클래스@해시코드
		// to string 정의 시 위치 정보값이 아닌 정의한 객체 정보가 뜸
		
	}

}

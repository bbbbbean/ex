package Ch09;

// 캡슐화?
// 생성한 객체를 어떤 메서드와 필드로 어떻게 일을 수행할지 외부에 숨기는 특성
// ex. 자동차 시동 -> 사용자가 볼 이유도 없고 사용자가 접근해 수정해서도 안되기 때문에 숨김, 과정은 숨기고 결과만 보이도록 함
// ex. 요리사 -> 영업비밀인 과정 숨기기

// 특정 목적을 가지는 기능을 구현하는데 필요한 세부 기능들을 묶어서 처리하는 방법
// 특정 목적을 가지는 기능 구현에 있어서 각 과정의 일부나 전부가 외부로 노출되는 문제를 막기위해 정보 은닉을 수반한다. (필수는 아님)
// 캡슐화 작업은 각 공정 과정에 대한 정확한 이해가 수반되어야 한다.

// 잘못 건들면 모든 공정이 어그러짐

class Engine{
	private void 흡입() {System.out.println("외부로부터 공기를 빨아들인다.");}
	private void 압축() {System.out.println("가둔 공기를 압축시킨다");}
	private void 폭발() {System.out.println("일정 수준 압축이 되면 폭발");}
	private void 배기() {System.out.println("가스를 외부로 보낸다");}
	// 캡슐화
	public void EngineStart() {
		흡입();
		압축();
		폭발();
		배기();
	}
}

class Car{
	Engine engine;
	Car(){
		engine = new Engine();
	}
	void run() {
		engine.EngineStart();
	}
}



public class C02캡슐화 {
	public static void main(String[] args) {
		Car car = new Car();
		car.run();
	}
}

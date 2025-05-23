package Ch13;

import java.util.Scanner;

// 메서드	: 일반 메서드 X, 전부 추상 메서드
// 속성	: 일반 멤버 필드 X, 한번 데이터를 넣으면 변경이 불가능한 기준값인 public static final로만 선언 가능
// 직접 객체 생성 불가능
// implements 예약어 사용
// 구현된 클래스에서 반드시 추상 메서드 재정의

// 왜?
// 인터페이스 - 인터페이스 명세서가 함께 전달됨 (그냥 주면 모르니까 설명서를 같이 주는 것)
// 코드 : 모듈화가 잘되어있어야함, 너무 의존하면 유지보수가 힘듦(직접 접근해서 객체 조정 : 의존도 높음)
// -> 인터페이스 사용시 : Tv,radio있다 생각 => 리모콘 생성 -> 각 객체에 맞게 재정의 -> 그럼? 유지보수때 리모콘만 건들면 됨
// 공정은 더 추가될 지 몰라도 유지 보수, 확장에 용이 (텀블러의 뚜껑같은 느낌) : 특정 기능에 문제가 생기면 거기만 걷어내면 됨


interface Remocon{
	int Max_vol=100;	// public static final
	int Min_vol=0;		// public static final
	
	//인터페이스에서는 껍데기만 만들기! - 각 객체에 맞게 각 클래스에서 강제 재정의
	void powerOn();		// abstract function
	void powerOff();	// abstract function
	void setVolumn(int vol);	// abstract function
	// 최대, 최소 볼륨 제한 해주세요
	// vol값이 100 초과하면 최대 볼륨값으로 적용 (print : 최대 볼륨으로 설정합니다.)
	// vol값이 0미만일 때는 최소 볼륨값으로 적용 (print : 최소 볼륨으로 설정합니다.)
}
interface Browser{
	void SearchURL(String url);
}

class Tv implements Remocon{
	
	int vol;
	
	@Override
	public void powerOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolumn(int vol) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("볼륨 입력");
//		int vol = sc.nextInt();
		this.vol=vol;

		if(vol>Max_vol) {
			System.out.println("tv를 최대 볼륨으로 설정합니다.");
			vol = Max_vol;
		}else if(vol<Min_vol) {
			System.out.println("tv를 최소 볼륨으로 설정합니다.");
			vol = Min_vol;
		}else {
			System.out.println("현재 볼륨 :"+this.vol);
		}
	}
	
}

class SmartTv extends Tv implements Browser{ // tv와 remocon, Browser 다 들고옴
											 // extends 뒤에 implements
	@Override
	public void SearchURL(String url) {
		System.out.println(url+"로 이동합니다.");
	}	
	
}

class Radio implements Remocon{
	
	int vol;
	
	@Override
	public void powerOn() {
		System.out.println("Radio를 켭니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("Radio를 끕니다.");
	}

	@Override
	public void setVolumn(int vol) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("볼륨 입력");
//		int vol = sc.nextInt();
		this.vol=vol;
		
		if(vol>Max_vol) {
			System.out.println("Radio를 최대 볼륨으로 설정합니다.");
			vol = Max_vol;
		}else if(vol<Min_vol) {
			System.out.println("Radio를 최소 볼륨으로 설정합니다.");
			vol = Min_vol;
		}else {
			System.out.println("현재 볼륨 :"+this.vol);
		}		
	}
	
}

public class C03InterfaceMain {
	public static void TurnOn(Remocon controller) {
		controller.powerOn();	// 하위에서 재정의된 함수에 접근 가능
	}
	public static void TurnOff(Remocon controller) {
		controller.powerOff();	// 하위에서 재정의된 함수에 접근 가능
	}
	public static void SetVolumn(Remocon controller,int vol) {
		controller.setVolumn(vol);
	}
	public static void Internet(Browser browser, String url) {
		browser.SearchURL(url);;
	}
	
	public static void main(String[] args) {
		
		Tv tv = new Tv();
		SmartTv smartTv = new SmartTv();
		Radio radio = new Radio();

		TurnOn(tv);
		TurnOn(smartTv);
		TurnOn(radio);
		
		TurnOff(tv);
		TurnOff(smartTv);
		TurnOff(radio);
		
		SetVolumn(tv,90);
		SetVolumn(smartTv,70);
		SetVolumn(radio,111);
		
		Internet(smartTv, "www.naver.com");
	}
}

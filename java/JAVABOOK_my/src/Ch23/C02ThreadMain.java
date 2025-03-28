package Ch23;

// 2가지 방식
// run 인터페이스
// thread 클래스


public class C02ThreadMain {
	public static void main(String[] args) throws InterruptedException {
		
		// Runnable Interface 스레드 분할
		// 워커 스레드 생성 -> C02worker
		// 01. 작업 객체 생성
		C02Worker1 w1 = new C02Worker1();
		C02Worker2 w2 = new C02Worker2();
		
		// 02. 메인 스레드에서 분리
		Thread th1 = new Thread(w1);
		Thread th2 = new Thread(w2);
		
		// 03. 스레드 실행
		th1.start();
		th2.start();
		
//-------------------------------------------------------
		
		// Thread class 스레드 분할 (익명 클래스 사용)
		// 스레드에 신호를 줘서 멈추는 작업 : Interrupt
		new Thread() {

			@Override
			public void run() {
				// 작업 내용 넣기
				for(int i=0;i<5;i++) {
					System.out.println("task 03");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
			}
			
		}.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("Main Thread");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
		
		
		
		
		
	}
}

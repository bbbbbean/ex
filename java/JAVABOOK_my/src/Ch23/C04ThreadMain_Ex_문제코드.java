//package Ch23;
//
//// 개념 잘 알아두기
//
//class IncrementThread implements Runnable {
//	private static int counter = 0;
//	// 스레드가 몇개든 카운터는 공유 가능
//
//	public int getCounter() {
//		return counter;
//	}
//
//	@Override
//	public void run() {
//		for (int i = 0; i < 100000; i++) {
//			counter++; // 공유변수값증가
//			// 어떤 스레드가 몇번 카운트 했는지 표시
//			System.out.println(Thread.currentThread().getName() + "s counter : " + counter);
//		}
//	}
//
//}
//
//public class C04ThreadMain_Ex_문제코드 {
//
//	public static void main(String[] args) throws InterruptedException {
//
//		
//		IncrementThread incrementThread1 = new IncrementThread();
//		IncrementThread incrementThread2 = new IncrementThread();
//		IncrementThread incrementThread3 = new IncrementThread();
//		IncrementThread incrementThread4 = new IncrementThread();
//
//		Thread thread1 = new Thread(incrementThread1);
//		Thread thread2 = new Thread(incrementThread2);
//		Thread thread3 = new Thread(incrementThread3);
//		Thread thread4 = new Thread(incrementThread3);
//
//		thread1.setName("TH1");
//		thread2.setName("TH2");
//		thread3.setName("TH3");
//		thread4.setName("TH4");
//
//		// 4개 동시 시작 : 40만번 반복 - 근데 39만 얼마 이런식으로 찍히는 애들이 있음 -> 중간에 동시에 작업에 들어가 씹힌 것
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		thread4.start();
//		//메인 스레드가 thread1,thread2의 작업이 모두 완료될 때까지 대기하도록 설정 - 메인스레드가 먼저 종료되지 않도록
//		thread1.join();
//		thread2.join();
//		thread3.join();
//		thread4.join();
//
//		System.out.println("Final value: " + incrementThread1.getCounter());
//
//	}
//}

package Ch23;

public class C02Worker2 implements Runnable {

	@Override
	public void run() {
		// 작업 내용 넣기
		for(int i=0;i<5;i++) {
			System.out.println("task 02");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
	}

}

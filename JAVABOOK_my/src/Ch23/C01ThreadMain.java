package Ch23;

public class C01ThreadMain {
	public static void main(String[] args) throws Exception {
		
		// 동기
		for(int i=0;i<5;i++) {
			System.out.println("task 01");
			Thread.sleep(500);	// .sleep(500) : 시간 주는 거
		}
		
		for(int i=0;i<5;i++) {
			System.out.println("task 02");
			Thread.sleep(500);
		}
		
		
	}
}

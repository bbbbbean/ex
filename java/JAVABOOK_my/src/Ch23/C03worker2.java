package Ch23;

public class C03worker2 implements Runnable {

	C03GUI gui;
	
	C03worker2(C03GUI gui){
		this.gui = gui;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				gui.area2.append("Worker02\n");
				Thread.sleep(500); // 지연값
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}  
		}
		System.out.println("Worker2 Interrupted(중단)");
		
	}

}

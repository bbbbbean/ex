package Ch23;

public class C03worker1 implements Runnable {
	
	C03GUI gui;
	
	C03worker1(C03GUI gui){
		this.gui = gui;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				gui.area1.append("Worker01\n");
				Thread.sleep(500); // 지연값
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}  
		}
		System.out.println("Worker1 Interrupted(중단)");
	}

}

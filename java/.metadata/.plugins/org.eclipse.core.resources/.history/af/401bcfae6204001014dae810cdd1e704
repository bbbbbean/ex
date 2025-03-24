package Ch24;

import java.io.DataInputStream;
import java.io.IOException;

public class ServerRecvThread implements Runnable{

	// 수신 : input
	DataInputStream din;
	
	ServerRecvThread(DataInputStream din){
		this.din = din;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String recv;
				
				// client > server 수신
				recv = din.readUTF();
				if(recv.equals("q")) break;
				System.out.println("[Server] : "+recv);
			}
		} catch (IOException e) {
			System.out.println("[Exception] Server Recv Thread 종료");
		}finally {try{din.close();}catch(Exception e2) {}}
	}

}

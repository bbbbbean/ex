package Ch24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClientSendThread implements Runnable{

	// 송신 : output
	DataOutputStream dout;
	
	ClientSendThread(DataOutputStream dout){
		this.dout = dout;
	}
	// 입력 필요
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void run() {
		try {
			while(true) {
				String send;
								
				// server > client 송신
				System.out.println("[Client(q:종료)] : ");
				send = sc.nextLine();
				if(send.equals("q")) break;
				dout.writeUTF(send);
				dout.flush();	// 버퍼 비우기
			}
		} catch (IOException e) {
			System.out.println("[Exerption] Client Send Thread 종료");
		}finally {
			try {dout.close();}catch(Exception e2) {}
		}
	}

}

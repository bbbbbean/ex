package Ch25;

import java.io.DataInputStream;
import java.io.IOException;

import javax.swing.JTextArea;

public class ServerRecvThread implements Runnable{

	// 수신 : input
	DataInputStream din;
	Sgui gui;
	
	ServerRecvThread(DataInputStream din, Sgui gui){
		this.din = din;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String recv;
				
				// client > server 수신
				recv = din.readUTF();
				if(recv.equals("q")) break;
//				System.out.println("[Server] : "+recv);
				gui.area.append("[Client]"+recv+"\n");
				
				// 스크롤을 맨 아래로 이동
				gui.area.setCaretPosition(gui.area.getDocument().getLength());
			}
		} catch (IOException e) {
			System.out.println("[Exception] Server Recv Thread 종료");
		}finally {try{din.close();}catch(Exception e2) {}}
	}

}

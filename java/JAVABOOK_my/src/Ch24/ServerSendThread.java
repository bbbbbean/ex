package Ch24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ServerSendThread implements Runnable{	// 대문자..
	// 데이터를 서버로 보내는 역할
	
	// 정보를 보내기 위해서는? 입력한 내용을 계속 보내는 outputStream
	// 객체가 생성되는 시점에 받아주기
	DataOutputStream dout;
	
	// 제이터를 입력 받아야함 : 스캐너 필요
	Scanner sc = new Scanner(System.in);
	
	ServerSendThread(DataOutputStream dout){
		this.dout = dout;
	}
	
	
	@Override
	public void run() {
		try {
			while(true) {
				String send;
				
				// server > client 송신
				System.out.println("[Server(q:종료)] : ");
				send = sc.nextLine();	// 띄어쓰기 포함 할 예정
				if(send.equals("q")) {
					break;
				}
				dout.writeUTF(send);
				dout.flush();	// 버퍼 비우기
			}
		} catch (IOException e) {
			System.out.println("[Exception] 예외 발생 Server Send Thread 종료");
		}finally {
			try {dout.close();}catch(Exception e1) {}
		}
	}

	
}

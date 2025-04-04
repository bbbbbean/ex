package Ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception, IOException {
		
		Socket client = new Socket("192.168.16.131",7000);	

		System.out.println("[Client] 연결 시작");
		// 대화 주고받기 위한 설정
		// in, out
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		// 워커 생성(스트림으로 객체 생성)
		ClientSendThread send = new ClientSendThread(dout);
		ClientRecvThread recv = new ClientRecvThread(din);
		
		// 스레드 생성(생성한 객체 스레드 연결, 스레드 객체 생성)
		Thread th1 = new Thread(send);
		Thread th2 = new Thread(recv);
		
		// 작동
		th1.start();
		th2.start();
		
		// 메인이 늦게 종료되도록 작업 / 순서 지정
		// join : 해당 스레드의 실행이 종료 될 때 까지 join을 호출한 로직의 실행을 멈추지 않음
		// -> main에서 호출 : main은 join이 끝나기 전까지 종료되지 않음
		th1.join();
		th2.join();
		
		// 자원 반납
		in.close();
		out.close();
		client.close();
		System.out.println("[Client] 연결 종료");
		
	}
}

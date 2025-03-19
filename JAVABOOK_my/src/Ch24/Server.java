package Ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception {
		
		// 비동기 방식 : 송수신 스레드 분리
		// 워커 : 서버 송신부, 서버 수신부
		
		// 서버 소켓 생성 - 전화기 생성
		ServerSocket server = new ServerSocket(7001);	// 192.168.16.17:7000
		System.out.println("[info] Server Socket Listening");
		
		// 1회 응답
		Socket client = server.accept();
		
		System.out.println("[Server] 연결 시작");
		
		// 대화 주고받기 위한 설정
		// in, out
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		// 워커 생성, 연결
		ServerSendThread send = new ServerSendThread(dout);
		ServerRecvThread recv = new ServerRecvThread(din);
		
		// 스레드 생성, 연결
		Thread th1 = new Thread(send);
		Thread th2 = new Thread(recv);
		
		// 작동
		th1.start();
		th2.start();
		
		// 메인 스레드가 워커 스레드 종료 이후에 종료되도록 작업
		th1.join();
		th2.join();
		
		// 자원 반납
		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("[Server] 연결 종료");
		
		       	
	}
}

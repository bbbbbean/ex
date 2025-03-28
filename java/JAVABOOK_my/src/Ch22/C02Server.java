package Ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {
	public static void main(String[] args) throws Exception {
		
		// 서버 소켓 생성 - 전화기 생성
		ServerSocket server = new ServerSocket(7000);	// 192.168.16.17:7000
		System.out.println("[info] Server Socket Listening");
		
		// 1회 응답
		Socket client = server.accept();
		
		System.out.println("[Server] 연결 시작");
		// 대화 주고받기 위한 설정
		// in, out 둘 다 설정
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		// 내용 교환 (q:종료)
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;
		while(true) {
			
			// 동기 방식 : 순서를 지정해줘야 함, 누가 먼저 전송할 것인지
			//		   : 지금은 서버가 먼저 보낸다 가정 -> 추후 비동기로 바꿈
			
			// server > client 송신
			System.out.println("[Server(q:종료)] : ");
			send = sc.nextLine();	// 띄어쓰기 포함 할 예정
			if(send.equals("q")) {
				break;
			}
			dout.writeUTF(send);
			dout.flush();	// 버퍼 비우기
			
			// client > server 수신
			recv = din.readUTF();
			if(recv.equals("q")) {
				break;
			}
			System.out.println("[Client] : "+recv);
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("[Server] 연결 종료");
		
		       	
	}
}

package Ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class C02Client {
	public static void main(String[] args) throws Exception, IOException {
		
		Socket client = new Socket("192.168.16.70",7000);	

		System.out.println("[Client] 연결 시작");
		// 대화 주고받기 위한 설정
		// in, out
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		// 내용 교환 (q:종료)
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;
		
		while(true) {
			// client > server 수신
			recv = din.readUTF();
			if(recv.equals("q")) break;
			System.out.println("[Server] : "+recv);
							
			// server > client 송신
			System.out.println("[Client(q:종료)] : ");
			send = sc.nextLine();
			if(send.equals("q")) break;
			
			dout.writeUTF(send);
			dout.flush();	// 버퍼 비우기
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		System.out.println("[Client] 연결 종료");
		
	}
}

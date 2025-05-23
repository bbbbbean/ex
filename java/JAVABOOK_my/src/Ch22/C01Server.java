package Ch22;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.core.io.DataOutputAsStream;

// ex. 전화기
// 0. 전화기 전화 코드 꽂기 (기본 전제, 준비)
// 1. 전화를 수신 받음 - 요청 대기
// 2. 전화를 받음 : 세션 형성

// 수화기를 든 상태 inoutstream


public class C01Server {
	public static void main(String[] args) throws IOException {
		
		// 서버 소켓 생성 - 전화기 생성
		ServerSocket server = new ServerSocket(7000);	// 192.168.16.17:7000
		System.out.println("[info] Server Socket Listening");
		
		// 통신 무한으로 받기 -> 여기부터 무한 루프
		// 연결 요청 통신객체와 연결
		Socket client = server.accept();
		
		// 클라이언트에 메세지
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		
		dout.writeUTF("[info] Welcome to Server");
		
		dout.flush();
		dout.close();
		out.close();
		client.close();
		server.close();
		
		System.out.println("서버 종료");
	}
}

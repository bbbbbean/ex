package Ch26;

import java.io.*;
import java.net.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBackground {
	ServerSocket server;
	ServerUI gui;
	Map<String,DataOutputStream> ClientList; // 접속한 클라이언트 별칭
	Socket client;
	
	
	ServerBackground(ServerUI ui)
	{
		gui = ui;
		ClientList = new HashMap();
		Collections.synchronizedMap(ClientList);//컬렉션 동기화 
		
	}
	
	
	public void Setting() {
		try {
			// 서버 소켓
			server = new ServerSocket(5555);

			while(true) {
				gui.area.append("서버 접속 요청 대기중....\n");
				client=server.accept();
				gui.area.append(client.getInetAddress()+" 에서 접속중..\n");
				
				//수신 스레드 처리 
				ServerRecvThread recv = new ServerRecvThread(client,this,gui);	// 클라이언트 정보 수신 스레드로 전달
				Thread th = new Thread(recv);
				th.start();
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void addClient(String nick, DataOutputStream Dout) {
		// 이미 접속 해 있는 클라이언트들에게 내용을 송출해야함 
		broadCast(nick  + " 님이 접속하셨습니다" +client.getInetAddress()+"\n");
		ClientList.put(nick, Dout);
		
	}
	public void removeClient(String nick) {
		gui.area.append(nick + " 님이 퇴장하셨습니다\n");
		ClientList.remove(nick);
	}
	
	public void broadCast(String msg) {
	
		for(String key : ClientList.keySet()) {	// 이미 접속 해 있는 클라이언트 리스트
			try {		
				ClientList.get(key).writeUTF(msg);
				ClientList.get(key).flush();		
			}catch(Exception e) {}
			
		}
		
		
		
	}
	
	public void broadCast(String nick, String msg) throws IOException {

		for(String tmpnick : ClientList.keySet())
		{
			if(!nick.equals(tmpnick))
			{
				DataOutputStream out =  ClientList.get(tmpnick);	//nick에 대응되는 outputStream을 꺼냄
				out.writeUTF(msg);
				out.flush();
			}
			
		}
		
		
	}
	

}

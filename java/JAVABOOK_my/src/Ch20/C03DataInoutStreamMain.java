package Ch20;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class C03DataInoutStreamMain {

	public static void main(String[] args) throws Exception{
		// 채팅작업 할 때 사용
		
//		FileOutputStream out = new FileOutputStream("C:\\IOTEST\\test3.txt");
//		DataOutputStream dout = new DataOutputStream(out);
//		dout.writeUTF("홍길동");
//		dout.writeDouble(95.5);
//		dout.writeInt(100);
//		dout.flush();
//		dout.close();
		
		FileInputStream in = new FileInputStream("C:\\IOTEST\\test3.txt");
		DataInputStream din = new DataInputStream(in);
		String name= din.readUTF();	// 문자
		System.out.println(name);
		double weight = din.readDouble(); // 더블
		System.out.println(weight);
		int data = din.readInt();	// 정수
		System.out.println(data);
		// 데이터 입력 순서대로 출력해야함
	}
}

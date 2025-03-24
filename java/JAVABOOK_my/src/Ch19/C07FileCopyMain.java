package Ch19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class C07FileCopyMain {
	public static void main(String[] args) throws Exception {
		
		InputStream in = new FileInputStream("C:\\IOTEST\\book.pdf");
		OutputStream out = new FileOutputStream("C:\\IOTEST\\COPY_book.pdf");
		
		// 01. 버퍼 미사용
//		System.out.println("진행중");
//		while(true) {
//			int data = in.read();
//			if(data==-1)break;
//			out.write((byte)data); 	// 공간 낭비 방지를 위해 byte화
//			out.flush();
//		}
//		in.close();
//		out.close();
//		System.out.println("진행완료");
		
		// 02. 버퍼 사용
		System.out.println("진행중");
		byte [] buff = new byte[4096];
		while(true) {
			int data = in.read(buff);
			if(data==-1)break;
//			out.write((byte)data); 	// 공간 낭비 방지를 위해 byte화
			out.write(buff, 0, data); 	// 버퍼, 시작인덱스, 길이 -> 길이의 존재 이유? 마지막에 쓸데없는 정보가 덧붙여져서 복사되지 않게 하기 위해, 공간의 낭비 없이 저장 위해
			out.flush();
		}
		in.close();
		out.close();
		System.out.println("진행완료");
	}
}

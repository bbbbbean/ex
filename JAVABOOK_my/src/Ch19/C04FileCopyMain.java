package Ch19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class C04FileCopyMain {

	
	public static void main(String[] args) throws IOException
	{
		
		Reader fin = new FileReader("C:\\IOTEST\\test3.txt");//원본파일
		int data=0;
		
		StringBuffer buffer = new StringBuffer();
		
		char [] buf = new char[1024];	// 1024byte
//		fin.read(buf);	// buf의 크기만큼 읽어들임, 여기서는 1024문자 만큼, 읽은 갯수를 리턴, 단위가 클수록 시간 단축
//		fin.read();	// 읽은 char값을 리턴
		
		// char별로 읽어서 카피해옴 -> 문자가 많으면 시간이 오래 걸림
		long startTime = System.currentTimeMillis();
		while((data = fin.read(buf)) != -1) {
//			System.out.print((char)data);
//			buffer.append((char)data);  // read()의 형태
			buffer.append(buf);
		}
		long endTime = System.currentTimeMillis();
		System.out.println();
		System.out.println("소요시간 : "+(endTime-startTime) + "ms");
//		System.out.println(buffer);
		
		fin.close();
		
	}

}

package Ch19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.Buffer;

public class C02ReaderMain {
	public static void main(String[] args) throws IOException {
		Reader fin = new FileReader("C:\\IOTEST\\test1.txt");
		int data=0;
		
		StringBuffer buffer = new StringBuffer();
		// 단일 문자를 읽고 유니코드 값 출력, 끝에 도달하면 -1 출력
		while((data = fin.read()) != -1) {
			System.out.print((char)data);
			buffer.append((char)data);
		}
		System.out.println();
		System.out.println(buffer);
		
		fin.close();
	}
}

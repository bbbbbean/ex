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
		
		// 중간에 버퍼를 거쳐 한번에 정보를 전송하는 것이 바로 입출력을 하는 것보다 빠르다.
		// 버퍼를 사용하지 않는 입력 	: 키를 누르는 즉시 바로 프로그램에 전달
		// 버퍼를 사용하는 입력		: 입력이 있을 때 마다 한 문자씩 버퍼로 이동시킴
		//						  버퍼가 가득 차거나 개행문자 전송 시 버퍼의 내용을 한 번에 프로그램에 전달
		StringBuffer buffer = new StringBuffer();
		
		// 단일 문자를 읽고 유니코드 값 출력, 끝에 도달하면 -1 출력
		while((data = fin.read()) != -1) {	// 데이터의 끝에 도달하지 않았다면 이라는 뜻
			System.out.print((char)data);
			buffer.append((char)data);
		}
		System.out.println();
		System.out.println(buffer);
		
		fin.close();
	}
}

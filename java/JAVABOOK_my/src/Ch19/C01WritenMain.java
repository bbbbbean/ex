package Ch19;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// 문자 스트림(Char, 2byte)
// 바이트 스트림(byte, 1byte)

// 파일에 내용을 저장할 예정

public class C01WritenMain {
	public static void main(String[] args) throws IOException {
//		Writer fout = new FileWriter("C:\\IOTEST\\test1.txt",false); //덮어쓰기
		Writer fout = new FileWriter("C:\\IOTEST\\test1.txt",true); //추가하기
		fout.write("TEST1\n");
		fout.write("TEST2\n");
		fout.write("TEST3\n");
		fout.write("TEST4\n");
		
		fout.flush();
		fout.close();
		
	}

}

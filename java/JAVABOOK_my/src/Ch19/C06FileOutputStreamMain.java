package Ch19;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class C06FileOutputStreamMain {
	public static void main(String[] args) throws Exception {
		
		OutputStream out = new FileOutputStream("C:\\IOTEST\\test4.txt");
		// byte인데 문자가 됨 -> 알파벳(7bit)은 문제가 없음, 한글문자(2byte)는 문제 생김
		out.write("가".getBytes(StandardCharsets.UTF_8));	// byte배열로 변환 후 넣으면 입력 가능
															// 버전에 따라 UTF_8가 기본이 아닌곳도 있음 -> 설정해주기
		out.write('a');
		out.write('b');
		out.write('c');
		
		out.flush();
		out.close();
		
	}
}

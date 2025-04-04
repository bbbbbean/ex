package Ch20;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import java.io.FileInputStream;


// 기본 입출력 스트림(input, output)을 인자로 전달해 옵션을 추가해 이용하는 것 -> 기본 스트림이 전제가 되어 있어야함
// 단독 사용 불가
// 중복 적용 가능


public class C01CharConvertStreamMain {

	public static void main(String[] args) throws Exception{
		String str = "문자 변환 스트림 사용";
		
		OutputStream out = new FileOutputStream("C:\\IOTEST\\test.txt");	// 기본
		OutputStreamWriter wout = new OutputStreamWriter(out);	// 보조
		BufferedWriter bout = new BufferedWriter(wout);	// 보조
		bout.write(str);	// 보조 스트림 사용 O
//		bout.write(str.getBytes(StandardCharsets.UTF_8));	// 보조스트림 이용 X
		bout.flush();
		bout.close();
		
		InputStream in = new FileInputStream("C:\\IOTEST\\test.txt");
		BufferedInputStream bin =  new BufferedInputStream(in);
		InputStreamReader rin = new InputStreamReader(bin);
		while(true) {
			int data = rin.read();
			if(data==-1)
				break;
			System.out.print((char)data);
		}
	}
}

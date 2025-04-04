package Ch19;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

public class C09URLStreamMain {
	public static void main(String[] args) throws Exception {
		
		// URL url = (new URL("https://n.news.naver.com/article/662/0000063734?cds=news_media_pc&type=editn")).toURI();
		// url 주소 가져오기
		URL url = (new URI("https://n.news.naver.com/article/662/0000063734?cds=news_media_pc&type=editn")).toURL(); 
		InputStream in = url.openStream();
		
		// 보조 스트림 추가(Ch20)
		// 기존 읽기, 쓰기 스트림에 기능 추가용으로 쓰는 스트림
		// 버퍼공간 생성, 문자 형변환 등등
		BufferedInputStream buffIn = new BufferedInputStream(in);	// 버퍼 공간 추가
		Reader rin = new InputStreamReader(buffIn);					// byte -> char 변환
		// 결과값인 rin을 read값으로 사용
		
		Writer out = new FileWriter("C:\\IOTEST\\index.html");
//		OutputStream out = new FileOutputStream("C:\\IOTEST\\index.html");
		
		while(true) {
			int data = rin.read();
			if(data==-1)break;	// 문서 종료시 반복문 종료 설정
			
//			System.out.print((byte)data);
			System.out.print((char)data);	// 문자로 나오긴 하는데 아스키코드를 벗어나면 깨짐 -> 보조 스트림 사용
			out.write((char)data);	// 다른 파일로 저장
			out.flush();
		}
		rin.close();
		buffIn.close();
		in.close();
		out.close();
		
		
		
	}
}

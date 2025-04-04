package Ch19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class C05FileInputStreamMain {
	public static void main(String[] args) throws Exception {
		
		InputStream fin = new FileInputStream("C:\\IOTEST\\data.xlsx");
		StringBuffer stringBuffer = new StringBuffer();
		
		// fin.read() 방식 확인
//		long sTime = System.currentTimeMillis();
//		while(true) {
//			int data = fin.read();
//			if(data==-1) break;
//			
//			System.out.print((char)data);
//		}
//		long eTime = System.currentTimeMillis();
//		System.out.println("소요시간 : "+(eTime-sTime)+"ms");
//		fin.close();
		
		// read([]) 방식 확인
		byte [] buf = new byte[4096];
		long sTime = System.currentTimeMillis();
		while(true) {
			int data = fin.read(buf);
			if(data==-1) break;
			
			System.out.print((char)data);
		}
		long eTime = System.currentTimeMillis();
		System.out.println("소요시간 : "+(eTime-sTime)+"ms");
		fin.close();
	}
}

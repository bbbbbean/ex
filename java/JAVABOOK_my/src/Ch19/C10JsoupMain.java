package Ch19;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class C10JsoupMain {
	public static void main(String[] args) throws Exception {
		// 이미지 긁어오기?
		// Jsoup 외부 라이브러리
		// maven repository : https://mvnrepository.com/
		
		// URL 연결
		Connection conn = Jsoup.connect("https://www.op.gg/champions");
		// 문서를 object형태로 들고옴
		Document document = conn.get();
		System.out.println(document);
		
		Elements elements = document.getElementsByTag("img");	// 배열형
//		System.out.println(elements);
		
		for(Element el : elements) {
			
			try {
				
	//			System.out.println(el);
				String img_url = el.getElementsByAttribute("src").attr("src");
				System.out.println(img_url);
				
				URL url = (new URI(img_url)).toURL();
				InputStream in = url.openStream();
				// 보조 스트림 추가
				BufferedInputStream buffIn = new BufferedInputStream(in);	// 버퍼 공간 추가
				
				OutputStream out = null;
				
				if(img_url.contains(".png"))
					out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".png");
				else if(img_url.contains(".svg"))
					out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".svg");
				else if(img_url.contains(".webp"))
					out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".webp");
				else
					out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".jpg");
				
				while(true) {
					int data = buffIn.read();
					if(data==-1)break;
					out.write((byte)data);
					out.flush();
				}
				
				out.close();
				buffIn.close();
				in.close();
			}catch(Exception e) {}
		}
		
		
	}
}

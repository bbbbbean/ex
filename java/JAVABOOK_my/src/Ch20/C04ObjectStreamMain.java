package Ch20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

// 객체단위로 데이터를 주고받을 수 있다.
// 바뀐 구조 구별을 위해 시리얼로 구분하면 좋다


class Board implements Serializable{	// 반드시 Serializable과 상속관계 (찾아보기, 직렬화)
	private static final long serialVersionUID = 1L;	// 이클립스 버전 정보
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date date;
	public Board(int bno, String title, String content, String writer, Date date) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", date="
				+ date + "]";
	}
	
	//All Args Constructor
	//Getter and Setter
	//toString
	
	
}

public class C04ObjectStreamMain {
	
	
	public static void main(String[] args) throws Exception{
		// 통신 때 자주 사용
		
//		FileOutputStream out = new FileOutputStream("C:\\IOTEST\\board.db");	// 다른 컴퓨터로 넘기기도 가능
//		ObjectOutputStream oout = new ObjectOutputStream(out);
//		oout.writeObject(new Board(1,"제목1","하2","홍길동",new Date()));
//		oout.writeObject(new Board(2,"제목2","하3","남길동",new Date()));
//		oout.flush();
//		oout.close();
//		out.close();
		
		
		// 직렬화된 데이터 꺼내기
		FileInputStream in = new FileInputStream("C:\\IOTEST\\board.db");
		ObjectInputStream oin = new ObjectInputStream(in);

 		Object obj =  oin.readObject();	// 오브젝트 단위로 받아
		Board down = (Board)obj;	// 다운캐스팅
		System.out.println(down);	// 확인
		
 		Object obj2 =  oin.readObject();	// 오브젝트 단위로 받아
		Board down2 = (Board)obj2;	// 다운캐스팅
		System.out.println(down2);	// 확인
		
		//더이상 읽을것이 없으면 java.io.EOFException 발생 -> 적절히 대처하기
 		Object obj3 =  oin.readObject();
		Board down3 = (Board)obj3;
		System.out.println(down3);

	}

}

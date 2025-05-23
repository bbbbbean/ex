package Ch08;

import java.util.Scanner;

// 문제 1
class TV{
	String brand;
	int year;
	int size;
	
	TV(String brand,int year,int size){
		this.brand=brand;
		this.year=year;
		this.size=size;
	}
	
	public void show() {
		System.out.printf("%s에서 만든 %d년 %d인치\n",brand,year,size);
	}
}

// 문제2
class Grade{
	private int math;
	private int science;
	private int english;
	
	Grade(int math,int science,int english){
		this.math=math;
		this.science=science;
		this.english=english;
	}
	
	public int average() {
		return (math+science+english)/3;
	}
}

// 문제3
class Song{
	String title;
	String artist;
	int year;
	String country;
	
	// 기본 생성자
	Song() {
	    this("title","artist",0000,"country");
	}
	
	public Song(String title, String artist, int year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	
	public void show() {
		System.out.printf("%d년 %s국적의 %s가 부른 %s\n",year,country,artist,title);
	}
}

public class C09Ex {
	public static void main(String[] args) {
		// package Ch08Ex;
		//
		// public class C00문제 {
		//--------------------------------------------
		// 문제 - 이것이자바다
		//--------------------------------------------
		// https://scksk.tistory.com/6
		
		// 클래스 기본문제
		// 1~7번 확인하기 
		
		// 12번-16번 확인하기
		
		//--------------------------------------------
		// 추가(명품자바)
		//--------------------------------------------
		// https://security-nanglam.tistory.com/213
		
		
		System.out.println("문제1");
//		자바 클래스를 작성하는 연습을 해보자. 다음 main() 메소드를 실행하였을 때 예시와 같이 출력되도록 TV 클래스를 작성하라.
		   TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치
		   myTV.show();
		   
		   
		System.out.println("문제2");
//		Grade 클래스를 작성해보자. 3 과목의 점수를 입력받아 Grade 객체를 생성하고 성적 평균을 출력하는 main()과 실행 예시는 다음과 같다.

			Scanner sc = new Scanner(System.in);
		      
			System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
			int math = sc.nextInt();
			int science = sc.nextInt();
			int english = sc.nextInt();
			Grade me = new Grade(math, science, english);
			System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴
		      
			sc.close();
		   
//		   수학, 과학, 영어 순으로 3개의 정수 입력 >> 90 88 96
//		   평균은 91
//		   [Hint] Grade 클래스에 int 타입의 math, science, english 필드를 private로 선언하고, 생성자와 세 과목의 평균을 리턴하는 average() 메소드를 작성한다.
		
		System.out.println("문제3");
//		노래 한 곡을 나타내는 Song 클래스를 작성하라. Song은 다음 필드로 구성된다.
//
//		- 노래의 제목을 나타내는 title
//		- 가수를 나타내는 artist
//		- 노래가 발표된 연도를 나타내는 year
//		- 국적을 나타내는 country
//
//		또한 Song 클래스에 다음 생성자와 메소드를 작성하라.
//		- 생성자 2개: 기본 생성자와 매개변수로 모든 필드를 초기화하는 생성자
//		- 노래 정보를 출력하는 show() 메소드
//		- main() 메소드에서는 1978년, 스웨덴 국적의 ABBA가 부른 "Dancing Queen"을
//		song 객체로 생성하고 show()를 이용하여 노래의 정보를 다음과 같이 출력하라.
//		1978년 스웨덴국적의 ABBA가 부른 Dancing Queen
		Song song = new Song("Dancing Queen","ABBA",1978,"스웨덴");
		song.show();
		
		
		//--------------------------------------------
		// 추가
		//--------------------------------------------
		// https://iu-corner.tistory.com/entry/JAVA-%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%97%B0%EC%8A%B5-%EB%AC%B8%EC%A0%9C-%EB%AA%A8%EC%9D%8C-1

	}
}

package Ch14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//********중요 시험에 무조건 나옴 (simple과 local 중 원하는 거로 암기)

public class C07LocalDateTimeFormatMain {
	public static void main(String[] args) {
		
		// 2. 날짜 정보 Formatting
		// 문자 입력 -> 문자열 확인 후 LocalDate로 변환 -> 출력용 포맷으로 변환 -> 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("YYYY/MM/DD 입력 : ");
		String ymd = sc.next(); // 날짜 문자열 입력
		
		// 입력용 포매터
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		// 문자열을 LocalDate로 변환
		LocalDate date = LocalDate.parse(ymd, inputFormatter);	// 포맷 일치 확인 후 변환
		// parse : 특정한 자료형으로 바꿔주는 작업 수행
		// LocalDate : time 정보 버림
		// 			   LocalDateTime까지 하면 시간 정보도 들고옴 - 이 경우 시분초 포맷팅도 해주기
		System.out.println("입력된 날짜 : "+ date);
		
		// 출력용 포매터
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy~MM~dd");
		
		// 포맷 변경 후 출력
		System.out.println("변환된 날짜 : "+date.format(outputFormatter));
		
		
		
		
		
		// 3. 날짜 시간 정보 Formatting
		Scanner scan = new Scanner(System.in);
		System.out.println("YYYY/MM/DD HH:MM:SS 입력 : ");
		String ymdt = scan.nextLine(); // 날짜 문자열 입력
		
		// 입력용 포매터
		DateTimeFormatter inputFormatterT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
		// 문자열을 LocalDate로 변환
		LocalDateTime dateTime = LocalDateTime.parse(ymdt, inputFormatterT);	// 포맷 일치 확인 후 변환
		// parse : 특정한 자료형으로 바꿔주는 작업 수행
		// LocalDate : time 정보 버림
		// 			   LocalDateTime까지 하면 시간 정보도 들고옴 - 이 경우 시분초 포맷팅도 해주기
		System.out.println("입력된 날짜 : "+ dateTime);
		
		// 출력용 포매터
		DateTimeFormatter outputFormatterT = DateTimeFormatter.ofPattern("yyyy~MM~dd HH-mm-ss");
		
		// 포맷 변경 후 출력
		System.out.println("변환된 날짜 : "+dateTime.format(outputFormatterT));
		
		scan.close();
	}
}

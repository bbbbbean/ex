package Ch14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// ********중요 시험에 무조건 나옴 (simple과 local 중 원하는 거로 암기)
// 데이터 -> 문자열 -> "2025-01-01 HH:MM:SS" 웹에서 받은 데이터 포멧(형태) -> DB 저장시 정제 필요 / DB종류마다 형태가 다름
// 문자 데이터 입력 -> 확인 -> 출력



public class C06SimpleDateFormatMain {
	public static void main(String[] args) throws ParseException {
		
		// 1. SimpleDateFormat
		Scanner sc = new Scanner(System.in);
		System.out.println("YYYY/MM/DD 입력 : ");
		String ymd = sc.next();
		
		// 포매터 객체 생성(입력용)
		SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd");	// ("yyyy/MM/dd") 입력 형태 지정 / y,M,d,h,m,s
		System.out.println(ymd);
		Date date = fmtin.parse(ymd);	// 예외 처리를 하지 않아 붉은 줄이 떴던 것. 예외처리해주면 됨(예외 : 특정 위치에서 처리, 중구난방 처리 안됨)
		// 형태에 맞지 않게 정보 입력 시 오류 뜨는거였네 - 해당 오류예외 처리 필요였네
		System.out.println(date);
		
		// 포매터 객체 생성(출력용)
		SimpleDateFormat fmtout = new SimpleDateFormat("yyyy~MM~dd");	// ("yyyy~MM~dd") 출력 형태 지정 / y,M,d,h,m,s
		System.out.println(fmtout.format(date));
		
		
		
		
	}
}

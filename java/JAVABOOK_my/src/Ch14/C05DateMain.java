package Ch14;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class C05DateMain {
	public static void main(String[] args) {
		// 시험에 무조건 나옴 -- 암기하듯 외우기 / local 알아두기, 혹시 모르니까 date까지. calendar는 참고
		// 두가지 중에 하나 선택 : Date, Calendar
		
		// Date
		Date d1 = new Date();
		System.out.println(d1);	// Mon Mar 10 10:44:14 GMT+09:00 2025
		System.out.println(d1.getYear()+1900);	// 125, 년도 작업 시 1900을 더해줘야 올해 수가 뜸
		System.out.println(d1.getMonth()+1);	// 3, 0월부터 시작 -> +1해주기
		System.out.println(d1.getDay());	// 0-6(일-토), 1
		System.out.println(d1.getHours());	// 10
		System.out.println(d1.getMinutes());	// 44
		System.out.println(d1.getSeconds());	// 14
		System.out.println(d1.getTime());	// 1741571054968, 시간을 가지고 계산하는 일이 있을 때 사용 참고
		
		
		// Calendar
		// 이미 만들어져 있는 걸 꺼내 사용하는 형태
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));	// 2025
		System.out.println(cal.get(Calendar.MONTH)+1);	// 3
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));	// 10
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));	// 2, 요일, 1-7(일-토)
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));	// 10
		System.out.println(cal.get(Calendar.MINUTE));	// 51
		System.out.println(cal.get(Calendar.SECOND));	// 12

		
		// 버전에 따라 지원X
		// LocalDateTime
		LocalDateTime now = LocalDateTime.now();
		
		// 연, 월, 일, 시, 분, 초 가져오기
		int year = now.getYear();
		int month = now.getMonthValue();	// 월 (1~12)
		int day = now.getDayOfMonth();		// 일 (1~31)
		int hour = now.getHour();			// 시 (0~23)
		int minute = now.getMinute();		// 분 (0~59)
		int second = now.getSecond();		// 초 (0~59)
		DayOfWeek dayOfWeek = now.getDayOfWeek();
		
		// 결과 출력
		System.out.println("연 : "+ year);
		System.out.println("월 : "+ month);
		System.out.println("일 : "+ day);
		System.out.println("시 : "+ hour);
		System.out.println("분 : "+ minute);
		System.out.println("초 : "+ second);
		System.out.println("요일 : "+ dayOfWeek);	// 영문 출력
		
		
	}
}

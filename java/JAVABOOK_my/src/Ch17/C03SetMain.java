package Ch17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C03SetMain {
	public static void main(String[] args) {
		Set<String> set = new HashSet();	// set은 중복값 허용 X -> 메모리 주소값으로 동일 객체인지 판별
		// 추가
		set.add("HTML/CSS/JS");	// 0
		set.add("JQUERY");		// 1
		set.add("NODEJS");		// 2
		set.add("SCSS");		// 3
		set.add("REACT");
		set.add("JAVA");
		set.add("JSP/SERVLET");
		set.add("STS");
		set.add("SPRING BOOT");	// older
		set.add("SPRING BOOT");	// newer(덮어쓰기) - 중복 불가
		
		
		// 확인
		System.out.println("개수 확인 : "+set.size());

		
		// 삭제
		set.remove("NODEJS");
		
		
		// 조회 : 인덱스가 없음
		// 1 ) 오래된 방식 = Iterator : 기준점 생성 후 순회하며 조회
//		Iterator<String> iter = set.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}

		// 2 ) 개량 for문
		for(String el:set) {
			System.out.println(el);
		}
		
		
		// 전체 삭제
		set.clear();
	}
}

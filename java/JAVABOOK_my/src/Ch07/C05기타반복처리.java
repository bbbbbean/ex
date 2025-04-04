package Ch07;

import java.util.ArrayList;
import java.util.List;

public class C05기타반복처리 {
	public static void main(String[] args) {
		
		// *** list, map, set 중요~~~
		
		// Collection 객체를 이용 - 저장
		// 배열과 유사, 반복 처리를 위한 사전 작업
		List<String> lists = new ArrayList();	// string만 들어가게 제약 걸어놓음
		lists.add("JAVA");
		lists.add("JSP/SERVLET");
		lists.add("SPRING STS");
		lists.add("SPRINGBOOT");
		lists.add("REACT");
		lists.add("ORACLE");
		
		// 기본 for문
		System.out.println("기본 for문-------------");
		for(int i=0; i<lists.size(); i++) {
			System.out.println(lists.get(i));	// i번째 요소 꺼내기
		}
		// 개량 for문
		System.out.println("개량 for문-------------");
		for(String subject : lists) {
			System.out.println(subject);
		}
		// Stream forEach
		// 람다식 == 화살표 함수
		System.out.println("Stream forEach-------------");
		lists.stream().forEach((item)->{System.out.println(item);});
		
	}
}

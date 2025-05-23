package Ch17;

import java.util.ArrayList;
import java.util.List;

// 어떤 타입으로 데이터를 담을지 <>로 전달 -> 데이터 입력
// 컬렉션 프레임워크 : 데이터를 수집하기 위해 미리 만들어둔 틀
// 컬렉션 : 임시저장 공간 -> 프로그램 껏다키면 사라짐 -> 데이터베이스 전송,저장 과정 필수


// List** : 배열과 유사하지만 동적 확장 가능, 인덱스 번호 O, 순서가 있는 형태로 데이터 보관, 동일 데이터 중복 가능
// Set : 순서가 없는 형태로 마구잡이로 넣는 형태, 동일 데이터 중복 불가, 유일한 값
// Map** : key/value 형태
// 		   key - 중복 불가능, 유일값, Set사용
//		   value - 중복 가능

public class C01ListMain {
	public static void main(String[] args) {
		List<String> list = new ArrayList();
		// 추가
		list.add("HTML/CSS/JS");	// 0
		list.add("JQUERY");			// 1
		list.add("NODEJS");			// 2
		list.add("SCSS");			// 3
		list.add("REACT");
		list.add("JAVA");
		list.add("JSP/SERVLET");
		list.add("STS");
		list.add("SPRING BOOT");
		list.add("SPRING BOOT");	// 중복 가능
		
		// 조회
		System.out.println("개수 확인 : "+list.size());
		System.out.println("idx로 조회 : "+list.get(2));
		System.out.println("Value로 idx확인 : "+list.indexOf("JAVA"));
		list.forEach(System.out::println);
		System.out.println("---");
		
		// 삭제
		list.remove(0);
		list.remove("JQUERY");
		for(String el : list) {
			System.out.println(el);
		}
		
		// 전체 삭제
		list.clear();
		
		
	}
}

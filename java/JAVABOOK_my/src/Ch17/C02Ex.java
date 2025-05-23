package Ch17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C02Ex {
	public static void func1(List<String> list) {
		// ArrayList에 있는 정수값을 입력받는데 전달되는 수중에
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("입력(종료-1)");
			String tmp = sc.next();
			list.add(tmp);
			try {
				int tmpI = Integer.valueOf(tmp);
				if(tmpI==-1) {
					break;
				}
			}catch(Exception e){
			}
		}
		
		// 짝수의 값만 입력받는 코드를 작성하세요.
		for(String el:list) {
			try {
				int liEl = Integer.valueOf(el);
				if(liEl%2==0) {
					System.out.println("짝수 : "+liEl);}
			}catch(NumberFormatException e) {
			}
		}
	}
	public static List<String> func2(List<String> list) {
		// ArrayList에 있는 문자열 중에서 길이가 5보다 큰 문자열만 필터링해서 리턴하는 함수를 만드세요
		List<String> li = new ArrayList<>();	// 빈 list 생성
		for(String el:list) {
			if(el.length()>5) {
				li.add(el);
			}
		}
		return li; //바꿔주세요 작업시
	}
	public static int func3(List<String> list) {
		// ArrayList에 있는 문자열 중에서 숫자형 데이터만 추출해서 합을 구해보세요
		int sum=0;
		for(String el:list) {
			try {
				int liSum=Integer.valueOf(el);
				sum+=liSum;
			}catch(NumberFormatException e) {
			}
		}
		return sum; //바꿔주세요 작업시
	}
	public static void main(String[] args) {
		List<String> li = new ArrayList();
		func1(li);
		List<String> returndList =  func2(li);
		int sum =  func3(returndList);
		System.out.println(sum);
	}
}

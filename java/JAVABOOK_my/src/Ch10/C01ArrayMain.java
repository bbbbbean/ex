package Ch10;
import java.util.Arrays;
import java.util.Scanner;

// 리스트 : 동적 확장 가능, 선호
// 배열 : 동적 확장 불가능, 고정된 크기, 선호 X


public class C01ArrayMain {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int [] arr1 = new int[5];
		System.out.println("5개의 값을 입력하세요");
		arr1[0] = sc.nextInt();
		arr1[1] = sc.nextInt();
		arr1[2] = sc.nextInt();
		arr1[3] = sc.nextInt();
		arr1[4] = sc.nextInt();
		
		System.out.println("배열 길이"+arr1.length);
		
		System.out.println("for문");
		for(int i=0; i<arr1.length;i++) {
			System.out.println(i+". "+arr1[i]);
		}
		System.out.println("for 배열");
		for(int el:arr1) {
			System.out.println(el);
		}
		System.out.println("람다 forEach");
		Arrays.stream(arr1).forEach(el->System.out.println(el));
		Arrays.stream(arr1).forEach(System.out::println);
		
		
		// 배열에 입력된 정수 중에 최대값과 최소값을 출력
//		int max = arr1[0];
//		int min = arr1[0];
		
//		if(max<arr1[1]) {max=arr1[1];}
//		if(max<arr1[2]) {max=arr1[2];}
//		if(max<arr1[3]) {max=arr1[3];}
//		if(max<arr1[4]) {max=arr1[4];}
//		
//		if(min>arr1[1]) {min=arr1[1];}
//		if(min>arr1[2]) {min=arr1[2];}
//		if(min>arr1[3]) {min=arr1[3];}
//		if(min>arr1[4]) {min=arr1[4];}
		
//		for(int el : arr1) {
//			if(max<el) {
//				max=el;
//			}
//		}
//		for(int el:arr1) {
//			if(min>el) {
//				min=el;
//			}
//		}
//		System.out.println("최대값은 "+max+", 최소값은"+min);
		
		// 최댓값
		Arrays.stream(arr1).max().getAsInt();	// optional : 예외 처리를 위한 여러가지 작업들이 포함되어 있음
		System.out.println("max : "+Arrays.stream(arr1).max().getAsInt());
		System.out.println("min : "+Arrays.stream(arr1).min().getAsInt());
		
		
		
		
	}
}

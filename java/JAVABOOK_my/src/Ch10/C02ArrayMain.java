package Ch10;

import java.util.Arrays;

public class C02ArrayMain {
	public static void main(String[] args) {
		
		// 얕은 복사(주소 복사)
		int arr1[] = {10,20,30};
		int arr2[];
		arr2 = arr1;
		arr1[0]=100;
		
		Arrays.stream(arr1).forEach(System.out::println);
		System.out.println("--------------------------");
		Arrays.stream(arr2).forEach(System.out::println);
		
		// 깊은 복사(값 복사)
		int arr3[] = new int[3];
		for(int i=0;i<arr1.length;i++) {
			arr3[i]=arr1[i];
		}
		
		// Arrays API
		int arr4[] = Arrays.copyOf(arr1, arr1.length);	// 원본 배열 arr1, 배열의 길이 : arr1의 길이만큼
		System.out.println("arr1 :"+arr1);	// [I@19469ea2
		System.out.println("arr2 :"+arr2);	// [I@19469ea2
		System.out.println("arr3 :"+arr3);	// [I@1fb3ebeb
		System.out.println("arr4 :"+arr4);	// [I@548c4f57

		
		
		
	}
}

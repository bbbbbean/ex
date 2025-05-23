package Ch10;

public class C03ArrayMain {
	public static void main(String[] args) {
		
		// 1차원 배열의 배열 요소는 idx위치에서의 지정 자료형이다
		// 배열 요소 == 배열을 이루는 구성 요소
		// int arr[]=new int[5] -> 한 칸당 4byte
		// 2차원 배열의 배열 요소는 1차원 배열이다
		// int arr[][] = new arr [2(행)][3(열)] -> 0번째 요소 0행
		
		
		int arr[][] = {
				{10,20,30},	// 0번째 요소 = 1차원 배열
				{40,50,60,65,67},
				{70,80,90,96,11,56},
				{100,110,120,15,22,33,44},
		};
		
		System.out.println("길이 : "+arr.length+" == 행의 길이");
		System.out.println("0번째 행의 길이 : "+arr[0].length+" == 열의 길이");
		System.out.println("1번째 행의 길이 : "+arr[1].length+" == 열의 길이");
		System.out.println("2번째 행의 길이 : "+arr[2].length+" == 열의 길이");
		System.out.println("3번째 행의 길이 : "+arr[3].length+" == 열의 길이");
		
		
	}
}

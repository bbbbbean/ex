package Ch09;

public class C05StringClass {
	public static void main(String[] args) {
		
		String str1 = "Java Powerful";
		String str2 = new String("java programming");
		String str3 = str1+str2;
		String str4 = str1.concat(str2);
		
		System.out.printf("%x\n",System.identityHashCode(str1));
		System.out.printf("%x\n",System.identityHashCode(str2));
		System.out.printf("%x\n",System.identityHashCode(str3));
		System.out.printf("%x\n",System.identityHashCode(str4));
		
//		int i =0;
//		String str = "";
//		while(i<10) {
//			str +=i;
//			System.out.println("str :"+str+"");
//			System.out.printf("%x\n",System.identityHashCode(str));
//			i++;
//		}
		
		
		// 문자열 덧붙이기 (메모리 누수 방지 클래스 : StrightBuffer, StringBuilder)
//		int i = 0;
//		StringBuilder str = new StringBuilder("");
//		while(i<10) {
//			str.append(i);
//			System.out.print("str :"+str+" ");
//			System.out.printf("위치 : %x\n",System.identityHashCode(str));
//			i++;
//		}
		
		
		// 문자열 길이
		System.out.println("문자열 길이 : "+ str1.length());
		System.out.println("한문자 찾기 : "+ str1.charAt(2));
		
		System.out.println("인덱스 찾기 :"+str1.indexOf('a'));	// 첫번째 문자 인덱스
		System.out.println("인덱스 찾기 :"+str1.lastIndexOf('a')); // 마지막 문자 인덱스
		
		System.out.println("문자열 포함 여부 : "+str1.contains("va"));	// 참거짓 출력
		System.out.println("문자열 포함 여부 : "+str1.contains("abs"));	// 참거짓 출력
		
		System.out.println("문자열 자르기 : "+str1.substring(2,6));	// 인덱스 2번부터 6번까지
		
		String str6="등산, 탁구, 축구, 골프, 독서, 영화감상";
		String [] result = str6.split(",");	// ,를 기준으로 가른 뒤 배열 result로 저장
		
		for(String hobby : result) {	// result 배열의 요소를 hobby에 저장, 출력
			System.out.println(hobby);
		}
		
	}
}

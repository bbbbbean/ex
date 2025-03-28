package Ch08;

class C07Simple{
	
	int sum(int ...arg) {	// ...arg : 파라미터 갯수가 미정일 때, 몇개의 값이든 받는 인자 -> 지정 자료형만 받음
		System.out.println(arg);
		int sum = 0;
		for(int item:arg) {
			System.out.println(item);
			sum += item;
		}
		return sum;
	}
	
}

public class C07가변인자 {
	public static void main(String[] args) {
		C07Simple ob = new C07Simple();
		int a = ob.sum(1,5,6,7,2,1,3,24,5,6,54,8,78,534,35456,21);	// [I@2ff4acd0
		System.out.println();
		int b = ob.sum(4,6,71,54,60,91);	// [I@54bedef2
		// [I@54bedef2 : 해당 형태가 뜨면 리스트 혹은 배열형이라고 인식
		
		System.out.println("합"+a);
		System.out.println("합"+b);
	}
}

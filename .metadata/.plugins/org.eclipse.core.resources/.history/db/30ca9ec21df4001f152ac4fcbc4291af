package Ch05;

public class C07IncDesArith {
	public static void main(String[] args) {
		int a=5, b=6, c=10, d;
		boolean e;
		d=++a*b--;	// a 전치, b 후치 6*6=36 == d, b=5
		 System.out.printf("a = %d, b = %d, d = %d\n", a, b, d);
		d=a++ + ++c - b--;	// 초기화 없이 진행, a,b 후치 -> 6 + 11 - 5 = 12=d, a=7, b=4
		System.out.printf("a = %d, b = %d, c = %d, d = %d\n", a, b, c, d);
		a=1;
		b=0;
		e=(a++>0)||((b*d/c)>0); // (true, a+1=2) / e = true, a=2, b=0, c=11, d=12
		System.out.printf("a = %d, b = %d, c = %d, d = %d ,e = %b\n", a, b, c, d , e);
		
	}
}	

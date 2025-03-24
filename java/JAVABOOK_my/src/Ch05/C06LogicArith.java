package Ch05;

public class C06LogicArith {
	public static void main(String[] args) {
		int a=0,b=0;
		boolean c;
		a = 1;
		b = 1;
		c =(++a>0)||(++b>0) ;	// or, 왼참-> 오른쪽X
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

		a = 1;
		b = 1;
		c = (++a>0)||(--b>0) ;	// or, 왼참 -> 오른쪽X
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

		a = 1;
		b = 1;
		c = (--a>0)||(++b>0) ;	// or, 0>0 false -> 1+1>2판별 -> true
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

		a = 1;
		b = 1;
		c = (--a>0)||(b-->0) ; // or, 1-1>0 false -> 1>0 true 1-1 = 0 b후치연산임.
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);
	}
}	

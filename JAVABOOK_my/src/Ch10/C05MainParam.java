package Ch10;

public class C05MainParam {
	public static void main(String[] args) {
		
		System.out.println("length : "+args.length);
		for(String param : args) {
			System.out.println(param);	// length : 0, public static void main(String[] args)에 전달한 인자가 없어서
		}
		
	}
}

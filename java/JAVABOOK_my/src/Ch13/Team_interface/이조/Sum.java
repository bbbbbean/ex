package Ch13.Team_interface.이조;

public class Sum implements Calculation {
	
	@Override
	public void sum(int x, int y) {
		System.out.println(x + y);
	}
	
	
	public void sum(int ...arg) {
		int sum = 0;
		for(int num : arg) {
			sum += num;
		}
		System.out.println(sum);
	}
	
	
	public void sum(double ...arg) {
		double sum = 0;
		for(double num : arg) {
			sum += num;
		}
		System.out.println(sum);
	}

	
	public void sum(String ...arg) {
		String sum = arg[0];
		for( int i = 1; i<arg.length; i++) {
			sum = sum + " + " + arg[i]  ;
		}
		
		System.out.println(sum);
	}
	
	
	public void sub(int x, int y) {
		
	}
	
	public void sub(int ...arg) {
		
	}
	
	public void sub(double ...arg) {
		
	}
	
	public void sub(String ...arg) {
		
	}
	
	
	public void div(int x, int y) {
		
	}
	
	public void div(int ...arg) {
		
	}
	
	public void div(double ...arg) {
		
	}
	
	public void div(String ...arg) {
		
	}
	
	
	public void mul(int x, int y) {
		
	}
	
	public void mul(int ...arg) {
		
	}
	
	public void mul(double ...arg) {
		
	}
	
	
	public void mul(String ...arg) {
		
	}
}

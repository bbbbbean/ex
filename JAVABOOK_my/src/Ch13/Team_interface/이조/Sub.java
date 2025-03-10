package Ch13.Team_interface.이조;

public class Sub implements Calculation{

	@Override
	public void sum(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sum(int... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sum(double... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sum(String... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub(int x, int y) {
	
		System.out.println(x-y);
		
	}

	@Override
	public void sub(int... arg) {

			int sub2=0;
			for(int item : arg) {
				sub2-=item;
			}
			System.out.println("n개 뺄셈 값 : " +sub2 );
		
	}

	@Override
	public void sub(double... arg) {
	
		double sub3=0;
		for(double item : arg) {
			sub3-=item;
		}
		System.out.println("n개 뺄셈 값 : " +sub3 );
		
	}

	@Override
	public void sub(String... arg) {
		
		String sub4="";
		for(String item : arg) {
			sub4+="-"+item;
		}
		System.out.println("n개 뺄셈 값 : " +sub4 );
		
	}

	@Override
	public void mul(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mul(int... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mul(double... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mul(String... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div(int... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div(double... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div(String... arg) {
		// TODO Auto-generated method stub
		
	}

	
	
}

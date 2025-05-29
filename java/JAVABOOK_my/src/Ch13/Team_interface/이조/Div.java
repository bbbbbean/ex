package Ch13.Team_interface.이조;

public class Div implements Calculation {

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub(int... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub(double... arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub(String... arg) {
		// TODO Auto-generated method stub
		
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
		double div = (double) x / y ;
		System.out.printf("%d / %d = %f\n", x, y, div);
	}

	@Override
	public void div(int... arg) {
		int div = arg[0];
		for(int i = 1; i <arg.length;i++) {
			div /= arg[i];
		}
		System.out.println(div);
	}

	@Override
	public void div(double... arg) {
		double div = arg[0];
		for(int i = 1; i < arg.length; i++) {
			div /= arg[i];
		}
		System.out.println(div);
	}

	@Override
	public void div(String... arg) {
		String div = "";
		for(String n : arg) {
			div += n;
		}
		System.out.println(div);
	}

}

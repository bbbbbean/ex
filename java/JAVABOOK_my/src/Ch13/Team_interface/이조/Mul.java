package Ch13.Team_interface.이조;

public class Mul implements Calculation{

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
	
	int x;
	int y;	

	@Override
	//2개 인자 받아 곱셈 화면 출력
	public void mul(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.printf("%d * %d = %d\n",x,y,x*y);
	}

	@Override
	//n개 인자 받아 곱셈 화면 출력
	public void mul(int... arg) {
		int mul = 1;
		for(int item:arg) {
			mul *= item;
		}
		System.out.println(mul);
	}

	@Override
	//n개 인자 받아 곱셈 화면 출력
	public void mul(double... arg) {
		double mul = 1;
		for(double item:arg){
			mul *= item;
		}
		System.out.println(mul);
	}

	@Override
	//n개 문자열받아 '*'를 기준으로 문자열덧붙여 출력
	public void mul(String... arg) {
		String mul = "";
		for(String item:arg){
			if(mul=="") {
				mul+=item;
			}else {
				mul += ("*"+item);
			}
		}
		System.out.println(mul);
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

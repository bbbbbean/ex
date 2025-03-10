package Ch13.Team_interface.이조;

public interface Calculation {
	//사칙연산의 결과를 담기위한 멤버변수를 만드세요(덧셈,뺄셈,곱셈,나눗셈별)	
	//사칙연산을 위한 추상 메서드를 만들고
	//해당 폴더에 있는 Div,Mul,Sub,Sum을 각각 역할 나눠서 함수를 완성하세요(C99Ex참고)
	//나머지는 자유롭게 - !
	
	void sum(int x, int y);		//2개 인자 받아 덧셈 화면 출력
	void sum(int ...arg);		//n개 인자 받아 덧셈 화면 출력
	void sum(double ...arg);	//n개 인자 받아 덧셈 화면 출력
	void sum(String ...arg);	//n개 문자열받아 '+'를 기준으로 문자열덧붙여 출력
	
	void sub(int x, int y);		//2개 인자 받아 뺄셈 화면 출력
	void sub(int ...arg);		//n개 인자 받아 뺄셈 화면 출력
	void sub(double ...arg);	//n개 인자 받아 뺄셈 화면 출력
	void sub(String ...arg);	//n개 문자열받아 '-'를 기준으로 문자열덧붙여 출력
	
	void mul(int x, int y);		//2개 인자 받아 곱셈 화면 출력
	void mul(int ...arg);		//n개 인자 받아 곱셈 화면 출력
	void mul(double ...arg);	//n개 인자 받아 곱셈 화면 출력
	void mul(String ...arg);	//n개 문자열받아 '*'를 기준으로 문자열덧붙여 출력
	
	void div(int x, int y);		//2개 인자 받아 나눗셈 화면 출력
	void div(int ...arg);		//n개 인자 받아 나눗셈 화면 출력
	void div(double ...arg);	//n개 인자 받아 나눗셈 화면 출력
	void div(String ...arg);	//n개 문자열받아 '/'를 기준으로 문자열덧붙여 출력
}

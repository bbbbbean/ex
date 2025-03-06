package Ch11;

// ### 디자인 패턴은 알아놔두기 ###
// 객체 생성시, 모니터시 등등 개념적으로는 알아두기

class Company{
	
	int n1;
	int n2;
	
	// toString
	@Override
	public String toString() {
		return "Company [n1=" + n1 + ", n2=" + n2 + "]";
	}
	
	// 싱글톤 패턴 : Servlet까지 사용
	// 싱글톤 패턴 구조
	private static Company instance;	// !중요 객체의 위치를 담을 수 있는 변수를 접근 제한 설정
	
	private Company() {}	// !중요 접근 불가. 객체 생성을 다른 위치에서 만들 수 없음 -> 외부에서 객체 생성 불가 설정
	public static Company getInstance() {	// !중요	getter, 위 instance가 private하기 때문에 생성
		// public이라 어느 위치에서건 사용 가능
		if(instance==null) {
			instance = new Company();
		}
		return instance;	// 위 private 변수 대신 getter에서 위치 정보 반환
	}
	
	
}



public class C03SingletonPattern {
	public static void main(String[] args) {
		// 개체 직접 생성 불가
		// Company test = new Company();
		
		Company com1 = Company.getInstance();	// 함수 호출 시점에서 
		Company com2 = Company.getInstance();
		
		com1.n1=100;
		com2.n2=100;
		
		System.out.println("com1 : "+com1);
		System.out.println("com2 : "+com2);
		
		
	}
}

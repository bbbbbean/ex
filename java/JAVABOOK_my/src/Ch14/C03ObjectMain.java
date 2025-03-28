package Ch14;

import java.util.Objects;

class C03Simple{
	int n;
	C03Simple(int n){
		this.n = n;
	}
	
	@Override	// equals함수 : 기존 위치 값(객체의 메모리주소값) 비교 -> n의 값 비교로 재정의
	public boolean equals(Object obj) {
		// int n에 접근하기 위해 downCasting 필요
		if(obj instanceof C03Simple) {
			C03Simple down = (C03Simple)obj;
			
			return this.n == down.n;
		}
	
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.n);
		// 그냥 들어가는 값 출력으로 설정(return this.n) -> 찝찝 할 수 있음 한번 더 꼬는 방법? Objects.hash() : 무의미한 값 출력
	}
	
	
	
}

public class C03ObjectMain {
	public static void main(String[] args) {
		C03Simple ob1 = new C03Simple(1);
		System.out.println(ob1.toString());	// Ch14.C03Simple@2ff4acd0, 재정의 후 Ch14.C03Simple@1, Objects.hash() 후 Ch14.C03Simple@20
		System.out.printf("%x\n",System.identityHashCode(ob1));	// 2ff4acd0
		
		C03Simple ob2 = new C03Simple(9);
		System.out.println(ob2.toString());	// Ch14.C03Simple@9, Objects.hash() 후 Ch14.C03Simple@28
	}
}

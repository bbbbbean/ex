package Ch34;

// 어노테이션 구현할 메인

@CustomAnnotation(value="HelloWorld",number=5,isOpen=true)
class Simple{
	String v1;
	int v2;
	boolean v3;
	
	Simple(){
		// reflection 이용, 객체가 생성된 시점에 어노테이션 정보 받아옴
		CustomAnnotation ref = this.getClass().getAnnotation(CustomAnnotation.class);
		System.out.println("value : "+ref.value());
		System.out.println("number : "+ref.number());
		System.out.println("isOpen : "+ref.isOpen());
		this.v1 = ref.value();
		this.v2 = ref.number();
		this.v3 = ref.isOpen();
	}
	
	@Override
	public String toString() {
		return "Simple [v1=" + v1 + ", v2=" + v2 + ", v3=" + v3 + "]";
	};
}

public class Main {
	public static void main(String[] args) {
		
		Simple obj = new Simple();
		System.out.println(obj);
		
		
	}
}

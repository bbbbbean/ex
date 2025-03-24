package Ch11;

// shopService 객체를 싱글톤으로 만들어 보세요 
// ShopServiceExample 클래스에서 shopService 의 getInstance() 메소드로 싱글톤을 얻을 수 있도록
// ShopService 클래스를 작성해보세요

class ShopService{
	
	private static ShopService instance;	// 접근 불가, 정적 참조 변수(싱글톤 객체를 담을 변수)
	private ShopService() {}				// private 생성자
	public static ShopService getInstance(){	// 대신 반환, getter 함수
		if(instance==null) {
			instance = new ShopService();	// getInstance()를 최초로 실행할 때에만 초기화 (지연 초기화)
		}
		return instance;
	}
	
	
	
}



public class C05Ex {
	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		// 여러번 호출해도 같은 instance 참조
		if (obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체 입니다.");
		}
	}
}

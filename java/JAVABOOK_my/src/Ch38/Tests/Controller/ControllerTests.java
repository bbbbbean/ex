package Ch38.Tests.Controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38.Controller.FrontController;

class ControllerTests {

	FrontController fc = FrontController.getInstance();
	
	@Test
	@Disabled
	void test() {
		// View에서 요청 정보 담기
		Map<String,Object> params = new HashMap();
		params.put("endPoint", "/user"); // endPoint
		params.put("serviceNo", 1);	// serviceNo
		// 회원가입 - 인자전달
		params.put("userid","ccccc");
		params.put("username","홍길동");
		params.put("password","1234");
		
		// 요청하기
		Map<String,Object> response = fc.execute(params);
		
		// 응답 확인
		for(String key:response.keySet()) {
			System.out.println(key+" : "+response.get(key));
		}
	}
	
	@Test
//	@Disabled
	void test1() {
		// view에서 요청 정보 담기
		Map<String,Object> params = new HashMap();
		params.put("endPoint", "/book");
		params.put("serviceNo", 1);
		// 도서 수정 - 인자 전달
		params.put("bookCode", "12345678");
		params.put("bookName", "1234567890");
		params.put("Publisher", "12345678");
		params.put("isbn", "12345678");
		
		// 요청
		Map<String,Object> response = fc.execute(params);
		
		// 응답확인
		for(String key : response.keySet()) {
			System.out.println(key+" : "+response.keySet());
		}
	}


}

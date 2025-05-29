package Ch38.Controller;

import java.util.Map;

public interface SubController {
	// API문서화에서 정한 요청 파라미터와 응답 형태(반환 형태)에 맞춰 제작
	// 예시 회원가입 "Success" : boolean - String : Object의 형태
	public Map<String,Object> execute (Map<String,Object> params);
	
	
	
	
	
}

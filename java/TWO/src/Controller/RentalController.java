package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.RentalDTO;
import Service.RentalService;

public class RentalController implements Controller{
	// rental service 연결
	private RentalService rentalService;
	public RentalController() {
		try {
			rentalService = RentalService.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Map<String,Object> response;
	
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("RentalController execute Invoke");
		response = new HashMap();
		Integer serviceNo = (Integer)params.get("serviceNo");
		// 값을 입력하지 않은 경우
		if(serviceNo==null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 요청입니다.");
			return response;
		}
		try {
			// C/R/U/D
			switch(serviceNo) {
			case 1:	// C : 대여하기
				System.out.println("대여하기");
				break;
			case 2:	// R : 대여 조회
				System.out.println("대여 조회");
				break;
			case 3:	// U : 대여 정보 수정
				System.out.println("대여 정보 수정");
				String rentalId = params.get("rentalId")!=null?(String)params.get("rentalId"):null;
				String bookCode = params.get("bookCode")!=null?(String)params.get("bookCode"):null;
				String memberId = params.get("memberId")!=null?(String)params.get("memberId"):null;
				RentalDTO rentalDto = new RentalDTO(rentalId,bookCode,memberId);
				
				// 유효성체크
				boolean isOk = isValid(rentalDto);
				System.out.println("[대여 정보 수정] : 유효성 검증 확인 : "+isOk);
				
				if(!isOk) {
					response.put("status", false);
					return response;
				}
				
				// 관련 서비스 실행
				boolean isSuccess = rentalService.RentalUpdate(rentalDto);
				// 뷰로 이동
				if(isSuccess) {
					response.put("status", isSuccess);
					response.put("message", "대여 정보 수정 성공");
				}
				
				break;
			case 4:	// D : 대여 취소
				System.out.println("대여 취소");
				break;
			default :
				System.out.println("잘못된 서비스번호 요청 확인");
				response.put("status", false);
				response.put("message", "대여 정보 수정 성공");
			}
		}catch(Exception e) {}
		return response;
	}
	// 유효성 검사
	private boolean isValid(RentalDTO rentalDto) {
		if(!rentalDto.getRentalId().matches("^[0-9]*$")) {
			response.put("error", "숫자만 입력 가능합니다.");
			System.out.println("숫자만 입력 가능합니다.");
			return false;
		}
		return true;
	}
	
	
	
	
	
}

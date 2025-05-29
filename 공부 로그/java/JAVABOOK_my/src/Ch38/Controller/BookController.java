package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch38.Domain.Dto.BookDto;
import Ch38.Domain.Service.BookServiceImpl;

public class BookController implements SubController {
	
	// BookService 연결
	private BookServiceImpl bookService;
	public BookController() {
		try {
			bookService = BookServiceImpl.getInstance();
		}catch(Exception e) {
			exceptionHandler(e);
		}
	}

	Map<String, Object> response;
	
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("[SC] BookController execute Invoke");
		// 00 기본 설정
		response = new HashMap();
		Integer serviceNo = (Integer)params.get("serviceNo");
		// 값 입력 X -> null
		if(serviceNo==null) {
			response.put("status", false);
			response.put("message","유효하지 않은 서비스 요청입니다");
			return response;
		}
		// 스위치 사용 번호 판별
		try {
			switch(serviceNo) {
			case 1:	// C - 도서 등록(role - 사서, 관리자)
				System.out.println("[SC] 도서 등록 요청 확인");
				// 01 파라미터 받기(정보 선별, 잘들어왔는가)
				String bookCode = params.get("bookCode")!=null?(String)params.get("bookCode"):null;
				String bookName = params.get("bookName")!=null?(String)params.get("bookName"):null;
				String Publisher = params.get("Publisher")!=null?(String)params.get("Publisher"):null;
				String isbn = params.get("isbn")!=null?(String)params.get("isbn"):null;
				BookDto bookDto = new BookDto(bookCode,bookName,Publisher,isbn);
				
				// 02 유효성 체크(Validation)
				boolean isOk = isValid(bookDto);
				System.out.println("[No01 도서등록] : 유효성 검증 확인 : "+isOk);
				
				if(!isOk) {
					response.put("status",false);
					return response;
				}
				
				// 03 관련 서비스 실행
				boolean isSuccess = bookService.BookRegistration(bookDto); // 서비스 성공 유무 전달
				// 04 뷰로 이동(or 내용 전달)
				if(isSuccess) {
					response.put("status", isSuccess);
					response.put("message", "책 생성 성공");
				}
				
				break;
			case 2:	// R - 도서 조회(role - 회원, 사서, 관리자)
				System.out.println("[SC] 도서 조회 요청 확인");
				// 01 파라미터 받기(정보 선별, 잘들어왔는가)
				// 02 유효성 체크(Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용 전달)			
				break;
			case 3:	// U - 도서 수정(role - 사서, 관리자)
				System.out.println("[SC] 도서 수정 요청 확인");
				// 01 파라미터 받기(정보 선별, 잘들어왔는가)
				// 02 유효성 체크(Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용 전달)			
				break;
			case 4:	// D - 도서 삭제 (role - 사서, 관리자)
				System.out.println("[SC] 도서 삭제 요청 확인");
				// 01 파라미터 받기(정보 선별, 잘들어왔는가)
				// 02 유효성 체크(Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용 전달)			
				break;
			default :
				System.out.println("[SC] ");
				response.put("status", false);
				response.put("message", "잘못된 서비스 번호 요청입니다");
			}
		}catch(Exception e) {exceptionHandler(e);}	
		return response;
	}
	// 유효성 검사
	private boolean isValid(BookDto bookDto) {
		if(bookDto.getBookCode()==null) {
			response.put("error", "bookCode를 비울 수 없습니다.");
			System.out.println("[INVALID] bookCode를 비울 수 없습니다");
			return false;
		}
		if(bookDto.getBookCode().length()!=8) {
			response.put("error", "bookCode는 8글자");
			System.out.println("[INVALID] 8글자를 입력해주세요");
			return false;
		}
		if(bookDto.getBookName().length()>255) {
			response.put("error", "bookName은 255글자를 넘길 수 없습니다");
			System.out.println("[INVALID] bookName은 255글자를 넘길 수 없습니다");
			return false;
		}
		return true;
	}
	// 예외 처리 함수
	public Map<String, Object> exceptionHandler(Exception e){
		
		if(response==null) response=new HashMap();
		
		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("exception", e);
		return response;
	}

}

package Domain.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dto.BookDto;
import Domain.Dto.Criteria;
import Domain.Dto.PageDto;

public class BookServiceImpl {
	// BookController랑 연결 - BookController에서 해주기
	// DB와 연결 - BookDao
	private BookDao bookDao;
	
	// 싱글톤
	private static BookServiceImpl instance;
	private BookServiceImpl() throws Exception {
		// DB-BookDao 연결
		bookDao = BookDaoImpl.getInstance();
		System.out.println("[SERVICE] BookServiceImpl init");
	}
	public static BookServiceImpl getInstance() throws Exception {
		if(instance == null)
			instance = new BookServiceImpl();
		return instance;
	}
	
	// 서비스 생성
	// 도서 생성(추가)
	// TX처리 + 비즈니스 유효성 검사(회사 특성(정책)에 맞는 유효성 검사)
	public boolean BookRegistration(BookDto bookDto) throws Exception {
		return bookDao.insert(bookDto)>0;
	}
	
	// 도서 전체 조회
	public Map<String,Object> getAllBooks() throws Exception{
		Map<String,Object> response = new LinkedHashMap();
		List<BookDto> list = bookDao.selectAll();
		if(list.size()!=0) {
			response.put("status",true);
			response.put("list",list);
		}else {
			response.put("status", false);
		}
		return response;
	}
	
	// 도서 단건 조회
	public Map<String, Object> getBook(String bookcode) throws Exception {
		Map<String, Object> response = new LinkedHashMap();
		
		BookDto bookDto = bookDao.select(bookcode);
		// response에 bookDto를 담아야함
		// 제대로 값을 못받아온 경우
		if(bookDto==null) {
			response.put("status",false);
		}else {
			response.put("status",true);
			response.put("bookDto",bookDto);
		}
		
		return response;
	}
	
	// 도서 수정
	public Map<String, Object> modifyBook(BookDto bookDto) throws Exception {
		Map<String, Object> response = new LinkedHashMap();
		
		int result = bookDao.update(bookDto);
		if(result<0)
			response.put("status", false);
		else {
			response.put("status", true);
			response.put("bookDto", bookDto);
		}
		
		return response;
	}
	
	//public boolean modifyBook(BookDto bookDto) throws Exception {
	//	
	//	int result = bookDao.update(bookDto);
	//	// 수정 성공 여부만 따지면 되니까 그냥 boolean형으로 던져서 간단하게 처리
	//	return result>0;
	//}
	
	// 도서 삭제
	public boolean removeBook(String bookCode) throws Exception {
		int result = bookDao.delete(bookCode);
		return result>0;
	}
	
	// 페이지
	public Map<String, Object> getAllBooks(Criteria criteria) throws Exception {
		Map<String,Object> response = new LinkedHashMap();
		
		if(criteria.getType()==null || criteria.getType().isEmpty()) {
		// 타입이 없는 상황 == 검색을 하지 않은 전체 검색 상황
			// 페이지 갯수대로 출력 쿼리 : limit 인덱스번호,표시하고자 하는 수량
			// limit 0,10 - 1~10
			// limit 10,10 - 11~20
			// limit 20,10 - 21~30
			// 뒤의 수량 고정
			// 앞 인덱스 번호(offset)만 변함
			int offset = (criteria.getPageno()-1) * criteria.getAmount();
			// 페이지별 건수
			List<BookDto> list = bookDao.selectAll(offset,criteria.getAmount());
			
			// 현재 받아온 것 : 페이지를 기준으로 10건의 데이터
			// 페이징 처리를 하기 위한 요소들을 받아오지 않음
			// 페이징 처리 시작
			// 필요한 거 : 전체 게시글 건수(count) -> 페이지 수 도출 -> 블럭 수 도촐
			long totalcount = bookDao.count();
			PageDto pageDto = new PageDto(totalcount,criteria);
			
			
			if(list.size()!=0) {
				response.put("status",true);
				response.put("list",list);
				response.put("pageDto",pageDto);
			}else {
				response.put("status", false);
			}
		}else {
			// offset 동일
			int offset = (criteria.getPageno()-1) * criteria.getAmount();
			// 페이지별 건수 - type, keyword 고려
			int amount = criteria.getAmount();
			String type = criteria.getType();
			String keyword = criteria.getKeyword();
			List<BookDto> list = bookDao.selectAll(offset,amount,type,keyword);
			
			// pageDto
			long totalcount = bookDao.count(criteria);
			PageDto pageDto = new PageDto(totalcount,criteria);
			
			if(list.size()>0) {
				response.put("status",true);
				response.put("list",list);
				response.put("pageDto",pageDto);
			}else {
				response.put("status", false);
			}
		}
		return response;
	}
	
	
	
	
	
	
	
	
}

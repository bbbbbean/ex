package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.Dao.BookDao;
import Ch38.Domain.Dao.BookDaoImpl;
import Ch38.Domain.Dto.BookDto;

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
	
	// 도서 수정
	
	// 도서 조회
	
	// 도서 삭제
	
	
	
}

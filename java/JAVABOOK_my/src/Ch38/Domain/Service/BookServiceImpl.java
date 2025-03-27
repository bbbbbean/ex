package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.Dao.BookDaoImpl;
import Ch38.Domain.Dto.BookDto;

public class BookServiceImpl {
	
	// DB와 연결 - BookDao
	private BookDaoImpl bookDao;
	
	// 싱글톤
	private static BookServiceImpl instance;
	private BookServiceImpl() throws ClassNotFoundException, SQLException {
		// DB-BookDao 연결
		bookDao = BookDaoImpl.getInstance();
		System.out.println("[SERVICE] BookServiceImpl init");
	}
	public static BookServiceImpl getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null)
			instance = new BookServiceImpl();
		return instance;
	}
	
	// 서비스 생성
	// 도서 생성
	public boolean BookCreate(BookDto bookDto) throws SQLException {
		return bookDao.insert(bookDto)>0;
	}
	
	// 도서 수정
	
	// 도서 조회
	
	// 도서 삭제
	
	
	
}

package Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Domain.Dto.BookDto;

public interface BookDao {

	// CRUD 함수
	int insert(BookDto bookDto) throws Exception;

	int update(BookDto bookDto) throws SQLException;

	int delete(BookDto bookDto) throws SQLException;

	BookDto select(BookDto bookDto);

	public List<BookDto> selectAll() throws Exception;

	public List<BookDto> selectAll(int offset, int amount) throws Exception;

	long count() throws Exception;

}
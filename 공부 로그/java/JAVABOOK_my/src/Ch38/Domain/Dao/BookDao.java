package Ch38.Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.BookDto;

public interface BookDao {

	// CRUD 함수
	int insert(BookDto bookDto) throws Exception;

	int update(BookDto bookDto) throws SQLException;

	int delete(BookDto bookDto) throws SQLException;

	BookDto select(BookDto bookDto);

	List<BookDto> selectAll();

}
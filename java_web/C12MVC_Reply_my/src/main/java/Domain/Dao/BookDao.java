package Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Domain.Dto.BookDto;
import Domain.Dto.Criteria;

public interface BookDao {

	// CRUD 함수
	int insert(BookDto bookDto) throws Exception;

	int update(BookDto bookDto) throws SQLException, Exception;

	int delete(String bookCode) throws Exception;

	BookDto select(BookDto bookDto);

	public List<BookDto> selectAll() throws Exception;

	public List<BookDto> selectAll(int offset, int amount) throws Exception;

	long count() throws Exception;

	BookDto select(String bookcode) throws Exception;

	List<BookDto> selectAll(int offset, int amount, String type, String keyword) throws Exception;

	public long count(Criteria criteria) throws Exception;

}
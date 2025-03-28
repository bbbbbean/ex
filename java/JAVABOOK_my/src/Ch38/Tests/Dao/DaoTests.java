package Ch38.Tests.Dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38.Domain.Dao.BookDao;
import Ch38.Domain.Dao.BookDaoImpl;
import Ch38.Domain.Dao.UserDao;
import Ch38.Domain.Dao.UserDaoImpl;
import Ch38.Domain.Dto.BookDto;
import Ch38.Domain.Dto.UserDto;

class DaoTests {

	@Test
	@Disabled
	void test1() throws Exception{
		UserDao userDaoImpl = UserDaoImpl.getInstance();
	}
	
	@Test
//	@Disabled
	void test2() throws Exception {
		UserDao userDaoImpl = UserDaoImpl.getInstance();
		userDaoImpl.insert(new UserDto("ccc","백길동","1234",""));
	}
	
	@Test
	void test3() throws Exception {
		BookDao bookDaoImpl = BookDaoImpl.getInstance();
		bookDaoImpl.insert(new BookDto("87654321","책책책","씀씀씀","번호"));
	}
	
//	@Test
//	void test3() {
//	}

}

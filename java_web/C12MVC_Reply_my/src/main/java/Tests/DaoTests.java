package Tests;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dao.BookReplyDaoImpl;
import Domain.Dao.UserDao;
import Domain.Dao.UserDaoImpl;
import Domain.Dto.BookDto;
import Domain.Dto.BookReplyDto;
import Domain.Dto.UserDto;

class DaoTests {
	
	@Test
	@Disabled
	void test() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
		
		userDao.insert(new UserDto("user123511","1234","ROLE_USER"));
	}
	
	@Test
	@Disabled
	void test2() throws Exception {
		BookDao bookDao = BookDaoImpl.getInstance();
		
		bookDao.insert(new BookDto("1111","책제목","출판사","111-111"));
	}

	@Test
	@Disabled
	void test1() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
		System.out.println(userDao.select("user1"));
	}

	@Test
	//@Disabled
	void test3() throws Exception {
		BookReplyDaoImpl.getInstance().insert(new BookReplyDto(-1,"CDJ000025503","user3","내용",LocalDateTime.now()));
	}
	
	@Test
	//@Disabled
	void test4() throws Exception {
		BookReplyDaoImpl.getInstance().selectAll("CDJ000025503").forEach(System.out::println);
	}
}



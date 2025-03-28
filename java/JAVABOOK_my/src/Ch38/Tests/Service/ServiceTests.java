package Ch38.Tests.Service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38.Domain.Dto.BookDto;
import Ch38.Domain.Dto.UserDto;
import Ch38.Domain.Service.BookServiceImpl;
import Ch38.Domain.Service.UserServiceImpl;

class ServiceTests {

	
	@Test
//	@Disabled
	void test() throws Exception {
		UserServiceImpl userService = UserServiceImpl.getInstance();
		userService.UserJoin(new UserDto("bbb","청길동","1234","ROLE_USER"));
//		userService.UserJoin(null);
	}

	@Test
	@Disabled
	void test99() throws Exception {
		BookServiceImpl bookService = BookServiceImpl.getInstance();
		bookService.BookRegistration(new BookDto("12345678","책이름","출판","123456"));
	}
}

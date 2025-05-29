package Tests;

import org.junit.jupiter.api.Test;

import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

class ServiceTests {

	@Test
	//@Disabled
	void test() throws Exception {
		BookServiceImpl.getInstance().BookRegistration(new BookDto("2222","제ㅔㅔ목","어ㅓㅓ디","222-222"));
	}

}

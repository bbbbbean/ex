package Tests;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Domain.Dto.BookDto;
import Domain.Dto.BookReplyDto;
import Domain.Service.BookServiceImpl;

class ServiceTests {

	@Test
	@Disabled
	void test() throws Exception {
		BookServiceImpl.getInstance().BookRegistration(new BookDto("2222","제ㅔㅔ목","어ㅓㅓ디","222-222"));
	}
	
	@Test
	//@Disabled
	void test1() throws Exception {
		BookServiceImpl.getInstance().bookReplyAdd(new BookReplyDto(-1,"CDJ000025503","user1","댓글내용",LocalDateTime.now()));
	}


}

package Ch38.Tests.Service;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38.Domain.Dto.UserDto;
import Ch38.Domain.Service.UserServiceImpl;

class ServiceTests {

	
	@Test
//	@Disabled
	void test() throws ClassNotFoundException, SQLException {
		UserServiceImpl userService = UserServiceImpl.getInstance();
		userService.UserJoin(new UserDto("bbb","청길동","1234","ROLE_USER"));
	}

	@Test
	@Disabled
	void test99() {
		
	}
}

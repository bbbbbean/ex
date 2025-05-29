package DbTests;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.mapper.UserMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class ExTest {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private UserMapper userMapper;

	
	
	@Test	
	public void user_test() {
		UserDto dto1 = UserDto.builder()
				.userid("abab")
				.username("홍길동")
				.password("1234")
				.build();
		UserDto dto2 = UserDto.builder()
				.userid("cdcd")
				.username("남길동")
				.password("1234")
				.build();		
		
		userMapper.insert(dto1);
		userMapper.insert(dto2);
		dto1.setAddr1("대구");
		userMapper.update(dto1);
		userMapper.delete("cdcd");
		
		System.out.println(userMapper.selectAt("abab"));
		
		List<UserDto> list1 = userMapper.selectAll();
		list1.forEach(System.out::println);
		
		List<Map<String,Object>>list2 = userMapper.selectAllResultXml();
		list2.forEach(System.out::println);
		
	}

}
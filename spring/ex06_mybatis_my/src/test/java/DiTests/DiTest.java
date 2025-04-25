package DiTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.config.PersonComponent;
import com.example.app.domain.dto.PersonDto;

//1. maven에 의존 라이브러리 활성화

// 기능 확장
@ExtendWith(SpringExtension.class)
// context영역 활성화
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DiTest {

	@Autowired
	private PersonDto personDto1;
	@Autowired
	private PersonDto personDto2;
	@Autowired
	private PersonDto person03;
	@Autowired
	private PersonDto personBean;
	@Autowired
	private PersonDto person05;
	@Autowired
	// 이름 지정 X시 앞글자 소문자 변환 후 그대로
	private PersonComponent personComponent;
	
	@Test
	@Disabled
	public void test() {
		System.out.println(personDto1);
		System.out.println(personDto2);
		System.out.println(person03);
		System.out.println(personBean);
		System.out.println(person05);
		System.out.println(personComponent);
	}

	// 안에 들어있는 걸 꺼내 씀
	// 하나만 존재, 이름 신경 쓸 필요 없음
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void test2() {
		// null 체크 - 문제가 안뜨면(초록이면) not null 체크된 셈
		assertNotNull(applicationContext);
		// bean 꺼내기
		System.out.println(applicationContext.getBean("personDto1"));
		System.out.println(applicationContext.getBean("person03"));
		System.out.println(applicationContext.getBean("personComponent"));
	}
}

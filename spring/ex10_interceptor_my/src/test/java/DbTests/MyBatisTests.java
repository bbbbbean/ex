package DbTests;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;

//기능 확장
@ExtendWith(SpringExtension.class)
//context영역 활성화
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

class MyBatisTests {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory; 

	@Autowired
	private MemoMapper memoMapper;
	
	@Test
	@Disabled
	void test() {
		assertNotNull(sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		assertNotNull(sqlSession);
		Connection conn = sqlSession.getConnection();
	}
	@Test
	@Disabled
	void test1() {
		//memoMapper.insert(new MemoDto(1013,"a","a@naver.com",LocalDateTime.now(), LocalDate.now()));
		//memoMapper.update(new MemoDto(1013,"b","b@naver.com",LocalDateTime.now(), LocalDate.now()));
		//memoMapper.delete(1013);
		//System.out.println(memoMapper.selectAt(1010));
		//List<MemoDto> list = memoMapper.selectAll();
		//list.forEach(System.out::println);
		
		//List<Map<String,Object>> list = memoMapper.selectAllResultMap();
		//list.forEach(System.out::println);
		
		// XML 방식
		// xml파일 내 경로 지정 주의!!!
		//memoMapper.insertXml(new MemoDto(1011,"a","a@naver.com",LocalDateTime.now(), LocalDate.now()));
		//List<Map<String,Object>> list = memoMapper.selectAllResultMapXml();
		//list.forEach(System.out::println);
		
		// select 키 적용
		MemoDto memo = new MemoDto(null,"a","a@naver.com",LocalDateTime.now(), LocalDate.now());
		//memoMapper.insert(memo);
		memoMapper.insertXml(memo);
		System.out.println("result : "+memo);

	}
	@Test
	//@Disabled
	void test3() {
		Map<String,Object> param = new HashMap();
		param.put("type", "writer");
		param.put("keyword", "exa");
		
//		List<Map<String,Object>> response = memoMapper.Select_if_xml(param);
//		response.forEach(System.out::println);

		List<Map<String,Object>> response = memoMapper.Select_when_xml(param);
		response.forEach(System.out::println);
		
		
		
	}

}

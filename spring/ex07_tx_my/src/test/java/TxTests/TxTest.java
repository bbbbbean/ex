package TxTests;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.service.MemoServiceImpl;

//기능 확장
@ExtendWith(SpringExtension.class)
//context영역 활성화
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class TxTest {

	@Autowired
	private MemoServiceImpl memoService;
	
	@Test
	void test() {
		memoService.addMemoTx(new MemoDto(1112,"a","aa",LocalDateTime.now(),null));
	}

}

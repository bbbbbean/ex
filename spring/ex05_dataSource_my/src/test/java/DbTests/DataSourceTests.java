package DbTests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//기능 확장
@ExtendWith(SpringExtension.class)
//context영역 활성화
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

class DataSourceTests {

	// 상위 클래스로 연결 (업캐스팅)
	// root-context의 id부분
	@Autowired
	private DataSource dataSource1;
	
	@Test
	void test1() throws SQLException {
		System.out.println(dataSource1);
		Connection con = dataSource1.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into tbl_book values('asdf','asdf','asdf','asdf')");
		pstmt.executeUpdate();
	}

}

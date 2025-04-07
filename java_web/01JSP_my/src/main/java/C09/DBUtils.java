package C09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import C04.UserDto;

public class DBUtils {
	// DB 관련 코드 다 넣을 예정
	

	// 아래 경로는 시험 문제에 제공
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;	// 시험장에서 정리.. 안해도 뭐..
	private PreparedStatement pstmt;	// 정리 잘하기
	private ResultSet rs;	// 정리 잘하기
	
	
	// 싱글톤 패턴 처리 - 가능하다면
	private static DBUtils instance;
	private DBUtils() throws Exception {
		// 생성자에서 처리
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}
	public static DBUtils getInstance() throws Exception {
		if(instance == null)
			instance = new DBUtils();
		return instance;
	}
	
	// 3~4개 있을 예정,.. 이름 다양하게 해서 잘 빼쓰기
	// User
	public int insertUser(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	public UserDto selectOneUser(String userid) throws Exception{
		pstmt = conn.prepareStatement("select * from tbl_user where userid=?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		UserDto userDto = null;
		if(rs != null) {
			while(rs.next()) {
				userDto = new UserDto();
				userDto.setUserid(rs.getString("userid"));
				userDto.setPassword(rs.getString("password"));
				userDto.setRole(rs.getString("role"));
			}
		}
		rs.close();
		pstmt.close();
		return userDto;
	}
	public List<UserDto> selectAllUser() throws Exception{
		pstmt = conn.prepareStatement("select * from tbl_user");
		rs = pstmt.executeQuery();
		List<UserDto> list = new ArrayList();
		UserDto userDto = null;

		if(rs != null) {
			while(rs.next()) {
				userDto = new UserDto();
				userDto.setUserid(rs.getString("userid"));
				userDto.setPassword(rs.getString("password"));
				userDto.setRole(rs.getString("role"));
				list.add(userDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	public int updateUser(UserDto userDto) throws Exception{
		pstmt = conn.prepareStatement("update tbl_user set userid=?, password=?, role=? where userid=?");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		pstmt.setString(4, userDto.getUserid());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	public int deleteUser(String userid) throws Exception {
		pstmt = conn.prepareStatement("delete from tbl_user where userid=?");
		pstmt.setString(1, userid);
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	// Order
	public List<OrderDto> selectAllOrder() throws Exception{
		// sql 문 : 구매금액이 50000원 이상인 품목 조회
		// select category, sum(price*quantity)
		// from tbl_order
		// group by category
		// having sum(price*quantity)>=50000
		// order by sum(price*quantity) desc;
		// ; 세미 콜론 빼기
		
		String sql = "select category, sum(price*quantity) from tbl_order"
				+ " group by category"
				+ " having sum(price*quantity)>=50000"
				+ " order by sum(price*quantity) desc";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<OrderDto> list = new ArrayList();
		OrderDto orderDto = null;

		if(rs != null) {
			while(rs.next()) {
				// 위 쿼리문 맞춰서 orderDto 만들기
				orderDto = new OrderDto();
				orderDto.setCategory(rs.getString(1));	// 이름 애매하면 그냥 인덱스 지정해도 됨
				orderDto.setSum(rs.getInt(2));
				list.add(orderDto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	// selectAllOrder2
	public List<OrderDto2> selectAllOrder2() throws Exception{
		// select order_date,round(avg(price*quantity),2)  -- 결과값 2자리수 까지만 표기
		// from tbl_order
		// group by order_date;
		
		String sql = "select order_date,round(avg(price*quantity),2)"
				+ " from tbl_order"
				+ " group by order_date";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		List<OrderDto2> list = new ArrayList();
		OrderDto2 orderDto2 = null;

		if(rs != null) {
			while(rs.next()) {
				orderDto2 = new OrderDto2();
				// 날짜 정보 : .toLocalDate() 변환 !
				orderDto2.setOrder_date(rs.getDate(1).toLocalDate());
				orderDto2.setAverage(rs.getDouble(2));
				list.add(orderDto2);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	// selectAllOrder3
	public List<OrderDto3> selectAllOrder3() throws Exception{
		// select addr, order_date, sum(price*quantity)
		// from tbl_user
		// join tbl_order
		// on tbl_user.userid=tbl_order.userid
		// group by addr, order_date
		// order by addr, sum(price*quantity) desc;
		
		
		
		String sql = "select addr, order_date, sum(price*quantity)"
				+ " from tbl_user"
				+ " join tbl_order"
				+ " on tbl_user.userid=tbl_order.userid"
				+ " group by addr, order_date"
				+ " order by addr, sum(price*quantity) desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<OrderDto3> list = new ArrayList();
		OrderDto3 orderDto3 = null;

		if(rs != null) {
			while(rs.next()) {
				orderDto3 = new OrderDto3();
				orderDto3.setAddr(rs.getString(1));
				orderDto3.setOrder_date(rs.getDate(2).toLocalDate());
				orderDto3.setSum_price(rs.getInt(3));
				list.add(orderDto3);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	// selectAllOrder4
		public List<OrderDto4> selectAllOrder4() throws Exception{
			// select tbl_user.userid, addr, quantity from tbl_user
			// left outer join tbl_order
			// on tbl_user.userid=tbl_order.userid
			// where tbl_order.userid is null;
			
			String sql = "select tbl_user.userid, addr, quantity from tbl_user"
					+ " left outer join tbl_order"
					+ " on tbl_user.userid=tbl_order.userid"
					+ " where tbl_order.userid is null";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<OrderDto4> list = new ArrayList();
			OrderDto4 orderDto4 = null;

			if(rs != null) {
				while(rs.next()) {
					orderDto4 = new OrderDto4();
					orderDto4.setUserid(rs.getString(1));
					orderDto4.setAddr(rs.getString(2));
					orderDto4.setQuantity(rs.getInt(3));
					list.add(orderDto4);
				}
			}
			rs.close();
			pstmt.close();
			return list;
		}
}

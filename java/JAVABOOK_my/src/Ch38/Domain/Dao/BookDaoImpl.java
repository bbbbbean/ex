package Ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dao.ConnectionPool.ConnectionItem;
import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38.Domain.Dto.BookDto;

public class BookDaoImpl extends Dao implements BookDao {

	// DB연결에 필요한 클래스 먼저 정리
	// DB Attr
	// 겹치는 부분은 추후에 상위로 빼주기
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
		
//	private String id = "root";
//	private String pw = "1234";
//	private String url = "jdbc:mysql://localhost:3306/bookDB";
	
	// connection pool
//	private ConnectionPool connectionPool;
	// connection pool에서 가져 온 item
//	private ConnectionItem connectionItem;
	
	private static BookDao instance;
	private BookDaoImpl() throws Exception {
		// DB연결
//		System.out.println("[DAO] BookDaoImpl init");
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url,id,pw);
		
		// 상단 주석 대신 connection pool 연결
//		connectionPool = ConnectionPool.getInstance();
		
		System.out.println("BookDaoImpl DB Connection Success");
	}
	public static BookDao getInstance() throws Exception {
		if(instance==null)
			instance = new BookDaoImpl();
		return instance;
	}
	
	// CRUD 함수
	@Override
	public int insert(BookDto bookDto) throws Exception {
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			// Dto에서 받은 쿼리문 실행
			// Dto에 맞게 컬럼 생성
			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
			pstmt.setString(1,bookDto.getBookCode());
			pstmt.setString(2,bookDto.getBookName());
			pstmt.setString(3,bookDto.getPublisher());
			pstmt.setString(4,bookDto.getIsbn());
			
			// connection release
			connectionPool.releaseConnection(connectionItem);
			
			return pstmt.executeUpdate();
				
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookDao's Insert SQL Exception");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	@Override
	public int update(BookDto bookDto) throws SQLException {
		// 원래 여기서 예외처리 안함, 커넥션풀이 없어서 임시 작업
//		try {
//			// Dto에서 받은 쿼리문 실행
//			pstmt = conn.prepareStatement("");
//			
//			return pstmt.executeUpdate();
//				
//		}catch(SQLException e){
//			e.printStackTrace();
//			throw new SQLException("BookDao's Insert SQL Exception");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
		return 0;
	}
	@Override
	public int delete(BookDto bookDto) throws SQLException {
		// 원래 여기서 예외처리 안함, 커넥션풀이 없어서 임시 작업
//		try {
//			// Dto에서 받은 쿼리문 실행
//			pstmt = conn.prepareStatement("");
//						
//			return pstmt.executeUpdate();
//			
//		}catch(SQLException e){
//			e.printStackTrace();
//			throw new SQLException("BookDao's Insert SQL Exception");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
		return 0;
	}
	@Override
	public BookDto select(BookDto bookDto) {
		return null;
	}
	@Override
	public List<BookDto> selectAll() {
		return null;
	}
}
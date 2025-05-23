package Domain.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Domain.Dto.BookDto;
import Domain.Dto.Criteria;
import Domain.Dto.UserDto;

public class BookDaoImpl extends Dao implements BookDao {

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
	public int update(BookDto bookDto) throws Exception {
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			// 
			pstmt = conn.prepareStatement("update tbl_book set bookcode=?,bookname=?,publisher=?,isbn=? where bookcode=?");
			pstmt.setString(1,bookDto.getBookCode());
			pstmt.setString(2,bookDto.getBookName());
			pstmt.setString(3,bookDto.getPublisher());
			pstmt.setString(4,bookDto.getIsbn());
			pstmt.setString(5,bookDto.getBookCode());

			
			// connection release
			connectionPool.releaseConnection(connectionItem);
			
			return pstmt.executeUpdate();
				
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookDao's Update SQL Exception");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	@Override
	public int delete(String bookCode) throws Exception {
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			// 
			pstmt = conn.prepareStatement("delete from tbl_book where bookcode=?");
			pstmt.setString(1,bookCode);
			
			// connection release
			connectionPool.releaseConnection(connectionItem);
			
			return pstmt.executeUpdate();
				
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookDao's Delete SQL Exception");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	@Override
	public BookDto select(BookDto bookDto) {
		return null;
	}
	
	// 전체 조회
	@Override
	public List<BookDto> selectAll() throws Exception {
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			List<BookDto> list = new LinkedList();
			BookDto book =null;
			
			pstmt = conn.prepareStatement("select * from tbl_book");
			
			rs = pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					book = new BookDto();
					book.setBookCode(rs.getString(1));
					book.setBookName(rs.getString(2));
					book.setPublisher(rs.getString(3));
					book.setIsbn(rs.getString(4));
					
					list.add(book);
				}
			}
			return list;
			
			// connection release
			//connectionPool.releaseConnection(connectionItem);
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookDao's selectAll SQL Exception");
		}finally {
			try {rs.close();pstmt.close();}catch(Exception e2) {}
			//Connection release
			connectionPool.releaseConnection(connectionItem);
		}
	}
	
	// 단건 조회
	@Override
	public BookDto select(String bookcode) throws Exception {
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("select * from tbl_book where bookcode=?");
			pstmt.setString(1, bookcode);
			// rs에 꼭 담아주기!
			rs = pstmt.executeQuery();
			
			BookDto book = null;
			
			if(rs!=null) { 
				while(rs.next()) {
					book = new BookDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				}
			}
			
			return book;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new SQLException("BookDAO's select SQL EXCEPTION!!");
		}finally {
			try {rs.close(); pstmt.close();}catch(Exception e2) {}

			//Connection release
			connectionPool.releaseConnection(connectionItem);
		}
	}
	
	@Override
	public List<BookDto> selectAll(int offset, int amount) throws Exception {
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			List<BookDto> list = new LinkedList();
			BookDto book =null;
			
			pstmt = conn.prepareStatement("select * from tbl_book order by bookcode desc limit ?,?");
			// offset, 수량
			pstmt.setInt(1, offset);
			pstmt.setInt(2, amount);
			
			rs = pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					book = new BookDto();
					book.setBookCode(rs.getString(1));
					book.setBookName(rs.getString(2));
					book.setPublisher(rs.getString(3));
					book.setIsbn(rs.getString(4));
					
					list.add(book);
				}
			}
			
			// connection release
			// 
			connectionPool.releaseConnection(connectionItem);
			
			return list;
			
			
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookDao's selectAll SQL Exception");
		}finally {
			try {rs.close();pstmt.close();}catch(Exception e2) {}
		}
	}
	

	

	// count 함수
	@Override
	public long count() throws Exception {
		long count = 0;
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("select count(*) from tbl_book");
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				count = rs.getLong(1);
			}
			
			// connection release
			// 해제하지 않으면 용량 다 차서 안뜸.. 
			// return 위에 위치하기
			connectionPool.releaseConnection(connectionItem);
			
			return count;
			
			
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookDao's selectAll SQL Exception");
		}finally {
			try {rs.close();pstmt.close();}catch(Exception e2) {}
		}
	}
	@Override
	public List<BookDto> selectAll(int offset, int amount, String type, String keyword) throws Exception {
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			List<BookDto> list = new LinkedList();
			BookDto book =null;
			
			// 포함 문자열 검색
			pstmt = conn.prepareStatement("select * from tbl_book where "+type+" like '%"+keyword+"%' order by bookcode desc limit ?,?");
			// offset, 수량
			pstmt.setInt(1, offset);
			pstmt.setInt(2, amount);
			
			rs = pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					book = new BookDto();
					book.setBookCode(rs.getString(1));
					book.setBookName(rs.getString(2));
					book.setPublisher(rs.getString(3));
					book.setIsbn(rs.getString(4));
					
					list.add(book);
				}
			}
			
			// connection release
			// 
			connectionPool.releaseConnection(connectionItem);
			
			return list;
			
			
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookDao's selectAll SQL Exception");
		}finally {
			try {rs.close();pstmt.close();}catch(Exception e2) {}
		}
	}
	@Override
	public long count(Criteria criteria) throws Exception {
		long count = 0;
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			String type = criteria.getType();
			String keyword = criteria.getKeyword();
			
			pstmt = conn.prepareStatement("select count(*) from tbl_book where "+type+" like '%"+keyword+"%'");
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				count = rs.getLong(1);
			}
			
			// connection release
			// 해제하지 않으면 용량 다 차서 안뜸.. 
			// return 위에 위치하기
			connectionPool.releaseConnection(connectionItem);
			
			return count;
			
			
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookDao's selectAll SQL Exception");
		}finally {
			try {rs.close();pstmt.close();}catch(Exception e2) {}
		}
	}
	

}
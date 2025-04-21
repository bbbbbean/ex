package Domain.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import Domain.Dto.BookDto;
import Domain.Dto.BookReplyDto;

public class BookReplyDaoImpl extends Dao {

	// 싱글톤 패턴처리
	private static BookReplyDaoImpl instance;
	// 생성자
	private BookReplyDaoImpl() throws Exception {
		System.out.println("[DAO] BookReplyDaoImpl init...");	
	};
	public static BookReplyDaoImpl getInstance() throws Exception {
		if(instance==null)
			instance = new BookReplyDaoImpl();
		return instance;
	}

	// CRUD
	// 댓글 등록 : insert (C)
	public int insert(BookReplyDto dto) throws Exception {
		
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			// no은 자동으로 들어가게
			pstmt = conn.prepareStatement("insert into tbl_reply values(null,?,?,?,?)");
			pstmt.setString(1,dto.getBookcode());
			pstmt.setString(2,dto.getUsername());
			pstmt.setString(3,dto.getContents());
			pstmt.setTimestamp(4,Timestamp.valueOf(dto.getCreateAt()));
			
			return pstmt.executeUpdate();
				
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookReplyDao's Insert SQL Exception");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
			// connection release
			connectionPool.releaseConnection(connectionItem);
		}
	}
	
	// 댓글 조회 : select (R)
	public List<BookReplyDto> selectAll(String bookCode) throws Exception {
		
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			List<BookReplyDto> list = new LinkedList();
			BookReplyDto book =null;
			
			pstmt = conn.prepareStatement("select * from tbl_reply where bookCode='"+bookCode+"' order by no desc");
			
			rs = pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					book = new BookReplyDto();
					book.setNo(rs.getInt(1));
					book.setBookcode(rs.getString(2));
					book.setUsername(rs.getString(3));
					book.setContents(rs.getString(4));
					book.setCreateAt(rs.getTimestamp(5).toLocalDateTime());	// toLocalDateTime() : 변환 가능
					
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
		}
	}
	
	// 댓글 갯수
	public long count(String bookCode) throws Exception {
		long count = 0;
		try {
			// connection get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("select count(*) from tbl_reply where bookcode=?");
			pstmt.setString(1, bookCode);
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				count = rs.getLong(1);
			}

			return count;
			
			
		}catch(SQLException e){
			// 예외는 user service로 던질 것
			e.printStackTrace();
			throw new SQLException("BookReplyDao's selectAll SQL Exception");
		}finally {
			try {rs.close();pstmt.close();}catch(Exception e2) {}
			connectionPool.releaseConnection(connectionItem);
		}
	}
	
	
}

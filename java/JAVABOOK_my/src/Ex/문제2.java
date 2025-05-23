package Ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class 문제2 {

	// DB CONN DATA
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/tmpdb";
	
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public static void conn() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED...");
	}
//	public static List<BookDto> selectAll() throws SQLException{
//		// SQL select 구문
//		pstmt = conn.prepareStatement("select * from tbl_book");
//		
//		// SQL 실행
//		rs = pstmt.executeQuery();
//		
//		List<BookDto> bookdto = new ArrayList();
//		
//		if(rs!=null) {
//			while(rs.next()) {
//				long bookCode = rs.getLong(0);
//				String bookName = rs.getString(1);
//				String publisher = rs.getString(2);
//				String isbn = rs.getString(3);
//			}
//		}
//		
//		return bookdto;
//	}
	public static BookDto select(Long bookCode) throws SQLException{
		pstmt = conn.prepareStatement("select * from tbl_book");
		return null;
	}
	
	public static PreparedStatement insertBook(BookDto bookDto) throws SQLException{
		
		pstmt=conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
		pstmt.setLong(1, bookDto.getBookCode());
		pstmt.setString(2, bookDto.getBookName());
		pstmt.setString(3, bookDto.getPublisher());
		pstmt.setString(4, bookDto.getIsbn());
		return pstmt;
	}
	
	public static PreparedStatement updateBook(BookDto bookDto) throws SQLException{
		pstmt=conn.prepareStatement("update tbl_book set bookName=?,publisher=?,isbn=? where bookCode=?");
		pstmt.setString(1, bookDto.getBookName());
		pstmt.setString(2, bookDto.getPublisher());
		pstmt.setString(3, bookDto.getIsbn());
		pstmt.setLong(4, bookDto.getBookCode());

		return pstmt;
	}
	
	public static PreparedStatement deleteBook(BookDto bookDto) throws SQLException{
		pstmt=conn.prepareStatement("delete from tbl_book where bookCode=?");
		pstmt.setLong(1, bookDto.getBookCode());
		return pstmt;
	}
	
	public static void main(String[] args) {
		try {
			// DB Conn
			conn();
			
			// Tx start
			conn.setAutoCommit(false);
			// insert
			insertBook(new BookDto(1L,"도서명1","출판사명1","isbn-1"));
			insertBook(new BookDto(1L,"도서명2","출판사명2","isbn-2"));
			insertBook(new BookDto(1L,"도서명3","출판사명3","isbn-3"));
			
			// SelectAll
			List<BookDto> allBook = selectAll();
			System.out.println("selextAll : ");
			allBook.forEach(el->System.out.println(el));
			
			// Select
			BookDto dto = select(1L);
			System.out.println("select : "+dto);
			
			// Update
			dto.setBookName("수정도서명-2");
			dto.setPublisher("수정출판사명-2");
			int r1 = updateBook(dto);
			if(r1>0)
				System.out.println("수정완료 : "+r1);
			
			// Delete
			int r2 = deleteBook(2L);
			if(r2>0)
				System.out.println("삭제 완료 : "+r2);
			
			// Tx End
			conn.commit();
		}catch(Exception e) {
			// Tx RollbackAll
			
		}
		
	}
	
}

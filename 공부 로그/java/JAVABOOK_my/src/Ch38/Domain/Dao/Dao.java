package Ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Ch38.Domain.Dao.ConnectionPool.ConnectionItem;
import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;
// 해당 클래스로 직접 객체 만들 일이 없으니까 abstract 처리해도 O
public abstract class Dao {
	// DB Attr
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	// connection pool
	protected ConnectionPool connectionPool;
	// connection pool에서 가져 온 item
	protected ConnectionItem connectionItem;
	
	Dao() throws Exception{
		// connectionPool
		connectionPool = ConnectionPool.getInstance();
	}
}

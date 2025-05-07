package com.example.app.domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app.domain.Dto.UserDto;
import com.mysql.cj.protocol.Resultset;

@Repository
public class UserDaoImpl {
	@Autowired
	private DataSource dataSource;
	
	public int insert(UserDto userDto) throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into tbl_userinfo values(?,?,?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getName());
		pstmt.setString(4, userDto.getNickname());
		
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	public UserDto selectOne(String userid) throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from tbl_userinfo where userid=?");
		pstmt.setString(1, userid);
		
		
		return null;
	}
}

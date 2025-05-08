package com.example.app.domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app.domain.Dto.UserDto;

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
	public int update(UserDto userDto) throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update set tbl_userinfo name=?, nickname=?,  where userid=?");
		pstmt.setString(1, userDto.getName());
		pstmt.setString(2, userDto.getNickname());
		pstmt.setString(3, userDto.getUserid());
		
		int result = pstmt.executeUpdate();
		
		return result;
	}
	public int delete(String userid) throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from tbl_userinfo where userid=?");
		pstmt.setString(1, userid);
		
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	public UserDto selectOne(String userid) throws SQLException {
		
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from tbl_userinfo where userid=?");
		pstmt.setString(1, userid);
		
		ResultSet rs = pstmt.executeQuery();
		
		UserDto user = null;
		
		if(rs!=null) { 
			while(rs.next()) {
				user = new UserDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		}
		
		return user;
	}
	public List<UserDto> selectAll() throws SQLException {
		
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from tbl_userinfo");
		
		ResultSet rs = pstmt.executeQuery();
		
		UserDto user = null;
		List<UserDto> list = new ArrayList();
		
		if(rs!=null) { 
			while(rs.next()) {
				user = new UserDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(user);
			}
		}
		
		return list;
	}
	
}

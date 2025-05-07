package com.example.app.domain.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.Dao.UserDaoImpl;
import com.example.app.domain.Dto.UserDto;

@Service
public class UserService {
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	public boolean join(UserDto userDto) throws SQLException {
		int result = userDaoImpl.insert(userDto);
		
		return result>0;
	}
}

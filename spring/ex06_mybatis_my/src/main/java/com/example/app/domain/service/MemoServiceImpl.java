package com.example.app.domain.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;

@Service
public class MemoServiceImpl {

	// 싱글톤 형태를 제외하고 @Autowired로 연결한다 생각
//	@Autowired
//	private MemoDaoImpl memoDaoImpl;

	
	// 등록 여부
//	public boolean registrationMemo(MemoDto memoDto) throws SQLException {
//		int result = memoDaoImpl.insert(memoDto);
//		
//		return result>0;
//	}

	// 서비스에 바로 mapper 걸기
	@Autowired
	private MemoMapper memoMapper;
	public boolean registrationMemo(MemoDto memoDto) throws SQLException{
		int result = memoMapper.insert(memoDto);
		return result>0;
	}
}

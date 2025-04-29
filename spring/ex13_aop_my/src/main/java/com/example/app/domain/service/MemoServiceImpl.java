package com.example.app.domain.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
		System.out.println("Memo registrationMemo's invoke");
		int result = memoMapper.insert(memoDto);
		return result>0;
	}
	
	// 전체 메모 가져오기
	public List<MemoDto> getAllMemo(){
		// log : 로깅용 태그, slf4j 연결하면 활성화
		log.info("MemoService's getAllMemo Call! ");
		return  memoMapper.selectAll(); 
	}
	
	// 단건 메모 가져오기
	@Transactional(rollbackFor = Exception.class) 
	public MemoDto getMemo(int id) {
		log.info("MemoService's getMemo Call! ");
		return memoMapper.selectAt(id);
	}
		
	//메모작성
	// tx 전 : 01 삽입됨
	// tx 후 : 01 삽입된 거 롤백 됨, 데이터 삽입 안됨
	@Transactional(rollbackFor = Exception.class) 
	public void addMemoTx(MemoDto dto)	 {
		log.info("MemoService's addMemoTx Call! ");
		int id=dto.getId();
		memoMapper.insert(dto);	//01 정상INSERT 
		dto.setId(id);			//PK오류 발생예정인 dto
		memoMapper.insert(dto);	//02	PK오류 발생!!		
	}

	@Transactional(rollbackFor = Exception.class)
	// put용 수정과 patch용 수정 따로 두어도 됨
	public void modifyMemo(MemoDto dto) {
		memoMapper.update(dto);
		
	}

	@Transactional(rollbackFor = Exception.class)
	// 삭제
	public void removeMemo(int id) {
		memoMapper.delete(id);
	}


}

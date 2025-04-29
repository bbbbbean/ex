package com.example.app.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.app.domain.dto.MemoDto;

@Mapper
public interface MemoMapper {
	// 기존 : 하위에 구현체를 만들어 상속 시키고 쿼리문 씀
	// 이제? 이 mapper가 대신 해줌
	
	// insert mapper
	// value에 쿼리문
	@SelectKey(statement="select max(id)+1 from tbl_memo",keyProperty = "id",before = false, resultType = int.class)
	// 속성을 하나하나 전달 가능 : #{속성이름}
	@Insert(value = "insert into tbl_memo values(#{id},#{text},#{writer},#{createAt},#{dateTest})")
	public int insert(MemoDto memoDto);
	
	@Update("update tbl_memo set text=#{text} where id=#{id}")
	public int update(MemoDto dto);
	
	@Delete("delete from tbl_memo where id=#{id}")
	public int delete(int id);
	
	@Select("select * from tbl_memo where id=#{id}")
	public MemoDto selectAt(int id);
	
	
	@Select("select * from tbl_memo")
	public List<MemoDto> selectAll(); 
	// map 형태로 결과를 받아옴
	@Results(id="MemoResultMap", value= {
			@Result(property = "id",column="id"),
			@Result(property = "text", column="text")
	})
	// 상기 맵의 리스트화 -> 키와 그 값을 꺼내 쓰기 용이
	@Select("select * from tbl_memo")
	public List< Map<String,Object> > selectAllResultMap();
	
	
	// XML방식
	// xml 파일의 id="insertXml" 와 함수명 일치시키기
	public int insertXml(MemoDto memoDto);
	public int updateXml(MemoDto memoDto);
	// 파라미터를 잘못 쓰는 경우가 있을 수 있음 외부에서 들어오는 파라미터 지정
	public int deleteXml(@Param("id") int id);
	public MemoDto selectAtXml(int id);
	public List<MemoDto> selectAllXml();
	public List<Map<String,Object>> selectAllResultMapXml();
	
	public List<Map<String,Object>> Select_if_xml(Map<String,Object> param);
	public List<Map<String,Object>> Select_when_xml(Map<String,Object> param);

}

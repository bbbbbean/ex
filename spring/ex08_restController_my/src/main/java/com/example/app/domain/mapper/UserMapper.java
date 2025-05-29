package com.example.app.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.app.domain.dto.UserDto;

public interface UserMapper {
	
	// 일반
	@Insert("insert into tbl_user_ex values(#{userid},#{username},#{password},#{addr1})")
	public int insert(UserDto dto);
	@Update("update tbl_user_ex set addr1=#{addr1}")
	public int update(UserDto dto);
	@Delete("delete from tbl_user_ex where userid=#{userid}")
	public int delete(@Param("userid") String id);
	
	@Select("select * from tbl_user_ex where userid=#{userid}")
	public UserDto selectAt(@Param("userid") String id);
	@Select("select * from tbl_user_ex")
	public List<UserDto> selectAll();
	@Results(id="UserResultMap", value= {
			@Result(property = "userid",column="userid"),
			@Result(property = "username", column="username"),
			@Result(property = "password", column="password"),
			@Result(property = "addr1", column="addr1")
	})
	@Select("select * from tbl_user_ex")
	public List<Map<String,Object>> selectAllResult();
	
	// Xml
	public int insertXml(UserDto dto);
	public int updateXml(UserDto dto);
	public int deleteXml(@Param("userid") String id);
	
	public UserDto selectAtXml(@Param("userid") String id);
	public List<UserDto> selectAllXml();
	public List<Map<String,Object>> selectAllResultXml();
}

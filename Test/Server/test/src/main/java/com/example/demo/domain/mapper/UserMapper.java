package com.example.demo.domain.mapper;

import com.example.demo.domain.Dto.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface UserMapper {
    @Insert(value="insert into tbl_userinfo values(#{userid},#{password},#{name},#{nickname})")
    public int insert(UserDto userDto);

    @Update(value = "update tbl_userinfo set password=#{password},name=#{name},nickname=#{nickname} where userid=#{userid}")
    public int update(@Param("userid") String userid);

    @Delete(value = "delete from tbl_userinfo where userid=#{userid}")
    public int delete(@Param("userid")String userid);

    @Select(value = "select * from tbl_userinfo")
    public List<UserDto> selectAll();

    @Results(id = "UserResult", value ={
                    @Result(property = "userid", column = "userid"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "nickname", column = "nickname")})
    @Select(value = "select * from tbl_userinfo")
    public List<Map<String, Objects>> selectAllMap();

    @Select(value = "select * from tbl_userinfo where userid=#{userid}")
    public UserDto selectOne(@Param("userid") String userid);
}

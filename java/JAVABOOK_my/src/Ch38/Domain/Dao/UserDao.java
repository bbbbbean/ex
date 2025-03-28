package Ch38.Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.UserDto;

public interface UserDao {

	// CRUD 함수 - 유저 테이블과 연결된 처리함수
	// 추가하면 추가된 행의 갯수 리턴
	int insert(UserDto userDto) throws Exception;

	// 수정하면 수정된 행의 갯수 리턴
	int update(UserDto userDto) throws SQLException;

	// 삭제하면 삭제된 행의 갯수 리턴
	int delete(UserDto userDto) throws SQLException;

	// 단건조회
	UserDto select(UserDto userDto);

	// 다건조회(전체 조회)
	List<UserDto> selectAll();

}
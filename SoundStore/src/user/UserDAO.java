package user;

import java.util.List;

public interface UserDAO {
	UserVO selectUser(int userNo);
	List<UserVO> selectAllUsers();
	boolean insertUser(UserVO user);
	boolean updateUser(UserVO user);
	boolean deleteUser(int userNo);
}

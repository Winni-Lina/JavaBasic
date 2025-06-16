package user;

import java.util.List;

public interface UserService {
	boolean registUser(UserVO user);
	List<UserVO> listUsers();
	UserVO detailUserInfo(int userNo);
	boolean updateUser(UserVO user);
	boolean removeUser(int userNo);
	UserVO selectUserByLogin(String id, String pw);
	boolean checkIDDuplication(String id);
	boolean checkNameDuplication(String name);
	
}

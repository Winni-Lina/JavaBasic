package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HashMapUserDAO implements UserDAO{

	protected Map<Integer, UserVO> userDB = new HashMap<>();
	protected int userSeq = 001;
	
	@Override
	public UserVO selectUser(int userNo) {
		return userDB.get(userNo);
	}

	@Override
	public List<UserVO> selectAllUsers() {
		return new ArrayList<UserVO>(userDB.values());
	}

	@Override
	public boolean insertUser(UserVO user) {
		user.setUserNo(userSeq++);
		userDB.put(user.getUserNo(), user);
		return true;
	}

	@Override
	public boolean updateUser(UserVO user) {
		userDB.put(user.getUserNo(), user);
		return true;
	}

	@Override
	public boolean deleteUser(int userNo) {
		return userDB.remove(userNo) != null;
	}
	
}

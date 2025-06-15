package user;

import java.util.LinkedList;
import java.util.List;

public class LinkedListUserDAO implements UserDAO {
	private List<UserVO> userList = new LinkedList<UserVO>();
	private int userSeq = 501;
	
	public LinkedListUserDAO(List<UserVO> userList) {
		this.userList = userList;
		this.addTestData();
	}
	
	public void addTestData() {
		this.insertUser(new UserVO("test1", "test1", "test1"));
		this.insertUser(new UserVO("test2", "test2", "test2"));
	}
	
	public UserVO selectUser(int userNo) {
		for(UserVO user : userList) {
			if(user.getUserNo() == userNo) return user;
		}
		return null;
	}
	
	public List<UserVO> selectAllUsers(){
		return userList;
	}
	
	public boolean insertUser(UserVO user) {
		user.setUserNo(userSeq++);
		return userList.add(user);
	}
	
	public boolean updateUser(UserVO user) {
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUserNo() == user.getUserNo()) {
				userList.set(i, user);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteUser(int userNo) {
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUserNo() == userNo) {
				userList.remove(i);
				return true;
			}
		}
		return false;
	}
}

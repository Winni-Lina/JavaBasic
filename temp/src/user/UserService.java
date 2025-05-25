package user;

import java.util.LinkedList;
import java.util.List;

import sound.Sound;

public class UserService {
	private List<User> userList = new LinkedList<User>();
	private int userSeq = 300;

	public UserService(List<User> userList) {
		this.userList = userList;
	}
	

	public User selectUser(int userNo) {
		for(User user: userList) {
			if(user.getUserNo() == userNo) return user;
		}
		return null;
	}
	
	public List<User> selectAllUsers(){
		return userList;
	}
	
	public boolean insertUser(User user) {
		user.setUserNo(userSeq++);
		return userList.add(user);
	}
	
	public boolean updateUser(User user) {
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

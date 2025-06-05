package user;

import java.util.LinkedList;
import java.util.List;

import sound.Sound;

public class UserService {
	private List<User> userList = new LinkedList<User>();
	private int userSeq = 300;

	public UserService(List<User> userList) {
		this.userList = userList;
		
		setTestData();
	}
	

	private void setTestData() {
		insertUser(new User("1","1","tester1"));
		insertUser(new User("2","2","tester2"));
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
	
	public User selectUserByLogin(String id, String pw) {
		for(User user: userList) {
			if(user.getId().equals(id))
				if(user.getPw().equals(pw)) 
					return user;
		}
		return null;
	}
}
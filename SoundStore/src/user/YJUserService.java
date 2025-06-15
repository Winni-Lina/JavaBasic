package user;

import java.util.List;

public class YJUserService implements UserService{
	private UserDAO userDAO;
	
	public YJUserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	@Override
	public boolean registUser(UserVO user) {
		return userDAO.insertUser(user);
	}

	@Override
	public List<UserVO> listUsers() {
		return userDAO.selectAllUsers();
	}

	@Override
	public UserVO detailUserInfo(int userNo) {
		return userDAO.selectUser(userNo);
	}

	@Override
	public boolean updateUser(UserVO user) {
		return userDAO.updateUser(user);
	}

	@Override
	public boolean removeUser(int userNo) {
		return userDAO.deleteUser(userNo);
	}

	@Override
	public UserVO selectUserByLogin(String id, String pw) {
		List<UserVO> userList = userDAO.selectAllUsers();
		
		for(UserVO user : userList) {
			if(user.getId().equals(id)) {
				if(user.getPw().equals(pw))
					return user;
			}
		}
		return null;
	}


	@Override
	public boolean checkIDDuplication(String id) {
		List<UserVO> userList = userDAO.selectAllUsers();

		for(UserVO user : userList) {
			if(user.getId().equals(id)) return true;
		}
		
		return false;
	}


	@Override
	public boolean checkNameDuplication(String name) {
		List<UserVO> userList = userDAO.selectAllUsers();

		for(UserVO user : userList) {
			if(user.getId().equals(name)) return true;
		}
		
		return false;
	}

}

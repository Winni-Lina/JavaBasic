package test;

import java.util.LinkedList;
import java.util.List;

import user.UserService;
import user.User;


public class UserServiceTest {
	static UserService us = new UserService(new LinkedList<User>());
	
	
	public static void main(String[] args) {
		
		printlist();
		
		System.out.println("유저 등록 시작 ======");
		System.out.println("유저1 등록 결과 : " + us.insertUser(new User("id1", "pw1", "유저1")));
		System.out.println("유저2 등록 결과 : " + us.insertUser(new User("id2", "pw2", "유저2")));
		System.out.println("유저3 등록 결과 : " + us.insertUser(new User("id3", "pw3", "유저3")));
		System.out.println("유저 등록 끝 ======");

		printlist();
		
		System.out.println("300번 유저 값 업데이트");
		User user = us.selectUser(300);
		user.setId("qwasz1111");
		user.setPw("qwaszpw");
		user.setName("뮤지커");
		System.out.println("수정할 값 : " + user);
		System.out.println("수정 결과 : " + us.updateUser(user));
		
		printlist();
		
		System.out.println("102번 유저 값 삭제");
		System.out.println("삭제 결과 : " + us.deleteUser(302));

		printlist();
	}
	
	static void printlist() {

		System.out.println("==== 현재 데이터 ====");
		
		List<User> userList = us.selectAllUsers();
		for(User u : userList) {
			System.out.println(u);
		}
		
		System.out.println("==================");
	}

}

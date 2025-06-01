package app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import sound.Sound;
import sound.SoundService;
import user.User;
import user.UserService;

public class SoundStoreMain {
	private static SoundService ss = new SoundService(new LinkedList<Sound>());
	private static UserService us = new UserService(new LinkedList<User>());
	private static Scanner scan = new Scanner(System.in);
	private static User loginUser = null;
	
	public static void main(String[] args) {
		showTitle();
		
		loginUser = login();
		
		boolean isContinue = true;
		
		while(isContinue)
		{
			isContinue = doMenu();
		}
		
	}
	

	private static void showTitle() {
		System.out.println(
				  "████████████████████████████\r\n"
				+ "█                          █\r\n"
				+ "█        SoundStore        █\r\n"
				+ "█                          █\r\n"
				+ "████████████████████████████"
				);
		
	}

	// 메뉴 시작 ----------------------
	static int chooseMenu() {
		String[] menuList = {"사운드 업로드", "내 사운드", "사운드 목록"};
		int choose;
		
		
		do {
			for(int i = 1; i <= menuList.length; i++) {
				System.out.println(i + ". " + menuList[i-1]);
			}
			System.out.println("0. 종료");
			System.out.print("메뉴를 선택하세요: ");
			
			try {
				choose = scan.nextInt();
				if(0 > choose || choose > menuList.length) {
					System.out.println("메뉴 번호가 잘못됐습니다.");
					choose = -1; 
				}
			} catch (Exception e) {
				System.out.println("메뉴 번호가 잘못됐습니다.");
				choose = -1;
			}
			System.out.println("======================");
		} while (choose == -1);
		
		
		return choose;
	}
	
	static boolean doMenu(){
		int chooseNum = chooseMenu();
		switch (chooseNum) {
			case 0: 
				System.out.println("사운드 스토어를 종료합니다.");
				scan.close();
				return false;
			case 1:
				if(loginUser == null) {
					System.out.println("비회원은 해당 기능 사용이 불가능합니다.");
				}
				uploadSound();
				break;
			case 2:
				if(loginUser == null) {
					System.out.println("비회원은 해당 기능 사용이 불가능합니다.");
				}
				mySoundMenu();
				break;
			case 3:
				showSoundList();
				break;
		}
		return true;
	}
	// 메뉴 끝 -------------------
	
	// 로그인 기능 시작 --------------------
	static User login() {
		while(true) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 비회원으로 사용");
			
			System.out.print("로그인 방식 선택 : ");
			int choose;
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = -1;
			}
			
			switch(choose) {
				case 1:
					return doLogin();
				case 2:
					signUp();
					break;
				case 3:
					return null;
				default:
					System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}

	private static User doLogin() {
		User loginUser = null;
		
		do {
			System.out.print("아이디 입력 : ");
			String id = scan.next();
			System.out.print("패스워드 입력 : ");
			String pw = scan.next();
			
			loginUser = us.selectUserByLogin(id, pw);
			
			if (loginUser == null) System.out.println("아이디 혹은 패스워드가 잘못됐습니다.");
		} while (loginUser == null);
		
		System.out.println("로그인 성공");
		System.out.println("============================");
		return loginUser;
	}
	
	private static void signUp() {
		System.out.print("이름 입력: ");
		String name = scan.next();
		
		System.out.print("아이디 입력: ");
		String id = scan.next();
		
		System.out.print("패스워드 입력: ");
		String pw = scan.next();
		
		boolean result = us.insertUser(new User(id, pw, name));
		if(result == true) System.out.println("회원가입 성공");
		else System.out.println("회원가입 실패");
		System.out.println("============================");
	}
	// 로그인 기능 끝 --------------------

	// 사운드 업로드 기능 시작 -------------------
	private static void uploadSound() {
		System.out.print("제목 : ");
		String title = scan.next();
		ss.insertSound(new Sound(title, loginUser.getName()));
	}
	// 사운드 업로드 기능 끝 -------------------
	
	// 내사운드 기능 시작 ---------------
	private static void mySoundMenu() {
		int choose;
		boolean isContinue = true;
		List<Sound> soundList = new ArrayList<Sound>();
		
		do {
			System.out.println("1. 업로드한 사운드");
			System.out.println("2. 좋아요한 사운드");
			System.out.println("3. 즐겨찾기한 사운드");
			System.out.println("0. 뒤로가기");
			System.out.print("메뉴 선택 : ");
			
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = -1;
			}
			
			switch(choose) {
				case 1:
					soundList = ss.selectAllSoundByAuthor(loginUser.getName());
					isContinue = false;
					break;
				case 2:
					for(Integer num : loginUser.getLikes())
						soundList.add(ss.selectSound(num));
					isContinue = false;
					break;
				case 3:
					for(Integer num : loginUser.getFavorites())
						soundList.add(ss.selectSound(num));
					isContinue = false;
					break;
				case 0 :
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
			}
		} while (isContinue);

		System.out.println("=======================");
		if(soundList.isEmpty()) {
			System.out.println("기록된 사운드가 없습니다.");
			System.out.println("=======================");
		}
		else {
			for (Sound sound : soundList) {
				System.out.println(sound);
			}
			System.out.println("=======================");
			try {
				System.out.print("정보 확인할 노래번호 입력 : ");
				showSoundInfo(scan.nextInt());
			} catch (Exception e) {
				System.out.println("오입력");
			}
		}
	}
	// 내사운드 기능 끝 ---------------
	

	// 사운드 정보 시작 ---------------
	static void showSoundInfo(int soundNo){
		Sound sound = ss.selectSound(soundNo);
		List<Integer> list = new ArrayList<Integer>();
		int choose = -1;
		int index;
		
		
		
		do {
			System.out.println("사운드 번호 : " + sound.getSoundNo());
			System.out.println("제목 : " + sound.getTitle());
			System.out.println("사운드 제작자 : " + sound.getAuthor());
			System.out.println("좋아요 수 : " + sound.getCountLikes());
			System.out.println("즐겨찾기 수 : " + sound.getCountFavorites());
			
			System.out.print("1. 좋아요 / 2. 즐겨찾기 / 0. 뒤로가기 : ");
			
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = -1;
			}
			
			System.out.println("===================");
			switch (choose) {
				case 1: 
					list = loginUser.getLikes();
					index = list.indexOf(sound.getSoundNo());
					if(index > -1) {
						System.out.print("이미 좋아요 상태입니다. 취소하시겠습니까? (1. 예 / 2. 아니오) : ");
						int n = scan.nextInt();
						
						if(n == 1) {
							list.remove(index);
							loginUser.setLikes(list);
							sound.setCountLikes(sound.getCountLikes() - 1);
							System.out.println("좋아요 해제 완료");
						}
						else {
							System.out.println("아니오를 선택하셨습니다.");
						}
					}
					else {
						list.add(sound.getSoundNo());
						loginUser.setLikes(list);
						sound.setCountLikes(sound.getCountLikes() + 1);
						System.out.println("좋아요 완료");
					}
					break;
				case 2:
					list = loginUser.getFavorites();
					index = list.indexOf(sound.getSoundNo());
					if(index > -1) {
						System.out.println("이미 즐겨찾기 상태입니다. 취소하시겠습니까? (1. 예 / 2. 아니오)");
						int n = scan.nextInt();
						
						if(n == 1) {
							list.remove(index);
							loginUser.setFavorites(list);
							sound.setCountFavorites(sound.getCountFavorites() - 1);
							System.out.println("즐겨찾기 해제 완료");
						}
						else {
							System.out.println("아니오를 선택하셨습니다.");
						}
					}
					else {
						list.add(sound.getSoundNo());
						loginUser.setFavorites(list);
						sound.setCountFavorites(sound.getCountFavorites() + 1);
						System.out.println("즐겨찾기 완료");
					}
					break;
			}
			System.out.println("===================");
		} while (choose != 0);
		
	}
	// 사운드 정보 끝 ---------------

	// 사운드 목록 보기 시작 --------------
	static void showSoundList(){
		
	}
	// 사운드 목록 보기 끝  --------------
}

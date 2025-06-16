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
	
	private static String[] loginMenuList = {"종료", "로그인", "회원가입", "비회원으로 이용"};
	private static String[] menuList = {"종료", "사운드 업로드", "내 사운드", "사운드 목록", "내정보"};
	private static String[] mySoundMenuList = {"뒤로가기", "업로드한 사운드", "좋아요한 사운드", "보유중인 사운드"};
	private static String[] showMyInfoMenuList = {"뒤로가기", "충전하기"};
	
	public static void main(String[] args) {
		showTitle();
		
		loginUser = login();
		
		int menuNum = -1;
		
		while(menuNum != 0) {
			menuNum = chooseMenu(menuList);
			doMenu(menuNum);
		}
		
		scan.close();
	}
	
	
	// 제목
	private static void showTitle() {
		System.out.println(
				  "████████████████████████████\r\n"
				+ "█                          █\r\n"
				+ "█        SoundStore        █\r\n"
				+ "█                          █\r\n"
				+ "████████████████████████████"
				);
	}

	// 로그인
	private static User login() {
		int menuNum;
		while (true) {
			menuNum = chooseMenu(loginMenuList);
			
			switch(menuNum) {
				case 1:
					return doLogin();
				case 2:
					signUp();
					break;
				case 3:
					System.out.println("비회원으로 로그인합니다.");
					return null;
			}
			
		}
	}
	
	// 로그인 시도
	private static User doLogin() {
		User loginUser = null;

		System.out.println("============================");
		System.out.println("< 로그인 >");
		do {
			System.out.print("아이디 입력 : ");
			String id = scan.next();
			System.out.print("패스워드 입력 : ");
			String pw = scan.next();
			
			loginUser = us.selectUserByLogin(id, pw);
			
			if (loginUser == null) System.out.println("아이디 혹은 패스워드가 잘못됐습니다.");
		} while (loginUser == null);
		
		System.out.println(loginUser.getName() +" 로그인 성공");
		System.out.println("============================");
		return loginUser;
	}
	
	// 회원가입
	private static void signUp() {
		System.out.println("============================");
		System.out.println("< 회원가입 >");
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
	
	// 메뉴 표시
	private static int chooseMenu(String[] list) {

		for(int i = 1; i < list.length; i++) {
			System.out.println(i + ". " + list[i]);
		}
		System.out.println("0. " + list[0]);
		System.out.print("메뉴를 선택하세요: ");
		
		try {
			return scan.nextInt();
		} catch (Exception e) {
			return -1;
		}
		
	}
	
	// 사운드 목록 보기
	private static void showSoundList(List<Sound> soundList) {
		System.out.println("=======================");
		for (Sound sound : soundList) {
			System.out.println(sound);
		}
		if(soundList.isEmpty()) System.out.println("사운드가 없습니다.");
		System.out.println("=======================");
	}
	
	// 사운드 정보 보기
	private static void showSoundInfo(Sound s) {
		
		int choose = -1;
		while (choose != 0) {
			System.out.println("=======================");
			System.out.println("< 사운드 정보 >");
			System.out.println("사운드 번호 : " + s.getSoundNo());
			System.out.println("제목 : " + s.getTitle());
			System.out.println("가격 : " + (s.getPrice() > 0));
			System.out.println("사운드 제작자 : " + s.getAuthor());
			System.out.println("좋아요 수 : " + s.getCntLikes());
			System.out.println("보유자 수 : " + s.getCntHaveUsers());
			System.out.println("=======================");

			if(loginUser != null) choose = doSound(s);
			else choose = 0;
		}
		


		
	}
	
	private static int doSound(Sound s) {
		int soundNo = s.getSoundNo();
		int choose = -1;
		
		String[] soundMenu = new String[3];
			
		boolean isUpload = loginUser.getUploadList().indexOf(soundNo) > -1;
		boolean isLiked = loginUser.getLikeList().indexOf(soundNo) > -1;
		boolean isHave = loginUser.getHaveList().indexOf(soundNo) > -1;
			
		soundMenu[1] = isLiked ? "좋아요 해제" : "좋아요";
		
		if(isHave) soundMenu[2] = "소유중";
		else if(isUpload || s.getPrice() == 0) soundMenu[2] = "소유하기";
		else soundMenu[2] = "구매하기";
			
		soundMenu[0] = "뒤로가기";
			
		choose = chooseMenu(soundMenu);
			
		List<Integer> list;
		switch(choose) {
			case 1:
				list = loginUser.getLikeList();
				if(isLiked) {
					list.remove(s.getSoundNo());
					loginUser.setLikeList(list);
					s.setCntLikes(s.getCntLikes() - 1);
					System.out.println("좋아요 해제 성공");
				}
				else {
					list.add(s.getSoundNo());
					loginUser.setLikeList(list);
					s.setCntLikes(s.getCntLikes() + 1);
					System.out.println("좋아요 성공");
				}
				break;
			case 2:
				if(isHave) break;
				
				list = loginUser.getHaveList();
				if(s.getPrice() == 0) {
					list.add(s.getSoundNo());
					loginUser.setHaveList(list);
					s.setCntHaveUsers(s.getCntHaveUsers() + 1);
					System.out.println("소유 완료");
				}
				else {
					if(buySound(s)) {
						list.add(s.getSoundNo());
						loginUser.setHaveList(list);
						s.setCntHaveUsers(s.getCntHaveUsers() + 1);
						System.out.println("구매 및 소유 완료");
					}
				}
				break;
		}
		System.out.println("=========================");
		
		return choose;
	}
	
	private static boolean buySound(Sound s) {
		if(loginUser.getPrice() < s.getPrice()) {
			System.out.println("금액이 없습니다 내정보에서 금액을 충전해주세요");
			return false;
		}
		
		System.out.println(s);
		System.out.print("구매하시겠습니까? (1: 네 / 2 : 아니오) : ");
		int choose = scan.nextInt();
		
		if(choose == 2) {
			System.out.println("취소되었습니다.");
			return false;
		}
		
		loginUser.setPrice(loginUser.getPrice() - s.getPrice());
		return true;
		
	}

	// 메인 메뉴 동작
	private static void doMenu(int menuNum) {
		switch(menuNum) {
			case 1:	// 사운드 업로드
				if(loginUser != null) uploadSound();
				else System.out.println("비회원은 해당 기능 사용이 불가능합니다.");
				break;
			case 2:	// 내 사운드
				if(loginUser != null) mySound();
				else System.out.println("비회원은 해당 기능 사용이 불가능합니다.");
				break;
			case 3: // 사운드 목록
				showSoundList(ss.selectAllSounds());
				break;
			case 4: // 내정보
				if(loginUser != null) showMyInfo();
				else System.out.println("비회원은 해당 기능 사용이 불가능합니다.");
				break;
			case 0:
				System.out.println("사운드 스토어를 종료합니다. 이용해주셔서 감사합니다");
				break;
			default:
				System.out.println("메뉴 번호가 잘못됐습니다. 다시 입력해주세요");
			
		}
	}
	
	private static void showMyInfo() {
		System.out.println("=================");
		System.out.println("< 내 정보 > ");
		System.out.println("유저 UID : " + loginUser.getUserNo());
		System.out.println("닉네임 : " + loginUser.getName());
		System.out.println("아이디 : " + loginUser.getId());
		System.out.println("패스워드 : " + '*'*loginUser.getPw().length());
		System.out.println("충전된 금액 : " + loginUser.getPrice());
		System.out.println("노래 업로드 수 : " + loginUser.getUploadList().size());
		System.out.println("=================");
		
		int choose = chooseMenu(showMyInfoMenuList);
		if(choose == 1) chargeAmount(); 
		
	}


	private static void chargeAmount() {
		System.out.println("현재 금액 : " + loginUser.getPrice());
		System.out.print("충전할 금액 입력 : ");
		
		try {
			loginUser.setPrice(loginUser.getPrice() + scan.nextInt());
			System.out.println("충전이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("입력값에 오류가 발생했습니다. ");
		}
		
	}


	// 메뉴 : 사운드 업로드 ----------------
	private static void uploadSound() {
		System.out.println("--- 업로드할 사운드 정보를 입력해주세요. ---");
		System.out.print("제목 : ");
		String title = scan.next();
		System.out.print("판매가 : ");

		int price = -1;	
		while(price == -1) {
			try {
				price = scan.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력되었습니다. 다시 입력해주세요");
				price = -1;
			}
		}
		ss.insertSound(new Sound(title, loginUser.getName(), price));
		System.out.println("업로드 완료");
	}
	
	
	
	// 메뉴 : 내 사운드 -------------------
	private static void mySound() {
		List<Sound> soundList = new ArrayList<Sound>();
		int menuNum = -1;
		
		do {
			menuNum = chooseMenu(mySoundMenuList);
			System.out.println("=======================");
			
			switch(menuNum) {
				case 1:	// 업로드한 사운드
					soundList = ss.selectAllSoundBySearch(ss.SEARCH_TYPE_AUTHOR, loginUser.getName());
					break;
				case 2:	// 좋아요한 사운드
					for(Integer num : loginUser.getLikeList())
						soundList.add(ss.selectSound(num));
					break;
				case 3: // 보유중인 사운드
					for(Integer num : loginUser.getHaveList())
						soundList.add(ss.selectSound(num));
					break;
				case 0:	// 뒤로가기
					return;
			}
		//숫자를 잘못 입력한 경우 반복
		} while (menuNum > mySoundMenuList.length || 0 > menuNum);
		
		showSoundList(soundList);
		
		while(true) {
			System.out.print("확인하고 싶은 사운드 번호 입력 (0: 뒤로가기) : ");
			int soundNo = -1;
			try {
				soundNo = scan.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하셧습니다.");
				soundNo = -1;
			}
			
			if(soundNo == 0) break;
			Sound s = ss.selectSound(soundNo);
			
			if(s == null) System.out.println("사운드 번호가 잘못됐습니다.");
			else {
				showSoundInfo(s);
			}
		}
	}
	
}

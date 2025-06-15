package app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import sound.LinkedListSoundDAO;
import sound.SoundService;
import sound.SoundVO;
import sound.YJSoundService;
import sound.file.ObjFileHashMapSoundDAO;
import user.LinkedListUserDAO;
import user.UserService;
import user.UserVO;
import user.YJUserService;
import user.file.ObjFileHashMapUserDAO;

public class SoundStoreApp {
	//public SoundService soundService = new YJSoundService(new LinkedListSoundDAO(new LinkedList<SoundVO>()));
	//public UserService userService = new YJUserService(new LinkedListUserDAO(new LinkedList<UserVO>()));
	public SoundService soundService = new YJSoundService(new ObjFileHashMapSoundDAO());
	public UserService userService = new YJUserService(new ObjFileHashMapUserDAO());
	private static Scanner scan = new Scanner(System.in);
	private static UserVO loginUser = null;
	
	public String[] loginMenuList = {"종료", "로그인", "회원가입", "비회원으로 이용"};
	public String[] menuList = {"종료", "사운드 업로드", "내 사운드", "사운드 목록", "내정보"};
	public String[] adminMenuList = {"종료", "사운드 업로드", "내 사운드", "사운드 목록", "내정보", "회원 삭제"};
	public String[] mySoundMenuList = {"뒤로가기", "업로드한 사운드", "좋아요한 사운드", "보유중인 사운드"};
	
	private final String HEAD_ADMIN_ID = "hadmin";
	private final String HEAD_ADMIN_PW = "hadmin";
	private boolean isHeadAdmin = false;
	
	// 로그인 시도
	public boolean doLogin() {
		System.out.println("< 로그인 >");
		do {
			System.out.print("아이디 입력 (0:뒤로가기) : ");
			String id = scan.next();
			if(id.equals("0")) return false;
			System.out.print("패스워드 입력 : ");
			String pw = scan.next();
			
			if(id.equals(HEAD_ADMIN_ID) && pw.equals(HEAD_ADMIN_PW)) {
				isHeadAdmin = true;
				return true;
			}
			loginUser = userService.selectUserByLogin(id, pw);
			
			if (loginUser == null) System.out.println("아이디 혹은 패스워드가 잘못됐습니다.");
		} while (loginUser == null);
		
		System.out.println(loginUser.getName() +" 로그인 성공");
		System.out.println("========================");
		return true;
	}
	
	// 회원가입
	public void signUp() {
		System.out.println("< 회원가입 >");
		System.out.print("이름 입력 (0: 뒤로가기): ");
		String name = scan.next();

		if(name.equals("0")) return;
		System.out.print("아이디 입력: ");
		String id = scan.next();
		
		System.out.print("패스워드 입력: ");
		String pw = scan.next();
		
		boolean result = false;
		if(userService.checkIDDuplication(id)) System.out.println("사용중인 아이디입니다.");
		else if(userService.checkNameDuplication(name)) System.out.println("사용중인 이름입니다.");
		else {
			result = userService.registUser(new UserVO(id, pw, name));
			
		}
		
		if(result == true) System.out.println("회원가입 성공");
		else System.out.println("회원가입 실패");
		
	}
	
	// 메뉴 표시
	public int chooseMenu(String[] list) {

		for(int i = 1; i < list.length; i++) {
			if(list[i].equals("x")) continue; // 예외
			System.out.println(i + ". " + list[i]);
		}
		System.out.println("0. " + list[0]);
		System.out.print("메뉴를 선택하세요: ");
		
		try {
			int i = Integer.parseInt(scan.next());
			return i;
		} catch (Exception e) {
			return -1;
		}
		
	}
	
	// 사운드 목록 보기
	public void showSoundList(List<SoundVO> soundList) {
		System.out.println("=======================");
		for (SoundVO sound : soundList) {
			System.out.println(sound);
		}
		if(soundList.isEmpty()) System.out.println("데이터가 없습니다.");
		System.out.println("=======================");
	}

	// 유저 목록 보기
	private void showUserList(List<UserVO> userList ) {
		System.out.println("=======================");
		for (UserVO user : userList) {
			System.out.println(user);
		}
		if(userList.isEmpty()) System.out.println("데이터가 없습니다.");
		System.out.println("=======================");
	}
	
	
	// 사운드 정보 보기
	public void showSoundListAndInfo(List<SoundVO> soundList) {
		
		while(true) {
			showSoundList(soundList);
			System.out.print("확인하고 싶은 사운드 번호 입력 (0: 뒤로가기) : ");
			int soundNo = -1;
			try {
				soundNo = scan.nextInt();
			} catch (Exception e) {
				soundNo = -1;
			}

			SoundVO s = soundService.detailSoundInfo(soundNo);

			if(soundNo == 0) break;
			if(s == null) {
				System.out.println("사운드 번호가 잘못됐습니다.");
				break;
			}
			
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
	}
	
	public int doSound(SoundVO s) {
		int soundNo = s.getSoundNo();
		int choose = -1;
		
		boolean isUpload = loginUser.getName().equals(s.getAuthor());
		boolean isLiked = loginUser.getLikeList().indexOf(soundNo) > -1;
		boolean isHave = loginUser.getHaveList().indexOf(soundNo) > -1;

		// 메뉴 생성 및 출력
		String[] soundMenu = new String[4];
		soundMenu[1] = isLiked ? "좋아요 해제" : "좋아요";
		
		if(isHave) soundMenu[2] = "소유중";
		else if(isUpload || s.getPrice() == 0) soundMenu[2] = "다운로드하기";
		else soundMenu[2] = "구매 및 다운로드하기";
			
		if(isHave) soundMenu[3] = "사운드 듣기";
		else soundMenu[3] = "x";
		
		soundMenu[0] = "뒤로가기";
			
		choose = chooseMenu(soundMenu);
		// ---------
		
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
				soundService.updateSound(s);
				userService.updateUser(loginUser);
				break;
			case 2:
				if(isHave) break;
				
				list = loginUser.getHaveList();
				if(s.getPrice() == 0) {
					System.out.println("다운로드중...");
					list.add(s.getSoundNo());
					loginUser.setHaveList(list);
					s.setCntHaveUsers(s.getCntHaveUsers() + 1);
					System.out.println("다운로드 완료");
				}
				else {
					if(buySound(s)) {
						System.out.println("다운로드중...");
						list.add(s.getSoundNo());
						loginUser.setHaveList(list);
						s.setCntHaveUsers(s.getCntHaveUsers() + 1);
						System.out.println("구매 및 다운로드 완료");
					}
				}
				soundService.updateSound(s);
				userService.updateUser(loginUser);
				break;
			case 3:
				System.out.println("♬~~(재생중)");
				while(true) {
					System.out.print("1. 노래재생 중지하기 : ");
					if(scan.next().equals("1")) break;
				}
				break;
		}
		System.out.println("=========================");
		
		return choose;
	}
	
	public boolean buySound(SoundVO s) {
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
	
	public void showUserInfo(UserVO u) {
		boolean isSameUser = (u == loginUser);
		boolean canManage = (isHeadAdmin || (!u.isAdmin() && loginUser.isAdmin()));
		
		System.out.println("=================");
		System.out.println("< 유저 정보 > ");
		System.out.println("유저 UID : " + u.getUserNo());
		System.out.println("닉네임 : " + u.getName());
		System.out.println("아이디 : " + u.getId());
		System.out.println("패스워드 : " + "*".repeat(u.getPw().length()));
		System.out.println("충전된 금액 : " + u.getPrice());
		System.out.println("노래 업로드 수 : " + u.getUploadList().size());
		System.out.println("=================");

		String[] showUserInfoMenuList = new String[3];
		showUserInfoMenuList[0] = "뒤로가기";
		if(isSameUser) {
			showUserInfoMenuList[1] = "충전하기";
			showUserInfoMenuList[2] = "x";
		}
		if(!isSameUser && canManage) {
			showUserInfoMenuList[1] = "x";
			showUserInfoMenuList[2] = "유저 삭제하기";
		}
		
		int choose = chooseMenu(showUserInfoMenuList);
		
		if(choose == 1 && isSameUser) chargeAmount();
		if(choose == 2 && !isSameUser && canManage) deleteUser(u);

		
	}

	private void deleteUser(UserVO u) {
		System.out.print("해당 유저를 삭제하시겠습니까? (1. 예 / 2. 아니요) : ");
		int check = -1;
		try {
			check = scan.nextInt();
		} catch (Exception e) {
		}
		
		if(check == 1) {
			System.out.print("비밀번호 입력: ");
			String pw = scan.next();
			
			if(pw.equals(HEAD_ADMIN_PW) || (loginUser != null && pw.equals(loginUser.getPw()))) {
				if(userService.removeUser(u.getUserNo())) System.out.println("삭제되었습니다.");
				else System.out.println("삭제에 실패했습니다.");
			}
			else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
			
		}
		else if(check == 2) {
			return;
		}
		else System.out.println("잘못 입력하셨습니다.");
		
	}

	public void doUserInfo() {
		
	}

	public void chargeAmount() {
		System.out.println("현재 금액 : " + loginUser.getPrice());
		
		
		try {
			System.out.print("카드 번호 입력 : ");
			String cardNum = scan.next();
			System.out.print("충전할 금액 입력 : ");
			loginUser.setPrice(loginUser.getPrice() + scan.nextInt());
			userService.updateUser(loginUser);
			System.out.println("충전이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("입력값에 오류가 발생했습니다. ");
		}
		
	}


	// 메뉴 : 사운드 업로드 ----------------
	public void uploadSound() {

		System.out.println("====================================");
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
		SoundVO sound = new SoundVO(title, loginUser.getName(), price);
		soundService.registSound(sound);
		System.out.println("업로드 완료");
	}

	public boolean isLoginUser() {
		return loginUser != null;
	}
	
	public boolean isHeadAdmin() {
		return isHeadAdmin;
	}
	
	public UserVO getLoginUser() {
		return loginUser;
	}

	public void mySound() {
		System.out.println("===================");
		List<SoundVO> soundList = new ArrayList<SoundVO>();
		int choose = -1;
		
		do {
			choose = chooseMenu(mySoundMenuList);
			
			switch(choose) {
				case 1:	// 업로드한 사운드
					soundList = soundService.listSoundsBySearch(SoundService.SEARCH_TYPE_AUTHOR, loginUser.getName());
					break;
				case 2:	// 좋아요한 사운드
					for(Integer num : loginUser.getLikeList())
						soundList.add(soundService.detailSoundInfo(num));
					break;
				case 3: // 보유중인 사운드
					for(Integer num : loginUser.getHaveList())
						soundList.add(soundService.detailSoundInfo(num));
					break;
				case 0:	// 뒤로가기
					return;
			}
		} while(choose > mySoundMenuList.length || 0 > choose);
		
		showSoundListAndInfo(soundList);
	}

	public void manageUser() {
		
		while(true) {
			showUserList(userService.listUsers());
			System.out.print("관리 대상 유저번호 입력 (0:뒤로가기) : ");
			int userNo = -1;
			
			try {
				userNo = scan.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			if(userNo == 0) return;
			
			UserVO user = userService.detailUserInfo(userNo);
			System.out.println(user);
			
			if(user == null) {
				System.out.println("번호에 해당하는 유저가 없습니다.");
				continue;
			}
			
			showUserInfo(user);
			
		}
		
		
	}
}

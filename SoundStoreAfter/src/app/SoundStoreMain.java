package app;

public class SoundStoreMain {
	private static SoundStoreApp ssa = new SoundStoreApp();
	
	public static void main(String[] args) {	
		// 타이틀 표시
		showTitle();
		
		// 로그인
		login();
		
		
		while(true) {
			// 메인 메뉴
			int choose = -1;
			
			if(ssa.isHeadAdmin() || (ssa.isLoginUser() && ssa.getLoginUser().isAdmin())) {
				choose = ssa.chooseMenu(ssa.adminMenuList);
			}
			else choose = ssa.chooseMenu(ssa.menuList);
			
			switch (choose) {
				case 1:	// 사운드 업로드
					if(ssa.isLoginUser()) ssa.uploadSound();
					else System.out.println("비회원은 해당 기능 사용이 불가능합니다.");
					break;
				case 2:	// 내 사운드
					if(ssa.isLoginUser()) ssa.mySound();
					else System.out.println("비회원은 해당 기능 사용이 불가능합니다.");
					break;
				case 3: // 사운드 목록
					ssa.showSoundListAndInfo(ssa.soundService.listSounds());
					break;
				case 4: // 내정보
					if(ssa.isLoginUser()) ssa.showUserInfo(ssa.getLoginUser());
					else System.out.println("비회원은 해당 기능 사용이 불가능합니다.");
					break;
				case 5: // 회원 관리
					if(ssa.isHeadAdmin() || (ssa.isLoginUser() && ssa.getLoginUser().isAdmin())) {
						ssa.manageUser();
					}
					break;
				case 0:
					System.out.println("사운드 스토어를 종료합니다. 이용해주셔서 감사합니다");
					return;
				default:
					System.out.println("메뉴 번호가 잘못됐습니다. 다시 입력해주세요");
				}
		}
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
	private static void login() {
		int menuNum;
		while (true) {
			System.out.println("==================");
			menuNum = ssa.chooseMenu(ssa.loginMenuList);

			System.out.println("========================");
			switch(menuNum) {
				case 1:
					if(ssa.doLogin()) return; 
					break;
				case 2:
					ssa.signUp();
					break;
				case 3:
					System.out.println("비회원으로 로그인합니다.");
					return;
			}
		}
	}
	
	
}

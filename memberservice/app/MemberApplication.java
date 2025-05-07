package memberservice.app;

import java.util.LinkedList;
import java.util.Scanner;

import member.Member;
import member.MemberService;
import member.exception.NoMemberException;

public class MemberApplication {
	
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	
	public void controlMenu() {
		
		int menu;
		do {
			// 메뉴를 보여주고 선택 받아서
			menu = selectMenu();
			// 해당 기능 수행
			switch (menu) {
			case 1: menuRegistMember(); break;
			case 2: menuMemberList(); break;
			case 3: menuMemberDetailInfo(); break;
			case 4: menuMemberUpdate(); break;
			case 5: menuMemberRemove(); break;
			case 0:
				System.out.println("*** 회원 관리 종료 ***");
				break;
			default:
				System.out.println("없는 메뉴입니다.");
			}
			
		} while (menu != 0);
	}
	
	private void menuMemberRemove() {
		System.out.println("*** 회원 탈퇴 ***");
		menuMemberList();
		System.out.print(">> 회원 번호 : ");
		int memberNo = sc.nextInt();
		try {
			ms.removeMember(memberNo);
			System.out.println("회원 탈퇴 성공");
		}catch (NoMemberException e) {
			System.out.println("회원 탈퇴 실패");
		}
	}
	
	private void menuMemberUpdate() {
		System.out.println("*** 회원 정보 수정 ***");
		menuMemberList();
		System.out.print(">> 회원 번호 : ");
		int memberNo = sc.nextInt();
		System.out.print(">> 기존 비밀번호 : ");
		String oldPassword = sc.next();
		System.out.print(">> 새로운 비밀번호 : ");
		String newPassword = sc.next();
		try {
			ms.updateMemberInfo(memberNo, oldPassword, newPassword);
			System.out.println("비밀번호를 수정하였습니다.");
		} catch (NoMemberException e) {
			System.out.println("회원정보 수정에 실패하였습니다.");
		}
	}
	
	private void menuMemberDetailInfo() {
		System.out.println("*** 회원 상세 정보 ***");
		menuMemberList();
		System.out.print(">> 회원 번호 : ");
		int memberNo = sc.nextInt();
		try {
			Member member = ms.detailMemberInfo(memberNo);
			System.out.println(member.toString());
			
		} catch (NoMemberException e) {
			System.out.println("없는 회원입니다.");
		}
		
	}
	
	private void menuRegistMember() {
		System.out.println("*** 회원 가입 ***");
		
		String id;
		do {
			System.out.print(">> 아이디 (중복불가) : ");
			id = sc.next();
		} while (!ms.isIdValid(id));
		
		System.out.print(">> 비밀번호 : ");
		String password = sc.next();
		
		System.out.print(">> 이름 : ");
		String username = sc.next();
		
		if (ms.registMember(id, password, username)) {
			System.out.println("회원 가입이 되었습니다.");
		} else {
			System.out.println("회원 가입에 실패하였습니다.");
		}
	}
	
	private void menuMemberList() {
		System.out.println("*** 회원 목록 ***");
		LinkedList<Member> memberList = ms.listMembers();
		System.out.println("---------------------------------------");
		if (memberList.isEmpty()) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			for (Member member : memberList) {
				System.out.println(member.toString());
			}
		}
		
		System.out.println("---------------------------------------");
		
	}
	
	private int selectMenu() {
		String[] menuList = {"종료", "회원가입", "회원목록", "회원상세정보", "회원정보수정", "회원탈퇴"};
		
		System.out.println("==============================");
		for (int i = 1; i < menuList.length; i++) {
			System.out.println(i + ". " + menuList[i]);
		}
		System.out.println("0. " + menuList[0]);
		System.out.println("==============================");
		System.out.print(">> 메뉴 선택 : ");
		int menu = -1;
		try {
			menu = Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			System.out.println("[오류] 메뉴 번호에 해당하는 숫자를 입력하세요.");
		}
		
		return menu;
		
	}
	
	public static void main(String[] args) {
		
		MemberApplication app = new MemberApplication();
		app.controlMenu();
	}

}

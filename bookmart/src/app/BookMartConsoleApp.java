package app;

import java.util.ArrayList;
import java.util.List;

import book.BookService;
import book.BookVO;
import book.HJBookService;
import book.file.ObjFileHashMapBookDAO;
import member.HJMemberService;
import member.MemberService;
import member.MemberVO;
import member.ObjFileHashMapMemberDAO;
import order.ObjFileHashMapOrderDAO;
import order.OrderItemVO;
import order.OrderService;
import order.OrderServiceImpl;
import order.OrderVO;

public class BookMartConsoleApp {

	String[] startMenuList = {"종료", "도서 목록", "로그인", "회원 가입"};
	String[] adminMenuList = {"로그아웃", "도서 목록", "도서 등록", "도서 정보 수정", "도서 삭제", "회원 목록", "주문 목록"};
	String[] memberMenuList = {"로그아웃", "도서 목록", "도서 주문", "주문 목록", "장바바구니 도서 담기", "장바구니 보기", "내 정보"};
	String[] cartMenuList = {"돌아가기", "도서 주문", "도서 삭제", "장바구니 비우기"};
	String[] myInfoMenuList = {"돌아가기", "비밀번호 변경", "회원 탈퇴"};
	
	final String ADMIN_ID = "admin";
	final String ADMIN_PWD = "1234";
	final String ADMIN_NAME = "관리자";
	
	final String CONFIRM = "yes";
	
	BookService bs = new HJBookService(new ObjFileHashMapBookDAO());
	MemberService ms = new HJMemberService(new ObjFileHashMapMemberDAO());
	OrderService os = new OrderServiceImpl(new ObjFileHashMapOrderDAO(), bs);
	MemberVO loggedMember;
	
	MyAppReader input = new MyAppReader();
	
	public static void main(String[] args) {
		BookMartConsoleApp app = new BookMartConsoleApp();
		app.displayWelcome();
		app.controlStartMenu();
	}

	private void displayWelcome() {
		System.out.println("***********************************");
		System.out.println("*  Welcome to Hyejeong Book Mart  *");
		System.out.println("***********************************");
	}

	private void controlStartMenu() {
		int menu;
		do {
			menu = selectMenu(startMenuList);
			
			switch (menu) {
			case 1: menuBookList(); break;
			case 2: menuLogin(); break;
			case 3: menuSignUp(); break;
			case 0: menuExit(); break;
			default : menuWrongNumber();
			}
			
		} while (menu != 0);
		
	}

	private void menuWrongNumber() {
		System.out.println("없는 메뉴입니다.");
		
	}

	private void menuExit() {
		System.out.println("Hyejeong Book Mart 서비스를 종료합니다.");
		
	}

	private void menuBookList() {
		System.out.println("*** 도서 목록 ***");
		displayBookList();
	}
	
	private void displayBookList() {
		List<BookVO> bookList = bs.listBooks();
		System.out.println("---------------------------------------");
		if (bookList.isEmpty()) {
			System.out.println("등록된 도서가 없습니다.");
		} else {
			for (BookVO book : bookList) {
				System.out.println(book);
			}
		}
		System.out.println("---------------------------------------");	
	}

	private void menuLogin() {
		System.out.println("*** 로그인 ***");
		String id = input.readString(">> id : ");
		String password = input.readString(">> password : ");
		
		// 관리자 -> 관리자 메뉴
		if (id.equals(ADMIN_ID) && password.equals(ADMIN_PWD)) {
			loggedMember = new MemberVO(ADMIN_ID, ADMIN_PWD, ADMIN_NAME);
			System.out.println("관리자 모드로 변경합니다.");
			controlAdminMenu();
		} else {
			// 회원 -> 회원 메뉴
			loggedMember = ms.login(id, password);
			
			if (loggedMember != null) {
				System.out.println("[로그인] " + loggedMember.getUsername() + "님 안녕하세요.");
				controlMemberMenu();
			} else {
				// 아니면
				System.out.println("로그인을 하지 못했습니다.");
			}
		}
		
	}

	private void controlMemberMenu() {
		int menu;
		do {
			menu = selectMenu(memberMenuList);
			// "로그아웃", "도서 목록", "도서 주문", "주문 목록", "장바바구니 도서 담기", "장바구니 보기", "내 정보"
			switch (menu) {
			case 1 : menuBookList(); break;
			case 2 : menuBookOrder(); break;
			case 3 : menuOrderList(); break;
			case 4 : menuAddBook2Cart(); break;
			case 5 : menuCartView(); break;
			case 6 : menuMyInfo(); break;
			case 0 : menuLogout(); break;
			default : menuWrongNumber();
			}
		} while (menu != 0);

	}

	private void menuBookOrder() {
		System.out.println("*** 도서 주문 ***");
		displayAvailableBookList();
		int bookNo = input.readInt(">> 도서 번호 : ");
		BookVO book = bs.detailBookInfo(bookNo);
		
		if (book == null) {
			System.out.println("없는 도서 입니다.");
			return;
		}
		
		int quantity = input.readInt(">> 주문량 (" + book.getInstock() + "권 이내) : ");
		if (quantity > book.getInstock()) {
			System.out.println("주문량이 재고량보다 큽니다.");
			return;
		}
		
		// 주문 도서 목록
		List<OrderItemVO> orderItemList = new ArrayList<>();
		int price = book.getPrice() * quantity;
		orderItemList.add(new OrderItemVO(bookNo, quantity, price));
		
		// 주문 정보 생성
		OrderVO order = new OrderVO(loggedMember.getId(), orderItemList, price);
		// 배송 정보 추가
		setDeliveryInfo();
		order.setMobile(loggedMember.getMobile());
		order.setAddress(loggedMember.getAddress());
		
		if (os.orderItems(order)) {
			System.out.println("주문이 완료되었습니다.");
			System.out.println("배송이 완료되었습니다.");
		} else {
			System.out.println("주문을 하지 못했습니다.");
		}
	}
	
	private void setDeliveryInfo() {
		if (loggedMember.getMobile() == null) {
			System.out.println("*** 배송 정보 입력 ***");
			
			String mobile = input.readString(">> 모바일 번호 : ");
			String email = input.readString(">> 이메일 주소 : ");
			String address = input.readString(">> 주소 : ");
			
			loggedMember.setMobile(mobile);
			loggedMember.setEmail(email);
			loggedMember.setAddress(address);
			
			ms.addMemberInfo(loggedMember.getId(), mobile, email, address);
			//loggedMember = ms.detailMemberInfo(loggedMember.getId());
			
		}
	}

	private void displayAvailableBookList() {
		List<BookVO> bookList = bs.listBooks();
		System.out.println("---------------------------------------");
		if (bookList.isEmpty()) {
			System.out.println("주문 가능한 도서가 없습니다.");
		} else {
			int count = 0;
			for (BookVO book : bookList) {
				if (book.getInstock() > 0) {
					System.out.println(book);
					count++;
				}
			}
			if (count == 0) 
				System.out.println("주문 가능한 도서가 없습니다.");
		}
		System.out.println("---------------------------------------");	
		
	}

	private void menuAddBook2Cart() {
		System.out.println("죄송합니다. 빠른 시일 내에 개발하겠습니다.");
		
	}

	private void menuCartView() {
		System.out.println("죄송합니다. 빠른 시일 내에 개발하겠습니다.");
		
	}

	private void menuMyInfo() {
		System.out.println("*** 내 정보 ***");
		System.out.println(loggedMember);
		
		controlMyInfoMenu();
	}

	private void controlMyInfoMenu() {
		int menu;
		do {
			menu = selectMenu(myInfoMenuList);
			// "돌아가기", "비밀번호 변경", "회원 탈퇴"
			switch (menu) {
			case 1 : menuUpatePassword(); break;
			case 2 : menuMemberExit(); break;
			case 0 : break;
			default : menuWrongNumber();
			}
		} while (menu != 0 && loggedMember != null);
		
	}

	private void menuUpatePassword() {
		System.out.println("*** 비밀번호 수정 ***");
		String oldPassword = input.readString(">> 기존 비밀번호 : ");
		String newPassword = input.readString(">> 새 비밀번호 : ");
		if (ms.updatePassword(loggedMember.getId(), oldPassword, newPassword)) {
			System.out.println("[비밀번호 수정] 비밀번호를 수정했습니다.");
		} else {
			System.out.println("[비밀번호 수정 실패] 비밀번호 수정에 실패했습니다.");
		}
	}

	private void menuMemberExit() {
		System.out.println("*** 회원 탈퇴 ***");
		String password = input.readString(">> 비밀번호 : ");
		if (ms.removeMember(loggedMember.getId(), password)) {
			System.out.println("[회원 탈퇴] 회원정보, 주문정보를 삭제하였습니다. 그동안 서비스를 이용해 주셔서 감사합니다.");
			loggedMember = null;
		} else {
			System.out.println("[회원 탈퇴 실패] 회원 탈퇴 처리에 실패했습니다.");
		}
		
	}

	private void controlAdminMenu() {
		int menu;
		do {
			menu = selectMenu(adminMenuList);
			// "로그아웃", "도서 목록", "도서 등록", "도서 정보 수정", "도서 삭제", "회원 목록", "주문 목록"
			switch (menu) {
			case 1: menuBookList(); break;
			case 2: menuBookRegist(); break;
			case 3: menuBookUpdate(); break;
			case 4: menuBookRemove(); break;
			case 5: menuMemberList(); break;
			case 6: menuOrderList(); break;
			case 0: menuLogout(); break;
			default : menuWrongNumber();
			}
			
		} while (menu != 0 && loggedMember != null);
		
	}

	private void menuBookRegist() {
		
		System.out.println("*** 도서 등록 ***");
		String title = input.readString(">> 도서 제목 : ");
		String author = input.readString(">> 저자 : ");
		String publisher = input.readString(">> 출판사 : ");
		int price = input.readInt(">> 가격 : ");
		int instock = input.readInt(">> 재고량 : ");
		
		if (bs.registBook(new BookVO(title, author, publisher, price, instock))) {
			System.out.println("도서를 등록했습니다.");
			displayBookList();
		} else {
			System.out.println("도서 등록에 실패했습니다.");
		}
		
	}

	private void menuBookUpdate() {
		System.out.println("*** 도서 정보 수정 ***");
		displayBookList();
		int bookNo = input.readInt(">> 도서 번호 :");
		
		int select = input.readInt(">> 수정할 정보 선택 (1. 가격, 2. 재고량) : ");
		if (select == 1) { // 가격
			int price = input.readInt(">> 새 가격 : ");
			if (bs.updateBookPrice(bookNo, price)) {
				System.out.println("[도서 정보 수정] 가격을 수정하였습니다.");
			} else {
				System.out.println("[도서 정보 수정 오류] 없는 도서입니다.");
			}
			
		} else if (select == 2) {// 재고량
			int instock = input.readInt(">> 새 재고량 :");
			if (bs.updateBookInstock(bookNo, instock)) {
				System.out.println("[도서 정보 수정] 재고량을 수정하였습니다.");
			} else {
				System.out.println("[도서 정보 수정 오류] 없는 도서입니다.");
			}
		} else {
			System.out.println("[도서 정보 수정 취소] 지원하지 않는 기능입니다.");
		}
		
	}

	private void menuBookRemove() {
		System.out.println("*** 도서 삭제 ***");
		displayBookList();
		int bookNo = input.readInt(">> 도서 번호 :");
		String confirm = input.readString("선택한 도서를 삭제하시겠습니까? ('" + CONFIRM + "'를 입력하면 실행) : ");
		if (confirm.equals(CONFIRM)) {
			if (bs.removeBook(bookNo)) {
				System.out.println("[도서 삭제] 도서를 삭제했습니다.");
			} else {
				System.out.println("[도서 삭제 오류] 없는 도서입니다.");
			}
		} else {
			System.out.println("[도서 삭제 취소] 도서 삭제를 취소했습니다.");
		}
	}

	private void menuMemberList() {
		System.out.println("*** 회원 목록 ***");
		System.out.println("---------------------------------------");
		List<MemberVO> memberList = ms.listMembers();
		if (memberList.isEmpty()) {
			System.out.println("회원이 없습니다.");
		} else {
			for (MemberVO member : memberList) {
				System.out.println(member);
			}
		}
		System.out.println("---------------------------------------");
		
	}

	private void menuOrderList() {
		if (loggedMember.getId().equals(ADMIN_ID)) {
			System.out.println(os.listAllOrder());
		} else {
			System.out.println(os.listMyOrders(loggedMember.getId()));
		}
		
	}

	private void menuLogout() {
		
		System.out.println("[로그아웃] " + loggedMember.getUsername() + "님, 안녕히 가십시오.");
		loggedMember = null;
		
	}

	private void menuSignUp() {
		System.out.println("*** 회원 가입 ***");
		String id = input.readString(">> id : ");
		String password = input.readString(">> password : ");
		String username = input.readString(">> username : ");
		
		if (ms.registMember(new MemberVO(id, password, username))) {
			System.out.println("회원 가입이 완료되었습니다. 서비스 이용을 위한 로그인 해주세요.");
		} else {
			System.out.println("회원 가입에 실패하였습니다.");
		}
		
	}

	private int selectMenu(String[] menuList) {

		System.out.println("-------------------------------");
		for (int i = 1; i < menuList.length; i++) {
			System.out.println(i + ". " + menuList[i]);
		}
		System.out.println("0. " + menuList[0]);
		System.out.println("-------------------------------");
		return input.readInt(">> 메뉴 선택 : ");
	}
}

package app;

import java.util.ArrayList;
import java.util.Scanner;

import book.Book;
import book.BookService;
import book.exception.NoBookException;

public class BookRentConsoleApp {
	
	BookService bs = new BookService();
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// BookRentConsoleApp 객체 생성
		BookRentConsoleApp app = new BookRentConsoleApp();
		
		// 환영 인사
		app.displayWelcome();
		
		// 선택 메뉴에 따라 기능 수행
		app.controlMenu();
	}
	
	private void displayWelcome() {
		System.out.println("************************************");
		System.out.println("*    도서 대여점에 오신 걸 환영합니다.    *");
		System.out.println("************************************");
	}
	
	private void controlMenu() {
		int menu;
		do {
			menu = getMenu(); // 메뉴 출력하고 메뉴 번호를 입력 받음
			switch (menu) {
			case 1: menuBookList(); break;
			case 2: menuBookRent(); break;
			case 3: menuBookRentList(); break;
			case 4: menuBookReturn(); break;
			case 5: menuBookRegist(); break;
			case 6: menuBookUpdate(); break;
			case 7: menuBookRemove(); break;
			case 0: menuExit();	break;
			default: System.out.println("없는 메뉴입니다.");
			}
		} while (menu != 0);
	}
	
	private void menuBookRemove() {
		displayBookList(bs.getBookList());
		System.out.print("삭제할 책 번호 입력: ");
		boolean result = bs.removeBook(scan.nextInt());
		
		if(result) System.out.println("삭제 성공");
		else System.out.println("삭제 실패");
		
	}

	private void menuBookUpdate(){
		displayBookList(bs.getBookList());
		
		
		try {
			System.out.print("수정할 책 번호 입력 : ");
			int bookNo = scan.nextInt();
			Book book = bs.getBook(bookNo);
			
			System.out.print("수정할 가격 입력:");
			book.setPrice(scan.nextInt());
			
			System.out.println("가격 수정 완료");
		} catch (NoBookException e) {
			System.out.println("번호에 일치하는 책이 없습니다.");
		} catch (Exception e) {
			System.out.println("입력값이 잘못되었습니다.");
		}
	}

	private void menuBookRegist() {
		int bookNo;
		try {
			while(true) {
				System.out.print("책 번호 (중복불가): ");
				bookNo = scan.nextInt();
				if(bs.isIdValid(bookNo)) break;
				System.out.println("책 번호가 중복되었습니다. 다시 입력해주세요.");
			}
			
			System.out.print("책 제목 : ");
			String title = scan.next();
			
			System.out.print("책 저자 : ");
			String author = scan.next();
			
			System.out.print("책 출판사 : ");
			String publisher = scan.next();
			
			System.out.print("책 구매 비용 : ");
			int money = scan.nextInt();
			
			Book book = new Book(bookNo, title, author, publisher, money, true);
			
			boolean result = bs.registBook(book);
			if(result) System.out.println("책 등록 완료");
			else System.out.println("책 등록 실패");
		} catch (Exception e) {
			System.out.println("입력값이 잘못되었습니다.");
		}

	}

	
	
	private void menuBookList() {
		ArrayList<Book> bookList = bs.listInstockBooks();
		displayBookList(bookList);
	}
	
	private void menuBookRentList() {
		ArrayList<Book> bookList = bs.listRentBooks();
		displayBookList(bookList);
	}
	
	private void displayBookList(ArrayList<Book> bookList) {
		System.out.println("--------------------------------------------");
		if (bookList.isEmpty()) {
			System.out.println("책이 없습니다.");
		} else {
			for (Book book : bookList) {
				System.out.println(book.toString());
			}
		}
		System.out.println("--------------------------------------------");
	}
	
	private void menuBookRent() {
		
		displayBookList(bs.listInstockBooks());
		
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 대여할 도서 번호 : ");
		int bookNo = sc.nextInt();
		
		if (bs.rentBook(bookNo)) {
			displayBookList(bs.listRentBooks());
		} else {
			System.out.println("[오류] 없는 도서이거나 이미 대여한 도서입니다.");
		}
	}
	
	private void menuBookReturn() {
		displayBookList(bs.listRentBooks());
		
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 반납할 도서 번호 : ");
		int bookNo = sc.nextInt();
		
		if (bs.returnBook(bookNo)) {
			displayBookList(bs.listRentBooks());
		} else {
			System.out.println("[오류] 없는 도서이거나 이미 반납한 도서입니다.");
		}
	}
	
	private int getMenu() {
		// 메뉴 출력
		System.out.println("=================================");
		System.out.println("1. 도서 목록 보기");
		System.out.println("2. 도서 대여");
		System.out.println("3. 도서 대여 현황 보기");
		System.out.println("4. 도서 반납");
		System.out.println("5. 도서 추가");
		System.out.println("6. 도서 가격 수정");
		System.out.println("7. 도서 삭제");
		System.out.println("0. 종료");
		System.out.println("=================================");
		System.out.print(">> 메뉴 선택 : ");
		
		// 메뉴 번호 입력
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();	
		return menu;
	}
	
	private void menuExit() {
		System.out.println("*** 도서 대여점 종료 ***");
	}
}

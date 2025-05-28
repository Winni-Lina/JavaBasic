package test;

import book.BookDAO;
import book.BookService;
import book.BookVO;
import book.HJBookService;
import book.HashMapBookDAO;
import book.ListBookDAO;
import book.file.TextFileHashMapBookDAO;
import book.file.FileBookDB;

public class BookServiceTest {

	static BookDAO bookDAO = new TextFileHashMapBookDAO();
	static BookService bs = new HJBookService(bookDAO);
	
	public static void main(String[] args) {
		
		//testSaveBooks();
		testLoadBooks();
	}
	
	public static void testLoadBooks() {
		((FileBookDB)bookDAO).loadBooks();
		System.out.println(bs.listBooks());
		
		bs.registBook(new BookVO("test4", "hye", "kopo", 15000, 9));
		System.out.println(bs.listBooks());
		((FileBookDB)bookDAO).saveBooks();
	}
	
	public static void testSaveBooks() {
		// 책등록
		bs.registBook(new BookVO("test", "hyejeong", "kopo", 10000, 10));
		bs.registBook(new BookVO("test2", "curi", "home", 1000, 5));
		bs.registBook(new BookVO("test3", "hye", "home", 3000, 15));
		((FileBookDB)bookDAO).saveBooks();
	}
	
	static void serviceTest() {
		// 책상세정보
				System.out.println(bs.detailBookInfo(112));
				
				// 책정보 수정
				bs.updateBookInstock(111, 15);
				bs.updateBookPrice(112, 30000);
				
				System.out.println(bs.listBooks());
				
				// 책 삭제
				bs.removeBook(113);
				
				System.out.println(bs.listBooks());
				
				System.out.println();
				
				bs = new HJBookService(new HashMapBookDAO());
				
				// 책등록
				bs.registBook(new BookVO("test", "hyejeong", "kopo", 10000, 10));
				bs.registBook(new BookVO("test2", "curi", "home", 1000, 5));
				bs.registBook(new BookVO("test3", "hye", "home", 3000, 15));
				
				// 책목록
				System.out.println(bs.listBooks());
				
				// 책상세정보
				System.out.println(bs.detailBookInfo(112));
				
				// 책정보 수정
				bs.updateBookInstock(111, 15);
				bs.updateBookPrice(112, 30000);
				
				System.out.println(bs.listBooks());
				
				// 책 삭제
				bs.removeBook(113);
				
				System.out.println(bs.listBooks());
	}
	
	static void DAOTest() {
		BookDAO bookDAO = new ListBookDAO();
		
		// 책등록
		bookDAO.insertBook(new BookVO("test", "hyejeong", "kopo", 10000, 10));
		bookDAO.insertBook(new BookVO("test2", "curi", "home", 1000, 5));
		bookDAO.insertBook(new BookVO("test3", "hye", "home", 3000, 15));
		
		// 책정보
		System.out.println(bookDAO.selectAllBooks());
		System.out.println(bookDAO.selectBook(112));
				
		// 책 정보 수정
		BookVO book = bookDAO.selectBook(111);
		book.setInstock(15);
		bookDAO.updateBook(book);
		
		book = bookDAO.selectBook(112);
		book.setPrice(30000);
		bookDAO.updateBook(book);
		
		System.out.println(bookDAO.selectAllBooks());
		
		// 책 삭제
		bookDAO.deleteBook(113);
		System.out.println(bookDAO.selectAllBooks());
	}
}

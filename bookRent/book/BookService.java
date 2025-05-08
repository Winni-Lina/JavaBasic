package book;

import java.util.ArrayList;

import book.exception.NoBookException;

public class BookService {
	
	private ArrayList<Book> bookList = new ArrayList<>();
	
	public BookService() {
		loadBookList();
	}
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	
	private void loadBookList() {
		bookList.add(new Book(101, "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아카데미", 20000, true));
		bookList.add(new Book(201, "나의 첫 알고리즘 + 자료구조", "코리 알트호프", "한빛미디어", 21000, true));
		bookList.add(new Book(301, "Do It! HTML+CSS+자바스크립트", "고경희", "이지스퍼블리싱", 32000, true));
	}
	
	public boolean registBook(Book book) {
		try {
			bookList.add(book);	
			return true;
		} catch (NullPointerException e) {
			return false;
		}
		
	}
	
	public boolean updateBook(int bookNo, int price) {
		try {
			Book book = getBook(bookNo);
			book.setPrice(price);
		} catch (NoBookException e) {
			System.out.println("번호에 해당하는 책이 없습니다.");
			return false;
		}
		return true;
	}
	
	public Book getBook(int bookNo) throws NoBookException{
		
		for(Book b : bookList) {
			if(b.getBookNo() == bookNo) {
				return b;
			}
		}
		
		throw new NoBookException(bookNo);
	}
	
	public boolean isIdValid(int id) {
		try {
			Book b = getBook(id);
			return false;
		} catch (NoBookException e) {
			return true;
		}
		
	}
	
	public boolean removeBook(int bookNo) {
		try {
			bookList.remove(getBook(bookNo));
			return true;
		} catch (NoBookException e) {
			System.out.println("번호에 해당하는 책이 없습니다.");
			return false;
		}
	}
	
	public ArrayList<Book> listInstockBooks() {
		return listBooks(true);
	}
	
	public ArrayList<Book> listRentBooks() {
		return listBooks(false);
	}
	
	private ArrayList<Book> listBooks(boolean isInstock) {
		ArrayList<Book> books = new ArrayList<>();
		
		for (Book book : bookList) {
			if (book.isInstock() == isInstock)
				books.add(book);
		}
		
		return books;
	}

	public boolean rentBook(int bookNo) {
		return changeRentStatus(bookNo, false);
	}
	
	public boolean returnBook(int bookNo) {
		return changeRentStatus(bookNo, true);
	}
	
	private boolean changeRentStatus(int bookNo, boolean isInstock) {
		for (Book book : bookList) {
			if (book.getBookNo() == bookNo && book.isInstock() != isInstock) {
				book.setInstock(isInstock);
				return true;
			}
		}
		return false;
	}
}

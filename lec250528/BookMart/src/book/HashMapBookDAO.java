package book;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapBookDAO implements BookDAO {

	protected Map<Integer, BookVO> bookDB = new HashMap<>();
	protected int bookSeq = 111;
	
	@Override
	public boolean insertBook(BookVO book) {
		book.setBookNo(bookSeq++);
		book.setRegdate(new Date());
		return bookDB.put(book.getBookNo(), book) != null;
		
	}

	@Override
	public BookVO selectBook(int bookNo) {
		return bookDB.get(bookNo);
	}

	@Override
	public List<BookVO> selectAllBooks() {
		return new ArrayList<>(bookDB.values());
	}

	@Override
	public boolean updateBook(BookVO newBook) {
		
		//return bookDB.put(newBook.getBookNo(), newBook) != null;
		if (bookDB.put(newBook.getBookNo(), newBook) != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteBook(int bookNo) {
		return bookDB.remove(bookNo) != null;
	}

}

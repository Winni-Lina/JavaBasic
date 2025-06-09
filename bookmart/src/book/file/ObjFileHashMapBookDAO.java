package book.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import book.BookVO;
import book.HashMapBookDAO;

public class ObjFileHashMapBookDAO extends HashMapBookDAO implements FileBookDB {

	private String dataFilename = DATA_FILE + ".obj";
	
	public ObjFileHashMapBookDAO() {
		loadBooks();
	}
	
	@Override
	public void saveBooks() {
		
		try (
			FileOutputStream fos = new FileOutputStream(dataFilename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				
		) {
			oos.writeObject(bookDB);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void loadBooks() {
		
		try (
			FileInputStream fis = new FileInputStream(dataFilename);
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			
			bookDB = (Map<Integer, BookVO>)ois.readObject();
			bookSeq = Collections.max(bookDB.keySet()) + 1;
			
		} catch (FileNotFoundException e) {
			System.out.println("[DB로딩] " + dataFilename + "가 없습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean insertBook(BookVO book) {
		boolean result = super.insertBook(book);
		if (result) saveBooks();
		return result;
	}

	@Override
	public boolean updateBook(BookVO newBook) {
		boolean result = super.updateBook(newBook);
		if (result) saveBooks();
		return result;
	}
	
	@Override
	public boolean deleteBook(int bookNo) {
		boolean result = super.deleteBook(bookNo);
		if (result) saveBooks();
		return result;
	}

}

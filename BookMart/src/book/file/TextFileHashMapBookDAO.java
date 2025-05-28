package book.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import book.BookVO;
import book.HashMapBookDAO;

public class TextFileHashMapBookDAO extends HashMapBookDAO implements FileBookDB {

	private String dataFilename = DATA_FILE + ".txt";
	private final String DATE_FORMAT = "YYYY-MM-dd HH:mm:ss";
			
	@Override
	public void saveBooks() {
		
		try (
			FileWriter fw = new FileWriter(dataFilename);
			PrintWriter pw = new PrintWriter(fw);
		) {
			
			for (BookVO book : bookDB.values()) {
				pw.println(book.getBookNo());
				pw.println(book.getTitle());
				pw.println(book.getAuthor());
				pw.println(book.getPublisher());
				pw.println(book.getPrice());
				pw.println(book.getInstock());
				
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				pw.println(sdf.format(book.getRegdate()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
	}

	@Override
	public void loadBooks() {

		try ( FileReader fr = new FileReader(dataFilename);
			  BufferedReader br = new BufferedReader(fr);
		) {
			
			while (br.ready()) {
				int bookNo = Integer.parseInt(br.readLine());
				String title = br.readLine().strip();
				String author = br.readLine().strip();
				String publisher = br.readLine().strip();
				int price = Integer.parseInt(br.readLine());
				int instock = Integer.parseInt(br.readLine());
				
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				Date regdate = sdf.parse(br.readLine());
				
				bookDB.put(bookNo, new BookVO(bookNo, title, author, publisher, price, instock, regdate));
				
				if (bookSeq <= bookNo) bookSeq = bookNo + 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println("[로딩] " + dataFilename + "이 없습니다.");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}

}

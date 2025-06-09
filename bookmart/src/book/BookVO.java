package book;

import java.io.Serializable;
import java.util.Date;

public class BookVO implements Serializable {
	private int bookNo;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private int instock;
	private Date regdate;
	
	public BookVO(int bookNo, String title, String author, String publisher, int price, int instock, Date regdate) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.instock = instock;
		this.regdate = regdate;
	}
	
	public BookVO(String title, String author, String publisher, int price, int instock) {
		this(-1, title, author, publisher, price, instock, null);
	}
	
	public String toString() {
		return "[" + bookNo + ", " + title + ", " + author + ", " + publisher + ", " + price + ", " + instock + "]";
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}

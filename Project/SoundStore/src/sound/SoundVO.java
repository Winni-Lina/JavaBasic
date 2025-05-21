package sound;

import java.util.Date;

public class SoundVO {
	private int soundNo;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private Date regDate; 
	
	public SoundVO(int soundNo, String title, String author, String publisher, int price, Date regDate) {
		this.soundNo = soundNo;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.regDate = regDate;
	}

	public SoundVO(String title, String author, String publisher, int price) {
		this(-1, title, author, publisher, price, null);
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "[" + soundNo + ". " + title + " - " + author + " / 공유자:" + publisher
				+ " / 가격: " + price + "]";
	}

	
	public int getSoundNo() {
		return soundNo;
	}
	public void setSoundNo(int soundNo) {
		this.soundNo = soundNo;
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

}
package sound;

public class SoundVO {
	private int soundNo;
	private String title;
	private String author;
	private String publisher;
	private int price;
	
	public SoundVO(int soundNo, String title, String author, String publisher, int price) {
		this.soundNo = soundNo;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[" + soundNo + ". " + title + " - " + author + " / 공유자:" + publisher
				+ " / 기격: " + price + "]";
	}

	public SoundVO(String title, String author, String publisher, int price) {
		this(-1, title, author, publisher, price);
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

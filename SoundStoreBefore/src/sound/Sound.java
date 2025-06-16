package sound;

public class Sound {
	private int soundNo;
	private String title;
	private String author;
	private int cntLikes;
	private int cntHaveUsers;
	private int price;
	
	public Sound(int soundNo, String title, String author, int cntLikes, int cntHaveUser, int price) {
		this.soundNo = soundNo;
		this.title = title;
		this.author = author;
		this.cntLikes = cntLikes;
		this.cntHaveUsers = cntHaveUser;
		this.price = price;
	}
	
	public Sound(String title, String author, int price) {
		this(0, title, author, 0, 0, price);
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

	public int getCntLikes() {
		return cntLikes;
	}

	public void setCntLikes(int cntLikes) {
		this.cntLikes = cntLikes;
	}

	public int getCntHaveUsers() {
		return cntHaveUsers;
	}

	public void setCntHaveUsers(int cntHaveUsers) {
		this.cntHaveUsers = cntHaveUsers;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "[" + soundNo + ". " + title + "-" + author + " / 좋아요 수 :" + cntLikes + " / 보유 수 : " + cntHaveUsers + "/ 구매 비용: " + price + "]";
	}
	
	
}

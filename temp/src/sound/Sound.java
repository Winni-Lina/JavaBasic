package sound;

public class Sound {
	private int soundNo;
	private String title;
	private String author;
	private String publisher;
	private int countLikes;
	private int countFavorites;
	
	public Sound(int soundNo, String title, String author, String publisher, int countLikes, int countFavorites) {
		this.soundNo = soundNo;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.countLikes = countLikes;
		this.countFavorites = countFavorites;
	}
	
	public Sound(String title, String author, String publisher) {
		this(0, title, author, publisher, 0, 0);
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

	public int getCountLikes() {
		return countLikes;
	}

	public void setCountLikes(int countLikes) {
		this.countLikes = countLikes;
	}

	public int getCountFavorites() {
		return countFavorites;
	}

	public void setCountFavorites(int countFavorites) {
		this.countFavorites = countFavorites;
	}

	@Override
	public String toString() {
		return soundNo + ". " + title + " - " + author + " | 좋아요 수: " + countLikes + ", 즐겨찾기 수: " + countFavorites;
	}
	
	

	
}

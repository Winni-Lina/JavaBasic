package user;

import java.util.ArrayList;
import java.util.List;

import sound.Sound;

public class User {
	private int userNo;
	private String id;
	private String pw;
	private String name;
	private int price;
	private List<Integer> likes;
	private List<Integer> favorites;
	
	public User(int userNo, String id, String pw, String name, int price, List<Integer> likes, List<Integer> favorites) {
		this.userNo = userNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.price = price;
		this.likes = likes;
		this.favorites = favorites;
	}

	public User(String id, String pw, String name) {
		this(0, id, pw, name, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
	}

	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Integer> getLikes() {
		return likes;
	}

	public void setLikes(List<Integer> likes) {
		this.likes = likes;
	}

	public List<Integer> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Integer> favorites) {
		this.favorites = favorites;
	}

	@Override
	public String toString() {
		return "[" + userNo + ". 아이디: " + id + ", 비밀번호: " + pw + ", 닉네임: " + name + ", 잔액=" + price
				+ ", 좋아요 표시한 노래=" + likes + ", 즐겨찾기 표시한 노래=" + favorites + "]";
	}
	
	
	
}

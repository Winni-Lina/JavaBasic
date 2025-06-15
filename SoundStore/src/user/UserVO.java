package user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserVO implements Serializable{
	private int userNo;
	private String id;
	private String pw;
	private String name;
	private int price;
	private List<Integer> likeList;
	private List<Integer> uploadList;
	private List<Integer> haveList;
	private boolean isAdmin;
	
	public UserVO(int userNo, String id, String pw, String name, int price, List<Integer> likeList, List<Integer> uploadList, List<Integer> haveList, boolean isAdmin) {
		this.userNo = userNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.price = price;
		this.likeList = likeList;
		this.uploadList = uploadList;
		this.haveList = haveList;
		this.isAdmin = isAdmin;
	}
	
	public UserVO(String id, String pw, String name) {
		this(0, id, pw, name, 0, new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>(), false);
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

	public List<Integer> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<Integer> likeList) {
		this.likeList = likeList;
	}

	public List<Integer> getUploadList() {
		return uploadList;
	}

	public void setUploadList(List<Integer> uploadList) {
		this.uploadList = uploadList;
	}

	public List<Integer> getHaveList() {
		return haveList;
	}

	public void setHaveList(List<Integer> haveList) {
		this.haveList = haveList;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	@Override
	public String toString() {
		return "[" + userNo + ". id:" + id + " / pw:" + pw + " / name:" + name + " / price:" + price
				+ " / likeList=" + likeList + " / uploadList:" + uploadList + " / haveList:" + haveList + "]";
	}	
}

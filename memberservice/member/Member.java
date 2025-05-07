package memberservice.member;

public class Member {

	private int memberNo;
	private String id;
	private String password;
	private String username;
	
	public Member(int memberNo, String id, String password, String username) {
		this.memberNo = memberNo;
		this.id = id;
		this.password = password;
		this.username = username;
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "[" + memberNo + ", " + id + ", " + password + ", " + username + "]";
	}
	
}

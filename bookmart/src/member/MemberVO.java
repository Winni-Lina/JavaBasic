package member;

import java.io.Serializable;
import java.util.Date;

public class MemberVO implements Serializable {
	private int memberNo;
	private String id;
	private String password;
	private String username;
	private String mobile;
	private String email;
	private String address;
	private Date regDate;
	
	public MemberVO(int memberNo, String id, String password, String username, String mobile, String email, String address, Date regDate) {
		this.memberNo = memberNo;
		this.id = id;
		this.password = password;
		this.username = username;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.regDate = regDate;
	}
	
	public MemberVO(String id, String password, String username) {
		this.id = id;
		this.password = password;
		this.username = username;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		String output = "[" + memberNo + ", " + id + ", " + password + ", " + username + ", " + regDate;
		if (mobile != null) {
			output += "(" + mobile + ", " + email + ", " + address +  ")";
		}
		output += "]";
		
		return output;
				
	}
	
	
}

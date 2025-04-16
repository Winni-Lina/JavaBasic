package account;

public class Account {
	private String accountNo;
	private String password;
	private String name;
	private int money;
	
	public Account(String accountNo, String password, String name, int money) {
		this.accountNo = accountNo;
		this.password = password;
		this.name = name;
		this.money = money;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "" + accountNo + "\t" + name + "\t" + money;
	}
	
	
}

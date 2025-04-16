package account;

import java.util.LinkedList;

public class AccountService {
	private LinkedList<Account> accountList = new LinkedList<Account>();

	public boolean registAccount(String accountNo, String password, String name, int money) {
		
		accountList.add(new Account(accountNo, password, name, money));
		
		return true;
	}

	public boolean isIdValid(String accountNo) {
		for(Account account : accountList) {
			if(account.getAccountNo().equals(accountNo))
				return false;
		}
		return true;
	}

	public LinkedList<Account> listAccounts() {
		return accountList;
	}

	public boolean deposit(String accountNo, int money) {
		Account account = getAccount(accountNo);
		if(account == null) return false;
		
		account.setMoney(account.getMoney() + money);
		
		return true;
	}
	
	private Account getAccount(String accountNo) {
		for(Account account : accountList) {
			if (account.getAccountNo().equals(accountNo))
				return account;
		}
		return null;
	}

	public boolean withdrawal(String accountNo, String password, int money) {
		Account account = getAccount(accountNo);
		
		if(account == null) return false;
		if(!account.getPassword().equals(password)) return false;
		if(account.getMoney() < money) return false;
		
		account.setMoney(account.getMoney() - money);
		return true;
		
	}

	
}

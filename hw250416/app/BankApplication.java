package app;

import java.util.LinkedList;
import java.util.Scanner;

import account.Account;
import account.AccountService;

public class BankApplication {
	
	Scanner scan = new Scanner(System.in);
	AccountService as = new AccountService();
	
	public static void main(String[] args) {
		BankApplication app = new BankApplication();
		app.controlMenu();
	}

	private void controlMenu() {
		
		int menu;
		do {
			// 메뉴를 보여주고 선택 받아서 
			menu = selectMenu();
			//해당 기능 수행
			switch (menu) {
			case 1: menuRegistAccount(); break;
			case 2: menuAccountList(); break;
			case 3: menuAccountDeposit(); break;
			case 4: menuAccountWithdrawal(); break;
			case 5: System.out.println("프로그램 종료"); break;
			default:
				System.out.println("없는 메뉴입니다.");
			}
		} while(menu != 0);
		
	}
	
	private void menuAccountWithdrawal() {
		System.out.println("-----------");
		System.out.println("출금");
		System.out.println("-----------");

		System.out.print("예금번호: ");
		String accountNo = scan.next();
		System.out.print("비밀번호: ");
		String password = scan.next();
		System.out.print("출금액: ");
		int money = scan.nextInt();
		
		if(as.withdrawal(accountNo, password, money)) 
			System.out.println("결과: 출금이 성공했습니다.");
		else System.out.println("결과: 출금이 실패했습니다.");
	}

	private void menuAccountDeposit() {
		
		System.out.println("-----------");
		System.out.println("예금");
		System.out.println("-----------");
		
		System.out.print("계좌번호: ");
		String accountNo = scan.next();
		System.out.print("예금액: ");
		int money = scan.nextInt();
		if(as.deposit(accountNo, money)) 
			System.out.println("결과: 예금이 성공했습니다.");
		else System.out.println("결과: 예금이 실패했습니다.");
		
	}

	private void menuAccountList() {
		System.out.println("-----------");
		System.out.println("계좌목록");
		System.out.println("-----------");
		
		LinkedList<Account> accountList = as.listAccounts();
		
		System.out.println("------------------------------------------");
		if(accountList.isEmpty()) {
			System.out.println("생성된 계좌가 없습니다.");
		}
		else {
			for(Account account : accountList) {
				System.out.println(account.toString());
			}
		}
		System.out.println("------------------------------------------");
		
	}

	private void menuMemberList() {
		System.out.println("-----------");
		System.out.println("계좌목록");
		System.out.println("-----------");
	}

	private int selectMenu() {
		String[] menuList = {"계좌생성", "계좌목록", "예금", "출금", "종료"};
		System.out.println("------------------------------------------------");
		for(int i = 0; i < menuList.length; i++)
			System.out.print(i+1 + ". " + menuList[i] + " | ");
		System.out.println("\n------------------------------------------------");
		
		System.out.print("선택 > ");
		
		return scan.nextInt();
	}
	
	private void menuRegistAccount() {
		System.out.println("-----------");
		System.out.println("계좌생성");
		System.out.println("-----------");
		
		String accountNo;
		do {
			System.out.print("계좌번호 (중복불가): ");
			accountNo = scan.next();
		} while (!as.isIdValid(accountNo));
		
		System.out.print("비밀번호: ");
		String password = scan.next();
		System.out.print("계좌주: ");
		String name = scan.next();
		System.out.print("초기입금액: ");
		int money = scan.nextInt();
		
		if(as.registAccount(accountNo, password, name, money)) {
			System.out.println("결과: 계좌가 생성되었습니다.");
		}
		else {
			System.out.println("결과: 계좌 생성에 실패하였습니다.");
		}
	}
}

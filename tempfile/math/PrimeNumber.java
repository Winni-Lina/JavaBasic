package math;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		PrimeNumber pn = new PrimeNumber();
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		int number = scan.nextInt();
		System.out.println(pn.isPrimeNumber(number));
	}
	
	public boolean isPrimeNumber(int number) {
		if(number == 1) return false;
		if(number == 2) return true;
		
		if(number % 2 == 0) return false;
		
		for(int i = 3; i <= number / 2; i+=2) {
			if(number%i==0) return false;
		}
		return true;
	}
}

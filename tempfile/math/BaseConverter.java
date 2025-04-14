package math;

import java.util.Scanner;

public class BaseConverter {

	public static void main(String[] args) {
		BaseConverter bc = new BaseConverter();
		
		Scanner scan = new Scanner(System.in);
		System.out.print(">> 숫자와 기수 입력 : ");
		int number = scan.nextInt();
		int base = scan.nextInt();
		
		String newNumStr = bc.convertBase(number, base);
		System.out.println(newNumStr);
	}
		
		
	public String convertBase(int number, int base) {
		// 진법별 자리수에 들어갈 digit character를 위한 자료구조 정의
		String digitChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
		// 변환된 digit을 저장하기 위한 자료구조 정의
		StringBuilder sb = new StringBuilder();
			
		do {
			sb.append(digitChar.charAt(number % base));
			number /= base;
		}while(number != 0);
			
		// 역순 정렬
		return sb.reverse().toString();
	}
}

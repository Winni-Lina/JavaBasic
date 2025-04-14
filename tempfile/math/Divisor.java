package math;

import java.util.Scanner;

public class Divisor {

	public static void main(String[] args) {
		Divisor d = new Divisor();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("공약수를 구할 숫자 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		
		int[] commonDivisors = d.getCommonDivisors(num1, num2);
		
		for(int i = 0; i < commonDivisors.length; i++) {
			if(commonDivisors[i] == -1) break;
			System.out.println(commonDivisors[i]);
		}
		
		System.out.println("최대공약수 : "+ d.getGCD(num1, num2));
	}

	public int getLCM(int M, int N) {
		//M을 작은 숫자로 만들기
		if(M>N) {
			int temp = M;
			M = N;
			N = temp;
		}
		
		for(int i =1; i < M; i++) {
			int candNo = N*i;
			if(candNo % M == 0 ) return candNo;
		}
		return M*N;
	}
	
	public int getGCD(int M, int N) {
		
		//M을 작은 숫자로 만들기
		if(M>N) {
			int temp = M;
			M = N;
			N = temp;
		}
		
		for(int candNo = M; candNo >= 2; candNo--) {
			if(M % candNo == 0 && N % candNo == 0)
				return candNo;
		}
		return 1;
		
	}
	
	public int[] getCommonDivisors(int M, int N) {
		// 작은 숫자(M)의 약수를 찾으면서,
		// 큰 숫자(N)의 약수인지 확인하여 공약수에 추가
		if(M>N) {
			int temp = M;
			M = N;
			N = temp;
		}
		
		int[] commonDivisors = new int[N+1];
		int numCD = 0;
		for( int candNo = 1; candNo <= M; candNo++) {
			if(M % candNo == 0 && N % candNo == 0) {
				commonDivisors[numCD++] = candNo;
			}
		}
		
		commonDivisors[numCD] = -1;
		return commonDivisors;
	}
	
	public int getDivisors(int number, int[] divisors) {
		int numDivisors = 0;
		
		for (int candNo = 1; candNo <= number; candNo++) {
			if(number % candNo == 0)
				divisors[numDivisors++] = candNo;
		}
		
		return numDivisors;
	}

	public int[] getDivisors(int number) {
		int[] divisors = new int[number+1];
		int numDivisors = 0;
		
		for (int candNo = 1; candNo <= number; candNo++) {
			if(number % candNo == 0)
				divisors[numDivisors++] = candNo;
		}
		divisors[numDivisors] = -1;
		return divisors;
	}
	
}

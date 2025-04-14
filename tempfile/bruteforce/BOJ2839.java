package bruteforce;

import java.util.Scanner;

public class BOJ2839 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int max5bag = N / 5;
		int max3bag = N / 3;
		int minBag = N;
		
		for (int bag5 = 0; bag5 <= max5bag; bag5++) {
			for (int bag3 = 0; bag3 <= max3bag; bag3++) {
				int sum = bag5 * 5 + bag3 * 3;
				int numBags = bag5 + bag3;
				if (sum == N && numBags < minBag) {
					minBag = numBags;
				}
			}
			
		}
		if(minBag == N) System.out.println(-1);
		else System.out.println(minBag);
	}

}

package bruteforce;

import java.util.Scanner;

public class BOJ2798 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] cards = new int[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = scan.nextInt();
		}
		
		
		int maxSum = 0;
		for(int card1 = 0; card1 < N - 2; card1++) {
			for (int card2 = card1 + 1; card2 < N - 1; card2++) {
				for(int card3 = card2 + 1; card3 < N; card3++) {
					int sum = cards[card1] + cards[card2] + cards[card3];
					if(sum <= M && sum > maxSum)
						maxSum = sum;
				}
			}
		}
		
		System.out.println(maxSum);
		
		
	}
}

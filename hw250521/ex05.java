package hw250521;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		
		int num;
		int max = 0;
		do {
			System.out.print("점수를 입력하세요 : ");
			num = scan.nextInt();
			if(num>=0) list.add(num);
			if(max < num) max = num;
		} while (num >= 0);
		
		System.out.println("전체 학생은 " + list.size() +"명이다.");
		System.out.print("학생들의 성적 ");
		for(int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
		System.out.println();
		
		for(int i = 0 ; i<list.size(); i++) {
			String grade = "";
			int score = list.get(i);
			
			if(score >= max - 10) grade = "A";
			else if (score >= max - 20) grade = "B";
			else grade = "C";
			
			System.out.printf("%d번 학생의 성적은 %d점이며 등급은 %s이다.\n", i, score, grade);
		}
		
		scan.close();
	}
}

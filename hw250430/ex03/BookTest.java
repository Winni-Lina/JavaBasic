package hw250430.ex03;

import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {

		Book[] books = {new Book(15000), new Book(50000), new Book(20000)};

		System.out.println("정렬 전");
		printBooks(books);
		
		Arrays.sort(books);

		System.out.println("정렬 후");
		printBooks(books);
		
	}
	
	public static void printBooks(Book[] bs) {

		for(Book b : bs) {
			System.out.println(b.toString());
		}
	}

}

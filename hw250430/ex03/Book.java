package hw250430.ex03;

public class Book implements Comparable {
	private int price;
	
	public int getPrice() {
		return price;
	}
	
	public Integer getPriceToInteger() {
		return price;
	}

	public Book(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [price=" + price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return ((Book)obj).getPriceToInteger().equals(getPriceToInteger());
	}
	
	@Override
	public int compareTo(Object o) {
		Book b = (Book) o;
		return getPriceToInteger().compareTo(b.getPriceToInteger());
	}
	
	
}

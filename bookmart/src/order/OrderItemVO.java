package order;

import java.io.Serializable;

public class OrderItemVO implements Serializable {
	private int bookNo;
	private int quantity;
	private int price;
	
	public OrderItemVO(int bookNo, int quantity, int price) {
		this.bookNo = bookNo;
		this.quantity = quantity;
		this.price = price;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\t***" + bookNo + ", " + quantity + "(권), " + price + "(원)";
	}
	
	
}

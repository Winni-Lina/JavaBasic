package order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderVO implements Serializable {

	private int orderNo;
	private String memberId;
	private List<OrderItemVO> orderItemList;
	private int price;
	private String mobile;
	private String address;
	private Date orderDate;
	private int status;
	private Date deliverDate;
	
	public OrderVO(String memberId, List<OrderItemVO> orderItemList, int price) {
		this.memberId = memberId;
		this.orderItemList = orderItemList;
		this.price = price;
	}
		
	public int getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public List<OrderItemVO> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemVO> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	@Override
	public String toString() {
		// 주문 정보
		StringBuilder orderInfo = new StringBuilder();
		orderInfo.append("[" + orderNo + ", " + memberId + ", " + price + "원");
		if (orderDate != null) {
			// 배송 정보
			orderInfo.append(", " + orderDate + ", " + status + ", " + deliverDate);
		}
		orderInfo.append("]\n");
		// 배송처 정보
		orderInfo.append("\t*** 배송처 : " + address + "(" + mobile + ")\n");
		// 주문한 도서들
		for (OrderItemVO item : orderItemList) {
			orderInfo.append(item).append("\n");
		}

		return orderInfo.toString();
	}
	
	
}

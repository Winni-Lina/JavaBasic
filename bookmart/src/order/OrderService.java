package order;

import java.util.List;

public interface OrderService {
	boolean orderItems(OrderVO order);
	List<OrderVO> listMyOrders(String memberId);
	List<OrderVO> listAllOrder();
}

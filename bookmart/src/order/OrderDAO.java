package order;

import java.util.List;

public interface OrderDAO {
	boolean insertOrder(OrderVO order);
	OrderVO selectBook(int orderNo);
	List<OrderVO> selectOrdersOfMember(String memberId);
	List<OrderVO> selectAllOrder();
}

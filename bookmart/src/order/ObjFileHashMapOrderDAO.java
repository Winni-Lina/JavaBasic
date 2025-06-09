package order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjFileHashMapOrderDAO implements OrderDAO {
	
	private Map<Integer, OrderVO> orderDB = new HashMap<>();
	private int orderSeq = 111;
	
	private final String DATA_FILE = "./data/orderDB.obj";
	
	public ObjFileHashMapOrderDAO() {
		loadOrders();
	}
	
	private void loadOrders() {
		try (
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE));
		) {
			
			orderDB = (Map<Integer, OrderVO>)ois.readObject();
			orderSeq = Collections.max(orderDB.keySet()) + 1;
				
		} catch (FileNotFoundException e) {
			System.out.println("[주문 정보 DB 로딩] " + DATA_FILE + "이 없습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
				
	}
	
	private void saveOrders() {
		try (
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE));
		) {
			oos.writeObject(orderDB);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertOrder(OrderVO order) {
		order.setOrderNo(orderSeq++);
		orderDB.put(order.getOrderNo(), order);
		saveOrders();
		return true;
	}

	@Override
	public OrderVO selectBook(int orderNo) {
		return orderDB.get(orderNo);
	}

	@Override
	public List<OrderVO> selectOrdersOfMember(String memberId) {
		List<OrderVO> orderList = new ArrayList<>();
		for (OrderVO order : selectAllOrder()) {
			if (order.getMemberId().equals(memberId))
				orderList.add(order);
		}
		return orderList;
	}

	@Override
	public List<OrderVO> selectAllOrder() {
		return new ArrayList<>(orderDB.values());
	}

}

package onlineshop.services.impl;

import onlineshop.enteties.Order;
import onlineshop.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	public static OrderManagementService getInstance() {
		if (instance == null)
			instance = new DefaultOrderManagementService();
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order[] getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	void clearServiceState() {

	}

}

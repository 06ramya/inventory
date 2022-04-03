package com.edu.SpringBootCustomerApp.Service;

import java.util.List;

import com.edu.SpringBootCustomerApp.Entity.Order;

public interface OrderService {
	Order saveOrder(Order order);

	List<Order> getAllOrder();

	Order getOrderById(long id);
    void deleteOrder(long id);

	Order updateOrder(Order order, long id);

	List<Order> getOrderByOrderNo(String orderNo);

	
}

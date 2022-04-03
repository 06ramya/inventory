package com.edu.SpringBootCustomerApp.ServiceImplementation;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


import com.edu.SpringBootCustomerApp.Entity.Order;
import com.edu.SpringBootCustomerApp.Exception.ResourceNotFoundException;
import com.edu.SpringBootCustomerApp.Repository.OrderRepository;
import com.edu.SpringBootCustomerApp.Service.OrderService;
@Service
public class OrderServiceImplementation implements OrderService{
	private OrderRepository orderRepository;
	public OrderServiceImplementation(OrderRepository orderRepository) {
		super();
		this.orderRepository=orderRepository;
	}
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	@Override
	public List<Order> getAllOrder(){
		return orderRepository.findAll();
	}
	@Override
	public Order getOrderById(long id) {
		Optional<Order>order=orderRepository.findById(id);
		if(order.isPresent()) {
			return order.get();
		}
		else {
			throw new ResourceNotFoundException("Order","orderId",id);
		}
	}
	
	@Override
	public Order updateOrder(Order order, long id) {
		Order od=new Order();
		try {
			od=orderRepository.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("Order","orderId",id));
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		//od.setOrderId(order.getOrderId());
		od.setOrderNo(order.getOrderNo());
		od.setDateOrder(order.getDateOrder());
		od.setQuantity(order.getQuantity());
		
		
		orderRepository.save(od);
		return od;
	}
	
	
	
	@Override
	public void deleteOrder(long id)
	{
		orderRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Order","orderId",id));
		orderRepository.deleteById(id);
	}
	@Override
	public List<Order> getOrderByOrderNo(String orderNo) {
		
		return orderRepository.getOrderByOrderNo(orderNo);
	}
	
}



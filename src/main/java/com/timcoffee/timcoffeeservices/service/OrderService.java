package com.timcoffee.timcoffeeservices.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.timcoffee.timcoffeeservices.entity.Order;
import com.timcoffee.timcoffeeservices.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  public Order addOrder(Order order) {
    if (order.getPickupDate() == null && order.getOrderDate() == null) {
      order.setOrderDate(new Timestamp(System.currentTimeMillis()));
      order.setPickupDate(new Timestamp(System.currentTimeMillis()));
    }
    order.setStatus((short) 0);
    return orderRepository.save(order);
  }

  public List<Order> getAllOrderQueue() {
    return orderRepository.findAllOrderQueue();
  }

  public List<Order> getAllOrderByPhoneNumber(String phoneNumber) {
    return orderRepository.findAllOrderByPhoneNumber(phoneNumber);
  }

  public int getTotalOrderToday() {
    Date date = new Date();  
    Timestamp start = new Timestamp(date.getTime());  
    Timestamp end = new Timestamp(date.getTime() + 1 * 24 * 60 * 60 * 1000 );
    List<Order> order = orderRepository.getTotalOrderToday(start, end);
    return order.size();
  }

  public Order updateOrderStatusById(int id, Short status) {
    Order order = orderRepository.findById(id).get();
    order.setId(id);
    order.setStatus(status);
    return orderRepository.save(order);
  }
  
}

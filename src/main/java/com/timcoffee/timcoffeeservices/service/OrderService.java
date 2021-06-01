package com.timcoffee.timcoffeeservices.service;

import com.timcoffee.timcoffeeservices.entity.Order;
import com.timcoffee.timcoffeeservices.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  public void addOrder(Order order) {
    orderRepository.save(order);
  }

  
}

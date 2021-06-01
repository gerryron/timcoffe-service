package com.timcoffee.timcoffeeservices.controller;

import com.timcoffee.timcoffeeservices.entity.Order;
import com.timcoffee.timcoffeeservices.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
  
  @Autowired
  private OrderService orderService;

  @PostMapping("/add")
  public void addOrder(@RequestBody Order order) {
    orderService.addOrder(order);
  }

}

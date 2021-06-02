package com.timcoffee.timcoffeeservices.controller;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.timcoffee.timcoffeeservices.entity.Order;
import com.timcoffee.timcoffeeservices.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
  
  @Autowired
  private OrderService orderService;

  @PostMapping("/add")
  public Order addOrder(@RequestBody Order order) {
    return orderService.addOrder(order);
  }

  @GetMapping("/getAllOrderQueue")
  public List<Order> getAllOrderQueue() {
    return orderService.getAllOrderQueue();
  }

  @GetMapping("/getOrderQueue/{phoneNumber}")
  public List<Order> getAllOrderByPhoneNumber(@PathVariable String phoneNumber) {
    return orderService.getAllOrderByPhoneNumber(phoneNumber);
  }

  @GetMapping("/getTotalOrderToday")
  public int getTotalOrderToday() {
    return orderService.getTotalOrderToday();
  }

  @PutMapping("/updateStatus/{id}")
  public Order updateOrder(@PathVariable int id, @RequestBody ObjectNode objectNode) {
    Short status = Short.valueOf(objectNode.get("status").asText());
    return orderService.updateOrderStatusById(id, status);
  }

}

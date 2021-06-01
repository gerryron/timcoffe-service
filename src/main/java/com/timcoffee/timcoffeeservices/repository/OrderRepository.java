package com.timcoffee.timcoffeeservices.repository;

import com.timcoffee.timcoffeeservices.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{
  
}

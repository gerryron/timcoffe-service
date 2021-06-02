package com.timcoffee.timcoffeeservices.repository;

import java.util.List;

import com.timcoffee.timcoffeeservices.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer>{

  @Query("from com.timcoffee.timcoffeeservices.entity.Order o WHERE o.status = '1'")
  public List<Order> findAllOrderQueue();
  
}

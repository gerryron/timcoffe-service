package com.timcoffee.timcoffeeservices.repository;

import java.sql.Timestamp;
import java.util.List;

import com.timcoffee.timcoffeeservices.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer>{

  @Query("from com.timcoffee.timcoffeeservices.entity.Order o WHERE o.status = '0' OR o.status = '1' ORDER BY o.status")
  public List<Order> findAllOrderQueue();

  @Query("from com.timcoffee.timcoffeeservices.entity.Order o WHERE o.nomerHp = :phoneNumber")
  public List<Order> findAllOrderByPhoneNumber(@Param("phoneNumber") String phoneNumber);

  @Query("from com.timcoffee.timcoffeeservices.entity.Order o WHERE o.orderDate >= :start and o.orderDate <= :end")
  public List<Order> getTotalOrderToday(@Param("start") Timestamp start, @Param("end") Timestamp end);
  
}

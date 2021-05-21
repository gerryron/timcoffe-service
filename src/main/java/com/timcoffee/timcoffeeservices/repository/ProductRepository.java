package com.timcoffee.timcoffeeservices.repository;

import com.timcoffee.timcoffeeservices.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  
}

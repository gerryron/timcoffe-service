package com.timcoffee.timcoffeeservices.repository;

import com.timcoffee.timcoffeeservices.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  public User findUserByUsername(String username);
  
}

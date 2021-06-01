package com.timcoffee.timcoffeeservices.repository;

import javax.websocket.server.PathParam;

import com.timcoffee.timcoffeeservices.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT u FROM User u WHERE u.nomerHp = :code OR u.email = :code")
  public User findUserByNomerHpOrEmail(@PathParam("code") String code);
  
}

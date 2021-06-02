package com.timcoffee.timcoffeeservices.repository;

import com.timcoffee.timcoffeeservices.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("FROM com.timcoffee.timcoffeeservices.entity.User u WHERE u.nomerHp = :code OR u.email = :code")
  public User findUserByNomerHpOrEmail(@Param("code") String code);
  
}

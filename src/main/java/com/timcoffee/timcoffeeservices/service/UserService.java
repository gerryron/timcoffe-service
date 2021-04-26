package com.timcoffee.timcoffeeservices.service;

import com.timcoffee.timcoffeeservices.entity.User;
import com.timcoffee.timcoffeeservices.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public User saveUser(User user) {
    return userRepository.save(user);
  }
}

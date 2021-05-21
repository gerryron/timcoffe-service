package com.timcoffee.timcoffeeservices.controller;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.timcoffee.timcoffeeservices.entity.User;
import com.timcoffee.timcoffeeservices.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  
  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestBody ObjectNode objectNode) {
    String username = objectNode.get("username").asText();
    String password = objectNode.get("password").asText();
    return userService.login(username, password);
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody User user) {
    return userService.register(user);
  }

  @GetMapping("/getAllUsers")
  public ResponseEntity<List<User>> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/find/username/{username}")
  public ResponseEntity<User> getUser(@PathVariable String username) {
    return userService.findUserByUsername(username);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
    return userService.updateUser(id, user);
  }

  @DeleteMapping("delete/{id}")
  public void deleteUser(@PathVariable int id) {
    userService.deleteUser(id);
  }

}

package com.timcoffee.timcoffeeservices.service;

import java.util.List;

import com.timcoffee.timcoffeeservices.entity.User;
import com.timcoffee.timcoffeeservices.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  
  @Autowired
  private UserRepository userRepository;

  public ResponseEntity<User> login (String username, String password) {
    User user = userRepository.findUserByUsername(username);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(null);
    }

    boolean isValidPassoword = passwordEncoder.matches(password, user.getPassword());
    if (!isValidPassoword){
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(null);
    }

    return ResponseEntity.status(HttpStatus.OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(user);

  }

  public ResponseEntity<User> register(User user) {
    try {
      String encodedPassword = this.passwordEncoder.encode(user.getPassword());
      user.setPassword(encodedPassword);
      User response = userRepository.save(user);
      return ResponseEntity.status(HttpStatus.CREATED)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(response);
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(null);
    }
  }

  public ResponseEntity<List<User>> getAllUsers() {
    List<User> response = userRepository.findAll();
    HttpStatus status = response.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    return ResponseEntity.status(status)
                          .contentType(MediaType.APPLICATION_JSON)
                          .body(response);
  }

  public ResponseEntity<User> findUserByUsername(String username) {
    User user = userRepository.findUserByUsername(username);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(null);
    }

    return ResponseEntity.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(user);
  }

  public ResponseEntity<User> updateUser(int id, User user) {
    user.setId(id);
    return register(user);
  }

  public void deleteUser(int id) {
    userRepository.deleteById(id);
  }

}

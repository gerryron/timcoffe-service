package com.timcoffee.timcoffeeservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  @Column(unique = true, length = 50, nullable = false)
  private String nomerHp;
  @Column(unique = true, length = 100, nullable = false)
  private String email;
  private String name;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private String role;

}

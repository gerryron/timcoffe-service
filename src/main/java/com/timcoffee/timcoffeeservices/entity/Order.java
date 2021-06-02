package com.timcoffee.timcoffeeservices.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nama;
  private String nomerHp;
  private Short status;
  private Timestamp orderDate;
  private Timestamp pickupDate;
  private String note;
  @OneToMany(
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  @JoinColumn(name = "order_id")
  private List<OrderDetail> orderDetails;
  
}

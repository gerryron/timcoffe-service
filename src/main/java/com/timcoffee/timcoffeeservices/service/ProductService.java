package com.timcoffee.timcoffeeservices.service;

import java.util.List;
import java.util.Optional;

import com.timcoffee.timcoffeeservices.entity.Product;
import com.timcoffee.timcoffeeservices.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  
  @Autowired
  private ProductRepository productRepository;

  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  public List<Product> getAllProduct() {
    return productRepository.findAll();
  }

  public ResponseEntity<Product> findProductById(int id) {
    Optional<Product> product = productRepository.findById(id);
    if (!product.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(null);
    }

    return ResponseEntity.status(HttpStatus.OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(product.get());
  }

  public Product updateProduct(int id, Product product) {
    product.setId(id);
    return productRepository.save(product);
  }

  public void deleteProduct(int id) {
    productRepository.deleteById(id);
  }

}

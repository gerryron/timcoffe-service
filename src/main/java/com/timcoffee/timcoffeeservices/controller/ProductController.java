package com.timcoffee.timcoffeeservices.controller;

import java.util.List;

import com.timcoffee.timcoffeeservices.entity.Product;
import com.timcoffee.timcoffeeservices.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @PostMapping("/add")
  public Product ControlleraddProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }
  
  @GetMapping("/getAllProduct")
  public List<Product> getProducts() {
    return productService.getAllProduct();
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Product> findProductById(@PathVariable int id) {
    return productService.findProductById(id);
  }

  @PutMapping("/update/{id}")
  public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
    return productService.updateProduct(id, product);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteProduct(@PathVariable int id) {
    productService.deleteProduct(id);
  }
}

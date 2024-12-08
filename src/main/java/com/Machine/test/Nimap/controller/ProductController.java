package com.Machine.test.Nimap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Machine.test.Nimap.model.Product;
import com.Machine.test.Nimap.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {
      @Autowired
      private ProductService productService;
      
      @GetMapping
      public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
          return productService.getAllProducts(page, size);
      }
      
      @PostMapping
      public Product createProduct(@RequestBody Product product) {
          return productService.createProduct(product);
      }
      
      @GetMapping("/{id}")
      public ResponseEntity<Product> getProductById(@PathVariable Long id) {
          return productService.getProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
      }
      @PutMapping("/{id}")
      public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
          return ResponseEntity.ok(productService.updateProduct(id, productDetails));
      }
      
      @DeleteMapping("/{id}")
      public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
          productService.deleteProduct(id);
          return ResponseEntity.noContent().build();
      }
}

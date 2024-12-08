package com.Machine.test.Nimap.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.Machine.test.Nimap.model.Product;
import com.Machine.test.Nimap.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getAllProducts(int page, int size) {
		return productRepository.findAll(PageRequest.of(page, size));
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	 public Optional<Product> getProductById(Long id) {
	        return productRepository.findById(id);
	    }
	 public Product updateProduct(Long id, Product productDetails) {
	        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	        product.setProductname(productDetails.getProductname());
	        product.setPrice(productDetails.getPrice());
	        product.setCategory(productDetails.getCategory());
	        return productRepository.save(product);
	    }

	public void deleteProduct(Long id) {
		 productRepository.deleteById(id);
	}
}

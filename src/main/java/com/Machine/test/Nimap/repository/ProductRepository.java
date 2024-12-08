package com.Machine.test.Nimap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Machine.test.Nimap.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value="select * from Product",nativeQuery = true)
	List<Product> getallproduct();
	
	@Query (value="select * from   Product where id = ?1",nativeQuery = true)
	void getProductById(Long id);
	
	@Query (value="update from  Product where id = ?1",nativeQuery = true)
	void updateProduct(Long id);
	
	@Modifying
	@Query (value="delete from  Product where id = ?1",nativeQuery = true)
	void deleteProduct(Long id);
}

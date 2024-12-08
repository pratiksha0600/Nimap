package com.Machine.test.Nimap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Machine.test.Nimap.model.Category;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query(value="select * from Cateory",nativeQuery = true)
	List<Category> getallCategories();
	
	@Query (value="select * from  Category where id = ?1",nativeQuery = true)
	void getCategoryById(Long id);
	
	@Query (value="update from  Category where id = ?1",nativeQuery = true)
	void updateCategory(Long id);
	
	@Modifying
	@Query (value="delete from  Category where id = ?1",nativeQuery = true)
	void deleteCategory(Long id);

}

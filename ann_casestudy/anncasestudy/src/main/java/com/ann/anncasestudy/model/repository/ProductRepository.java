package com.ann.anncasestudy.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ann.anncasestudy.dbmodel.Products;






/*
* This class is implementing the JpaRepository interface for User.
* Annotate this class with @Repository annotation
* */
@Repository
public interface ProductRepository extends JpaRepository<Products, String> {

/*
	* Apart from the standard CRUD methods already available in JPA Repository, based
	* on our requirements, we might need to create few query methods for getting 
	* specific data from the database. 
	* */
	
	/*
	* This method will validate a user from database by username and password. 
    */
	@Query("select p from Products p")
    List<Products> findAll();
	@Query("select p from Products p where p.product_id = (?1) ")
    Products findByProductId(Integer product_id);
	Products save(Products prod);
//	void delete(Products prod);
}

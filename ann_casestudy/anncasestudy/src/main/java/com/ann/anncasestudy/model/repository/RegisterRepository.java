package com.ann.anncasestudy.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ann.anncasestudy.dbmodel.Customers;






/*
* This class is implementing the JpaRepository interface for User.
* Annotate this class with @Repository annotation
* */
@Repository
public interface RegisterRepository extends JpaRepository<Customers, String> {

/*
	* Apart from the standard CRUD methods already available in JPA Repository, based
	* on our requirements, we might need to create few query methods for getting 
	* specific data from the database. 
	* */
	
	/*
	* This method will validate a user from database by username and password. 
    */

	@Query("select c from Customers c where c.customer_id = (?1) ")
    Customers findByCustomerId(Integer customer_id);
	@Query("select c from Customers c where c.email = (?1) ")
	 Customers findByCustomerEmail(String email);
	Customers save(Customers cust);
//	void delete(Products prod);
}

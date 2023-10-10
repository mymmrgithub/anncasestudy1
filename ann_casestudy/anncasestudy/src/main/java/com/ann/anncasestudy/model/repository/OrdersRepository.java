package com.ann.anncasestudy.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ann.anncasestudy.dbmodel.Orders;






/*
* This class is implementing the JpaRepository interface for User.
* Annotate this class with @Repository annotation
* */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {

/*
	* Apart from the standard CRUD methods already available in JPA Repository, based
	* on our requirements, we might need to create few query methods for getting 
	* specific data from the database. 
	* */
	
	/*
	* This method will validate a user from database by username and password. 
    */
//	@Query("select o.*,p.*,c.* from Orders p,Products p,Customers c where o.product_id=p.product_id and o.customer_id=c.customer_id")
//    List<Orders> findAll();
	@Query("select o from Orders o where o.order_id = (?1)")
    Orders findOrderbyId(Integer order_id);
//	@Query("select o.*,p.*,c.* from Orders p,Products p,Customers c where o.product_id=p.product_id and o.customer_id=c.customer_id and o.customer_id = (?1)")
//    List<Orders> findAllOrdersByCustomerId(Integer customer_id);
//	@Query("select o.*,p.*,c.* from Orders p,Products p,Customers c where o.product_id=p.product_id and o.customer_id=c.customer_id and o.product_id = (?1)")
//    List<Orders> findAllOrdersByproductId(Integer product_id);
	Orders save(Orders order);

	
	
}

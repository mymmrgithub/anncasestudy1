package com.ann.anncasestudy.services;

import com.ann.anncasestudy.dbmodel.Orders;


public interface OrdersService {
	
	
//    List<Orders> findAll();
    Orders findOrderbyId(Integer order_id);
//    List<Orders> findAllOrdersByCustomerId(Integer customer_id);
//    List<Orders> findAllOrdersByproductId(Integer product_id);
    Orders createOrder(Orders ord);
    Orders updateOrder(Orders ord);
    
}

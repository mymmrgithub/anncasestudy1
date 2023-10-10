package com.ann.anncasestudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ann.anncasestudy.dbmodel.Orders;
import com.ann.anncasestudy.model.repository.OrdersRepository;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */

@Service
public class OrdersServiceImpl implements OrdersService {

	/*
	 * Autowiring should be implemented for the MusicRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	public OrdersServiceImpl(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}

//	 public List<Orders> findAll(){
//		return ordersRepository.findAll();
//		 
//	 }
	public Orders findOrderbyId(Integer order_id) {
		return this.ordersRepository.findOrderbyId(order_id);

	}

//	    public List<Orders> findAllOrdersByCustomerId(Integer customer_id){
//			return ordersRepository.findAllOrdersByCustomerId(customer_id);
//	    	
//	    }
//	    public List<Orders> findAllOrdersByproductId(Integer product_id){
//			return ordersRepository.findAllOrdersByproductId(product_id);
//	    	
//	    }

	@Override
	public Orders createOrder(Orders ord) {
		// TODO Auto-generated method stub
		return this.ordersRepository.save(ord);
	}

	@Override
	public Orders updateOrder(Orders ord) {
		// TODO Auto-generated method stub
		return this.ordersRepository.save(ord);
	}

}

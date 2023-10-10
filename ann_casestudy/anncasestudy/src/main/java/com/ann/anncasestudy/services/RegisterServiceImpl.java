package com.ann.anncasestudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ann.anncasestudy.dbmodel.Customers;
import com.ann.anncasestudy.model.repository.RegisterRepository;

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
public class RegisterServiceImpl implements RegisterService {

	/*
	 * Autowiring should be implemented for the MusicRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	@Autowired
	private RegisterRepository registerRepository;
	@Autowired
	public RegisterServiceImpl(RegisterRepository registerRepository) {
		this.registerRepository = registerRepository;
	}
	@Override
	public Customers findByCustomerId(Integer cusotmerId) {
		// TODO Auto-generated method stub
		return registerRepository.findByCustomerId(cusotmerId);
	}
	@Override
	public Customers Register(Customers cust) {
		// TODO Auto-generated method stub
		return registerRepository.save(cust);
	}
	@Override
	public Customers update(Customers cust) {
		// TODO Auto-generated method stub
		return registerRepository.save(cust);
	}
	@Override
	public Customers findByCustomerEmail(String email) {
		// TODO Auto-generated method stub
		return registerRepository.findByCustomerEmail(email);
	}


	
	
	

}

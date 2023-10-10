package com.ann.anncasestudy.services;

import com.ann.anncasestudy.dbmodel.Customers;


public interface RegisterService {
	
	
 
    Customers findByCustomerId(Integer cusotmerId);
    Customers findByCustomerEmail(String email);
    Customers Register(Customers cust);
    Customers update(Customers cust);
    // void deleteProduct(Products prod);
    
}

package com.ann.anncasestudy.services;

import java.util.List;

import com.ann.anncasestudy.dbmodel.Products;


public interface ProductService {
	
	
    List<Products> getAllProducts(Integer prodType);
    Products findByProductId(Integer prodId);
    Products addProduct(Products prod);
     Products modProduct(Products prod);
    // void deleteProduct(Products prod);
    
}

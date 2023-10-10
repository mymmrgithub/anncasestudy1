package com.ann.anncasestudy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ann.anncasestudy.dbmodel.Products;
import com.ann.anncasestudy.model.repository.ProductRepository;

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
public class ProductServiceImpl implements ProductService {

	/*
	 * Autowiring should be implemented for the MusicRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/*
	 * This method should be used to save a new Music.Call the corresponding method
	 * of Respository interface.
	 */
	public List<Products> getAllProducts(Integer prodId) {
		List<Products> prodLst = this.productRepository.findAll();

		return prodLst;
	}

	public Products findByProductId(Integer product_id) {
		Products prod = this.productRepository.findByProductId(product_id);

		return prod;
	}

	@Override
	public Products addProduct(Products prod) {
		// TODO Auto-generated method stub
		return this.productRepository.save(prod);
	}

	@Override
	public Products modProduct(Products prod) {
		// TODO Auto-generated method stub
		return this.productRepository.save(prod);
	}
//	@Override
//	public void deleteProduct(Products prod) {
//		// TODO Auto-generated method stub
//		this.productRepository.delete(prod);
//	}

}

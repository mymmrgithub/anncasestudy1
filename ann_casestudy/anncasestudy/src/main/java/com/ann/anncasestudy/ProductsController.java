package com.ann.anncasestudy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ann.anncasestudy.dbmodel.Products;
import com.ann.anncasestudy.dto.ProductsDto;
import com.ann.anncasestudy.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProductsController {

	@Autowired
	ProductService productService;

	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("products/{prodType}")
	public ResponseEntity<List<ProductsDto>> getAllProducts(@PathVariable("prodType") Integer prodType) {

		List<Products> prodList = this.productService.getAllProducts(prodType);
		List<ProductsDto> prdDtoLst = null;
		if (prodList != null) {
			prdDtoLst = new ArrayList<ProductsDto>();
			for (Products prd : prodList) {
				ProductsDto pdto = prepareProductDto(prd);
				prdDtoLst.add(pdto);
			}
			return new ResponseEntity<List<ProductsDto>>(prdDtoLst, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("products/id/{prodId}")
	public ResponseEntity<List<ProductsDto>> getProduct(@PathVariable("prodId") Integer prodId) {
		Products prod = this.productService.findByProductId(prodId);
		List<ProductsDto> prodList = null;
		if (prod != null) {
			prodList = new ArrayList<ProductsDto>();
			prodList.add(prepareProductDto(prod));
			return new ResponseEntity<List<ProductsDto>>(prodList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("products/add")
	public ResponseEntity<ProductsDto> addProduct(@RequestBody Products prod) {
		Products newprod = this.productService.addProduct(prod);
		if (newprod != null) {
			return new ResponseEntity<ProductsDto>(prepareProductDto(newprod), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping("products/Modify")
	private ResponseEntity<ProductsDto> Modify(@RequestBody Products prod) {
		Products modprod = this.productService.modProduct(prod);
		return new ResponseEntity<ProductsDto>(prepareProductDto(modprod), HttpStatus.OK);
	}

	private ProductsDto prepareProductDto(Products prod) {

		ProductsDto pdto = null;

		if (prod != null) {
			pdto = new ProductsDto();
			pdto.setProduct_id(prod.getProduct_id());
			pdto.setProduct_desc(prod.getProduct_desc());
			pdto.setProduct_name(prod.getProduct_name());
			pdto.setAvailable_qty(prod.getAvailable_qty());
			pdto.setProduct_type(prod.getProduct_type());
			pdto.setProduct_img(null);// get it from S3 Bucket
			pdto.setUnits(prod.getUnits());
			pdto.setPrice_per_units(prod.getPrice_per_units());

		}

		return pdto;

	}

}

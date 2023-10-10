package com.ann.anncasestudy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ann.anncasestudy.dbmodel.Customers;
import com.ann.anncasestudy.dbmodel.Orders;
import com.ann.anncasestudy.dbmodel.Products;
import com.ann.anncasestudy.dto.OrdersDto;
import com.ann.anncasestudy.dto.ProductsDto;
import com.ann.anncasestudy.services.OrdersService;
import com.ann.anncasestudy.services.ProductService;
import com.ann.anncasestudy.services.RegisterService;
import com.ann.anncasestudy.util.AnnCustomerSession;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class OrdersController {

	@Autowired
	OrdersService ordersService;

	@Autowired
	ProductService productService;
	@Autowired
	RegisterService registerService;

	@Autowired
	public OrdersController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	private Products prepareProducts(ProductsDto proddto) {
		Products prdEnt = new Products();
		prdEnt.setProduct_id(proddto.getProduct_id());
		return prdEnt;

	}

	@PostMapping("order/create/customer/id/{custId}")
	public ResponseEntity<List<ProductsDto>> create(@PathVariable("custId") Integer custId,
			@RequestBody OrdersDto ordersDto, HttpServletRequest request) {

		AnnCustomerSession annCustomerSession = new AnnCustomerSession();
		if (!annCustomerSession.getSession(request, custId + "")) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

		if (ordersDto != null) {
			AnnCustomerSession annCustomerSession1 = new AnnCustomerSession();
			if (!annCustomerSession1.getSession(request, ordersDto.getCustomers().getCustomer_id() + "")) {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
			List<ProductsDto> prodLst = ordersDto.getProducts();// all ordered prods of customer
			List<Orders> ordLst = new ArrayList<Orders>();

			for (ProductsDto prd : prodLst) {
				Products prdEnt = prepareProducts(prd);
				Orders ord = new Orders();
				ord.setProducts(prdEnt);
				ord.setOrder_date(new java.sql.Date(System.currentTimeMillis()));
				ord.setOrder_qty(prd.getOrder_qty());
				ord.setCustomers(ordersDto.getCustomers());
//				ord.setCustomer_id(ordersDto.getCustomers().getCustomer_id());
//				ord.setProduct_id(prd.getProduct_id());
				ord.setOrder_status(1);
				Orders ordCreated = ordersService.createOrder(ord);
				ord.setOrder_id(ordCreated.getOrder_id());
				// ord.set
				prd.setOrder_id(ordCreated.getOrder_id());
				ordLst.add(ord);
			}
			return new ResponseEntity<List<ProductsDto>>(prodLst, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("orders/dispatch/id/{ordId}/refnum/{refNum}/fgfg")
	public ResponseEntity<String> dispatch2(@PathVariable("ordId") Integer ordId, @PathVariable("refNum") String refNum,
			HttpServletRequest request) {

		Orders ords = this.ordersService.findOrderbyId(ordId);
		if (ords == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		Products prod = ords.getProducts();
		if ((prod.getAvailable_qty() - ords.getOrder_qty()) >= 0) {
			prod.setAvailable_qty(prod.getAvailable_qty() - ords.getOrder_qty());
			// productService.modProduct(prod);
			// Orders ord = this.ordersService.updateOrder(ords);

			return new ResponseEntity<String>("Dispathced Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Insuficient Stock to dispath, and could not Dispatch",
					HttpStatus.FORBIDDEN);

		}
	}

	@PostMapping("orders/dispatch/id/{ordId}/refnum/{refNum}")
	public ResponseEntity<String> dispatch(@PathVariable("ordId") Integer ordId, @PathVariable("refNum") String refNum,
			HttpServletRequest request) {
		AnnCustomerSession annCustomerSession1 = new AnnCustomerSession();
		Integer loggedinUser = -1;
		try {
			loggedinUser = Integer.parseInt(annCustomerSession1.getLoggedUser(request));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Customers loggedinUserAdmin = this.registerService.findByCustomerId(loggedinUser);
		if (loggedinUserAdmin.getAdmin_role() == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

		if (loggedinUserAdmin.getAdmin_role() == 1) {
			// admin role
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		Orders ords = this.ordersService.findOrderbyId(ordId);
		if (ords == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		if (ords.getOrder_status() == 1) {
			ords.setOrder_status(2);
			ords.setReference_no(refNum);
			ords.setDispatch_date(new java.sql.Date(System.currentTimeMillis()));
		} else {
			return new ResponseEntity<String>("Order already Dispatched", HttpStatus.FORBIDDEN);
		}

		Products prod = ords.getProducts();
		if ((prod.getAvailable_qty() - ords.getOrder_qty()) >= 0) {
			prod.setAvailable_qty(prod.getAvailable_qty() - ords.getOrder_qty());
//		productService.modProduct(prod);
//		Orders ord  = this.ordersService.updateOrder(ords);

			return new ResponseEntity<String>("Dispathced Successfully1", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Insuficient1 Stock to dispath, and could not Dispatch",
					HttpStatus.FORBIDDEN);

		}

	}

	@PostMapping("orders/id/{ordId}")
	public ResponseEntity<Orders> getOrder(@PathVariable("ordId") Integer ordId) {
		Orders ords = this.ordersService.findOrderbyId(ordId);
		if (ords != null) {
			return new ResponseEntity<Orders>(ords, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}


}

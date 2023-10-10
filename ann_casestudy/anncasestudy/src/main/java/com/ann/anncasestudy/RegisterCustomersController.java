package com.ann.anncasestudy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ann.anncasestudy.dbmodel.Customers;
import com.ann.anncasestudy.services.RegisterService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class RegisterCustomersController {
	@Autowired
	RegisterService registerService;

	@PostMapping("/auth/login")
	public ResponseEntity<Customers> authorize(@RequestBody Customers cust, HttpServletRequest request) {
		Customers dbcust = this.registerService.findByCustomerId(cust.getCustomer_id());

		if (cust != null && dbcust != null) {
			if (dbcust.getCustomer_id().equals(cust.getCustomer_id())
					&& cust.getPassword().equals(dbcust.getPassword())) {
				List<String> login_session = (List<String>) request.getSession().getAttribute("LOGIN_SESSION");
				if (login_session == null) {
					login_session = new ArrayList<>();
					// if notes object is not present in session, set notes in the request session
					login_session.add(cust.getCustomer_id().toString());
					request.getSession().setAttribute("LOGIN_SESSION", login_session);
				} else {
					request.getSession().invalidate();

					return new ResponseEntity<Customers>(cust, HttpStatus.CONFLICT);
				}
				return new ResponseEntity<Customers>(cust, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/customer/Register")
	public ResponseEntity<Customers> Register(@RequestBody Customers cust) {
		Customers existing = this.registerService.findByCustomerEmail(cust.getEmail());
		if (existing == null) {
			this.registerService.Register(cust);
			return new ResponseEntity<Customers>(cust, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<Customers>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/customer/update")
	public ResponseEntity<Customers> update(@RequestBody Customers cust) {
		Customers existing = this.registerService.findByCustomerEmail(cust.getEmail());
		if (existing != null) {
			this.registerService.update(cust);
			return new ResponseEntity<Customers>(cust, HttpStatus.FOUND);
		}

		else {
			return new ResponseEntity<Customers>(cust, HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/customer/logout")
	public String destroySession(HttpServletRequest request) {
		// invalidate the session , this will clear the data from configured database
		
		request.getSession().invalidate();
		return "redirect:/home";
	}
}

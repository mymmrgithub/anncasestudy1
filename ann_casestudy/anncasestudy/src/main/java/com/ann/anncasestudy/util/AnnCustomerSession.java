package com.ann.anncasestudy.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;

public class AnnCustomerSession {

	public boolean getSession(HttpServletRequest request, String custId) {

		// List<OrderDto> ordDtoLst= null;
		List<String> login_session = (List<String>) request.getSession().getAttribute("LOGIN_SESSION");
		if (login_session != null) {
			if (!login_session.contains(custId + "")) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

	public String getLoggedUser(HttpServletRequest request) {

		// List<OrderDto> ordDtoLst= null;
		List<String> login_session = (List<String>) request.getSession().getAttribute("LOGIN_SESSION");
		if (login_session != null) {
			return login_session.get(0);

		} else {
			return null;
		}

	}

}

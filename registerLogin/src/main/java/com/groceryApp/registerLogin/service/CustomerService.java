package com.groceryApp.registerLogin.service;

import java.util.List;

import com.groceryApp.registerLogin.DTO.LoginDTO;
import com.groceryApp.registerLogin.DTO.customerDTO;

import com.groceryApp.registerLogin.model.Customer;
import com.groceryApp.registerLogin.response.LoginResponse;

public interface CustomerService {

	String addCustomer(customerDTO customerDTO);
	List<Customer> getAllCustomers();
	Customer getCustomerById(Long id);
	LoginResponse loginCustomer(LoginDTO loginDTO);
	}
	
	
	


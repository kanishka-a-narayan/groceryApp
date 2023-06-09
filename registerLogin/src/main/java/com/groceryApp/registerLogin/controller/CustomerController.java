package com.groceryApp.registerLogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceryApp.registerLogin.DTO.LoginDTO;
import com.groceryApp.registerLogin.DTO.customerDTO;
import com.groceryApp.registerLogin.model.Customer;
import com.groceryApp.registerLogin.response.LoginResponse;
import com.groceryApp.registerLogin.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("groceryApp/customer")



public class CustomerController {
	@Autowired
    private CustomerService customerService;
	@PostMapping(path="/save")
	public String saveCustomer(@RequestBody customerDTO customerDTO)
	{
		String id=customerService.addCustomer(customerDTO);
		return id;
	}
	@GetMapping(path="/infocustomer")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> customers=customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id)
	{
		Customer customer=customerService.getCustomerById(id);
		if(customer!=null)
		{
			return ResponseEntity.ok(customer);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> loginCustomer(@RequestBody LoginDTO loginDTO)
	{
		LoginResponse loginResponse=CustomerService.loginCustomer(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}

}

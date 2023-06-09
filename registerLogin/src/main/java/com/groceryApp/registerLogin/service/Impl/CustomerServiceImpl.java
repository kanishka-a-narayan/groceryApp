package com.groceryApp.registerLogin.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.groceryApp.registerLogin.DTO.LoginDTO;
import com.groceryApp.registerLogin.DTO.customerDTO;
import com.groceryApp.registerLogin.model.Customer;
import com.groceryApp.registerLogin.repository.CustomerRepo;
import com.groceryApp.registerLogin.response.LoginResponse;
import com.groceryApp.registerLogin.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepo customerRepo;
	

	@Override
	public String addCustomer(customerDTO customerDTO) {
		Customer customer=new Customer(
				customerDTO.getId(),
				customerDTO.getFirstName(),
				customerDTO.getLastName(),
				customerDTO.getEmail(),
			    customerDTO.getPassword(),
			    customerDTO.getAdddress()

				);
				
				
		customerRepo.save(customer);
		return customer.getFirstName();
	}


	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	
	@Override
	public Customer getCustomerById(Long id) {
		return customerRepo.findById(id).orElse(null);
	}


//	@Override
	public LoginResponse loginCustomer(LoginDTO loginDTO) {
		Customer customer=CustomerRepo.findByEmail(loginDTO.getEmail());
		if(customer!=null)
		{
			String password=loginDTO.getPassword();
			String password2=customer.getPassword();
			Boolean isPwdRight=password.equals(password2);
			if(isPwdRight)
			{
				Optional<Customer> customer1=CustomerRepo.findOneByEmailAndPassword(loginDTO.getEmail(),password2);
				if(customer1.isPresent()) {
					return new LoginResponse("Login Successful",true);
				}else {
						return new LoginResponse("Login Failed",false);
					}}
			else {
						return new LoginResponse("Password doesn't match",false);
				}
			}else 
			{
				return new LoginResponse("Email doesn't exist", false);
		}
	}

	
		
	}



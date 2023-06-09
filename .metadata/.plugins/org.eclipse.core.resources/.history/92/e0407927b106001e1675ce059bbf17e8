package com.groceryApp.registerLogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.groceryApp.registerLogin.model.Customer;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>
{
    Optional<Customer> findOneByEmailAndPassword(String email,String password);
	Customer findByEmail(String email);
	
	}

	



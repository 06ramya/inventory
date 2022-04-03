package com.edu.SpringBootCustomerApp.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.edu.SpringBootCustomerApp.Entity.Customer;
import com.edu.SpringBootCustomerApp.Entity.User;
import com.edu.SpringBootCustomerApp.Repository.CustomerRepository;
import com.edu.SpringBootCustomerApp.Repository.UserRepository;
import com.edu.SpringBootCustomerApp.Service.CustomerService;

@Service
public class MyUserDetailsService implements UserDetailsService  {

	@Autowired
    //UserRepository userRepository;
 CustomerRepository customerRepository;


	public MyUserDetailsService( CustomerRepository customerRepository) {
	super();
	//this.userRepository = userRepository;
	this.customerRepository = customerRepository;
}


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Customer> user = customerRepository.findByEmail(userName);
		user.orElseThrow(()-> new UsernameNotFoundException("Not found "+ userName));
		return user.map(MyUserDetails::new).get();
		//return new MyUserDetails(user);
	}

	}


	

	
	
	


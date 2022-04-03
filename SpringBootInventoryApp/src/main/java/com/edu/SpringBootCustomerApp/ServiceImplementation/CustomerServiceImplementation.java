package com.edu.SpringBootCustomerApp.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.SpringBootCustomerApp.Entity.Customer;
import com.edu.SpringBootCustomerApp.Entity.User;
import com.edu.SpringBootCustomerApp.Exception.ResourceNotFoundException;
import com.edu.SpringBootCustomerApp.Repository.CustomerRepository;
import com.edu.SpringBootCustomerApp.Service.CustomerService;

@Service
public  class  CustomerServiceImplementation implements CustomerService{

private CustomerRepository customerRepository;	
	
	public CustomerServiceImplementation(CustomerRepository customerRepository)
	{
		super();
		this.customerRepository=customerRepository;
	}
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public List<Customer>getAllCustomer(){
		return customerRepository.findAll();
	}
	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> employee = customerRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
          
			throw new ResourceNotFoundException("Customer","custId",id);
		}
		
	}
	@Override
	public Customer updateCustomer(Customer customer,long id) {
		Customer cust=new Customer();
		try {
			cust=customerRepository.findById(id).orElseThrow(
					()->    new ResourceNotFoundException("Customer","custId",id));
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setEmail(customer.getEmail());
		cust.setMobileNo(customer.getMobileNo());
		
		customerRepository.save(cust);
		return cust;
	}

	@Override
	public void deleteCustomer(long id)
	{
		customerRepository.findById(id).orElseThrow(
		()->new ResourceNotFoundException("Customer","custId",id));
		customerRepository.deleteById(id);
	}
	
	/*@Override
	public List<Customer> getCustomerByFirstName(String firstName){
		return customerRepository.findByFirstName(firstName);
	}*/
	@Override
	public List<Customer> getCustomerByFirstName(String firstName){
		return customerRepository.findCustomersByFirstName(firstName);
	}
	
	@Override
	public List<Customer> getCustomerByLastName(String lastName){
		return customerRepository.findByLastName(lastName);
	}
	@Override
	public Customer getCustomerFullNameById(long id){
		return customerRepository.findCustomerFullNameById( id);
	}

	/*@Override
	public List<Customer> getCustomerInDescOrder(String firstName) {
		return customerRepository.findCustomerInDescOrder();
	}*/
	/*@Override
	public List<Customer> getcustomerByFirstNameAndLastName(String firstName, String lastName) {
		
		return customerRepository.findByFirstNameAndLastName(firstName,lastName);
	}*/

	@Override
	public List<Customer> getcustomerByFirstNameAndLastName(String firstName, String lastName) {
		
		return customerRepository.findCustomersByFirstNameAndLastName(firstName,lastName);
	}
	
	@Override
	public List<Customer> getcustomerByFirstNameOrLastName(String firstName, String lastName) {
		
		return customerRepository.findByFirstNameAndLastName(firstName,lastName);
	}

	@Override
	public long getIdByEmail(String email) {
		
		return customerRepository.getIdByEmail(email);
	}
}

	
	
	/*@Override
	public List<Customer> getCustomerInDescOrder(String firstName) {
		
		return customerRepository.findCustomerInDescOrder();
	}

	@Override
	public List<Customer> getCustomerInDescOrder() {
		
		return customerRepository.findCustomerInDescOrder();
	}
*/
	

	
	

	
	
	
	


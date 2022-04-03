package com.edu.SpringBootCustomerApp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootCustomerApp.Entity.Customer;
import com.edu.SpringBootCustomerApp.Service.CustomerService;
@RestController
//@Controller
@RequestMapping("/api/customer")
public class CustomerController {
private CustomerService customerService;

public CustomerController(CustomerService customerService) {
	super();
	this.customerService=customerService;
}

@PostMapping
//@ResponseBody
public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
	return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
}
@GetMapping("/")
//@ResponseBody
String index() {
	return "index";
}

@GetMapping
//@ResponseBody
public List<Customer> getAllCustomer()
{
	return customerService.getAllCustomer();
}

@GetMapping("/getCustomers")
//@ResponseBody
public String getAllCustomer(Model model) {
	
	List<Customer> employees =  customerService.getAllCustomer();
	
	model.addAttribute("customers", employees);
	
    return "list-customer";//list-employee.html
}

@GetMapping("{id}")//4
public ResponseEntity<Customer>getCustomerById(@PathVariable("id") long id) {
	return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);

}

@GetMapping("/customerByFirstName/{firstName}")
public List<Customer> getCustomerByFirstName(@PathVariable("firstName")String firstName){
	return customerService.getCustomerByFirstName(firstName);
}

@GetMapping("/customerByLastName/{lastName}")
public List<Customer> getCustomerByLastName(@PathVariable("lastName")String lastName){
	return customerService.getCustomerByLastName(lastName);
	
}

/*@GetMapping("/customerByFirstName/{firstName}/LastName{lastName}")
public List<Customer> getCustomerByFirstNameAndLastName(@PathVariable("firstName")String firstName,String lastName){
	
	return customerService.getcustomerByFirstNameAndLastName(firstName,lastName);
	
}*/
@GetMapping("/customerByFirstNameAndLastName")
public List<Customer> getCustomerByFirstNameAndLastName(@RequestParam String firstName,@RequestParam String lastName){
	return customerService.getcustomerByFirstNameAndLastName(firstName,lastName);
}
@GetMapping("/customerByFirstNameOrLastName")
public List<Customer> getCustomerByFirstNameOrLastName(@RequestParam String firstName,@RequestParam String lastName){
	return customerService.getcustomerByFirstNameOrLastName(firstName,lastName);
}

@GetMapping("/CustomerFullNameById/{id}")
public Customer getCustomerFullNameById(@PathVariable("id") long id) {
	return customerService.getCustomerFullNameById(id);
}


@PutMapping("{id}")
public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id,@RequestBody Customer customer){
	return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id),HttpStatus.OK);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
	customerService.deleteCustomer(id);
	return new ResponseEntity<String>("Customer record deleted ",HttpStatus.OK);
}
}



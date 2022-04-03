package com.edu.SpringBootCustomerApp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.SpringBootCustomerApp.Entity.Customer;
import com.edu.SpringBootCustomerApp.Entity.User;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

	
	List<Customer> findByFirstName(String firstName);
	@Query("Select c from Customer c where firstName= :name")
	List <Customer> findCustomersByFirstName(@Param("name") String firstName);
	@Query("Select c from Customer c where firstName=:firstName and lastName=:lastName")
	List<Customer> findCustomersByFirstNameAndLastName(@Param ("firstName") String firstName,@Param ("lastName") String lastName);
	//@Query("Select new com.edu.SpringBootCustomerApp.Entity.Customer(c.firstName,c.lastName)from Customer c where c.id=:id")
	//Customer findCustomerFullNameById(@Param("id") long id);
	@Query("Select new com.edu.SpringBootCustomerApp.Entity.Customer(c.custId,c.email)from Customer c where c.id=:id")
	Customer findCustomerFullNameById(@Param("id") long id);
	//@Query("Select count(c.id) from Customer c ORDER BY c.firstName desc")
   // List<Customer> findCustomerInDescOrder();
	
	List<Customer> findByLastName(String lastName);
	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

	
	@Query("Select c.custId from Customer c where c.email=: email")
	long getIdByEmail( @Param("email" ) String userEmail);
	Optional<Customer> findByEmail(String email);
}

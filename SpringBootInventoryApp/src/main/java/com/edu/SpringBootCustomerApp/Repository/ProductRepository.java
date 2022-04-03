package com.edu.SpringBootCustomerApp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.SpringBootCustomerApp.Entity.Customer;
import com.edu.SpringBootCustomerApp.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

	/*@Query("Select  p.id from Product p GROUP BY p.brandId where brandId= :brandid")
	List<Product> findProductsGroupByBrandId(@Param("name") String brandId);*/
	
	List<Product> findByBrandId(String brandId);

	List<Product> findByProductName(String productName);
	
	@Query("Select p from Product p where p.productName= :name")
	List<Product> findProductsByProductName(@Param("name") String productName);

	@Query("Select p from Product p where p.productName= :name")
	List<Product> findProductGroupByProductName(@Param("name") String productName);

	Product findProductNameById(long id);
    
	@Query("Select p from Product p where p.dateSold= :dateSold")
	List<Product> findProductByDateSold(@Param("dateSold") String dateSold);

	List<Product> findProductByDateReceived(String dateReceived);
	
	@Query("Select p from Product p where p.order.id= :id")
	List<Product> findProductsByOrderId(@Param("id") long id);
}

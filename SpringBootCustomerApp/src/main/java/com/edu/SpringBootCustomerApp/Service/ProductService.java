package com.edu.SpringBootCustomerApp.Service;

import java.util.List;

import com.edu.SpringBootCustomerApp.Entity.Customer;
import com.edu.SpringBootCustomerApp.Entity.Product;

public interface ProductService {
	Product saveProduct(Product product);
	List<Product>getAllProduct();
	Product getProductById(long id);
	Product updateProduct(Product product,long id);
	void deleteProduct(long id);
	List<Product> getProductGroupByBrandId(String brandId);
	List<Product> getProductByProductName(String productName);
	List<Product> getProductGroupByProductName(String productName);
	List<Product> getProductByDateSold(String dateSold);
	List<Product> getProductByDateReceived(String dateReceived);
	Product getProductNameById(long id);
	List<Product> getProductsByOrderId(long id);
	
}

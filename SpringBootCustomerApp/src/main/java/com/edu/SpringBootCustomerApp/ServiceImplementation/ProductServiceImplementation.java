package com.edu.SpringBootCustomerApp.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootCustomerApp.Entity.Customer;
import com.edu.SpringBootCustomerApp.Entity.Product;
import com.edu.SpringBootCustomerApp.Exception.ResourceNotFound;
import com.edu.SpringBootCustomerApp.Exception.ResourceNotFoundException;
import com.edu.SpringBootCustomerApp.Repository.ProductRepository;

import com.edu.SpringBootCustomerApp.Service.ProductService;
@Service
public class ProductServiceImplementation implements ProductService{
private ProductRepository productRepository;
public ProductServiceImplementation(ProductRepository productRepository)
{
	super();
	this.productRepository=productRepository;
}

@Override
public Product saveProduct(Product product) {
	return productRepository.save(product);
}

@Override
public List<Product>getAllProduct(){
	return productRepository.findAll();
}
@Override
public Product getProductById(long id) {
	Optional<Product> product=productRepository.findById(id);
	if(product.isPresent()) {
		return product.get();
	}
	else {
		throw new ResourceNotFoundException("Product","proId",id);
	}
}
@Override
public Product updateProduct(Product product,long id) {
	Product pro=new Product();
	try {
		pro=productRepository.findById(id).orElseThrow(
				()->    new ResourceNotFoundException("Product","proId",id));
	}catch (ResourceNotFoundException e) {
		e.printStackTrace();
	}
	pro.setProId(product.getProId());
	pro.setProductName(product.getProductName());
	pro.setBrandId(product.getBrandId());
	pro.setDateReceived(product.getDateReceived());
	pro.setDateSold(product.getDateSold());
	 
	productRepository.save(pro);
	return pro;
}

@Override
public void deleteProduct(long id) {
	productRepository.findById(id).orElseThrow(
		()->new ResourceNotFoundException("Product","proId",id));
	productRepository.deleteById(id);
	
}

@Override
public List<Product> getProductGroupByBrandId(String brandId){
	return productRepository.findByBrandId(brandId );
}
@Override
public List<Product> getProductByProductName(String productName){
	return productRepository.findByProductName(productName);
}
@Override
public List<Product> getProductGroupByProductName(String productName){
	return productRepository.findByProductName(productName);
}
/*@Overide
public List<Product> getProductByProductName(String productName){
	return productRepository.findProductsByProductName(productName);
}*/
@Override
public List<Product> getProductByDateSold(String dateSold){
	return productRepository.findProductByDateSold(dateSold);
}
@Override
public List<Product> getProductByDateReceived(String dateReceived){
	return productRepository.findProductByDateReceived(dateReceived);
}



@Override
public Product getProductNameById(long id) {
	
	return productRepository.findProductNameById(id);
}

@Override
public List<Product> getProductsByOrderId(long id) {
	return productRepository.findProductsByOrderId(id);
}
}


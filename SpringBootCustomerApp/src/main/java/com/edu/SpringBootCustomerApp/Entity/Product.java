package com.edu.SpringBootCustomerApp.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;
@Data
@Entity
@Table(name="producttable")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_id")
private Long proId;
	@Column(name="product_name")
private String productName;
	@Column(name="brand_id")
private String brandId;
	@Column(name="date_received")
private String dateReceived;
	@Column(name="date_sold")
private String dateSold;
	
	public Long getProId() {
		return proId;
	}
	@ManyToMany(mappedBy="pro")
    List <Customer> cust;
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id",nullable=false)
	private Order order;*/
	@OneToMany(mappedBy="product")
	private List <Order> order;
	
	@OneToMany(mappedBy="product")
	 private List <Stock> stock;
	/*@ManyToMany
	@JoinTable(name="product_customer",joinColumns=@JoinColumn(name="pro_id"),
	inverseJoinColumns=@JoinColumn(name="cust_id"))*/
	
	public void setProId(Long proId) {
		this.proId = proId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}
	
	public String getDateSold() {
		return dateSold;
	}
	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}
	/*public List<Customer> getCust() {
		return cust;
	}
	public void setCust(List<Customer> cust) {
		this.cust = cust;
	}*/
	
	
}

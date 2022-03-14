package com.edu.SpringBootCustomerApp.Entity;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
@Table(name="customertable")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cust_id")
private long custId;
	@Column(name="first_name")
private String firstName;
	@Column(name="last_name")
private String lastName;
	@Column(name="email")
private String email;
	@Column(name="password")
	private String password;
	@Column(name="confirm_password")
	private String confirmPassword;
	@Column(name="mobile_no")
private int mobileNo;
	
	/*@ManyToMany(mappedBy="cust")

	List <Product> pro;
	public List<Product> getPro() {
		return pro;
	}
	public void setPro(List<Product> pro) {
		this.pro = pro;
	}*/
	@ManyToMany
	@JoinTable(name="customer_product",joinColumns=@JoinColumn(name="cust_id"),
	inverseJoinColumns=@JoinColumn(name="pro_id"))
	List<Product >pro;
	//@JsonBackReference
	@OneToMany(mappedBy="customer")
	private List<Order>order;
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public List<Product> getPro() {
		return pro;
	}
	public void setPro(List<Product> pro) {
		this.pro = pro;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Customer() {
		super();
	}
	public Customer( String firstName, String lastName) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Customer(long custId, String email) {
		super();
		this.custId = custId;
		this.email = email;
	}
	
}

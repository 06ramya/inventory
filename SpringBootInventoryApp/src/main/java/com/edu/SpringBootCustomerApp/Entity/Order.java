package com.edu.SpringBootCustomerApp.Entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import javax.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
@Table(name="ordertable")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
private long orderId;
	@Column(name="order_no")
private long orderNo;
	
	@Column(name="quantity")
String quantity;
	@Column(name="date_order")
String dateOrder;
	
	//@JsonManagedReference
	@ManyToOne
	@JoinTable(name="order_customer",joinColumns= { @JoinColumn (name="order_id")}, inverseJoinColumns= { @JoinColumn (name="cust_id")})
	private Customer customer;
	/*@OneToOne(mappedBy="order",cascade=CascadeType.ALL)
    private Product product;*/
	@ManyToOne
	@JoinColumn(name="productId")
    private Product product;
	@ManyToOne
	@JoinColumn(name="supplierId")
	private  Supplier supplier;
	public long getOrderId() {
		return orderId;
	}
	public Order() {
		super();
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}
	
}



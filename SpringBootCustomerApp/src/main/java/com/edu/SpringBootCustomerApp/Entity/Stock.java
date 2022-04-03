package com.edu.SpringBootCustomerApp.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
@Data
@Entity
@Table(name="stocktable")
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stock_id")
private Long stockId;
	@Column(name="stock_no")
private String stockNo;
	@Column(name="stock_items")
	private String stockItems;
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="productId")
    private Product product;
	@ManyToOne
	@JoinColumn(name="supplierId")
	private  Supplier supplier;
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public String getStockNo() {
		return stockNo;
	}
	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}
	public String getStockItems() {
		return stockItems;
	}
	public void setStockItems(String stockItems) {
		this.stockItems = stockItems;
	}
	
}

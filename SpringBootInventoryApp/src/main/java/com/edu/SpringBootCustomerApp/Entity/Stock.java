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

import lombok.Data;
@Data
@Entity
@Table(name="stocktable")
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stock_id")
private long stockId;
	@Column(name="stock_no")
private String stockNo;
	@Column(name="stock_items")
	private String stockItems;
	
	@ManyToOne
	@JoinColumn(name="productId")
    private Product product;
	@ManyToOne
	@JoinColumn(name="supplierId")
	private  Supplier supplier;
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
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

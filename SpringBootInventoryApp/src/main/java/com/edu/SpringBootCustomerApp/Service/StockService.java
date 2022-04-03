package com.edu.SpringBootCustomerApp.Service;

import java.util.List;


import com.edu.SpringBootCustomerApp.Entity.Stock;

public interface StockService {

	Stock saveStock(Stock stock);

	List<Stock> getAllStock();

	Stock getStockById(long id);

	Stock updateStock(Stock stock, long id);

	void deleteStock(long id);

	

}

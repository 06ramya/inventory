package com.edu.SpringBootCustomerApp.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootCustomerApp.Entity.Product;
import com.edu.SpringBootCustomerApp.Entity.Stock;
import com.edu.SpringBootCustomerApp.Exception.ResourceNotFoundException;
import com.edu.SpringBootCustomerApp.Repository.StockRepository;
import com.edu.SpringBootCustomerApp.Service.StockService;

@Service
public class StockServiceImplementation implements StockService {

	private StockRepository stockRepository;

	public StockServiceImplementation(StockRepository stockRepository)
	{
		super();
		this.stockRepository=stockRepository;
	}

	@Override
	public Stock saveStock(Stock stock) {
		return stockRepository.save(stock);
	}
	
	@Override
	public List<Stock> getAllStock() {
		return stockRepository.findAll();
	}

	@Override
	public Stock getStockById(long id) {
		Optional<Stock> stock=stockRepository.findById(id);
		if(stock.isPresent()) {
			return stock.get();
		}
		else {
			throw new ResourceNotFoundException("Stock","stockId",id);
		}
		
	}

	@Override
	public Stock updateStock(Stock stock, long id) {
		Stock stk1=new Stock();
		try {
			stk1=stockRepository.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("Stock","stockId",id));
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		stk1.setStockId(stock.getStockId());
		stk1.setStockNo(stock.getStockNo());
		stk1.setStockItems(stock.getStockItems());
		//System.out.println(stock.getStockId());
		stockRepository.save(stk1);
		return stk1;
	}

	@Override
	public void deleteStock(long id) {
		stockRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Stock","stockId",id));
		stockRepository.deleteById(id);
		
	}
}



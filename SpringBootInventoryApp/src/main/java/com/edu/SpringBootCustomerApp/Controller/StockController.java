package com.edu.SpringBootCustomerApp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootCustomerApp.Entity.Product;
import com.edu.SpringBootCustomerApp.Entity.Stock;
import com.edu.SpringBootCustomerApp.Service.StockService;

@RestController
@RequestMapping("/api/stock")
public class StockController {
private StockService stockService;

public StockController(StockService stockService) {
	super();
	this.stockService=stockService;
}
	
@PostMapping
public ResponseEntity<Stock> saveStock(@RequestBody Stock stock){
	return new ResponseEntity<Stock> (stockService.saveStock(stock),HttpStatus.CREATED);
}
@GetMapping
public List<Stock> getAllStock()
{
	return stockService.getAllStock();
}
@GetMapping("{id}")
public ResponseEntity<Stock>getStockById(@PathVariable("id") long id){
	return new ResponseEntity<Stock>(stockService.getStockById(id),HttpStatus.OK);
}
@PutMapping("{id}")
public ResponseEntity<Stock> updateStock(@PathVariable("id") long id,@RequestBody Stock stock){
	return new ResponseEntity<Stock>(stockService.updateStock(stock,id),HttpStatus.OK);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteStock(@PathVariable("id") long id){
	stockService.deleteStock(id);
	return new ResponseEntity<String>("Stock record deleted",HttpStatus.OK);
}
}




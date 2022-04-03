package com.edu.SpringBootCustomerApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootCustomerApp.Entity.Stock;

public interface StockRepository extends JpaRepository<Stock,Long>{

}

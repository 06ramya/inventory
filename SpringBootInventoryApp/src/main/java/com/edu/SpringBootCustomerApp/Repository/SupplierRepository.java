package com.edu.SpringBootCustomerApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootCustomerApp.Entity.Supplier;



public interface SupplierRepository extends JpaRepository<Supplier,Long>{

}

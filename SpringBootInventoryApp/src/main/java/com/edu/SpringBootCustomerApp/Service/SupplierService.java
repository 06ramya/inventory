package com.edu.SpringBootCustomerApp.Service;

import java.util.List;

import com.edu.SpringBootCustomerApp.Entity.Supplier;

public interface SupplierService {

	Supplier saveSupplier(Supplier supplier);

	List<Supplier> getAllSupplier();

	Supplier getSupplierById(long id);

	Supplier updateSupplier(Supplier supplier, long id);

	void deleteSupplier(long id);

}

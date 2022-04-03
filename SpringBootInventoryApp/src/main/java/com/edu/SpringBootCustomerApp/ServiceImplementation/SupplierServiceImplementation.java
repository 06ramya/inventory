package com.edu.SpringBootCustomerApp.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootCustomerApp.Entity.Stock;
import com.edu.SpringBootCustomerApp.Entity.Supplier;
import com.edu.SpringBootCustomerApp.Exception.ResourceNotFoundException;
import com.edu.SpringBootCustomerApp.Repository.SupplierRepository;
import com.edu.SpringBootCustomerApp.Service.SupplierService;



@Service
public class SupplierServiceImplementation implements SupplierService{
private SupplierRepository supplierRepository;
	public SupplierServiceImplementation(SupplierRepository supplierRepository)
	{
		super();
		this.supplierRepository=supplierRepository;
	}
	@Override
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	@Override
	public List<Supplier> getAllSupplier(){
		return supplierRepository.findAll();
	}
	@Override
	public Supplier getSupplierById(long id) {
		Optional<Supplier> supplier=supplierRepository.findById(id);
		if(supplier.isPresent()) {
			return supplier.get();
		}
		else {
			throw new ResourceNotFoundException("Supplier","supplierId",id);
		}
	}
	@Override
	public Supplier updateSupplier(Supplier supplier,long id) {
		Supplier sup=new Supplier();
		try {
			sup=supplierRepository.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("Supplier","supplierId",id));
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		//sup.setSupplierId(supplier.getSupplierId());
		sup.setFirstName(supplier.getFirstName());
		sup.setLastName(supplier.getLastName());
		sup.setEmail(supplier.getEmail());
		sup.setMobileNo(supplier.getMobileNo());
		supplierRepository.save(sup);
		return sup;
	}
	@Override
	public void deleteSupplier(long id) {
		supplierRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Supplier","supplierId",id));
		supplierRepository.deleteById(id);
	}
}




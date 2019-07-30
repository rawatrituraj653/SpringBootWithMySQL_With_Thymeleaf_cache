package com.st.service;

import java.util.List;

import com.st.entity.Customer;

public interface ICustomerService {

	 public abstract Integer saveCustomer(Customer customer);
	 List<Customer> getAll();
	 void deleteCust(Integer id );
	 public Customer getCustomerOnly(Integer id) ; 
	 public  Customer updateCustomer(Integer id,Customer cust);  
}

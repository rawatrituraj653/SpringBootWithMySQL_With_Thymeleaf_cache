package com.st.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.entity.Customer;
import com.st.repo.CustomerRepo;
import com.st.service.ICustomerService;

@Service
public class CutomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepo repo;
	
	@Transactional
	public Integer saveCustomer(Customer customer) {
		
		return repo.save(customer).getCustId();
	}
	/*
	 * @Transactional(readOnly = true)
	 * 
	 * @Cacheable(value ="customer-cache",key="#id" ) public Customer
	 * getCustomer(Integer id) {
	 * 
	 * Optional<Customer> opt=repo.findById(id); if(opt.isPresent()) { return
	 * opt.get(); } return null; }
	 */

	@Override
	@Transactional(readOnly = true)
	public List<Customer> getAll() {

		return repo.findAll();
	}

	@Transactional
	@CacheEvict(value = "customer-cache",key="#id")
	public void deleteCust(Integer id) {
		repo.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	@Cacheable(value="customer-cache",key="#id", unless = "#result==null")
	public Customer getCustomerOnly(Integer id) {	
		Optional<Customer> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}		
		return null;
	}
	
	
	@Override
	@Transactional
	@CachePut(value="customer-cache",key="#id")
	public Customer updateCustomer(Integer id, Customer cust) {
		
		return repo.save(cust);
	}
		
}
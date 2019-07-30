package com.st.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}

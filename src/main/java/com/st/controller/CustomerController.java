package com.st.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.entity.Customer;
import com.st.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	@RequestMapping("/reg")
	public String getReg(Model map) {
		
		map.addAttribute("customer",new Customer());
		return "Register";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST )
	public String saveCustomer(@ModelAttribute Customer customer, Model map) {
			
		Integer id=service.saveCustomer(customer);
		map.addAttribute("msg", "customer form saved with Id: "+id);
		map.addAttribute("customer",new Customer());
		return "Register";
	}
	@RequestMapping("/showAll")
	public String  getAallEmp(Model map) {
		List<Customer> custs=service.getAll();
		map.addAttribute("custs", custs);
		return "Data";
	}
	
	@RequestMapping("/view/{id}")
	public  String getCustomer(@PathVariable Integer id,Model map) {
			Customer  cust=service.getCustomerOnly(id);
			map.addAttribute("cust", cust);
		return "View";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Integer id,Model map) {
			service.deleteCust(id);
		map.addAttribute("msg", "Employee Delete with Id: "+id);
		return "redirect:/customer/showAll";
	}
	@RequestMapping("/edit/{id}")
	public String editPage(@PathVariable Integer id  ,Model map) {
		Customer cust=service.getCustomerOnly(id);
		map.addAttribute("customer", cust);
		map.addAttribute("MODE", "EDIT");
		return "Edit";
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String doUpdate(@ModelAttribute Customer customer,Model map) {
		int id=customer.getCustId();
		System.out.println(id);
		Customer c=service.updateCustomer(id, customer);
		map.addAttribute("msg", c);
		return "redirect:/customer/showAll";
	}
}


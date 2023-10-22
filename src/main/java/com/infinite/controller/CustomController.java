package com.infinite.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infinite.model.Customer;
import com.infinite.service.CustomerServiceImpl;
import com.infinite.service.ICustomerService;

@Controller
public class CustomController {
	private static final Logger logger = Logger.getLogger(CustomController.class);
	@Autowired
	ICustomerService cserviceimpl;

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllCustomers";
	}

	@RequestMapping(value="/getAllCustomers", method= RequestMethod.GET)
	public String getAllCustomers(Model model)
	{
		model.addAttribute("customer",new Customer());
		model.addAttribute("listOfCustomers",cserviceimpl.getAllCustomers());
		return "customerdetails";
	}
	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return cserviceimpl.getCustomer(id);
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		if (customer.getId() == 0) {
			cserviceimpl.addCustomer(customer);
		} else {
			cserviceimpl.updateCustomer(customer);
		}
		return "redirect:/getAllCustomers";
	}

	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCustomer(@PathVariable("id") int id, Model model) {
		model.addAttribute("customer", this.cserviceimpl.getCustomer(id));
		model.addAttribute("listOfCustomers", this.cserviceimpl.getAllCustomers());
		return "customerdetails";
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		cserviceimpl.deleteCustomer(id);
		return "redirect:/getAllCustomers";
	}

}

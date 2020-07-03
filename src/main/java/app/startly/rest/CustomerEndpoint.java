package app.startly.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.startly.controller.*;
import app.startly.domain.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerEndpoint {
	@Autowired
	CustomerService customerService;
	UserService userService;
	
	@PostMapping("/")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/")
	public Iterable<Customer> getCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/getByEmail/{email}")
	public Customer getByEmail(@PathVariable(value = "email") String email) {
		return customerService.getByEmail(email);
	}
	
	@GetMapping("/getByEmail/{email}/{date}")
	public Iterable<Task> getTasksCustomerByDate(@PathVariable(value = "email") String email, 
	@PathVariable(value = "date") String date) {
		return customerService.getByEmail(email).getTasks(date);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable(value = "id") String customerId) {
		customerService.deleteCustomer(Long.parseLong(customerId));
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable(value = "id") String customerId, @RequestBody Customer customerDetails) {
		return customerService.updateCustomer(Long.parseLong(customerId), customerDetails);
	}
	
}

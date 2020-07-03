package app.startly.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.startly.domain.Customer;
import app.startly.domain.User;


@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository<Customer> customerRepository;

	public Customer addCustomer(Customer customer) {
		System.out.println("New Customer added to Database");
		return (Customer) customerRepository.save(customer);
	}

	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void deleteCustomer(long customerId) {
		System.out.println("Customer deleted from Database");
		customerRepository.deleteById(customerId);
	}

	public Customer updateCustomer(Long userId, Customer customerDetails) {
		System.out.println("Customer updated in Database");
		Customer customer = (Customer) customerRepository.findById(userId).get();
		
		if (customerDetails.getUserName() != null && customerDetails.getUserName() != "") {
			customer.setUserName(customerDetails.getUserName());
		}
		if (customerDetails.getEmailAdress() != null && customerDetails.getEmailAdress() != "") {
			customer.setEmailAdress(customerDetails.getEmailAdress());
		}
		if (customerDetails.getPasswordHash() != null && customerDetails.getPasswordHash() != "") {
			customer.setPasswordHash(customerDetails.getPasswordHash());
		}
		if (customerDetails.getCustomerName() != null && customerDetails.getCustomerName() != "") {
			customer.setCustomerName(customerDetails.getCustomerName());
		}
		if (customerDetails.getProfileImage() != null && customerDetails.getProfileImage() != "") {
			customer.setProfileImage(customerDetails.getProfileImage());
		}
		if (customerDetails.getLastLoginDateTime() != null) {
			customer.setLastLoginDateTime(customerDetails.getLastLoginDateTime());
		}
		
		return (Customer) customerRepository.save(customer);
	}
	
	public Customer getByEmail(String email) {
		System.out.println("GetByEmail in gebruikerService aangeroepen");
		Customer customer = (Customer) customerRepository.findByEmailAdress(email).get();
		customer.setLastLoginDateTime(LocalDateTime.now());
		return customer;
	}
}

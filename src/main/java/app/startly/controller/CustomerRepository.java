package app.startly.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.startly.domain.Customer;

@Repository
public interface CustomerRepository<T extends Customer> extends CrudRepository<T, Long>{
	Optional<Customer> findByEmailAdress(String emailAdress);
}

package com.g2academy.bookstore.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.g2academy.bookstore.models.Customer;
import com.g2academy.bookstore.repository.CustomerRepository;
import com.g2academy.bookstore.service.dto.CustomerDto;

@Service
public class CustomerService {

	private final CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public final Customer save(Customer entity) {
		return repository.save(entity);
	}

	@Transactional
	public Customer add(CustomerDto customerDto) {
		Customer aEntity = new Customer();
		aEntity.setEmail(customerDto.getEmail());
		aEntity.setName(customerDto.getName());
		aEntity.setPhone(customerDto.getPhone());
		aEntity.setAddress(customerDto.getAddress());

		return repository.save(aEntity);

	}

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public Customer edit(Long id, CustomerDto customerDto) {
		Optional<Customer> oEntity = this.findById(id);
		Customer aEntity = oEntity.orElse(null);
		if (aEntity != null) {
			aEntity.setEmail(customerDto.getEmail());
			aEntity.setName(customerDto.getName());
			aEntity.setPhone(customerDto.getPhone());
			aEntity.setAddress(customerDto.getAddress());
			return repository.save(aEntity);
		}
		return null;
	}

	public void delete(Long id) {
		repository.findById(id).map(entity -> {
			repository.delete(entity);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new NullPointerException("Customer with " + id + " not found"));
	}

}

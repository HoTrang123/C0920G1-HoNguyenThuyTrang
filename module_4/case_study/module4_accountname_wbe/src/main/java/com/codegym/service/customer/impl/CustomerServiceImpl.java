package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.TypeCustomer;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.repository.customer.TypeCustomerRepository;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TypeCustomerRepository typeCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void remove(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<TypeCustomer> findAllTypeCustomer() {
        return typeCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findByNameContaining(Pageable pageable, String name) {
        return customerRepository.findByNameContaining(pageable, name);
    }
}

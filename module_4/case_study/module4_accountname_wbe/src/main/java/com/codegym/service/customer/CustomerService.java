package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.TypeCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Customer findById(String id);

    void save(Customer customer);

    void update(Customer customer);

    void remove(String id);

    List<TypeCustomer> findAllTypeCustomer();

    Page<Customer> findByNameContaining (Pageable pageable, String name);
}

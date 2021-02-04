package com.codegym.service.service;

import com.codegym.model.service.RentType;
import com.codegym.model.service.Service;
import com.codegym.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {

    List<Service> findAll();

    Page<Service> findAll(Pageable pageable);

    Service findById(String id);

    void save(Service service);

    void update(Service service);

    void remove(String id);

    List<RentType> findAllRentType();

    List<ServiceType> findAllServiceType();

    Page<Service> findByNameContaining (Pageable pageable, String name);
}

package com.codegym.service.service.impl;

import com.codegym.model.service.RentType;
import com.codegym.model.service.ServiceType;
import com.codegym.repository.service.RentTypeRepository;
import com.codegym.repository.service.ServiceRepository;
import com.codegym.repository.service.ServiceTypeRepository;
import com.codegym.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<com.codegym.model.service.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<com.codegym.model.service.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public com.codegym.model.service.Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(com.codegym.model.service.Service service) {
        serviceRepository.save(service);

    }

    @Override
    public void update(com.codegym.model.service.Service service) {
        serviceRepository.save(service);

    }

    @Override
    public void remove(String id) {
        serviceRepository.deleteById(id);

    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Page<com.codegym.model.service.Service> findByNameContaining(Pageable pageable, String name) {
        return serviceRepository.findByNameContaining(pageable, name);
    }
}

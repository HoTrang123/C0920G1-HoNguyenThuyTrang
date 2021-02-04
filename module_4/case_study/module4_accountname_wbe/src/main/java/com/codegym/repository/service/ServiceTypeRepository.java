package com.codegym.repository.service;

import com.codegym.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository  extends JpaRepository<ServiceType, Integer> {
}

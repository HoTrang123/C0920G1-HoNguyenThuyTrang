package com.trang.services;

import com.trang.services.models.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> getListCustomer();
}

package com.trang.repositories;

import com.trang.repositories.models.CustomerEDM;

import java.util.List;

public interface ICustomerRepository {
    List<CustomerEDM> getListCustomer();
}

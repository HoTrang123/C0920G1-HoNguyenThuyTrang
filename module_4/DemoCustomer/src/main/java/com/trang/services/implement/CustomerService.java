package com.trang.services.implement;

import com.trang.repositories.ICustomerRepository;
import com.trang.repositories.models.CustomerEDM;
import com.trang.services.ICustomerService;
import com.trang.services.models.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<CustomerDTO> getListCustomer() {
        List<CustomerEDM> customerEDMList = this.iCustomerRepository.getListCustomer();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (CustomerEDM edm : customerEDMList)
        {
            CustomerDTO customerDTO = new CustomerDTO(edm.getId(), edm.getName(), edm.getAge(), edm.getEmail());
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}

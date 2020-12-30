package service.customer;

import model.customer.CustomerType;
import repository.customer.CustomerTypeRepository;
import repository.customer.CustomerTypeRepositoryImpl;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {

    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerTypeRepository.getAllCustomerType();
    }

    @Override
    public CustomerType selectTypeCustomerById(int id) {
        return customerTypeRepository.selectTypeCustomerById(id);
    }
}

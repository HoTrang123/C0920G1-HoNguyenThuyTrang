package repository.customer;

import model.customer.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {

    List<CustomerType> getAllCustomerType();

    CustomerType selectTypeCustomerById(int id);
}

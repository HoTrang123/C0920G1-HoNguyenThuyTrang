package repository;

import model.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    public List<CustomerType> selectAllTypeCustomer();
    public CustomerType selectTypeCustomerById(int id);
}

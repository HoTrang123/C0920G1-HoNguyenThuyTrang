package repository;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {

    public List<Customer> selectAllCustomer();

    public Customer selectCustomerById(int id);

    public void insertCustomer(Customer customer) throws SQLException;

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    public List<Customer> searchCustomer(String name) throws SQLException;
}

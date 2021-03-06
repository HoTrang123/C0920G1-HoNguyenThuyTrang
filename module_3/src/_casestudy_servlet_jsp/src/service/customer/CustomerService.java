package service.customer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    void insertCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(int id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    Customer selectCustomerById(int id);
    List<Customer> searchByName(String name);
}
